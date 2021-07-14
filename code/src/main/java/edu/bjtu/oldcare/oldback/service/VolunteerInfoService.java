package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.entity.VolunteerInfo;

import java.util.List;
import java.util.Map;

public interface VolunteerInfoService {
    List<VolunteerInfo> findAll();

    List<VolunteerInfo> findAll2();

    VolunteerInfo findById(int id);

    void addOne(VolunteerInfo old);

    void deleteById(int id);

    VolunteerInfo findByName(String name);

    void update(VolunteerInfo volunteerInfo);

    //统计用
    int count();

    List<Map<String,Integer>> countByGender();

    int countByAge(int min,int max);


}
