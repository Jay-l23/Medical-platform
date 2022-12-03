package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 挂号费用设置对象 sys_registration_cost
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public class SysRegistrationCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 挂号费用 */
    private Long regId;

    /** 挂号费名称 */
    @Excel(name = "挂号费名称")
    private String regName;

    /** 挂号费 */
    @Excel(name = "挂号费")
    private BigDecimal regPrice;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setRegId(Long regId) 
    {
        this.regId = regId;
    }

    public Long getRegId() 
    {
        return regId;
    }
    public void setRegName(String regName) 
    {
        this.regName = regName;
    }

    public String getRegName() 
    {
        return regName;
    }
    public void setRegPrice(BigDecimal regPrice) 
    {
        this.regPrice = regPrice;
    }

    public BigDecimal getRegPrice() 
    {
        return regPrice;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("regId", getRegId())
            .append("regName", getRegName())
            .append("regPrice", getRegPrice())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
