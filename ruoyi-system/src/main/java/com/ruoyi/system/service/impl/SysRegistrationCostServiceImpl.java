package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRegistrationCostMapper;
import com.ruoyi.system.domain.SysRegistrationCost;
import com.ruoyi.system.service.ISysRegistrationCostService;

/**
 * 挂号费用设置Service业务层处理
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@Service
public class SysRegistrationCostServiceImpl implements ISysRegistrationCostService 
{
    @Autowired
    private SysRegistrationCostMapper sysRegistrationCostMapper;

    /**
     * 查询挂号费用设置
     * 
     * @param regId 挂号费用设置主键
     * @return 挂号费用设置
     */
    @Override
    public SysRegistrationCost selectSysRegistrationCostByRegId(Long regId)
    {
        return sysRegistrationCostMapper.selectSysRegistrationCostByRegId(regId);
    }

    /**
     * 查询挂号费用设置列表
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 挂号费用设置
     */
    @Override
    public List<SysRegistrationCost> selectSysRegistrationCostList(SysRegistrationCost sysRegistrationCost)
    {
        return sysRegistrationCostMapper.selectSysRegistrationCostList(sysRegistrationCost);
    }

    /**
     * 新增挂号费用设置
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 结果
     */
    @Override
    public int insertSysRegistrationCost(SysRegistrationCost sysRegistrationCost)
    {
        sysRegistrationCost.setCreateTime(DateUtils.getNowDate());
        return sysRegistrationCostMapper.insertSysRegistrationCost(sysRegistrationCost);
    }

    /**
     * 修改挂号费用设置
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 结果
     */
    @Override
    public int updateSysRegistrationCost(SysRegistrationCost sysRegistrationCost)
    {
        sysRegistrationCost.setUpdateTime(DateUtils.getNowDate());
        return sysRegistrationCostMapper.updateSysRegistrationCost(sysRegistrationCost);
    }

    /**
     * 批量删除挂号费用设置
     * 
     * @param regIds 需要删除的挂号费用设置主键
     * @return 结果
     */
    @Override
    public int deleteSysRegistrationCostByRegIds(Long[] regIds)
    {
        return sysRegistrationCostMapper.deleteSysRegistrationCostByRegIds(regIds);
    }

    /**
     * 删除挂号费用设置信息
     * 
     * @param regId 挂号费用设置主键
     * @return 结果
     */
    @Override
    public int deleteSysRegistrationCostByRegId(Long regId)
    {
        return sysRegistrationCostMapper.deleteSysRegistrationCostByRegId(regId);
    }
}
