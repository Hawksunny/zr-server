package com.zr.service.shop.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.shop.CityMapper;
import com.zr.service.shop.CityService;
import com.zr.vo.shop.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    /**
     * 查询城市
     * @param city
     * @return
     */
    @Override
    public List<City> list(City city) {
        //分页插件使用，放在接口方法前，只生效一次
        PageHelper.startPage(city.getPageNum(), city.getPageSize());
        return cityMapper.list(city);
    }

    /**
     * 新增城市
     * @param city
     */
    @Override
    public void add(City city) {
        cityMapper.insertSelective(city);
    }
}
