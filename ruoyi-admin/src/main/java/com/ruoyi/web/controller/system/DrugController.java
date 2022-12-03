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
import com.ruoyi.system.domain.Drug;
import com.ruoyi.system.service.IDrugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品信息维护Controller
 * 
 * @author lijie
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/drug")
public class DrugController extends BaseController
{
    @Autowired
    private IDrugService drugService;

    /**
     * 查询药品信息维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(Drug drug)
    {
        startPage();
        List<Drug> list = drugService.selectDrugList(drug);
        return getDataTable(list);
    }

    /**
     * 导出药品信息维护列表
     */
    @PreAuthorize("@ss.hasPermi('system:drug:export')")
    @Log(title = "药品信息维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Drug drug)
    {
        List<Drug> list = drugService.selectDrugList(drug);
        ExcelUtil<Drug> util = new ExcelUtil<Drug>(Drug.class);
        util.exportExcel(response, list, "药品信息维护数据");
    }

    /**
     * 获取药品信息维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:drug:query')")
    @GetMapping(value = "/{drugId}")
    public AjaxResult getInfo(@PathVariable("drugId") Long drugId)
    {
        return success(drugService.selectDrugByDrugId(drugId));
    }

    /**
     * 新增药品信息维护
     */
    @PreAuthorize("@ss.hasPermi('system:drug:add')")
    @Log(title = "药品信息维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Drug drug)
    {
        return toAjax(drugService.insertDrug(drug));
    }

    /**
     * 修改药品信息维护
     */
    @PreAuthorize("@ss.hasPermi('system:drug:edit')")
    @Log(title = "药品信息维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Drug drug)
    {
        return toAjax(drugService.updateDrug(drug));
    }

    /**
     * 删除药品信息维护
     */
    @PreAuthorize("@ss.hasPermi('system:drug:remove')")
    @Log(title = "药品信息维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugIds}")
    public AjaxResult remove(@PathVariable Long[] drugIds)
    {
        return toAjax(drugService.deleteDrugByDrugIds(drugIds));
    }
}
