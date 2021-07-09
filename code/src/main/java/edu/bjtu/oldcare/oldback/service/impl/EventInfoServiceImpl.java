package edu.bjtu.oldcare.oldback.service.impl;

import edu.bjtu.oldcare.oldback.entity.EventInfo;
import edu.bjtu.oldcare.oldback.repository.EventInfoRepository;
import edu.bjtu.oldcare.oldback.service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventInfoServiceImpl implements EventInfoService {
    @Autowired
    private EventInfoRepository eventInfoRepository;

    @Override
    public List<EventInfo> findAll() {
        return eventInfoRepository.findAll();
    }

    @Override
    public EventInfo findById(int id) {
        return eventInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void addOne(EventInfo event) {
        eventInfoRepository.save(event);
    }

    @Override
    public void deleteById(int id) {
        eventInfoRepository.deleteById(id);
    }

    @Override
    public List<EventInfo> findByType(int type) {
        return eventInfoRepository.findByEvent_type(type);
//        return null;
    }
}
