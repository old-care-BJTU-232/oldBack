package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/test")
    public Response test(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.okMap("test","success");
    }
}
