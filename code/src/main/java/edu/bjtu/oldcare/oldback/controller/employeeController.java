package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.entity.EmployeeInfo;
import edu.bjtu.oldcare.oldback.service.EmployeeInfoService;
import edu.bjtu.oldcare.oldback.service.impl.EmployeeInfoServiceImpl;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class employeeController {
    @Autowired
    private EmployeeInfoService employeeInfoService;

    @GetMapping("/employee/findAll")
    public Response getAllOld(){
        List<EmployeeInfo> list=employeeInfoService.findAll2();
        return Response.ok(list);
    }

    @PostMapping("/employee/add")
    public Response addOld(@RequestBody EmployeeInfo employeeInfo){
        System.out.println(employeeInfo);
        System.out.println(employeeInfo.getDESCRIPTION());
        employeeInfo.setCREATED(new Date());
        employeeInfo.setISACTIVE("active");
        employeeInfo.setREMOVE("0");
        employeeInfoService.addOne(employeeInfo);
        return Response.ok();
    }

    @PostMapping("/employee/update")
    public Response updateOld(@RequestBody EmployeeInfo employeeInfo){
        System.out.println(employeeInfo);
        System.out.println(employeeInfo.getDESCRIPTION());
        employeeInfoService.update(employeeInfo);
        return Response.ok();
    }

    @GetMapping("/employee/delete")
    public Response getAllOld(@RequestParam(value = "id", required = true) Integer id){
        System.out.println(id);
        if (employeeInfoService.findById(id)==null)
            return Response.fail("无此id信息，删除失败");
        EmployeeInfo e=employeeInfoService.findById(id);
        e.setREMOVE("1");
        employeeInfoService.update(e);
        return Response.ok("删除成功");
    }

    @GetMapping("/employee/number")
    public  Response getNumber(){
        Map map = new HashMap();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        //1.工作人员总数
        map.put("totalnumber", employeeInfoService.count());

        //2.男性女性数量
        //使用迭代器进行相关遍历

        Iterator it1 = employeeInfoService.countByGender().iterator();
        while (it1.hasNext())//判断下一个元素之后有值
        {
            Map p = (Map) it1.next();
            map1.put(p.get("gender"), p.get("number"));
        }


        //3.工作人员各年龄段的人数
        List list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        for (int i = 0; i < 4; i++) {
            if(i==3){
                map2.put(list1.get(i), this.employeeInfoService.countByAge(50,100));
            }else{
                map2.put(list1.get(i), this.employeeInfoService.countByAge(20+i*10,29+i*10));
            }

        }


        map.put("gender", map1);
        map.put("age", map2);

        return Response.ok(map);
    }
}
