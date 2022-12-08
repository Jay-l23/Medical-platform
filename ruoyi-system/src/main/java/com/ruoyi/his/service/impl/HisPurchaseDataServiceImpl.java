package com.ruoyi.his.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisPurchaseDataMapper;
import com.ruoyi.his.domain.HisPurchaseData;
import com.ruoyi.his.service.IHisPurchaseDataService;

/**
 * 订单审核Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-08
 */
@Service
public class HisPurchaseDataServiceImpl implements IHisPurchaseDataService 
{
    @Autowired
    private HisPurchaseDataMapper hisPurchaseDataMapper;

    /**
     * 查询订单审核
     * 
     * @param purOrderId 订单审核主键
     * @return 订单审核
     */
    @Override
    public HisPurchaseData selectHisPurchaseDataByPurOrderId(String purOrderId)
    {
        return hisPurchaseDataMapper.selectHisPurchaseDataByPurOrderId(purOrderId);
    }

    /**
     * 查询订单审核列表
     * 
     * @param hisPurchaseData 订单审核
     * @return 订单审核
     */
    @Override
    public List<HisPurchaseData> selectHisPurchaseDataList(HisPurchaseData hisPurchaseData)
    {
        return hisPurchaseDataMapper.selectHisPurchaseDataList(hisPurchaseData);
    }

    /**
     * 新增订单审核
     * 
     * @param hisPurchaseData 订单审核
     * @return 结果
     */
    @Override
    public int insertHisPurchaseData(HisPurchaseData hisPurchaseData)
    {
        hisPurchaseData.setCreateTime(DateUtils.getNowDate());
        return hisPurchaseDataMapper.insertHisPurchaseData(hisPurchaseData);
    }

    /**
     * 修改订单审核
     * 
     * @param hisPurchaseData 订单审核
     * @return 结果
     */
    @Override
    public int updateHisPurchaseData(HisPurchaseData hisPurchaseData)
    {
        hisPurchaseData.setUpdateTime(DateUtils.getNowDate());
        return hisPurchaseDataMapper.updateHisPurchaseData(hisPurchaseData);
    }

    /**
     * 批量删除订单审核
     * 
     * @param purOrderIds 需要删除的订单审核主键
     * @return 结果
     */
    @Override
    public int deleteHisPurchaseDataByPurOrderIds(String[] purOrderIds)
    {
        return hisPurchaseDataMapper.deleteHisPurchaseDataByPurOrderIds(purOrderIds);
    }

    /**
     * 删除订单审核信息
     * 
     * @param purOrderId 订单审核主键
     * @return 结果
     */
    @Override
    public int deleteHisPurchaseDataByPurOrderId(String purOrderId)
    {
        return hisPurchaseDataMapper.deleteHisPurchaseDataByPurOrderId(purOrderId);
    }
}
