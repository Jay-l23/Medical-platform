package com.ruoyi.his.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购入库对象 his_purchase
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public class HisPurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String purId;

    /** 订单总额 */
    @Excel(name = "订单总额")
    private BigDecimal purCount;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Long purVerify;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supName;

    public void setPurId(String purId) 
    {
        this.purId = purId;
    }

    public String getPurId() 
    {
        return purId;
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
    public void setSupName(String supName) 
    {
        this.supName = supName;
    }

    public String getSupName() 
    {
        return supName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purId", getPurId())
            .append("purCount", getPurCount())
            .append("purVerify", getPurVerify())
            .append("supName", getSupName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
