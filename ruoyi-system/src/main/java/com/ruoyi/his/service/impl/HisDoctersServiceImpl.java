package com.ruoyi.his.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisDoctersMapper;
import com.ruoyi.his.domain.HisDocters;
import com.ruoyi.his.service.IHisDoctersService;

/**
 * 医生管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
@Service
public class HisDoctersServiceImpl implements IHisDoctersService 
{
    @Autowired
    private HisDoctersMapper hisDoctersMapper;

    /**
     * 查询医生管理
     * 
     * @param dId 医生管理主键
     * @return 医生管理
     */
    @Override
    public HisDocters selectHisDoctersByDId(Long dId)
    {
        return hisDoctersMapper.selectHisDoctersByDId(dId);
    }

    /**
     * 查询医生管理列表
     * 
     * @param hisDocters 医生管理
     * @return 医生管理
     */
    @Override
    public List<HisDocters> selectHisDoctersList(HisDocters hisDocters)
    {
        return hisDoctersMapper.selectHisDoctersList(hisDocters);
    }

    /**
     * 新增医生管理
     * 
     * @param hisDocters 医生管理
     * @return 结果
     */
    @Override
    public int insertHisDocters(HisDocters hisDocters)
    {
        hisDocters.setCreateTime(DateUtils.getNowDate());
        return hisDoctersMapper.insertHisDocters(hisDocters);
    }

    /**
     * 修改医生管理
     * 
     * @param hisDocters 医生管理
     * @return 结果
     */
    @Override
    public int updateHisDocters(HisDocters hisDocters)
    {
        return hisDoctersMapper.updateHisDocters(hisDocters);
    }

    /**
     * 批量删除医生管理
     * 
     * @param dIds 需要删除的医生管理主键
     * @return 结果
     */
    @Override
    public int deleteHisDoctersByDIds(Long[] dIds)
    {
        return hisDoctersMapper.deleteHisDoctersByDIds(dIds);
    }

    /**
     * 删除医生管理信息
     * 
     * @param dId 医生管理主键
     * @return 结果
     */
    @Override
    public int deleteHisDoctersByDId(Long dId)
    {
        return hisDoctersMapper.deleteHisDoctersByDId(dId);
    }
}
