package com.zr.service.car.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.car.WorkMapper;
import com.zr.service.car.WorkService;
import com.zr.vo.car.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Resource
    private WorkMapper workMapper;

    @Transactional
    @Override
    public List<Work> list(Work work) {
        PageHelper.startPage(work.getPageNum(), work.getPageSize());
        return workMapper.list(work);
    }

    @Override
    public void update(Work work) {
        workMapper.updateByPrimaryKeySelective(work);
    }
}
