package edu.bjtu.oldcare.oldback.controller;

import edu.bjtu.oldcare.oldback.server.WebSocketServer;
import edu.bjtu.oldcare.oldback.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

    @Autowired
    private WebSocketServer webSocketServer;

    @PostMapping("/sendAllWebSocket")
    public String testSocket(String text) {
//        String text1="你们好！这是websocket群体发送！";
        try {
            webSocketServer.sendInfo(text);
        }catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }

}
