package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.service.SysUserService;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class loginController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/login")
    public Response login(@RequestBody Map<String,String> request){
        System.out.println(request);
        String username=request.get("id");
        String password=request.get("password");
        if(sysUserService.checkLogin(username,password)){
            return Response.ok(null,"success");
        }else {
            return Response.fail("fail");
        }

    }
}
