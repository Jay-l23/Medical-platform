package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产厂商管理对象 factory
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public class Factory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 厂家ID */
    @Excel(name = "厂家ID")
    private Long facId;

    /** 厂家名称 */
    @Excel(name = "厂家名称")
    private String facName;

    /** 厂家编码 */
    @Excel(name = "厂家编码")
    private String facCode;

    /** 联系人 */
    @Excel(name = "联系人")
    private String facContact;

    /** 电话 */
    @Excel(name = "电话")
    private String facTel;

    /** 关键字 */
    @Excel(name = "关键字")
    private String facKey;

    /** 地址 */
    private String facAddress;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setFacId(Long facId) 
    {
        this.facId = facId;
    }

    public Long getFacId() 
    {
        return facId;
    }
    public void setFacName(String facName) 
    {
        this.facName = facName;
    }

    public String getFacName() 
    {
        return facName;
    }
    public void setFacCode(String facCode) 
    {
        this.facCode = facCode;
    }

    public String getFacCode() 
    {
        return facCode;
    }
    public void setFacContact(String facContact) 
    {
        this.facContact = facContact;
    }

    public String getFacContact() 
    {
        return facContact;
    }
    public void setFacTel(String facTel) 
    {
        this.facTel = facTel;
    }

    public String getFacTel() 
    {
        return facTel;
    }
    public void setFacKey(String facKey) 
    {
        this.facKey = facKey;
    }

    public String getFacKey() 
    {
        return facKey;
    }
    public void setFacAddress(String facAddress) 
    {
        this.facAddress = facAddress;
    }

    public String getFacAddress() 
    {
        return facAddress;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("facId", getFacId())
            .append("facName", getFacName())
            .append("facCode", getFacCode())
            .append("facContact", getFacContact())
            .append("facTel", getFacTel())
            .append("facKey", getFacKey())
            .append("facAddress", getFacAddress())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
