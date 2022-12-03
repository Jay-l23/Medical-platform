package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 挂号列表对象 his_reg
 * 
 * @author lijie
 * @date 2022-12-03
 */
public class HisReg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 挂单号 */
    private Long regId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patiName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String regCardNum;

    /** 挂号科室 */
    @Excel(name = "挂号科室")
    private String regDepts;

    /** 接诊医生 */
    @Excel(name = "接诊医生")
    private String regDocter;

    /** 挂号费用 */
    @Excel(name = "挂号费用")
    private BigDecimal regPrice;

    /** 流水编号 */
    @Excel(name = "流水编号")
    private Integer regNum;

    /** 状态 */
    @Excel(name = "状态")
    private String regStatus;

    /** 就诊日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "就诊日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date regSdate;

    /** 挂号类型 */
    @Excel(name = "挂号类型")
    private String regType;

    /** 挂号时段 */
    @Excel(name = "挂号时段")
    private String regTime;

    /** 挂号时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂号时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date regRdate;

    public void setRegId(Long regId) 
    {
        this.regId = regId;
    }

    public Long getRegId() 
    {
        return regId;
    }
    public void setPatiName(String patiName) 
    {
        this.patiName = patiName;
    }

    public String getPatiName() 
    {
        return patiName;
    }
    public void setRegCardNum(String regCardNum) 
    {
        this.regCardNum = regCardNum;
    }

    public String getRegCardNum() 
    {
        return regCardNum;
    }
    public void setRegDepts(String regDepts) 
    {
        this.regDepts = regDepts;
    }

    public String getRegDepts() 
    {
        return regDepts;
    }
    public void setRegDocter(String regDocter) 
    {
        this.regDocter = regDocter;
    }

    public String getRegDocter() 
    {
        return regDocter;
    }
    public void setRegPrice(BigDecimal regPrice) 
    {
        this.regPrice = regPrice;
    }

    public BigDecimal getRegPrice() 
    {
        return regPrice;
    }
    public void setRegNum(Integer regNum) 
    {
        this.regNum = regNum;
    }

    public Integer getRegNum() 
    {
        return regNum;
    }
    public void setRegStatus(String regStatus) 
    {
        this.regStatus = regStatus;
    }

    public String getRegStatus() 
    {
        return regStatus;
    }
    public void setRegSdate(Date regSdate) 
    {
        this.regSdate = regSdate;
    }

    public Date getRegSdate() 
    {
        return regSdate;
    }
    public void setRegType(String regType) 
    {
        this.regType = regType;
    }

    public String getRegType() 
    {
        return regType;
    }
    public void setRegTime(String regTime) 
    {
        this.regTime = regTime;
    }

    public String getRegTime() 
    {
        return regTime;
    }
    public void setRegRdate(Date regRdate) 
    {
        this.regRdate = regRdate;
    }

    public Date getRegRdate() 
    {
        return regRdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("regId", getRegId())
            .append("patiName", getPatiName())
            .append("regCardNum", getRegCardNum())
            .append("regDepts", getRegDepts())
            .append("regDocter", getRegDocter())
            .append("regPrice", getRegPrice())
            .append("regNum", getRegNum())
            .append("regStatus", getRegStatus())
            .append("regSdate", getRegSdate())
            .append("regType", getRegType())
            .append("regTime", getRegTime())
            .append("regRdate", getRegRdate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
