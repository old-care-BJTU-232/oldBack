package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.EventInfo;
import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OldpersonInfoRepository extends JpaRepository<OldpersonInfo,Integer> {
    List<OldpersonInfo> findByUsername(String name);

    @Query(value ="select o from OldpersonInfo o where o.REMOVE = '0'")
    List<OldpersonInfo> findAll2();

    //统计信息使用
    @Query(value ="select count(o) from OldpersonInfo o where o.REMOVE = '0'")
    int countByID();

    @Query(value ="select o.gender as gender,count(o) as number from OldpersonInfo o where o.REMOVE = '0' group by o.gender")
    List<Map<String, Integer>> countBySex();

    @Query(value ="select count(o) from OldpersonInfo o where o.REMOVE = '0' and o.health_state=?1")
    int countByHealth_state(String state);
//    @Query(value = "select count(o) as number from OldpersonInfo  o where TIMESTAMPDIFF(YEAR,birthday,NOW()) between ?1 and ?2 ")
//    List countByAge(int)
}
