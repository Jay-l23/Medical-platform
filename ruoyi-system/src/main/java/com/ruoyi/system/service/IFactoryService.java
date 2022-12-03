package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Factory;

/**
 * 生产厂商管理Service接口
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public interface IFactoryService 
{
    /**
     * 查询生产厂商管理
     * 
     * @param facId 生产厂商管理主键
     * @return 生产厂商管理
     */
    public Factory selectFactoryByFacId(Long facId);

    /**
     * 查询生产厂商管理列表
     * 
     * @param factory 生产厂商管理
     * @return 生产厂商管理集合
     */
    public List<Factory> selectFactoryList(Factory factory);

    /**
     * 新增生产厂商管理
     * 
     * @param factory 生产厂商管理
     * @return 结果
     */
    public int insertFactory(Factory factory);

    /**
     * 修改生产厂商管理
     * 
     * @param factory 生产厂商管理
     * @return 结果
     */
    public int updateFactory(Factory factory);

    /**
     * 批量删除生产厂商管理
     * 
     * @param facIds 需要删除的生产厂商管理主键集合
     * @return 结果
     */
    public int deleteFactoryByFacIds(Long[] facIds);

    /**
     * 删除生产厂商管理信息
     * 
     * @param facId 生产厂商管理主键
     * @return 结果
     */
    public int deleteFactoryByFacId(Long facId);
}
