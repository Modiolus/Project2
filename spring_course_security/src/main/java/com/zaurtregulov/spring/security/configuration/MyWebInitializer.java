package com.zaurtregulov.spring.security.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {  // аналогично как мы давали ссылку в web.xml на applicationContext.xml. Здесь мы ссылаемся на MyConfig
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  // аналогично как мы давали ссылку в web.xml на в <url-pattern>
    }
}
