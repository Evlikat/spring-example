package net.thumbtack.example;

import net.thumbtack.example.aop.Aspects;
import net.thumbtack.example.security.WebSecurity;
import net.thumbtack.example.service.Services;
import net.thumbtack.example.web.Mvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        Aspects.class,
        Mvc.class,
        WebSecurity.class,
        Services.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
