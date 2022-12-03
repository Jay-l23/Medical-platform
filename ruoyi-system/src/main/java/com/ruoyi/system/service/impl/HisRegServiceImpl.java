package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HisRegMapper;
import com.ruoyi.system.domain.HisReg;
import com.ruoyi.system.service.IHisRegService;

/**
 * 挂号列表Service业务层处理
 * 
 * @author lijie
 * @date 2022-12-03
 */
@Service
public class HisRegServiceImpl implements IHisRegService 
{
    @Autowired
    private HisRegMapper hisRegMapper;

    /**
     * 查询挂号列表
     * 
     * @param regId 挂号列表主键
     * @return 挂号列表
     */
    @Override
    public HisReg selectHisRegByRegId(Long regId)
    {
        return hisRegMapper.selectHisRegByRegId(regId);
    }

    /**
     * 查询挂号列表列表
     * 
     * @param hisReg 挂号列表
     * @return 挂号列表
     */
    @Override
    public List<HisReg> selectHisRegList(HisReg hisReg)
    {
        return hisRegMapper.selectHisRegList(hisReg);
    }

    /**
     * 新增挂号列表
     * 
     * @param hisReg 挂号列表
     * @return 结果
     */
    @Override
    public int insertHisReg(HisReg hisReg)
    {
        hisReg.setCreateTime(DateUtils.getNowDate());
        return hisRegMapper.insertHisReg(hisReg);
    }

    /**
     * 修改挂号列表
     * 
     * @param hisReg 挂号列表
     * @return 结果
     */
    @Override
    public int updateHisReg(HisReg hisReg)
    {
        hisReg.setUpdateTime(DateUtils.getNowDate());
        return hisRegMapper.updateHisReg(hisReg);
    }

    /**
     * 批量删除挂号列表
     * 
     * @param regIds 需要删除的挂号列表主键
     * @return 结果
     */
    @Override
    public int deleteHisRegByRegIds(Long[] regIds)
    {
        return hisRegMapper.deleteHisRegByRegIds(regIds);
    }

    /**
     * 删除挂号列表信息
     * 
     * @param regId 挂号列表主键
     * @return 结果
     */
    @Override
    public int deleteHisRegByRegId(Long regId)
    {
        return hisRegMapper.deleteHisRegByRegId(regId);
    }
}
