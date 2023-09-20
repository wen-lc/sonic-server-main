package org.cloud.sonic.common.tools;



//import cn.sunline.mone.test.core.i18n.I18NUtils;
//import cn.sunline.mone.test.core.util.StringUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

/**
 * @Author: cyr
 * @Date: 2021/1/28 10:02
 * 系统异常（非Service中异常，配置异常等）
 */
public class MOneTestException extends RuntimeException{

    private static final long serialVersionUID = -2657756055378346409L;

    private String key;
    private String[] argsArray;
    private Locale locale;
    private String message;

    public MOneTestException() {
        this.key = "-1000";
    }

    public MOneTestException(String key) {
        super(key);
        this.key = key;
    }

    public MOneTestException(String key, String message) {
        super(key);
        this.key = key;
        this.message = message;
    }

    public MOneTestException(String key, String[] argsArray) {
        super(key);
        this.key = key;
        this.argsArray = argsArray;
    }

    public MOneTestException(Throwable cause) {
        super(cause);
        this.key = "-1000";
    }

    public MOneTestException(String key, Throwable cause) {
        super(key, cause);
        this.key = key;
    }

    public MOneTestException(String key, String[] argsArray, Throwable cause) {
        super(key, cause);
        this.key = key;
        this.argsArray = argsArray;
    }

    public MOneTestException(Locale locale) {
        this.key = "-1000";
        this.locale = locale;
    }

    public MOneTestException(String key, Locale locale) {
        super(key);
        this.key = key;
        this.locale = locale;
    }

    public MOneTestException(String key, String[] argsArray, Locale locale) {
        super(key);
        this.key = key;
        this.argsArray = argsArray;
        this.locale = locale;
    }

    public MOneTestException(String key, Locale locale, Throwable cause) {
        super(key, cause);
        this.key = key;
        this.locale = locale;
    }

    public MOneTestException(String key, String[] argsArray, Locale locale, Throwable cause) {
        super(key, cause);
        this.key = key;
        this.argsArray = argsArray;
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getKey() {
        return this.key;
    }

    public String[] getArgsArray() {
        return this.argsArray;
    }

//    public String getMessage(Locale locale) {
//        return I18NUtils.getMessage(this.key, this.argsArray, locale);
//    }
//
//    public String getMessage() {
//        if (StringUtils.isNotEmpty(this.message)) {
//            return this.message;
//        } else {
//            return getMessage(I18NUtils.getLocale());
//        }
//    }
}

