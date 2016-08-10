package net.thumbtack.example.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class Aspects {

    @Bean
    public WatcherAspect watcherAspect() {
        return new WatcherAspect();
    }
}
