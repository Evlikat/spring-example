package net.thumbtack.example.web;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
public class Mvc extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("index");
        registry.addViewController("login");
        registry.addViewController("bye");
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver("/html/", ".html"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        }
    }
}
