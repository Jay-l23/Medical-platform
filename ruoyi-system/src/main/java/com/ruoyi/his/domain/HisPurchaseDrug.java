package com.ruoyi.his.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ${subTable.functionName}对象 his_purchase_drug
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public class HisPurchaseDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    private String purOrderId;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long drugId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long purNumbers;

    /** 批次号 */
    @Excel(name = "批次号")
    private Long purId;

    /** 药品批发单价 */
    @Excel(name = "药品批发单价")
    private BigDecimal purPrice;

    public void setPurOrderId(String purOrderId) 
    {
        this.purOrderId = purOrderId;
    }

    public String getPurOrderId() 
    {
        return purOrderId;
    }
    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setPurNumbers(Long purNumbers) 
    {
        this.purNumbers = purNumbers;
    }

    public Long getPurNumbers() 
    {
        return purNumbers;
    }
    public void setPurId(Long purId) 
    {
        this.purId = purId;
    }

    public Long getPurId() 
    {
        return purId;
    }
    public void setPurPrice(BigDecimal purPrice) 
    {
        this.purPrice = purPrice;
    }

    public BigDecimal getPurPrice() 
    {
        return purPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purOrderId", getPurOrderId())
            .append("drugId", getDrugId())
            .append("purNumbers", getPurNumbers())
            .append("purId", getPurId())
            .append("purPrice", getPurPrice())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
