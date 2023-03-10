package com.ruoyi.his.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提交订单对象 his_purchase
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public class HisPur extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String purOrderId;

    /** 订单总额 */
    @Excel(name = "订单总额")
    private BigDecimal purCount;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Long purVerify;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supId;

    public void setPurOrderId(String purOrderId) 
    {
        this.purOrderId = purOrderId;
    }

    public String getPurOrderId() 
    {
        return purOrderId;
    }
    public void setPurCount(BigDecimal purCount) 
    {
        this.purCount = purCount;
    }

    public BigDecimal getPurCount() 
    {
        return purCount;
    }
    public void setPurVerify(Long purVerify) 
    {
        this.purVerify = purVerify;
    }

    public Long getPurVerify() 
    {
        return purVerify;
    }
    public void setSupId(Long supId) 
    {
        this.supId = supId;
    }

    public Long getSupId() 
    {
        return supId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purOrderId", getPurOrderId())
            .append("purCount", getPurCount())
            .append("purVerify", getPurVerify())
            .append("supId", getSupId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
