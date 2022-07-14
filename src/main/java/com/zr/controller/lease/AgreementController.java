package com.zr.controller.lease;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zr.service.lease.AgreementService;
import com.zr.util.AjaxResult;
import com.zr.vo.lease.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 合同管理类
 */
@RestController
@RequestMapping("/lease/agreement")
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    @RequestMapping("/list")
    public String list(@RequestBody Agreement agreement){
        //查询合同列表
        List<Agreement> agreementList = agreementService.list(agreement);
        //封装到分页对象中
        PageInfo<Agreement> pageInfo = new PageInfo<>(agreementList);
        return JSON.toJSONString(AjaxResult.success("查询成功", pageInfo));
    }

    /**
     * 添加合同
     * @param agreement
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestBody Agreement agreement){
        agreementService.add(agreement);
        return JSON.toJSONString(AjaxResult.success("新增成功"));
    }

    /**
     * 编辑合同
     * @param agreement
     * @return
     */
    @RequestMapping("/edit")
    public String edit(@RequestBody Agreement agreement){
        agreementService.edit(agreement);
        return JSON.toJSONString(AjaxResult.success("编辑成功"));
    }

    /**
     * 删除合同
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long id){
        agreementService.del(id);
        return JSON.toJSONString(AjaxResult.success("删除成功"));
    }

}
