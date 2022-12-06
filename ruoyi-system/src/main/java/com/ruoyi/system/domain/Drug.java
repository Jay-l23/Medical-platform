package com.ruoyi.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品信息维护对象 drug
 * 
 * @author lijie
 * @date 2022-11-04
 */

public class Drug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品ID */
    private Long drugId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品编码 */
    @Excel(name = "药品编码")
    private String drugNumber;

    /** 药品关键字 */
    @Excel(name = "药品关键字")
    private String drugKey;

    /** 药品类型 */
    @Excel(name = "药品类型")
    private String drugType;

    /** 处方类型 */
    @Excel(name = "处方类型")
    private String drugRxType;

    /** 单位 */
    @Excel(name = "单位")
    private String drugUnit;

    /** 处方价格 */
    @Excel(name = "处方价格")
    private BigDecimal drugRxPrice;

    /** 库存量 */
    @Excel(name = "库存量")
    private Long drugStocks;

    /** 预警值 */
    @Excel(name = "预警值")
    private Long drugWarning;

    /** 换算值 */
    @Excel(name = "换算值")
    private Long drugMatrixing;

    /** 状态 */
    @Excel(name = "状态")
    private Long drugStatus;

    /** 厂家ID */
    private Long facId;

    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugNumber(String drugNumber) 
    {
        this.drugNumber = drugNumber;
    }

    public String getDrugNumber() 
    {
        return drugNumber;
    }
    public void setDrugKey(String drugKey) 
    {
        this.drugKey = drugKey;
    }

    public String getDrugKey() 
    {
        return drugKey;
    }
    public void setDrugType(String drugType) 
    {
        this.drugType = drugType;
    }

    public String getDrugType() 
    {
        return drugType;
    }
    public void setDrugRxType(String drugRxType) 
    {
        this.drugRxType = drugRxType;
    }

    public String getDrugRxType() 
    {
        return drugRxType;
    }
    public void setDrugUnit(String drugUnit) 
    {
        this.drugUnit = drugUnit;
    }

    public String getDrugUnit() 
    {
        return drugUnit;
    }
    public void setDrugRxPrice(BigDecimal drugRxPrice) 
    {
        this.drugRxPrice = drugRxPrice;
    }

    public BigDecimal getDrugRxPrice() 
    {
        return drugRxPrice;
    }
    public void setDrugStocks(Long drugStocks) 
    {
        this.drugStocks = drugStocks;
    }

    public Long getDrugStocks() 
    {
        return drugStocks;
    }
    public void setDrugWarning(Long drugWarning) 
    {
        this.drugWarning = drugWarning;
    }

    public Long getDrugWarning() 
    {
        return drugWarning;
    }
    public void setDrugMatrixing(Long drugMatrixing) 
    {
        this.drugMatrixing = drugMatrixing;
    }

    public Long getDrugMatrixing() 
    {
        return drugMatrixing;
    }
    public void setDrugStatus(Long drugStatus) 
    {
        this.drugStatus = drugStatus;
    }

    public Long getDrugStatus() 
    {
        return drugStatus;
    }
    public void setFacId(Long facId) 
    {
        this.facId = facId;
    }

    public Long getFacId() 
    {
        return facId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("drugId", getDrugId())
            .append("drugName", getDrugName())
            .append("drugNumber", getDrugNumber())
            .append("drugKey", getDrugKey())
            .append("drugType", getDrugType())
            .append("drugRxType", getDrugRxType())
            .append("drugUnit", getDrugUnit())
            .append("drugRxPrice", getDrugRxPrice())
            .append("drugStocks", getDrugStocks())
            .append("drugWarning", getDrugWarning())
            .append("drugMatrixing", getDrugMatrixing())
            .append("drugStatus", getDrugStatus())
            .append("facId", getFacId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
