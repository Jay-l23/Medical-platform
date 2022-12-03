package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商维护对象 supplier
 * 
 * @author lijie
 * @date 2022-11-04
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String supContact;

    /** 联系人手机 */
    @Excel(name = "联系人手机")
    private String supMobile;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String supTel;

    /** 银行账号 */
    @Excel(name = "银行账号")
    private String supAccount;

    /** 地址 */
    @Excel(name = "地址")
    private String supAddress;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setSupId(Long supId) 
    {
        this.supId = supId;
    }

    public Long getSupId() 
    {
        return supId;
    }
    public void setSupName(String supName) 
    {
        this.supName = supName;
    }

    public String getSupName() 
    {
        return supName;
    }
    public void setSupContact(String supContact) 
    {
        this.supContact = supContact;
    }

    public String getSupContact() 
    {
        return supContact;
    }
    public void setSupMobile(String supMobile) 
    {
        this.supMobile = supMobile;
    }

    public String getSupMobile() 
    {
        return supMobile;
    }
    public void setSupTel(String supTel) 
    {
        this.supTel = supTel;
    }

    public String getSupTel() 
    {
        return supTel;
    }
    public void setSupAccount(String supAccount) 
    {
        this.supAccount = supAccount;
    }

    public String getSupAccount() 
    {
        return supAccount;
    }
    public void setSupAddress(String supAddress) 
    {
        this.supAddress = supAddress;
    }

    public String getSupAddress() 
    {
        return supAddress;
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
            .append("supId", getSupId())
            .append("supName", getSupName())
            .append("supContact", getSupContact())
            .append("supMobile", getSupMobile())
            .append("supTel", getSupTel())
            .append("supAccount", getSupAccount())
            .append("supAddress", getSupAddress())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
