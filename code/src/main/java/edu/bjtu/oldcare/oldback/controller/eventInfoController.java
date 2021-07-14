package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.entity.EventInfo;
import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.service.EventInfoService;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class eventInfoController {
    @Autowired
    private EventInfoService eventInfoService;
    @Autowired
    private OldpersonInfoService oldpersonInfoService;

    @GetMapping("/event/findAll")
    public Response getAllEvent(){
        List<EventInfo> list=eventInfoService.findAll();
        for (EventInfo o:list)
            System.out.println(o.getEvent_desc());
        return Response.ok(list);
    }

    @GetMapping("/event/type")
    public Response getEventByType(@RequestParam(value = "type", required = true) Integer type){
        List<EventInfo> list=eventInfoService.findByType(type);
        List<Map<String,Object>> list1=new LinkedList<>();
        for (EventInfo o:list){
//            System.out.println(o.getId());
            Map<String,Object> map = new HashMap<>();
            if(o.getOldperson_id() != null){
                String name=oldpersonInfoService.findById(o.getOldperson_id()).getUsername();
                map.put("old_name",name);
                map.put("oldperson_id",o.getOldperson_id());
            }else {
                map.put("old_name","陌生人");
            }
            map.put("id",o.getId());
            map.put("event_type",o.getEvent_type());
            map.put("event_location",o.getEvent_location());
            map.put("event_desc",o.getEvent_desc());
            map.put("img_url",o.getImg_url());
//            修改时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String datef = sdf.format(o.getEvent_date());
            map.put("event_date",datef);

            list1.add(map);
        }
        return Response.ok(list1);
    }

    @PostMapping("/event/add")
    public Response addEvent(@RequestBody EventInfo eventInfo){
        eventInfo.setEvent_date(new Date());
        eventInfoService.addOne(eventInfo);
        return Response.ok("插入成功");
    }
}
