package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.SysUser;
import org.springframework.stereotype.Service;


public interface SysUserService {
    //登陆检验
    boolean checkLogin(String username, String password);
    //通过系统管理员用户名获取系统管理员用户
    SysUser findSysUserByName(String username);
    //注册
    void register(String username, String password,String email);
    //通过ID查找用户
    SysUser selectById(int id);
    //更新照片
    void updateAddressOfPic(int userId,String address);
    //更新用户信息
    void updateSysUserInfo(SysUser sysUser);
}
