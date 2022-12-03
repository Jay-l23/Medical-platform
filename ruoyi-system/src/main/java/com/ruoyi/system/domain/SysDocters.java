package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生信息管理对象 sys_docters
 * 
 * @author lijie
 * @date 2022-11-05
 */
public class SysDocters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long dId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String dName;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long deptsId;

    /** 手机号 */
    @Excel(name = "手机号")
    private String dPhone;

    /** 性别 */
    @Excel(name = "性别")
    private String dSex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer dAge;

    /** 排班状态 */
    @Excel(name = "排班状态")
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
    public void setdAge(Integer dAge) 
    {
        this.dAge = dAge;
    }

    public Integer getdAge() 
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
