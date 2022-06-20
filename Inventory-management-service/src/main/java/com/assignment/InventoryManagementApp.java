package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class InventoryManagementApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryManagementApp.class);
        
    }
}
