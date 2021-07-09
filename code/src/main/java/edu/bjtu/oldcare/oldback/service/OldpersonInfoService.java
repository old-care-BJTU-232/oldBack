package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;

import java.util.List;

public interface OldpersonInfoService {
    List<OldpersonInfo> findAll();

    OldpersonInfo findById(int id);

    void addOne(OldpersonInfo old);

    void deleteById(int id);

    OldpersonInfo findByName(String name);

    boolean checkRepeat(String name);

    void updateOldperson(OldpersonInfo old);


}
