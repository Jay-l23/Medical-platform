package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检查费用对象 sys_exam_cost
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public class SysExamCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目费用ID */
    private Long examId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String examName;

    /** 项目关键字 */
    @Excel(name = "项目关键字")
    private String examKey;

    /** 项目单价 */
    @Excel(name = "项目单价")
    private BigDecimal examOnePrice;

    /** 项目成本 */
    @Excel(name = "项目成本")
    private BigDecimal examCost;

    /** 单位 */
    @Excel(name = "单位")
    private String examUnit;

    /** 类别 */
    @Excel(name = "类别")
    private Long examType;

    /** 状态  */
    @Excel(name = "状态 ")
    private Integer status;

    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }
    public void setExamName(String examName) 
    {
        this.examName = examName;
    }

    public String getExamName() 
    {
        return examName;
    }
    public void setExamKey(String examKey) 
    {
        this.examKey = examKey;
    }

    public String getExamKey() 
    {
        return examKey;
    }
    public void setExamOnePrice(BigDecimal examOnePrice) 
    {
        this.examOnePrice = examOnePrice;
    }

    public BigDecimal getExamOnePrice() 
    {
        return examOnePrice;
    }
    public void setExamCost(BigDecimal examCost) 
    {
        this.examCost = examCost;
    }

    public BigDecimal getExamCost() 
    {
        return examCost;
    }
    public void setExamUnit(String examUnit) 
    {
        this.examUnit = examUnit;
    }

    public String getExamUnit() 
    {
        return examUnit;
    }
    public void setExamType(Long examType) 
    {
        this.examType = examType;
    }

    public Long getExamType() 
    {
        return examType;
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
            .append("examId", getExamId())
            .append("examName", getExamName())
            .append("examKey", getExamKey())
            .append("examOnePrice", getExamOnePrice())
            .append("examCost", getExamCost())
            .append("examUnit", getExamUnit())
            .append("examType", getExamType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
