package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MedPatiMapper;
import com.ruoyi.system.domain.MedPati;
import com.ruoyi.system.service.IMedPatiService;

/**
 * 患者库Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
@Service
public class MedPatiServiceImpl implements IMedPatiService 
{
    @Autowired
    private MedPatiMapper medPatiMapper;

    /**
     * 查询患者库
     * 
     * @param patiId 患者库主键
     * @return 患者库
     */
    @Override
    public MedPati selectMedPatiByPatiId(Long patiId)
    {
        return medPatiMapper.selectMedPatiByPatiId(patiId);
    }

    /**
     * 查询患者库列表
     * 
     * @param medPati 患者库
     * @return 患者库
     */
    @Override
    public List<MedPati> selectMedPatiList(MedPati medPati)
    {
        return medPatiMapper.selectMedPatiList(medPati);
    }

    /**
     * 新增患者库
     * 
     * @param medPati 患者库
     * @return 结果
     */
    @Override
    public int insertMedPati(MedPati medPati)
    {
        medPati.setCreateTime(DateUtils.getNowDate());
        return medPatiMapper.insertMedPati(medPati);
    }

    /**
     * 修改患者库
     * 
     * @param medPati 患者库
     * @return 结果
     */
    @Override
    public int updateMedPati(MedPati medPati)
    {
        medPati.setUpdateTime(DateUtils.getNowDate());
        return medPatiMapper.updateMedPati(medPati);
    }

    /**
     * 批量删除患者库
     * 
     * @param patiIds 需要删除的患者库主键
     * @return 结果
     */
    @Override
    public int deleteMedPatiByPatiIds(Long[] patiIds)
    {
        return medPatiMapper.deleteMedPatiByPatiIds(patiIds);
    }

    /**
     * 删除患者库信息
     * 
     * @param patiId 患者库主键
     * @return 结果
     */
    @Override
    public int deleteMedPatiByPatiId(Long patiId)
    {
        return medPatiMapper.deleteMedPatiByPatiId(patiId);
    }
}
