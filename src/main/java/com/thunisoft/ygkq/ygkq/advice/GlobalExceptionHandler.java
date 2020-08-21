/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.advice
 * @className com.thunisoft.ygkq.ygkq.advice.GlobalExceptionHandler
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import com.thunisoft.artery.exception.ArteryException;
import com.thunisoft.artery.response.ExceptionBody;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalExceptionHandler
 *
 * @description 全局异常处理
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Slf4j
public class GlobalExceptionHandler {

    /**
     * GlobalExceptionHandler
     *
     * @description 自定义异常
     * @param req 请求
     * @param e 异常
     * @param method 方法
     * @return 响应实体
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     **/
    @ExceptionHandler({ArteryException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody operatorForbiddenException(HttpServletRequest req, Exception e, HandlerMethod method) {
        log.error("---错误信息---method: {}, Host {} invokes url {} ERROR: {}", method.getMethod().getName(),
            req.getRemoteHost(), req.getRequestURL(), e.getMessage(), e);
        return new ExceptionBody(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "系统错误，请联系管理员");
    }
}