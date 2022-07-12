package com.zr.service.car;

import com.zr.vo.car.Car;
import com.zr.vo.shop.City;

import java.util.List;

public interface CarService {
    List<Car> list(Car car);

    void add(Car car);

    void edit(Car car);

    void del(Long id);
}
