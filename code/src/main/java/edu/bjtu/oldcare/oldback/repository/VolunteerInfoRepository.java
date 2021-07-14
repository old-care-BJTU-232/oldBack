package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.entity.VolunteerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface VolunteerInfoRepository extends JpaRepository<VolunteerInfo,Integer> {
    List<VolunteerInfo> findByName(String name);

    @Query(value ="select v from VolunteerInfo v where v.REMOVE = '0'")
    List<VolunteerInfo> findAll2();

    //统计信息使用
    @Query(value ="select count(v) from VolunteerInfo v where v.REMOVE = '0'")
    int countByID();

    @Query(value ="select o.gender as gender,count(o) as number from VolunteerInfo o where o.REMOVE = '0' group by o.gender")
    List<Map<String, Integer>> countBySex();
}
