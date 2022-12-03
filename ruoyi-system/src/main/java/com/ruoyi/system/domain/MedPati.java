package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者库对象 med_pati
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public class MedPati extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者编号 */
    private Long patiId;

    /** 患者名称 */
    @Excel(name = "患者名称")
    private String patiName;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    private String patiCode;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patiPhone;

    /** 出生年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date patiBirthday;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private String patiAge;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String patiSex;

    /** 患者住址 */
    private String patiAddress;

    /** 患者过敏史 */
    @Excel(name = "患者过敏史")
    private String patiAllergy;

    /** 信息状态 */
    @Excel(name = "信息状态")
    private String status;

    public void setPatiId(Long patiId) 
    {
        this.patiId = patiId;
    }

    public Long getPatiId() 
    {
        return patiId;
    }
    public void setPatiName(String patiName) 
    {
        this.patiName = patiName;
    }

    public String getPatiName() 
    {
        return patiName;
    }
    public void setPatiCode(String patiCode) 
    {
        this.patiCode = patiCode;
    }

    public String getPatiCode() 
    {
        return patiCode;
    }
    public void setPatiPhone(String patiPhone) 
    {
        this.patiPhone = patiPhone;
    }

    public String getPatiPhone() 
    {
        return patiPhone;
    }
    public void setPatiBirthday(Date patiBirthday) 
    {
        this.patiBirthday = patiBirthday;
    }

    public Date getPatiBirthday() 
    {
        return patiBirthday;
    }
    public void setPatiAge(String patiAge) 
    {
        this.patiAge = patiAge;
    }

    public String getPatiAge() 
    {
        return patiAge;
    }
    public void setPatiSex(String patiSex) 
    {
        this.patiSex = patiSex;
    }

    public String getPatiSex() 
    {
        return patiSex;
    }
    public void setPatiAddress(String patiAddress) 
    {
        this.patiAddress = patiAddress;
    }

    public String getPatiAddress() 
    {
        return patiAddress;
    }
    public void setPatiAllergy(String patiAllergy) 
    {
        this.patiAllergy = patiAllergy;
    }

    public String getPatiAllergy() 
    {
        return patiAllergy;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patiId", getPatiId())
            .append("patiName", getPatiName())
            .append("patiCode", getPatiCode())
            .append("patiPhone", getPatiPhone())
            .append("patiBirthday", getPatiBirthday())
            .append("patiAge", getPatiAge())
            .append("patiSex", getPatiSex())
            .append("patiAddress", getPatiAddress())
            .append("patiAllergy", getPatiAllergy())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
