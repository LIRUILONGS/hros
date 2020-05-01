package com.liruilong.hros.controller.publics;

import com.liruilong.hros.model.MainNorice;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.service.MainNoriceService;
import com.liruilong.hros.service.OplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2019/12/18 19:23
 */
@RestController
public class HomeController {

    @Autowired
   MainNoriceService mainNoriceService;
  @Autowired
    OplogService oplogService;

    @GetMapping("/body")
    public List<MainNorice> getAllsMainNoricebody(){
        return mainNoriceService.getAllsMainNoricebody();
    }

    @GetMapping("/log")
    public List<OpLog> getAllsOplog(){
        return oplogService.getAllsOplogm();
    }



}
