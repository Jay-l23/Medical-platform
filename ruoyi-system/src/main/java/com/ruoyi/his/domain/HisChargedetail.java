package com.ruoyi.his.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收费查询对象 his_chargedetail
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public class HisChargedetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private String orderId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long drugId;

    /** 药品单价 */
    @Excel(name = "药品单价")
    private BigDecimal drugRxPrice;

    /** 药品价格 */
    @Excel(name = "药品价格")
    private BigDecimal drugPrice;

    /** 药品数量 */
    @Excel(name = "药品数量")
    private Long drugAmount;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setDrugRxPrice(BigDecimal drugRxPrice) 
    {
        this.drugRxPrice = drugRxPrice;
    }

    public BigDecimal getDrugRxPrice() 
    {
        return drugRxPrice;
    }
    public void setDrugPrice(BigDecimal drugPrice) 
    {
        this.drugPrice = drugPrice;
    }

    public BigDecimal getDrugPrice() 
    {
        return drugPrice;
    }
    public void setDrugAmount(Long drugAmount) 
    {
        this.drugAmount = drugAmount;
    }

    public Long getDrugAmount() 
    {
        return drugAmount;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("drugName", getDrugName())
            .append("drugId", getDrugId())
            .append("drugRxPrice", getDrugRxPrice())
            .append("drugPrice", getDrugPrice())
            .append("drugAmount", getDrugAmount())
            .append("type", getType())
            .append("status", getStatus())
            .toString();
    }
}
