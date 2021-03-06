package cn.spacewalker.tsp.bg.tbox;

import cn.spacewalker.tsp.bg.tbox.client.TBoxClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/11 17:52
 * Copyright (c) 2017 www.space-walker.cn
 *
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class TBoxLauncher implements CommandLineRunner {

    @Autowired
    private TBoxClient tBoxClient;

    public static void main(String[] args) {
        SpringApplication.run(TBoxLauncher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        new TBoxClient().start();
        tBoxClient.start();
    }
}
