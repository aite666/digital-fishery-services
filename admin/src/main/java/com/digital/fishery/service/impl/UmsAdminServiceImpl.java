package com.digital.fishery.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.bo.AdminUserDetails;
import com.digital.fishery.dao.UmsAdminRoleRelationDao;
import com.digital.fishery.dto.UmsAdminLoginParam;
import com.digital.fishery.dto.UmsAdminParam;
import com.digital.fishery.dto.UpdateAdminPasswordParam;
import com.digital.fishery.dto.WeChatLoginResult;
import com.digital.fishery.mapper.*;
import com.digital.fishery.model.*;
import com.digital.fishery.service.UmsAdminCacheService;
import com.digital.fishery.service.UmsAdminService;
import com.digital.fishery.util.HttpClientUtil;
import com.github.pagehelper.PageHelper;
import com.digital.fishery.exception.Asserts;
import com.digital.fishery.util.RequestUtil;
import com.digital.fishery.util.JwtTokenUtil;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ??????????????????Service?????????
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    private static final String openIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Value("${wechat.app.id}")
    private String WECHAT_APP_ID;
    @Value("${wechat.app.secret}")
    private String WECHAT_APP_SECRET;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminWxMapper adminWxMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;
    @Autowired
    private InfoBlockMapper infoBlockMapper;
    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if (admin != null) {
            if (StringUtils.isEmpty(admin.getBlockIds())) {
                admin.setBlockIds(this.getBlockIdsByEnterpriseId(admin.getEnterpriseId()));
            }
            return admin;
        }
//        UmsAdmin admin = new UmsAdmin();
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            admin.setBlockIds(this.getBlockIdsByEnterpriseId(admin.getEnterpriseId()));
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public String getBlockIdsByEnterpriseId(Long enterpriseId) {
        String blockIds = null;
        if (enterpriseId != null && enterpriseId != -1) {
            InfoBlockExample example = new InfoBlockExample();
            InfoBlockExample.Criteria criteria = example.createCriteria();
            criteria.andEnterpriseIdEqualTo(enterpriseId);
            List<InfoBlock> infoBlockList = infoBlockMapper.selectByExampleWithBLOBs(example);
            List<Long> blockIdList = infoBlockList.stream().map(InfoBlock::getId).collect(Collectors.toList());
            blockIds = org.apache.commons.lang.StringUtils.join(blockIdList, ",");
        }
        return blockIds;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
//        umsAdmin.setStatus(1);
        //???????????????????????????????????????
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //???????????????????????????
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //????????????????????????????????????
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("???????????????");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("??????????????????");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("????????????:{}", e.getMessage());
        }
        return token;
    }

    /**
     * ??????????????????
     * @param username ?????????
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        loginLogMapper.insert(loginLog);
    }

    /**
     * ?????????????????????????????????
     */
    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Long enterpriseId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(criteria.andNickNameLike("%" + keyword + "%"));
        }
        if (enterpriseId != null) {
            criteria.andEnterpriseIdEqualTo(enterpriseId);
        }
        return adminMapper.selectByExample(example);
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = adminMapper.selectByPrimaryKey(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //??????????????????????????????????????????
            admin.setPassword(null);
        }else{
            //?????????????????????????????????????????????
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        adminCacheService.delAdmin(id);
        int count = adminMapper.deleteByPrimaryKey(id);
        adminCacheService.delResourceList(id);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //????????????????????????
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //???????????????
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        adminCacheService.delResourceList(adminId);
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminCacheService.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList = adminRoleRelationDao.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            return -1;
        }
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if(CollUtil.isEmpty(adminList)){
            return -2;
        }
        UmsAdmin umsAdmin = adminList.get(0);
        if(!passwordEncoder.matches(param.getOldPassword(),umsAdmin.getPassword())){
            return -3;
        }
        umsAdmin.setPassword(passwordEncoder.encode(param.getNewPassword()));
        adminMapper.updateByPrimaryKey(umsAdmin);
        adminCacheService.delAdmin(umsAdmin.getId());
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //??????????????????
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("????????????????????????");
    }

    @Override
    public WeChatLoginResult wechatCheckBind(String code) {
        String openId = getOpenId(code);
        UmsAdminWxExample example = new UmsAdminWxExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        List<UmsAdminWx> adminWxList = adminWxMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminWxList) || adminWxList.get(0) == null) {
            return null;
        }
        UmsAdminWx umsAdminWx = adminWxList.get(0);
        UmsAdmin umsAdmin = adminMapper.selectByPrimaryKey(umsAdminWx.getUserId());
        umsAdmin.setBlockIds(this.getBlockIdsByEnterpriseId(umsAdmin.getEnterpriseId()));
        UserDetails userDetails = loadUserByUsername(umsAdmin.getUsername());
        String token = getToken(userDetails);
        WeChatLoginResult result = new WeChatLoginResult();
        result.setToken(token);
        result.setUmsAdmin(umsAdmin);
        return result;
    }

    @Override
    public WeChatLoginResult wechatBind(UmsAdminLoginParam param) {
        WeChatLoginResult result = new WeChatLoginResult();
        UmsAdmin umsAdmin = getAdminByUsername(param.getUsername());
        if (umsAdmin == null) {
            result.setMessage("??????????????????");
            return result;
        }
        if(!passwordEncoder.matches(param.getPassword(),umsAdmin.getPassword())){
//            Asserts.fail("???????????????");
            result.setMessage("???????????????");
            return result;
        }
        if (umsAdmin.getStatus() == null || umsAdmin.getStatus() != 1) {
//            Asserts.fail("???????????????");
            result.setMessage("????????????????????????????????????");
            return result;
        }
        String openId = getOpenId(param.getCode());
        UmsAdminWxExample example = new UmsAdminWxExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        List<UmsAdminWx> adminWxList = adminWxMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminWxList) || adminWxList.get(0) == null) {
            UmsAdminWx wx = new UmsAdminWx();
            wx.setOpenId(openId);
            wx.setUserId(umsAdmin.getId());
            adminWxMapper.insert(wx);
        } else {
            UmsAdminWx umsAdminWx = adminWxList.get(0);
            if (!umsAdminWx.getUserId().equals(umsAdmin.getId())) {
                umsAdminWx.setUserId(umsAdmin.getId());
                adminWxMapper.updateByPrimaryKey(umsAdminWx);
            }
        }
        UserDetails userDetails = loadUserByUsername(umsAdmin.getUsername());
        String token = getToken(userDetails);
        result.setToken(token);
        result.setUmsAdmin(umsAdmin);
        result.setMessage("????????????");
        return result;
    }

    @Override
    public void wechatLogout(String code) {
        String openId = getOpenId(code);
        UmsAdminWxExample example = new UmsAdminWxExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        adminWxMapper.deleteByExample(example);
    }

    /**
     * ????????????openId
     * @param code
     * @return
     */
    private String getOpenId(String code) {
        String requestUrl = String.format(openIdUrl, WECHAT_APP_ID, WECHAT_APP_SECRET, code);
        String responseStr = HttpClientUtil.doGet(requestUrl, new HashMap<>());
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(responseStr);
        return jsonObject.getString("openid");
    }

    private String getToken(UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
        insertLoginLog(userDetails.getUsername());
        return token;
    }
}
