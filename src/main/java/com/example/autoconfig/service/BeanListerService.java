package com.example.autoconfig.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanListerService {

    private final ApplicationContext applicationContext;

    public BeanListerService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void listBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("All Beans in ApplicationContext:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}