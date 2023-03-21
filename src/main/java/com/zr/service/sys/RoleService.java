package com.zr.service.sys;

import com.zr.vo.sys.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectList();

    List<Role> list(Role role);

    void del(Integer id);

    void edit(Role role);

    void add(Role role);
}
