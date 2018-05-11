package cn.spacewalker.tsp.ft.bigscreen.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/14 15:16
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ImportResource("classpath:spring/spring-web.xml")
public class BigScreenLauncher {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BigScreenLauncher.class, args);
    }
}
