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
import com.ruoyi.system.domain.Factory;
import com.ruoyi.system.service.IFactoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产厂商管理Controller
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/factory")
public class FactoryController extends BaseController
{
    @Autowired
    private IFactoryService factoryService;

    /**
     * 查询生产厂商管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(Factory factory)
    {
        startPage();
        List<Factory> list = factoryService.selectFactoryList(factory);
        return getDataTable(list);
    }

    /**
     * 导出生产厂商管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:factory:export')")
    @Log(title = "生产厂商管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Factory factory)
    {
        List<Factory> list = factoryService.selectFactoryList(factory);
        ExcelUtil<Factory> util = new ExcelUtil<Factory>(Factory.class);
        util.exportExcel(response, list, "生产厂商管理数据");
    }

    /**
     * 获取生产厂商管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:factory:query')")
    @GetMapping(value = "/{facId}")
    public AjaxResult getInfo(@PathVariable("facId") Long facId)
    {
        return success(factoryService.selectFactoryByFacId(facId));
    }

    /**
     * 新增生产厂商管理
     */
    @PreAuthorize("@ss.hasPermi('system:factory:add')")
    @Log(title = "生产厂商管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Factory factory)
    {
        return toAjax(factoryService.insertFactory(factory));
    }

    /**
     * 修改生产厂商管理
     */
    @PreAuthorize("@ss.hasPermi('system:factory:edit')")
    @Log(title = "生产厂商管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Factory factory)
    {
        return toAjax(factoryService.updateFactory(factory));
    }

    /**
     * 删除生产厂商管理
     */
    @PreAuthorize("@ss.hasPermi('system:factory:remove')")
    @Log(title = "生产厂商管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{facIds}")
    public AjaxResult remove(@PathVariable Long[] facIds)
    {
        return toAjax(factoryService.deleteFactoryByFacIds(facIds));
    }
}
