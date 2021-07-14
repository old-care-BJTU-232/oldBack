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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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
//        SysUser user= sysUserService.findSysUserByName("admin");
        Map map1=new HashMap<>();
        List<Map<String, Integer>> list=oldpersonInfoRepository.countBySex();
        Iterator it1 = list.iterator();
        while (it1.hasNext())//判断下一个元素之后有值
        {
            Map p = (Map) it1.next();
            System.out.println(p.get("gender"));
            System.out.println(p.get("number"));
            map1.put(p.get("gender"), p.get("number"));
        }

    }

    @Test
    void test2(){
//        System.out.println(oldpersonInfoService.countByAge(70,80));
        System.out.println(oldpersonInfoRepository.countByHealth_state("健康"));
    }


}
