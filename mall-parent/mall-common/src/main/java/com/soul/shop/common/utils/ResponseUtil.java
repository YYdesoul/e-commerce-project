package com.soul.shop.common.utils;

import com.alibaba.fastjson.JSON;
import com.soul.shop.common.enums.BusinessCodeEnum;
import com.soul.shop.common.vo.Result;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 输出相应工具
 */
@Slf4j
public class ResponseUtil {

    static final String ENCODING = "UTF-8";
    static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    /**
     * 输出前端内容以及状态指定
     * @param response
     * @param status
     * @param content
     */
    public static void output(HttpServletResponse response, Integer status, String content) {
        ServletOutputStream servletOutputStream = null;
        try {
            response.setCharacterEncoding(ENCODING);
            response.setContentType(CONTENT_TYPE);
            response.setStatus(status);
            servletOutputStream = response.getOutputStream();
            servletOutputStream.write(content.getBytes());
        } catch (Exception e) {
            log.error("response output error: ", e);
        } finally {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException e) {
                    log.error("response output IO close error: " , e);
                }
            }
        }
    }

    /**
     * respon 输出JSON
     * @param response
     * @param status
     * @param result
     */
    public static void output(HttpServletResponse response, Integer status, Result result) {
        response.setStatus(status);
        output(response, result);
    }

    public static void output(HttpServletResponse response, Result result) {
        ServletOutputStream servletOutputStream = null;
        try {
            response.setCharacterEncoding(ENCODING);
            response.setContentType(CONTENT_TYPE);
            servletOutputStream = response.getOutputStream();
            servletOutputStream.write(JSON.toJSONString(result).getBytes());
        } catch (Exception e) {
            log.error("response output error: ", e);
        } finally {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException e) {
                    log.error("response output IO close error: ", e);
                }
            }
        }
    }

}
