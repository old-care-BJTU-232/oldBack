package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.repository.OldpersonInfoRepository;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OldpersonInfoServiceImpl implements OldpersonInfoService {

    @Autowired
    private OldpersonInfoRepository oldpersonInfoRepository;

    @Override
    public List<OldpersonInfo> findAll() {
        return oldpersonInfoRepository.findAll();
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
}
