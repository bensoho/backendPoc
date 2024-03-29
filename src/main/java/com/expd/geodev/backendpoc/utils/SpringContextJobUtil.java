package com.expd.geodev.backendpoc.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextJobUtil implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextJobUtil.context = context;
    }

    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }

}
