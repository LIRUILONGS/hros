package com.liruilong.hros.controller.system.cfg;

import com.liruilong.hros.model.MainNorice;
import com.liruilong.hros.model.RespBean;
import com.liruilong.hros.model.RespPageBean;
import com.liruilong.hros.service.MainNoriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description :

 * @Date: 2020/1/3 10:01
 */
@RequestMapping("/system/cfg")
@RestController
public class MainNoriceController {

    @Autowired
    MainNoriceService mainNoriceService;

    @GetMapping("/")
    public RespPageBean getAllsMainNorice(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "11") Integer size, String keyword){
        return mainNoriceService.getAllsMainNorice(page, size, keyword);
    }


    @PostMapping("/")
    public RespBean addMainNorice(@RequestBody MainNorice mainNorice) {
        if (mainNoriceService.addMainNorice(mainNorice) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateMainNorice(@RequestBody MainNorice mainNorice) {
        if (mainNoriceService.updateMainNorice(mainNorice) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteMainNorice(@PathVariable Integer id){
        if (mainNoriceService.deleteMainNorice(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");

    }
    @DeleteMapping("/")
    public RespBean deldteMainNorices(Integer[] ids){
        if (mainNoriceService.deldteMainNorices(ids) == ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
