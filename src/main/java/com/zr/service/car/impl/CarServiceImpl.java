package com.zr.service.car.impl;

import com.zr.mapper.car.CarMapper;
import com.zr.service.car.CarService;
import com.zr.vo.car.Car;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;

    @Override
    public List<Car> list() {
        return carMapper.list();
    }
}
