package com.ruoyi.his.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科室管理对象 his_depts
 * 
 * @author lijie
 * @date 2022-12-05
 */
public class HisDepts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科室编号 */
    private Long deptsId;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String deptsName;

    /** 科室编码 */
    @Excel(name = "科室编码")
    private String deptsCode;

    /** 科室挂号 */
    @Excel(name = "科室挂号")
    private Long deptsNum;

    /** 科室领导 */
    @Excel(name = "科室领导")
    private String deptsLeader;

    /** 科室电话 */
    @Excel(name = "科室电话")
    private String deptsPhone;

    /** 科室状态 */
    @Excel(name = "科室状态")
    private Long status;

    public void setDeptsId(Long deptsId) 
    {
        this.deptsId = deptsId;
    }

    public Long getDeptsId() 
    {
        return deptsId;
    }
    public void setDeptsName(String deptsName) 
    {
        this.deptsName = deptsName;
    }

    public String getDeptsName() 
    {
        return deptsName;
    }
    public void setDeptsCode(String deptsCode) 
    {
        this.deptsCode = deptsCode;
    }

    public String getDeptsCode() 
    {
        return deptsCode;
    }
    public void setDeptsNum(Long deptsNum) 
    {
        this.deptsNum = deptsNum;
    }

    public Long getDeptsNum() 
    {
        return deptsNum;
    }
    public void setDeptsLeader(String deptsLeader) 
    {
        this.deptsLeader = deptsLeader;
    }

    public String getDeptsLeader() 
    {
        return deptsLeader;
    }
    public void setDeptsPhone(String deptsPhone) 
    {
        this.deptsPhone = deptsPhone;
    }

    public String getDeptsPhone() 
    {
        return deptsPhone;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptsId", getDeptsId())
            .append("deptsName", getDeptsName())
            .append("deptsCode", getDeptsCode())
            .append("deptsNum", getDeptsNum())
            .append("deptsLeader", getDeptsLeader())
            .append("deptsPhone", getDeptsPhone())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
