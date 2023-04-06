package com.liruilong.hros.controller.publics;

import com.liruilong.hros.model.MainNorice;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.service.MainNoriceService;
import com.liruilong.hros.service.OplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :

 * @Date: 2019/12/18 19:23
 */
@RestController
public class HomeController {

    @Autowired
    MainNoriceService mainNoriceService;
    @Autowired
    OplogService oplogService;

    @GetMapping("/body")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<MainNorice> getAllsMainNoricebody(){
        return mainNoriceService.getAllsMainNoricebody();
    }

    @GetMapping("/log")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<OpLog> getAllsOplog(){
        return oplogService.getAllsOplogm();
    }



}
