package org.example.app.config;


import org.example.app.controller.EmployeeController;
import org.example.app.entity.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.app")
public class AppConfig {

    @Bean
    public EmployeeController getEmployeeController() {
        return new EmployeeController();
    }

    @Bean
    public Message doMessage() {
        Message message = new Message();
        message.setMessage("The workflow is done.");
        return message;
    }

}
