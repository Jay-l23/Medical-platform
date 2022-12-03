package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysExamCost;

/**
 * 检查费用Service接口
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public interface ISysExamCostService 
{
    /**
     * 查询检查费用
     * 
     * @param examId 检查费用主键
     * @return 检查费用
     */
    public SysExamCost selectSysExamCostByExamId(Long examId);

    /**
     * 查询检查费用列表
     * 
     * @param sysExamCost 检查费用
     * @return 检查费用集合
     */
    public List<SysExamCost> selectSysExamCostList(SysExamCost sysExamCost);

    /**
     * 新增检查费用
     * 
     * @param sysExamCost 检查费用
     * @return 结果
     */
    public int insertSysExamCost(SysExamCost sysExamCost);

    /**
     * 修改检查费用
     * 
     * @param sysExamCost 检查费用
     * @return 结果
     */
    public int updateSysExamCost(SysExamCost sysExamCost);

    /**
     * 批量删除检查费用
     * 
     * @param examIds 需要删除的检查费用主键集合
     * @return 结果
     */
    public int deleteSysExamCostByExamIds(Long[] examIds);

    /**
     * 删除检查费用信息
     * 
     * @param examId 检查费用主键
     * @return 结果
     */
    public int deleteSysExamCostByExamId(Long examId);
}
