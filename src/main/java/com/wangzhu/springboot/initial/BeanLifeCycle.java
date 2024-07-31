package com.wangzhu.springboot.initial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by wangz on 2024/7/30 16:18.
 **/
@Component
public class BeanLifeCycle implements ApplicationContextAware, InitializingBean, DisposableBean {


    // 1.bean实例化
    // 2.bean属性注入

    // --- BeanPostProcessor postProcessBeforeInitialization
    // 3.bean初始化 PostConstruct InitializingBean init-method
    // --- BeanPostProcessor postProcessAfterInitialization
    // 4.bean使用
    // 5.bean销毁 PreDestroy DisposableBean destroy-method
    private static final Logger logger = LoggerFactory.getLogger(BeanLifeCycle.class);

    public BeanLifeCycle(){
        logger.info("create");
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        logger.info("PostConstruct");
    }

    @PreDestroy
    public void close(){
        logger.info("PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy");
    }
}
