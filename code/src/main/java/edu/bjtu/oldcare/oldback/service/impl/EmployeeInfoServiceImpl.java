package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.entity.EventInfo;
import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.entity.VolunteerInfo;
import edu.bjtu.oldcare.oldback.repository.EmployeeInfoRepository;
import edu.bjtu.oldcare.oldback.service.EmployeeInfoService;
import edu.bjtu.oldcare.oldback.service.EventInfoService;
import edu.bjtu.oldcare.oldback.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;


    @Override
    public List<EmployeeInfo> findAll() {
        return employeeInfoRepository.findAll();
    }

    @Override
    public List<EmployeeInfo> findAll2() {
        return employeeInfoRepository.findAll2();
    }

    @Override
    public EmployeeInfo findById(int id) {
        return employeeInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void addOne(EmployeeInfo old) {
        employeeInfoRepository.save(old);
    }

    @Override
    public void deleteById(int id) {
        employeeInfoRepository.deleteById(id);
    }

    @Override
    public EmployeeInfo findByName(String name) {
        List<EmployeeInfo> list=employeeInfoRepository.findByUsername(name);
        System.out.println(list);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public void update(EmployeeInfo employeeInfo) {
        employeeInfoRepository.save(employeeInfo);
    }

    @Override
    public int count() {
        return employeeInfoRepository.countByID();
    }

    @Override
    public List<Map<String,Integer>> countByGender() {
        return employeeInfoRepository.countBySex();
    }

    @Override
    public int countByAge(int min, int max) {
        int count = 0;
        List<EmployeeInfo> list = employeeInfoRepository.findAll2();
        Iterator<EmployeeInfo> iter = list.iterator();
        while (iter.hasNext()) {
            EmployeeInfo o = (EmployeeInfo) iter.next();
            int dif = TimeUtil.yearCompare(o.getBirthday(), new Date());
            System.out.println(dif);
            if (dif >= min && dif <= max) {
                count++;
            }
        }
        return count;
    }
}
