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
import com.ruoyi.system.domain.SysDepts;
import com.ruoyi.system.service.ISysDeptsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室管理Controller
 *
 * @author ruoyi
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/depts")
public class SysDeptsController extends BaseController
{
    @Autowired
    private ISysDeptsService sysDeptsService;

    /**
     * 查询科室管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:depts:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDepts sysDepts)
    {
        startPage();
        List<SysDepts> list = sysDeptsService.selectSysDeptsList(sysDepts);
        return getDataTable(list);
    }

    /**
     * 导出科室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:depts:export')")
    @Log(title = "科室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDepts sysDepts)
    {
        List<SysDepts> list = sysDeptsService.selectSysDeptsList(sysDepts);
        ExcelUtil<SysDepts> util = new ExcelUtil<SysDepts>(SysDepts.class);
        util.exportExcel(response, list, "科室管理数据");
    }

    /**
     * 获取科室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:depts:query')")
    @GetMapping(value = "/{deptsId}")
    public AjaxResult getInfo(@PathVariable("deptsId") Long deptsId)
    {
        return success(sysDeptsService.selectSysDeptsByDeptsId(deptsId));
    }

    /**
     * 新增科室管理
     */
    @PreAuthorize("@ss.hasPermi('system:depts:add')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDepts sysDepts)
    {
        return toAjax(sysDeptsService.insertSysDepts(sysDepts));
    }

    /**
     * 修改科室管理
     */
    @PreAuthorize("@ss.hasPermi('system:depts:edit')")
    @Log(title = "科室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDepts sysDepts)
    {
        return toAjax(sysDeptsService.updateSysDepts(sysDepts));
    }

    /**
     * 删除科室管理
     */
    @PreAuthorize("@ss.hasPermi('system:depts:remove')")
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptsIds}")
    public AjaxResult remove(@PathVariable Long[] deptsIds)
    {
        return toAjax(sysDeptsService.deleteSysDeptsByDeptsIds(deptsIds));
    }
}
