package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.entity.VolunteerInfo;
import edu.bjtu.oldcare.oldback.repository.VolunteerInfoRepository;
import edu.bjtu.oldcare.oldback.service.VolunteerInfoService;
import edu.bjtu.oldcare.oldback.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class VolunteerServiceImpl implements VolunteerInfoService {
    @Autowired
    private VolunteerInfoRepository volunteerInfoRepository;

    @Override
    public List<VolunteerInfo> findAll() {
        return volunteerInfoRepository.findAll();
    }

    @Override
    public List<VolunteerInfo> findAll2() {
        return volunteerInfoRepository.findAll2();
    }

    @Override
    public VolunteerInfo findById(int id) {
        return volunteerInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void addOne(VolunteerInfo old) {
        volunteerInfoRepository.save(old);
    }

    @Override
    public void deleteById(int id) {
        volunteerInfoRepository.deleteById(id);
    }

    @Override
    public VolunteerInfo findByName(String name) {
        return volunteerInfoRepository.findByName(name).get(0);
    }

    @Override
    public void update(VolunteerInfo volunteerInfo) {
        volunteerInfoRepository.save(volunteerInfo);
    }

    @Override
    public int count() {
        return volunteerInfoRepository.countByID();
    }

    @Override
    public List<Map<String,Integer>> countByGender() {
        return volunteerInfoRepository.countBySex();
    }

    @Override
    public int countByAge(int min, int max) {
        int count=0;
        List<VolunteerInfo> list=volunteerInfoRepository.findAll2();
        Iterator<VolunteerInfo> iter = list.iterator();
        while (iter.hasNext()){
            VolunteerInfo o = (VolunteerInfo) iter.next();
            int dif= TimeUtil.yearCompare(o.getBirthday(),new Date());
            System.out.println(dif);
            if(dif>=min && dif<=max){
                count++;
            }
        }
        return count;
    }
}
