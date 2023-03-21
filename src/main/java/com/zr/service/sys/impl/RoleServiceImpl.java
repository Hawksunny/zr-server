package com.zr.service.sys.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.sys.RoleAuthMapper;
import com.zr.mapper.sys.RoleMapper;
import com.zr.mapper.sys.UserRoleMapper;
import com.zr.service.sys.RoleService;
import com.zr.util.TokenUtil;
import com.zr.vo.sys.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private RoleAuthMapper roleAuthMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public List<Role> selectList() {
        return roleMapper.selectList();
    }

    @Override
    public List<Role> list(Role role) {
        PageHelper.startPage(role.getPageNum(), role.getPageSize());
        return roleMapper.list(role);
    }

    @Override
    public void del(Integer id) {
        roleAuthMapper.del(id);
        userRoleMapper.del(id);
        roleMapper.deleteByPrimaryKey(Long.parseLong(id.toString()));
    }

    @Override
    public void edit(Role role) {
        role.setModifyId(tokenUtil.getUserId());
        role.setModifyTime(new Date());
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void add(Role role) {
        role.setCreateId(tokenUtil.getUserId());
        role.setCreateTime(new Date());
        roleMapper.insert(role);
    }
}
