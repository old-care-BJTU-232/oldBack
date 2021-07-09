package edu.bjtu.oldcare.oldback.repository;

import edu.bjtu.oldcare.oldback.entity.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventInfoRepository extends JpaRepository<EventInfo,Integer> {
    @Query(value ="select e from EventInfo e where e.event_type=?1")
    List<EventInfo> findByEvent_type(Integer type);
}
