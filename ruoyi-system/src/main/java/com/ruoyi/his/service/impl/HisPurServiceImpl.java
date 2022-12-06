package com.ruoyi.his.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisPurMapper;
import com.ruoyi.his.domain.HisPur;
import com.ruoyi.his.service.IHisPurService;

/**
 * 提交订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
@Service
public class HisPurServiceImpl implements IHisPurService 
{
    @Autowired
    private HisPurMapper hisPurMapper;

    /**
     * 查询提交订单
     * 
     * @param purOrderId 提交订单主键
     * @return 提交订单
     */
    @Override
    public HisPur selectHisPurByPurOrderId(String purOrderId)
    {
        return hisPurMapper.selectHisPurByPurOrderId(purOrderId);
    }

    /**
     * 查询提交订单列表
     * 
     * @param hisPur 提交订单
     * @return 提交订单
     */
    @Override
    public List<HisPur> selectHisPurList(HisPur hisPur)
    {
        return hisPurMapper.selectHisPurList(hisPur);
    }

    /**
     * 新增提交订单
     * 
     * @param hisPur 提交订单
     * @return 结果
     */
    @Override
    public int insertHisPur(HisPur hisPur)
    {
        hisPur.setCreateTime(DateUtils.getNowDate());
        return hisPurMapper.insertHisPur(hisPur);
    }

    /**
     * 修改提交订单
     * 
     * @param hisPur 提交订单
     * @return 结果
     */
    @Override
    public int updateHisPur(HisPur hisPur)
    {
        hisPur.setUpdateTime(DateUtils.getNowDate());
        return hisPurMapper.updateHisPur(hisPur);
    }

    /**
     * 批量删除提交订单
     * 
     * @param purOrderIds 需要删除的提交订单主键
     * @return 结果
     */
    @Override
    public int deleteHisPurByPurOrderIds(String[] purOrderIds)
    {
        return hisPurMapper.deleteHisPurByPurOrderIds(purOrderIds);
    }

    /**
     * 删除提交订单信息
     * 
     * @param purOrderId 提交订单主键
     * @return 结果
     */
    @Override
    public int deleteHisPurByPurOrderId(String purOrderId)
    {
        return hisPurMapper.deleteHisPurByPurOrderId(purOrderId);
    }
}
