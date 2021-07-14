package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static edu.bjtu.oldcare.oldback.util.TimeUtil.checkDate;

@RestController
public class oldpersonController {

    @Autowired
    private OldpersonInfoService oldpersonInfoService;

    @GetMapping("/old/findAll")
    public Response getAllOld(){
        List<OldpersonInfo> list=oldpersonInfoService.findAll2();
        return Response.ok(list);
    }

    @PostMapping("/old/add")
    public Response addOld(@RequestBody OldpersonInfo oldpersonInfo){
        System.out.println(oldpersonInfo);
        oldpersonInfo.setCREATED(new Date());
        oldpersonInfo.setISACTIVE("active");
        oldpersonInfo.setREMOVE("0");
        oldpersonInfoService.addOne(oldpersonInfo);
        return Response.ok();
    }

    @PostMapping("/old/update")
    public Response updateOld(@RequestBody OldpersonInfo oldpersonInfo){
        System.out.println(oldpersonInfo);
        oldpersonInfoService.updateOldperson(oldpersonInfo);
        return Response.ok();
    }

    @GetMapping("/old/delete")
    public Response getAllOld(@RequestParam(value = "id", required = true) Integer id){
        System.out.println(id);
        if (oldpersonInfoService.findById(id)==null)
            return Response.fail("无此id信息，删除失败");
        OldpersonInfo o=oldpersonInfoService.findById(id);
        o.setREMOVE("1");
        oldpersonInfoService.updateOldperson(o);
        return Response.ok("删除成功");
    }

    @GetMapping("/old/number")
    public  Response getNumber(){
        Map map = new HashMap();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();
        //1.老人总数
        map.put("totalnumber", oldpersonInfoService.count());

        //2.男性女性数量
        //使用迭代器进行相关遍历

        Iterator it1 = oldpersonInfoService.countByGender().iterator();
        while (it1.hasNext())//判断下一个元素之后有值
        {
            Map p = (Map) it1.next();
            map1.put(p.get("gender"), p.get("number"));
        }


        //3.老人各年龄段的人数
        List list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        list1.add("five");
        list1.add("six");
        for (int i = 0; i < 6; i++) {
            if(i==5){
                map2.put(list1.get(i), this.oldpersonInfoService.countByAge(100,500));//500代表无限制
            }else{
                map2.put(list1.get(i), this.oldpersonInfoService.countByAge(50+i*10,59+i*10));
            }

        }


        //4.老人数量（按健康状况分）
        List list3 = new ArrayList();
        list3.add("健康");
        list3.add("良好");
        list3.add("一般");
        list3.add("差");
        list3.add("很差");
        for (int i = 0; i < 5; i++) {
            map3.put(list3.get(i), oldpersonInfoService.countByHealthState((String) list3.get(i)));
        }

        map.put("gender", map1);
        map.put("age", map2);
        map.put("health_state", map3);

        return Response.ok(map);
    }
}
