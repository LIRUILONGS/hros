package com.liruilong.hros.controller.system.basic;

import com.liruilong.hros.model.RespBean;
import com.liruilong.hros.model.RwardsAndPunishments;
import com.liruilong.hros.model.RwardsPunishments;
import com.liruilong.hros.service.RwardsAndPunishmentsService;
import com.liruilong.hros.service.RwardsPunishmentsSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 奖惩

 * @Date: 2019/12/28 16:06
 */

@RestController
@RequestMapping("/system/basic/rp")
public class RwardsPunishmentsController {

    @Autowired
    RwardsPunishmentsSevice rwardsPunishmentsSevice;
    @Autowired
    RwardsAndPunishmentsService rwardsAndPunishmentsService;

    @GetMapping("/")
    public List<RwardsPunishments> getAllRwardsPunishments() {
        return rwardsPunishmentsSevice.getAllRwardsPunishments();
    }

    @GetMapping("/rap/")
    public List<RwardsAndPunishments> getAllRwardsAndPunishments(){
        return rwardsAndPunishmentsService.getAllRwardsAndPunishments();
    };

    @PutMapping("/")
    public RespBean updateRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {

        if (rwardsPunishmentsSevice.updateRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/")
    public RespBean addRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {
        if (rwardsPunishmentsSevice.addRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRwardsPunishmentsById( @PathVariable Integer id){
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsById(id) == 1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }
    @DeleteMapping("/")
    public RespBean deleteRwardsPunishmentsByIds(Integer[] ids){
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/serch/")
    public List<RwardsPunishments> sercRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments){
        return rwardsPunishmentsSevice.sercRwardsPunishments(rwardsPunishments);
    }


}

