package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysExamCostMapper;
import com.ruoyi.system.domain.SysExamCost;
import com.ruoyi.system.service.ISysExamCostService;

/**
 * 检查费用Service业务层处理
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@Service
public class SysExamCostServiceImpl implements ISysExamCostService 
{
    @Autowired
    private SysExamCostMapper sysExamCostMapper;

    /**
     * 查询检查费用
     * 
     * @param examId 检查费用主键
     * @return 检查费用
     */
    @Override
    public SysExamCost selectSysExamCostByExamId(Long examId)
    {
        return sysExamCostMapper.selectSysExamCostByExamId(examId);
    }

    /**
     * 查询检查费用列表
     * 
     * @param sysExamCost 检查费用
     * @return 检查费用
     */
    @Override
    public List<SysExamCost> selectSysExamCostList(SysExamCost sysExamCost)
    {
        return sysExamCostMapper.selectSysExamCostList(sysExamCost);
    }

    /**
     * 新增检查费用
     * 
     * @param sysExamCost 检查费用
     * @return 结果
     */
    @Override
    public int insertSysExamCost(SysExamCost sysExamCost)
    {
        sysExamCost.setCreateTime(DateUtils.getNowDate());
        return sysExamCostMapper.insertSysExamCost(sysExamCost);
    }

    /**
     * 修改检查费用
     * 
     * @param sysExamCost 检查费用
     * @return 结果
     */
    @Override
    public int updateSysExamCost(SysExamCost sysExamCost)
    {
        sysExamCost.setUpdateTime(DateUtils.getNowDate());
        return sysExamCostMapper.updateSysExamCost(sysExamCost);
    }

    /**
     * 批量删除检查费用
     * 
     * @param examIds 需要删除的检查费用主键
     * @return 结果
     */
    @Override
    public int deleteSysExamCostByExamIds(Long[] examIds)
    {
        return sysExamCostMapper.deleteSysExamCostByExamIds(examIds);
    }

    /**
     * 删除检查费用信息
     * 
     * @param examId 检查费用主键
     * @return 结果
     */
    @Override
    public int deleteSysExamCostByExamId(Long examId)
    {
        return sysExamCostMapper.deleteSysExamCostByExamId(examId);
    }
}
