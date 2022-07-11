package com.zr.service.sys.impl;

import com.zr.mapper.sys.RoleMapper;
import com.zr.service.sys.RoleService;
import com.zr.vo.sys.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectList() {
        return roleMapper.selectList();
    }
}
