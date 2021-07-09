package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OldpersonInfoRepository extends JpaRepository<OldpersonInfo,Integer> {
    List<OldpersonInfo> findByUsername(String name);
}
