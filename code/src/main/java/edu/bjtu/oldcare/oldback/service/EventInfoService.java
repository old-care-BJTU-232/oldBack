package edu.bjtu.oldcare.oldback.service;

import edu.bjtu.oldcare.oldback.entity.EventInfo;


import java.util.List;

public interface EventInfoService {
    List<EventInfo> findAll();

    EventInfo findById(int id);

    void addOne(EventInfo event);

    void deleteById(int id);

    List<EventInfo> findByType(int type);


}
