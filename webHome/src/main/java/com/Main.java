package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anthony_xu
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/14 15:09 anthony_xu Exp $$
 */
@SpringBootApplication
@MapperScan("com.netty.dao.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
