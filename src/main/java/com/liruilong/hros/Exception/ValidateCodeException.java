package com.liruilong.hros.Exception;


import org.springframework.security.core.AuthenticationException;


/**
 * @Description :

 * @Date: 2020/2/8 7:24
 */

public class ValidateCodeException extends AuthenticationException  {

    public ValidateCodeException(String msg) {
        super(msg);
    }


}
