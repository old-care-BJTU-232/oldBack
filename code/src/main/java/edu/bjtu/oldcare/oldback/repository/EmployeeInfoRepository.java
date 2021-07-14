package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Integer> {
    List<EmployeeInfo> findByUsername(String name);

    @Query(value ="select e from EmployeeInfo e where e.REMOVE = '0'")
    List<EmployeeInfo> findAll2();

    //统计信息使用
    @Query(value ="select count(v) from EmployeeInfo v where v.REMOVE = '0'")
    int countByID();

    @Query(value ="select o.gender as gender,count(o) as number from EmployeeInfo o where o.REMOVE = '0' group by o.gender")
    List<Map<String, Integer>> countBySex();
}
