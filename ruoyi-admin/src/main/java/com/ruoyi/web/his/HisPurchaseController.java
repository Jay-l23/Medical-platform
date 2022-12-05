package com.ruoyi.his.controller;

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
import com.ruoyi.his.domain.HisPurchase;
import com.ruoyi.his.service.IHisPurchaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购入库Controller
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/his/purchase")
public class HisPurchaseController extends BaseController
{
    @Autowired
    private IHisPurchaseService hisPurchaseService;

    /**
     * 查询采购入库列表
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisPurchase hisPurchase)
    {
        startPage();
        List<HisPurchase> list = hisPurchaseService.selectHisPurchaseList(hisPurchase);
        return getDataTable(list);
    }

    /**
     * 导出采购入库列表
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:export')")
    @Log(title = "采购入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisPurchase hisPurchase)
    {
        List<HisPurchase> list = hisPurchaseService.selectHisPurchaseList(hisPurchase);
        ExcelUtil<HisPurchase> util = new ExcelUtil<HisPurchase>(HisPurchase.class);
        util.exportExcel(response, list, "采购入库数据");
    }

    /**
     * 获取采购入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:query')")
    @GetMapping(value = "/{purId}")
    public AjaxResult getInfo(@PathVariable("purId") String purId)
    {
        return success(hisPurchaseService.selectHisPurchaseByPurId(purId));
    }

    /**
     * 新增采购入库
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:add')")
    @Log(title = "采购入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisPurchase hisPurchase)
    {
        return toAjax(hisPurchaseService.insertHisPurchase(hisPurchase));
    }

    /**
     * 修改采购入库
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:edit')")
    @Log(title = "采购入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisPurchase hisPurchase)
    {
        return toAjax(hisPurchaseService.updateHisPurchase(hisPurchase));
    }

    /**
     * 删除采购入库
     */
    @PreAuthorize("@ss.hasPermi('his:purchase:remove')")
    @Log(title = "采购入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{purIds}")
    public AjaxResult remove(@PathVariable String[] purIds)
    {
        return toAjax(hisPurchaseService.deleteHisPurchaseByPurIds(purIds));
    }
}
