package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysDocters;

/**
 * 医生信息管理Mapper接口
 * 
 * @author lijie
 * @date 2022-11-05
 */
public interface SysDoctersMapper 
{
    /**
     * 查询医生信息管理
     * 
     * @param dId 医生信息管理主键
     * @return 医生信息管理
     */
    public SysDocters selectSysDoctersByDId(Long dId);

    /**
     * 查询医生信息管理列表
     * 
     * @param sysDocters 医生信息管理
     * @return 医生信息管理集合
     */
    public List<SysDocters> selectSysDoctersList(SysDocters sysDocters);

    /**
     * 新增医生信息管理
     * 
     * @param sysDocters 医生信息管理
     * @return 结果
     */
    public int insertSysDocters(SysDocters sysDocters);

    /**
     * 修改医生信息管理
     * 
     * @param sysDocters 医生信息管理
     * @return 结果
     */
    public int updateSysDocters(SysDocters sysDocters);

    /**
     * 删除医生信息管理
     * 
     * @param dId 医生信息管理主键
     * @return 结果
     */
    public int deleteSysDoctersByDId(Long dId);

    /**
     * 批量删除医生信息管理
     * 
     * @param dIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDoctersByDIds(Long[] dIds);
}
