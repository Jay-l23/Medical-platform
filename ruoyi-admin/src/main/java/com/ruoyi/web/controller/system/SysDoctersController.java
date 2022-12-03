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
import com.ruoyi.system.domain.SysDocters;
import com.ruoyi.system.service.ISysDoctersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生信息管理Controller
 * 
 * @author lijie
 * @date 2022-11-05
 */
@RestController
@RequestMapping("/system/docters")
public class SysDoctersController extends BaseController
{
    @Autowired
    private ISysDoctersService sysDoctersService;

    /**
     * 查询医生信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:docters:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDocters sysDocters)
    {
        startPage();
        List<SysDocters> list = sysDoctersService.selectSysDoctersList(sysDocters);
        return getDataTable(list);
    }

    /**
     * 导出医生信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:docters:export')")
    @Log(title = "医生信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDocters sysDocters)
    {
        List<SysDocters> list = sysDoctersService.selectSysDoctersList(sysDocters);
        ExcelUtil<SysDocters> util = new ExcelUtil<SysDocters>(SysDocters.class);
        util.exportExcel(response, list, "医生信息管理数据");
    }

    /**
     * 获取医生信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:docters:query')")
    @GetMapping(value = "/{dId}")
    public AjaxResult getInfo(@PathVariable("dId") Long dId)
    {
        return success(sysDoctersService.selectSysDoctersByDId(dId));
    }

    /**
     * 新增医生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:docters:add')")
    @Log(title = "医生信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDocters sysDocters)
    {
        return toAjax(sysDoctersService.insertSysDocters(sysDocters));
    }

    /**
     * 修改医生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:docters:edit')")
    @Log(title = "医生信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDocters sysDocters)
    {
        return toAjax(sysDoctersService.updateSysDocters(sysDocters));
    }

    /**
     * 删除医生信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:docters:remove')")
    @Log(title = "医生信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dIds}")
    public AjaxResult remove(@PathVariable Long[] dIds)
    {
        return toAjax(sysDoctersService.deleteSysDoctersByDIds(dIds));
    }
}
