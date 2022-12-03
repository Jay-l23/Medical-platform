package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MedPati;

/**
 * 患者库Service接口
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public interface IMedPatiService 
{
    /**
     * 查询患者库
     * 
     * @param patiId 患者库主键
     * @return 患者库
     */
    public MedPati selectMedPatiByPatiId(Long patiId);

    /**
     * 查询患者库列表
     * 
     * @param medPati 患者库
     * @return 患者库集合
     */
    public List<MedPati> selectMedPatiList(MedPati medPati);

    /**
     * 新增患者库
     * 
     * @param medPati 患者库
     * @return 结果
     */
    public int insertMedPati(MedPati medPati);

    /**
     * 修改患者库
     * 
     * @param medPati 患者库
     * @return 结果
     */
    public int updateMedPati(MedPati medPati);

    /**
     * 批量删除患者库
     * 
     * @param patiIds 需要删除的患者库主键集合
     * @return 结果
     */
    public int deleteMedPatiByPatiIds(Long[] patiIds);

    /**
     * 删除患者库信息
     * 
     * @param patiId 患者库主键
     * @return 结果
     */
    public int deleteMedPatiByPatiId(Long patiId);
}
