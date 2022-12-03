package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Drug;

/**
 * 药品信息维护Mapper接口
 * 
 * @author lijie
 * @date 2022-11-04
 */
public interface DrugMapper 
{
    /**
     * 查询药品信息维护
     * 
     * @param drugId 药品信息维护主键
     * @return 药品信息维护
     */
    public Drug selectDrugByDrugId(Long drugId);

    /**
     * 查询药品信息维护列表
     * 
     * @param drug 药品信息维护
     * @return 药品信息维护集合
     */
    public List<Drug> selectDrugList(Drug drug);

    /**
     * 新增药品信息维护
     * 
     * @param drug 药品信息维护
     * @return 结果
     */
    public int insertDrug(Drug drug);

    /**
     * 修改药品信息维护
     * 
     * @param drug 药品信息维护
     * @return 结果
     */
    public int updateDrug(Drug drug);

    /**
     * 删除药品信息维护
     * 
     * @param drugId 药品信息维护主键
     * @return 结果
     */
    public int deleteDrugByDrugId(Long drugId);

    /**
     * 批量删除药品信息维护
     * 
     * @param drugIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugByDrugIds(Long[] drugIds);
}
