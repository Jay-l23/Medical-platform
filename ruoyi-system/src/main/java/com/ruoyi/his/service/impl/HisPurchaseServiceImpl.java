package com.ruoyi.his.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisPurchaseMapper;
import com.ruoyi.his.domain.HisPurchase;
import com.ruoyi.his.service.IHisPurchaseService;

/**
 * 采购入库Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
@Service
public class HisPurchaseServiceImpl implements IHisPurchaseService 
{
    @Autowired
    private HisPurchaseMapper hisPurchaseMapper;

    /**
     * 查询采购入库
     * 
     * @param purId 采购入库主键
     * @return 采购入库
     */
    @Override
    public HisPurchase selectHisPurchaseByPurId(String purId)
    {
        return hisPurchaseMapper.selectHisPurchaseByPurId(purId);
    }

    /**
     * 查询采购入库列表
     * 
     * @param hisPurchase 采购入库
     * @return 采购入库
     */
    @Override
    public List<HisPurchase> selectHisPurchaseList(HisPurchase hisPurchase)
    {
        return hisPurchaseMapper.selectHisPurchaseList(hisPurchase);
    }

    /**
     * 新增采购入库
     * 
     * @param hisPurchase 采购入库
     * @return 结果
     */
    @Override
    public int insertHisPurchase(HisPurchase hisPurchase)
    {
        hisPurchase.setCreateTime(DateUtils.getNowDate());
        return hisPurchaseMapper.insertHisPurchase(hisPurchase);
    }

    /**
     * 修改采购入库
     * 
     * @param hisPurchase 采购入库
     * @return 结果
     */
    @Override
    public int updateHisPurchase(HisPurchase hisPurchase)
    {
        hisPurchase.setUpdateTime(DateUtils.getNowDate());
        return hisPurchaseMapper.updateHisPurchase(hisPurchase);
    }

    /**
     * 批量删除采购入库
     * 
     * @param purIds 需要删除的采购入库主键
     * @return 结果
     */
    @Override
    public int deleteHisPurchaseByPurIds(String[] purIds)
    {
        return hisPurchaseMapper.deleteHisPurchaseByPurIds(purIds);
    }

    /**
     * 删除采购入库信息
     * 
     * @param purId 采购入库主键
     * @return 结果
     */
    @Override
    public int deleteHisPurchaseByPurId(String purId)
    {
        return hisPurchaseMapper.deleteHisPurchaseByPurId(purId);
    }
}
