package edu.bjtu.oldcare.oldback;

import edu.bjtu.oldcare.oldback.entity.EventInfo;
import edu.bjtu.oldcare.oldback.entity.SysUser;
import edu.bjtu.oldcare.oldback.repository.OldpersonInfoRepository;
import edu.bjtu.oldcare.oldback.repository.SysUserRepository;
import edu.bjtu.oldcare.oldback.service.EventInfoService;
import edu.bjtu.oldcare.oldback.service.OldpersonInfoService;
import edu.bjtu.oldcare.oldback.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class OldBackApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OldpersonInfoRepository oldpersonInfoRepository;
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private OldpersonInfoService oldpersonInfoService;
    @Autowired
    private EventInfoService eventInfoService;
    @Test
    void contextLoads() {
        System.out.println("init");
    }

    @Test
    void test1(){
//        SysUser user= sysUserService.findSysUserByName("admin");
        SysUser user= sysUserService.findSysUserByName("admin");
        System.out.println(user.getName());
    }

    @Test
    void test2(){
        List<EventInfo> list=eventInfoService.findByType(0);
        list.forEach((i)->{
            System.out.println(i.getEvent_desc());
        });
    }


}
