package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
    List<SysUser> findByName(String name);
}
