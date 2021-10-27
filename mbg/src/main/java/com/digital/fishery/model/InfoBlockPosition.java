package com.digital.fishery.model;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class InfoBlockPosition implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "区块id")
    private Long blockId;

    @ApiModelProperty(value = "坐标数据")
    private String position;

    @ApiModelProperty(value = "坐标数据Json")
    private JSONObject positionJson;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public JSONObject getPositionJson() {
        return positionJson;
    }

    public void setPositionJson(JSONObject positionJson) {
        this.positionJson = positionJson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", blockId=").append(blockId);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}