package com.ruoyi.his.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisChargedetailMapper;
import com.ruoyi.his.domain.HisChargedetail;
import com.ruoyi.his.service.IHisChargedetailService;

/**
 * 收费查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
@Service
public class HisChargedetailServiceImpl implements IHisChargedetailService 
{
    @Autowired
    private HisChargedetailMapper hisChargedetailMapper;

    /**
     * 查询收费查询
     * 
     * @param id 收费查询主键
     * @return 收费查询
     */
    @Override
    public HisChargedetail selectHisChargedetailById(Long id)
    {
        return hisChargedetailMapper.selectHisChargedetailById(id);
    }

    /**
     * 查询收费查询列表
     * 
     * @param hisChargedetail 收费查询
     * @return 收费查询
     */
    @Override
    public List<HisChargedetail> selectHisChargedetailList(HisChargedetail hisChargedetail)
    {
        return hisChargedetailMapper.selectHisChargedetailList(hisChargedetail);
    }

    /**
     * 新增收费查询
     * 
     * @param hisChargedetail 收费查询
     * @return 结果
     */
    @Override
    public int insertHisChargedetail(HisChargedetail hisChargedetail)
    {
        return hisChargedetailMapper.insertHisChargedetail(hisChargedetail);
    }

    /**
     * 修改收费查询
     * 
     * @param hisChargedetail 收费查询
     * @return 结果
     */
    @Override
    public int updateHisChargedetail(HisChargedetail hisChargedetail)
    {
        return hisChargedetailMapper.updateHisChargedetail(hisChargedetail);
    }

    /**
     * 批量删除收费查询
     * 
     * @param ids 需要删除的收费查询主键
     * @return 结果
     */
    @Override
    public int deleteHisChargedetailByIds(Long[] ids)
    {
        return hisChargedetailMapper.deleteHisChargedetailByIds(ids);
    }

    /**
     * 删除收费查询信息
     * 
     * @param id 收费查询主键
     * @return 结果
     */
    @Override
    public int deleteHisChargedetailById(Long id)
    {
        return hisChargedetailMapper.deleteHisChargedetailById(id);
    }
}
