package org.project.boulangerie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableCaching
@SpringBootApplication
//@ComponentScan(basePackages = {"spring.nx", "org.project.boulangerie"})
public class BoulangerieApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoulangerieApplication.class, args);
    }
}
