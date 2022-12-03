package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Supplier;
import com.ruoyi.system.service.ISupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商维护Controller
 * 
 * @author lijie
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/supplier")
public class SupplierController extends BaseController
{
    @Autowired
    private ISupplierService supplierService;

    /**
     * 查询供应商维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(Supplier supplier)
    {
        startPage();
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:export')")
    @Log(title = "供应商维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Supplier supplier)
    {
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        ExcelUtil<Supplier> util = new ExcelUtil<Supplier>(Supplier.class);
        util.exportExcel(response, list, "供应商维护数据");
    }

    /**
     * 获取供应商维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:query')")
    @GetMapping(value = "/{supId}")
    public AjaxResult getInfo(@PathVariable("supId") Long supId)
    {
        return success(supplierService.selectSupplierBySupId(supId));
    }

    /**
     * 新增供应商维护
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:add')")
    @Log(title = "供应商维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Supplier supplier)
    {
        return toAjax(supplierService.insertSupplier(supplier));
    }

    /**
     * 修改供应商维护
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:edit')")
    @Log(title = "供应商维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Supplier supplier)
    {
        return toAjax(supplierService.updateSupplier(supplier));
    }

    /**
     * 删除供应商维护
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:remove')")
    @Log(title = "供应商维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supIds}")
    public AjaxResult remove(@PathVariable Long[] supIds)
    {
        return toAjax(supplierService.deleteSupplierBySupIds(supIds));
    }
}
