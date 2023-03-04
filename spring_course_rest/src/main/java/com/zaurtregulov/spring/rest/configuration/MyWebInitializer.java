package com.zaurtregulov.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// класс вместо web.xml где мы пропишем dispatcher servlet
public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class}; // аналогично как мы давали ссылку в web.xml на applicationContext.xml. Здесь мы ссылаемся на MyConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};  // аналогично как мы давали ссылку в web.xml на <url-pattern>
    }

}
