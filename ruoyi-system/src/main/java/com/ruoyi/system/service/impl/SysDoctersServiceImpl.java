package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDoctersMapper;
import com.ruoyi.system.domain.SysDocters;
import com.ruoyi.system.service.ISysDoctersService;

/**
 * 医生信息管理Service业务层处理
 * 
 * @author lijie
 * @date 2022-11-05
 */
@Service
public class SysDoctersServiceImpl implements ISysDoctersService 
{
    @Autowired
    private SysDoctersMapper sysDoctersMapper;

    /**
     * 查询医生信息管理
     * 
     * @param dId 医生信息管理主键
     * @return 医生信息管理
     */
    @Override
    public SysDocters selectSysDoctersByDId(Long dId)
    {
        return sysDoctersMapper.selectSysDoctersByDId(dId);
    }

    /**
     * 查询医生信息管理列表
     * 
     * @param sysDocters 医生信息管理
     * @return 医生信息管理
     */
    @Override
    public List<SysDocters> selectSysDoctersList(SysDocters sysDocters)
    {
        return sysDoctersMapper.selectSysDoctersList(sysDocters);
    }

    /**
     * 新增医生信息管理
     * 
     * @param sysDocters 医生信息管理
     * @return 结果
     */
    @Override
    public int insertSysDocters(SysDocters sysDocters)
    {
        sysDocters.setCreateTime(DateUtils.getNowDate());
        return sysDoctersMapper.insertSysDocters(sysDocters);
    }

    /**
     * 修改医生信息管理
     * 
     * @param sysDocters 医生信息管理
     * @return 结果
     */
    @Override
    public int updateSysDocters(SysDocters sysDocters)
    {
        return sysDoctersMapper.updateSysDocters(sysDocters);
    }

    /**
     * 批量删除医生信息管理
     * 
     * @param dIds 需要删除的医生信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDoctersByDIds(Long[] dIds)
    {
        return sysDoctersMapper.deleteSysDoctersByDIds(dIds);
    }

    /**
     * 删除医生信息管理信息
     * 
     * @param dId 医生信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDoctersByDId(Long dId)
    {
        return sysDoctersMapper.deleteSysDoctersByDId(dId);
    }
}
