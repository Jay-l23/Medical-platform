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
import com.ruoyi.his.domain.HisChargedetail;
import com.ruoyi.his.service.IHisChargedetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收费查询Controller
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
@RestController
@RequestMapping("/his/chargedetail")
public class HisChargedetailController extends BaseController
{
    @Autowired
    private IHisChargedetailService hisChargedetailService;

    /**
     * 查询收费查询列表
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisChargedetail hisChargedetail)
    {
        startPage();
        List<HisChargedetail> list = hisChargedetailService.selectHisChargedetailList(hisChargedetail);
        return getDataTable(list);
    }

    /**
     * 导出收费查询列表
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:export')")
    @Log(title = "收费查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisChargedetail hisChargedetail)
    {
        List<HisChargedetail> list = hisChargedetailService.selectHisChargedetailList(hisChargedetail);
        ExcelUtil<HisChargedetail> util = new ExcelUtil<HisChargedetail>(HisChargedetail.class);
        util.exportExcel(response, list, "收费查询数据");
    }

    /**
     * 获取收费查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hisChargedetailService.selectHisChargedetailById(id));
    }

    /**
     * 新增收费查询
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:add')")
    @Log(title = "收费查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisChargedetail hisChargedetail)
    {
        return toAjax(hisChargedetailService.insertHisChargedetail(hisChargedetail));
    }

    /**
     * 修改收费查询
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:edit')")
    @Log(title = "收费查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisChargedetail hisChargedetail)
    {
        return toAjax(hisChargedetailService.updateHisChargedetail(hisChargedetail));
    }

    /**
     * 删除收费查询
     */
    @PreAuthorize("@ss.hasPermi('his:chargedetail:remove')")
    @Log(title = "收费查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hisChargedetailService.deleteHisChargedetailByIds(ids));
    }
}
