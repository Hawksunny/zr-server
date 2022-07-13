package com.zr.controller.car;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zr.service.car.CarService;
import com.zr.util.AjaxResult;
import com.zr.vo.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 功能：查询车辆信息
     * @return String
     * @param car
     */
    @RequestMapping("/list")
    public String list(@RequestBody Car car) {
        //查询车辆列表
        List<Car> carList = carService.list(car);
        //封装到分页对象中
        PageInfo<Car> pageInfo = new PageInfo<>(carList);
        return JSON.toJSONString(AjaxResult.success("查询成功", carList));
    }

    @RequestMapping("/add")
    public String add(@RequestBody Car car){
        carService.add(car);
        return JSON.toJSONString(AjaxResult.success("新增成功"));
    }

    /**
     * 编辑车辆
     * @param car
     * @return
     */
    @RequestMapping("/edit")
    public String edit(@RequestBody Car car){
        carService.edit(car);
        return JSON.toJSONString(AjaxResult.success("编辑成功"));
    }

    /**
     * 删除车辆
     * @param car
     * @return
     */
    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long id){
        carService.del(id);
        return JSON.toJSONString(AjaxResult.success("删除成功"));
    }

}
