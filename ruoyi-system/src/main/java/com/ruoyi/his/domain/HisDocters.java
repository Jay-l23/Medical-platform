package com.ruoyi.his.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生管理对象 his_docters
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public class HisDocters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医生编号 */
    private Long dId;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String dName;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long deptsId;

    /** 医生手机 */
    @Excel(name = "医生手机")
    private String dPhone;

    /** 医生性别 */
    @Excel(name = "医生性别")
    private String dSex;

    /** 医生年龄 */
    @Excel(name = "医生年龄")
    private Long dAge;

    /** 是否排班 */
    @Excel(name = "是否排班")
    private Long orderwork;

    /** 学历背景 */
    @Excel(name = "学历背景")
    private Long dEducationBg;

    public void setdId(Long dId) 
    {
        this.dId = dId;
    }

    public Long getdId() 
    {
        return dId;
    }
    public void setdName(String dName) 
    {
        this.dName = dName;
    }

    public String getdName() 
    {
        return dName;
    }
    public void setDeptsId(Long deptsId) 
    {
        this.deptsId = deptsId;
    }

    public Long getDeptsId() 
    {
        return deptsId;
    }
    public void setdPhone(String dPhone) 
    {
        this.dPhone = dPhone;
    }

    public String getdPhone() 
    {
        return dPhone;
    }
    public void setdSex(String dSex) 
    {
        this.dSex = dSex;
    }

    public String getdSex() 
    {
        return dSex;
    }
    public void setdAge(Long dAge) 
    {
        this.dAge = dAge;
    }

    public Long getdAge() 
    {
        return dAge;
    }
    public void setOrderwork(Long orderwork) 
    {
        this.orderwork = orderwork;
    }

    public Long getOrderwork() 
    {
        return orderwork;
    }
    public void setdEducationBg(Long dEducationBg) 
    {
        this.dEducationBg = dEducationBg;
    }

    public Long getdEducationBg() 
    {
        return dEducationBg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dId", getdId())
            .append("dName", getdName())
            .append("deptsId", getDeptsId())
            .append("dPhone", getdPhone())
            .append("dSex", getdSex())
            .append("dAge", getdAge())
            .append("orderwork", getOrderwork())
            .append("dEducationBg", getdEducationBg())
            .append("createTime", getCreateTime())
            .toString();
    }
}
