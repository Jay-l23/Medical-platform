package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysDepts;

/**
 * 科室管理Service接口
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public interface ISysDeptsService 
{
    /**
     * 查询科室管理
     * 
     * @param deptsId 科室管理主键
     * @return 科室管理
     */
    public SysDepts selectSysDeptsByDeptsId(Long deptsId);

    /**
     * 查询科室管理列表
     * 
     * @param sysDepts 科室管理
     * @return 科室管理集合
     */
    public List<SysDepts> selectSysDeptsList(SysDepts sysDepts);

    /**
     * 新增科室管理
     * 
     * @param sysDepts 科室管理
     * @return 结果
     */
    public int insertSysDepts(SysDepts sysDepts);

    /**
     * 修改科室管理
     * 
     * @param sysDepts 科室管理
     * @return 结果
     */
    public int updateSysDepts(SysDepts sysDepts);

    /**
     * 批量删除科室管理
     * 
     * @param deptsIds 需要删除的科室管理主键集合
     * @return 结果
     */
    public int deleteSysDeptsByDeptsIds(Long[] deptsIds);

    /**
     * 删除科室管理信息
     * 
     * @param deptsId 科室管理主键
     * @return 结果
     */
    public int deleteSysDeptsByDeptsId(Long deptsId);
}
