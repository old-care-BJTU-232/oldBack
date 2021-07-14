package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;


import java.util.List;
import java.util.Map;

public interface EmployeeInfoService {
    List<EmployeeInfo> findAll();

    List<EmployeeInfo> findAll2();

    EmployeeInfo findById(int id);

    void addOne(EmployeeInfo old);

    void deleteById(int id);

    EmployeeInfo findByName(String name);

    void update(EmployeeInfo employeeInfo);


    //统计用
    int count();

    List<Map<String,Integer>> countByGender();

    int countByAge(int min,int max);


}
