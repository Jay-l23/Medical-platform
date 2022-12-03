package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDeptsMapper;
import com.ruoyi.system.domain.SysDepts;
import com.ruoyi.system.service.ISysDeptsService;

/**
 * 科室管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
@Service
public class SysDeptsServiceImpl implements ISysDeptsService 
{
    @Autowired
    private SysDeptsMapper sysDeptsMapper;

    /**
     * 查询科室管理
     * 
     * @param deptsId 科室管理主键
     * @return 科室管理
     */
    @Override
    public SysDepts selectSysDeptsByDeptsId(Long deptsId)
    {
        return sysDeptsMapper.selectSysDeptsByDeptsId(deptsId);
    }

    /**
     * 查询科室管理列表
     * 
     * @param sysDepts 科室管理
     * @return 科室管理
     */
    @Override
    public List<SysDepts> selectSysDeptsList(SysDepts sysDepts)
    {
        return sysDeptsMapper.selectSysDeptsList(sysDepts);
    }

    /**
     * 新增科室管理
     * 
     * @param sysDepts 科室管理
     * @return 结果
     */
    @Override
    public int insertSysDepts(SysDepts sysDepts)
    {
        sysDepts.setCreateTime(DateUtils.getNowDate());
        return sysDeptsMapper.insertSysDepts(sysDepts);
    }

    /**
     * 修改科室管理
     * 
     * @param sysDepts 科室管理
     * @return 结果
     */
    @Override
    public int updateSysDepts(SysDepts sysDepts)
    {
        sysDepts.setUpdateTime(DateUtils.getNowDate());
        return sysDeptsMapper.updateSysDepts(sysDepts);
    }

    /**
     * 批量删除科室管理
     * 
     * @param deptsIds 需要删除的科室管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDeptsByDeptsIds(Long[] deptsIds)
    {
        return sysDeptsMapper.deleteSysDeptsByDeptsIds(deptsIds);
    }

    /**
     * 删除科室管理信息
     * 
     * @param deptsId 科室管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDeptsByDeptsId(Long deptsId)
    {
        return sysDeptsMapper.deleteSysDeptsByDeptsId(deptsId);
    }
}
