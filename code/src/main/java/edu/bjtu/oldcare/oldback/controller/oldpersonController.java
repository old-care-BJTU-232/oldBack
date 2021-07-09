package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.entity.OldpersonInfo;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static edu.bjtu.oldcare.oldback.util.TimeUtil.checkDate;

@RestController
public class oldpersonController {

    @Autowired
    private OldpersonInfoService oldpersonInfoService;

    @GetMapping("/old/findAll")
    public Response getAllOld(){
        List<OldpersonInfo> list=oldpersonInfoService.findAll();
        for (OldpersonInfo o:list)
            System.out.println(o.getUsername());
        return Response.ok(list);
    }

    @PostMapping("/old/add")
    public Response addOld(@RequestBody OldpersonInfo oldpersonInfo){
        System.out.println(oldpersonInfo);
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
        oldpersonInfoService.deleteById(id);
        return Response.ok("删除成功");
    }
}
