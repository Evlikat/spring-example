package net.thumbtack.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJavaConfigApplication {

    @Bean
    public CatOperatingSystem os() {
        return new Linux();
    }

    @Bean
    public Cat cat(CatOperatingSystem os) {
        return new Cat("breezy", os);
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigApplication.class)) {
            Cat cat = context.getBean(Cat.class);
            System.out.println(cat.getName());
            System.out.println(cat.findFunction("bring"));
        }
    }
}
