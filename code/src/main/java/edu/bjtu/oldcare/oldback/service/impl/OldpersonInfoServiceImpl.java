package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.repository.OldpersonInfoRepository;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import edu.bjtu.oldcare.oldback.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class OldpersonInfoServiceImpl implements OldpersonInfoService {

    @Autowired
    private OldpersonInfoRepository oldpersonInfoRepository;

    @Override
    public List<OldpersonInfo> findAll() {
        return oldpersonInfoRepository.findAll();
    }

    @Override
    public List<OldpersonInfo> findAll2() {
        return oldpersonInfoRepository.findAll2();
    }

    @Override
    public OldpersonInfo findById(int id) {
        return oldpersonInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void addOne(OldpersonInfo old) {
        oldpersonInfoRepository.save(old);
    }

    @Override
    public void deleteById(int id) {
        oldpersonInfoRepository.deleteById(id);
    }

    @Override
    public OldpersonInfo findByName(String name) {
        List<OldpersonInfo> list=oldpersonInfoRepository.findByUsername(name);
        System.out.println(list);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public boolean checkRepeat(String name) {
        if(findByName(name) == null)
            return false;
        else
            return true;
    }

    @Override
    public void updateOldperson(OldpersonInfo old) {
        oldpersonInfoRepository.save(old);
    }

    @Override
    public int count() {
        return oldpersonInfoRepository.countByID();
    }

    @Override
    public List<Map<String,Integer>> countByGender() {
        return oldpersonInfoRepository.countBySex();
    }

    @Override
    public int countByAge(int min, int max) {
        int count=0;
        List<OldpersonInfo> list=oldpersonInfoRepository.findAll2();
        Iterator<OldpersonInfo> iter = list.iterator();
        while (iter.hasNext()){
            OldpersonInfo o = (OldpersonInfo) iter.next();
            int dif=TimeUtil.yearCompare(o.getBirthday(),new Date());
            System.out.println(dif);
            if(dif>=min && dif<=max){
                count++;
            }
        }
        return count;
    }

    @Override
    public int countByHealthState(String state) {
        return oldpersonInfoRepository.countByHealth_state(state);
    }
}
