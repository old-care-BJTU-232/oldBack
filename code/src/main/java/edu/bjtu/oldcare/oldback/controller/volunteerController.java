package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.entity.VolunteerInfo;
import edu.bjtu.oldcare.oldback.service.EmployeeInfoService;
import edu.bjtu.oldcare.oldback.service.VolunteerInfoService;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class volunteerController {

    @Autowired
    private VolunteerInfoService volunteerInfoService;

    @GetMapping("/volunteer/findAll")
    public Response getAllOld(){
        List<VolunteerInfo> list=volunteerInfoService.findAll2();
        return Response.ok(list);
    }

    @PostMapping("/volunteer/add")
    public Response addOld(@RequestBody VolunteerInfo volunteerInfo){
        System.out.println(volunteerInfo);
        volunteerInfo.setCREATED(new Date());
        volunteerInfo.setISACTIVE("active");
        volunteerInfo.setREMOVE("0");
        volunteerInfoService.addOne(volunteerInfo);
        return Response.ok();
    }

    @PostMapping("/volunteer/update")
    public Response updateOld(@RequestBody VolunteerInfo volunteerInfo){
        System.out.println(volunteerInfo);
        System.out.println(volunteerInfo.getDESCRIPTION());
        volunteerInfoService.update(volunteerInfo);
        return Response.ok();
    }

    @GetMapping("/volunteer/delete")
    public Response getAllOld(@RequestParam(value = "id", required = true) Integer id){
        System.out.println(id);
        if (volunteerInfoService.findById(id)==null)
            return Response.fail("无此id信息，删除失败");
        VolunteerInfo e=volunteerInfoService.findById(id);
        e.setREMOVE("1");
        volunteerInfoService.update(e);
        return Response.ok("删除成功");
    }

    @GetMapping("/volunteer/number")
    public  Response getNumber(){
        Map map = new HashMap();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        //1.义工总数
        map.put("totalnumber", volunteerInfoService.count());

        //2.男性女性数量
        //使用迭代器进行相关遍历

        Iterator it1 = volunteerInfoService.countByGender().iterator();
        while (it1.hasNext())//判断下一个元素之后有值
        {
            Map p = (Map) it1.next();
            map1.put(p.get("gender"), p.get("number"));
        }


        //3.义工各年龄段的人数
        List list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        for (int i = 0; i < 4; i++) {
            if(i==3){
                map2.put(list1.get(i), this.volunteerInfoService.countByAge(50,100));
            }else{
                map2.put(list1.get(i), this.volunteerInfoService.countByAge(20+i*10,29+i*10));
            }

        }


        map.put("gender", map1);
        map.put("age", map2);

        return Response.ok(map);
    }
}
