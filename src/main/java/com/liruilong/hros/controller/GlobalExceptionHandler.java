
package com.liruilong.hros.controller;

import com.liruilong.hros.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @Description :全局异常处理
 * @Author: Liruilong
 * @Date: 2019/12/25 16:41
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据,操作异常!");
        }
        return RespBean.error("数据库异常,操作失败");
    }
}
