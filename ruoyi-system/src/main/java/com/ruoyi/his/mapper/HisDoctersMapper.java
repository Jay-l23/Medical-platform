package com.ruoyi.his.mapper;

import java.util.List;
import com.ruoyi.his.domain.HisDocters;

/**
 * 医生管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public interface HisDoctersMapper 
{
    /**
     * 查询医生管理
     * 
     * @param dId 医生管理主键
     * @return 医生管理
     */
    public HisDocters selectHisDoctersByDId(Long dId);

    /**
     * 查询医生管理列表
     * 
     * @param hisDocters 医生管理
     * @return 医生管理集合
     */
    public List<HisDocters> selectHisDoctersList(HisDocters hisDocters);

    /**
     * 新增医生管理
     * 
     * @param hisDocters 医生管理
     * @return 结果
     */
    public int insertHisDocters(HisDocters hisDocters);

    /**
     * 修改医生管理
     * 
     * @param hisDocters 医生管理
     * @return 结果
     */
    public int updateHisDocters(HisDocters hisDocters);

    /**
     * 删除医生管理
     * 
     * @param dId 医生管理主键
     * @return 结果
     */
    public int deleteHisDoctersByDId(Long dId);

    /**
     * 批量删除医生管理
     * 
     * @param dIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisDoctersByDIds(Long[] dIds);
}
