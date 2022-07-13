package com.zr.controller.car;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zr.service.car.WorkService;
import com.zr.util.AjaxResult;
import com.zr.vo.car.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    /**
     * 查询车辆派遣记录
     * @param work
     * @return String
     */
    @RequestMapping("/list")
    public String list(@RequestBody Work work) {
        List<Work> workList = workService.list(work);
        PageInfo<Work> pageInfo = new PageInfo<>(workList);
        return JSON.toJSONString(AjaxResult.success("查询成功", pageInfo));
    }

    @RequestMapping("/update")
    public void update(@RequestBody Work work) {
        workService.update(work);
    }

}
