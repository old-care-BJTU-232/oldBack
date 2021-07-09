package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.SysUser;
import edu.bjtu.oldcare.oldback.repository.SysUserRepository;
import edu.bjtu.oldcare.oldback.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public boolean checkLogin(String username, String password) {
        SysUser user=findSysUserByName(username);
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public SysUser findSysUserByName(String username) {
        return sysUserRepository.findByName(username).get(0);
    }

    @Override
    public void register(String username, String password, String email) {

    }

    @Override
    public SysUser selectById(int id) {
        return sysUserRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAddressOfPic(int userId, String address) {

    }

    @Override
    public void updateSysUserInfo(SysUser sysUser) {

    }
}
