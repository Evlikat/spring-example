package net.thumbtack.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringXmlConfigApplication {

    public static void main(String[] args) {
        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext("application-context.xml")) {
            Cat cat = context.getBean(Cat.class);
            System.out.println(cat.getName());
            System.out.println(cat.findFunction("bring"));
        }
    }
}
