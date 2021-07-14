package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;

import java.util.List;
import java.util.Map;

public interface OldpersonInfoService {
    List<OldpersonInfo> findAll();

    //查找所有元素（不包括标志为删除的元素）
    List<OldpersonInfo> findAll2();

    OldpersonInfo findById(int id);

    void addOne(OldpersonInfo old);

    void deleteById(int id);

    OldpersonInfo findByName(String name);

    boolean checkRepeat(String name);

    void updateOldperson(OldpersonInfo old);

    //统计用
    int count();

    List<Map<String,Integer>> countByGender();

    int countByAge(int min,int max);

    int countByHealthState(String state);




}
