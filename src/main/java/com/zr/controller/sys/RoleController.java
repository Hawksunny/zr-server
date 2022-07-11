package com.zr.controller.sys;

import com.alibaba.fastjson.JSON;
import com.zr.service.sys.RoleService;
import com.zr.util.AjaxResult;
import com.zr.vo.sys.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色列表
     * @return
     */
    @RequestMapping("/selectList")
    public String selectList(){
        List<Role> roleList = roleService.selectList();
        return JSON.toJSONString(AjaxResult.success("查询成功", roleList));
    }

}
