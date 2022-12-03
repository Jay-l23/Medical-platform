package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Supplier;

/**
 * 供应商维护Mapper接口
 * 
 * @author lijie
 * @date 2022-11-04
 */
public interface SupplierMapper 
{
    /**
     * 查询供应商维护
     * 
     * @param supId 供应商维护主键
     * @return 供应商维护
     */
    public Supplier selectSupplierBySupId(Long supId);

    /**
     * 查询供应商维护列表
     * 
     * @param supplier 供应商维护
     * @return 供应商维护集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商维护
     * 
     * @param supplier 供应商维护
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供应商维护
     * 
     * @param supplier 供应商维护
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 删除供应商维护
     * 
     * @param supId 供应商维护主键
     * @return 结果
     */
    public int deleteSupplierBySupId(Long supId);

    /**
     * 批量删除供应商维护
     * 
     * @param supIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSupplierBySupIds(Long[] supIds);
}
