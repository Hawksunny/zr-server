package com.zr.controller.shop;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zr.service.shop.CityService;
import com.zr.util.AjaxResult;
import com.zr.vo.shop.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户操作类
 */
@RestController
@RequestMapping("/shop/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/list")
    public String list(@RequestBody City city){
        //查询城市列表
        List<City> cityList = cityService.list(city);
        //封装到分页对象中
        PageInfo<City> pageInfo = new PageInfo<>(cityList);
        return JSON.toJSONString(AjaxResult.success("查询成功", pageInfo));
    }

    @RequestMapping("/add")
    public String add(@RequestBody City city){
        cityService.add(city);
        return JSON.toJSONString(AjaxResult.success("新增成功"));
    }
}
