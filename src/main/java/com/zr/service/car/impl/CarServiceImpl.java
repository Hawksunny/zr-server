package com.zr.service.car.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.car.CarMapper;
import com.zr.service.car.CarService;
import com.zr.util.RedisUtils;
import com.zr.util.TokenUtil;
import com.zr.vo.car.Car;
import com.zr.vo.shop.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TokenUtil tokenUtil;

    @Resource
    private CarMapper carMapper;

    /**
     * 查询车辆
     * @param car
     */
    @Override
    public List<Car> list(Car car) {
        //分页插件使用，放在接口方法前，只生效一次
        PageHelper.startPage(car.getPageNum(), car.getPageSize());
        return carMapper.list(car);
    }

    /**
     * 新增车辆
     * @param car
     */
    @Override
    public void add(Car car) {
        car.setCreateId(tokenUtil.getUserId());
        car.setCreateTime(new Date());
        carMapper.insertSelective(car);
    }

    @Override
    public void edit(Car car) {
        //判断是否有修改
        if(car.getId() != null){
            //修改该城市
            car.setModifyId(tokenUtil.getUserId());
            car.setModifyTime(new Date());
            carMapper.updateByPrimaryKeySelective(car);
        }
    }

    @Override
    public void del(Long id) {
        //删除该城市
        carMapper.deleteByPrimaryKey(id);
    }
}
