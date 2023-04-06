
package com.liruilong.hros.Exception;

import com.liruilong.hros.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @Description :全局异常处理

 * @Date: 2019/12/25 16:41
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger("GlobalExceptionHandler");
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据,操作异常!");
        }
        return RespBean.error("数据库异常,操作失败");
    }
/*    @ExceptionHandler(IllegalStateException.class)
    public void ValidateCodeException(IllegalStateException e) {

        logger.warning("Cannot call sendError() after the response has been committed " +"异常");

    }
    @ExceptionHandler(NullPointerException.class)
    public RespBean ValidateCodeException(NullPointerException e) {
        return RespBean.error("系统错误提示:空指针异常");
    }*/
}
