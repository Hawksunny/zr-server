package com.zr.controller.car;

import com.alibaba.fastjson.JSON;
import com.zr.service.car.CarService;
import com.zr.util.AjaxResult;
import com.zr.vo.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 作者：黄成翰
     * 功能：查询车辆信息
     * @return String
     */
    @RequestMapping("/list")
    public String list() {
        List<Car> carList = carService.list();

        return JSON.toJSONString(AjaxResult.success("查询成功", carList));
    }
}
