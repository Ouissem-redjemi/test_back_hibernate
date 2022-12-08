package com.test.test_back_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestBackHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBackHibernateApplication.class, args);
    }

}
