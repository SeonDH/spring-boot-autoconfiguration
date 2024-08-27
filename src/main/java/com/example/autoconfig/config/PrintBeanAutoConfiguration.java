package com.example.autoconfig.config;

import com.example.autoconfig.service.BeanListerService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@AutoConfiguration
@ConditionalOnProperty(name= "print.bean", havingValue = "true")
public class PrintBeanAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public BeanListerService BeanListerAutoConfiguration(ApplicationContext applicationContext) {
        return new BeanListerService(applicationContext);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        BeanListerService beanListerService = event.getApplicationContext().getBean(BeanListerService.class);
        beanListerService.listBeans();
    }
}