package com.ruoyi.web.his;

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
import com.ruoyi.his.domain.HisDepts;
import com.ruoyi.his.service.IHisDeptsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室管理Controller
 * 
 * @author lijie
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/his/depts")
public class HisDeptsController extends BaseController
{
    @Autowired
    private IHisDeptsService hisDeptsService;

    /**
     * 查询科室管理列表
     */
    @PreAuthorize("@ss.hasPermi('his:depts:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisDepts hisDepts)
    {
        startPage();
        List<HisDepts> list = hisDeptsService.selectHisDeptsList(hisDepts);
        return getDataTable(list);
    }

    /**
     * 导出科室管理列表
     */
    @PreAuthorize("@ss.hasPermi('his:depts:export')")
    @Log(title = "科室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisDepts hisDepts)
    {
        List<HisDepts> list = hisDeptsService.selectHisDeptsList(hisDepts);
        ExcelUtil<HisDepts> util = new ExcelUtil<HisDepts>(HisDepts.class);
        util.exportExcel(response, list, "科室管理数据");
    }

    /**
     * 获取科室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:depts:query')")
    @GetMapping(value = "/{deptsId}")
    public AjaxResult getInfo(@PathVariable("deptsId") Long deptsId)
    {
        return success(hisDeptsService.selectHisDeptsByDeptsId(deptsId));
    }

    /**
     * 新增科室管理
     */
    @PreAuthorize("@ss.hasPermi('his:depts:add')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisDepts hisDepts)
    {
        return toAjax(hisDeptsService.insertHisDepts(hisDepts));
    }

    /**
     * 修改科室管理
     */
    @PreAuthorize("@ss.hasPermi('his:depts:edit')")
    @Log(title = "科室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisDepts hisDepts)
    {
        return toAjax(hisDeptsService.updateHisDepts(hisDepts));
    }

    /**
     * 删除科室管理
     */
    @PreAuthorize("@ss.hasPermi('his:depts:remove')")
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptsIds}")
    public AjaxResult remove(@PathVariable Long[] deptsIds)
    {
        return toAjax(hisDeptsService.deleteHisDeptsByDeptsIds(deptsIds));
    }
}
