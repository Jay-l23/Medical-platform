package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FactoryMapper;
import com.ruoyi.system.domain.Factory;
import com.ruoyi.system.service.IFactoryService;

/**
 * 生产厂商管理Service业务层处理
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@Service
public class FactoryServiceImpl implements IFactoryService 
{
    @Autowired
    private FactoryMapper factoryMapper;

    /**
     * 查询生产厂商管理
     * 
     * @param facId 生产厂商管理主键
     * @return 生产厂商管理
     */
    @Override
    public Factory selectFactoryByFacId(Long facId)
    {
        return factoryMapper.selectFactoryByFacId(facId);
    }

    /**
     * 查询生产厂商管理列表
     * 
     * @param factory 生产厂商管理
     * @return 生产厂商管理
     */
    @Override
    public List<Factory> selectFactoryList(Factory factory)
    {
        return factoryMapper.selectFactoryList(factory);
    }

    /**
     * 新增生产厂商管理
     * 
     * @param factory 生产厂商管理
     * @return 结果
     */
    @Override
    public int insertFactory(Factory factory)
    {
        factory.setCreateTime(DateUtils.getNowDate());
        return factoryMapper.insertFactory(factory);
    }

    /**
     * 修改生产厂商管理
     * 
     * @param factory 生产厂商管理
     * @return 结果
     */
    @Override
    public int updateFactory(Factory factory)
    {
        factory.setUpdateTime(DateUtils.getNowDate());
        return factoryMapper.updateFactory(factory);
    }

    /**
     * 批量删除生产厂商管理
     * 
     * @param facIds 需要删除的生产厂商管理主键
     * @return 结果
     */
    @Override
    public int deleteFactoryByFacIds(Long[] facIds)
    {
        return factoryMapper.deleteFactoryByFacIds(facIds);
    }

    /**
     * 删除生产厂商管理信息
     * 
     * @param facId 生产厂商管理主键
     * @return 结果
     */
    @Override
    public int deleteFactoryByFacId(Long facId)
    {
        return factoryMapper.deleteFactoryByFacId(facId);
    }
}
