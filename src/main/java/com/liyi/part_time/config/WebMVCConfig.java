package com.liyi.part_time.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("sys/index");
        registry.addViewController("/login").setViewName("sys/login");
        registry.addViewController("/register").setViewName("sys/register");
        registry.addViewController("/userSetting").setViewName("sys/user-setting");
        registry.addViewController("/userPassword").setViewName("sys/user-password");
        registry.addViewController("/statistics").setViewName("sys/statistics");
        registry.addViewController("/welcome").setViewName("sys/welcome");

        registry.addViewController("/adminTable").setViewName("admin/table");
        registry.addViewController("/adminAdd").setViewName("admin/add");
        registry.addViewController("/adminEdit").setViewName("admin/edit");

        registry.addViewController("/businessTable").setViewName("business/table");
        registry.addViewController("/businessDetail").setViewName("business/detail");
        registry.addViewController("/businessAudit").setViewName("business/audit");

        registry.addViewController("/jobTable").setViewName("job/table");
        registry.addViewController("/jobDetail").setViewName("job/detail");

        registry.addViewController("/hunterTable").setViewName("hunter/table");
        registry.addViewController("/hunterDetail").setViewName("hunter/detail");

        registry.addViewController("/feedbackTable").setViewName("feedback/table");
        registry.addViewController("/feedbackDetail").setViewName("feedback/detail");


    }
}