package net.thumbtack.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class WatcherAspect {

    private static final Logger LOG = LoggerFactory.getLogger(WatcherAspect.class);

    @Pointcut("execution(* net.thumbtack.example.repo.*.findAll(..))")
    public void whenRepositoryFindAll() {
    }

    @Before(value = "whenRepositoryFindAll()")
    public void watchBeforeFindAllRequested(JoinPoint jp) {
        LOG.warn("Warning! Someone wants to know about the cats");
    }

    @AfterReturning(value = "whenRepositoryFindAll()", returning = "result")
    public void watchAfterFindAllRequested(JoinPoint jp, Object result) {
        LOG.warn("Warning! Someone knows about the cats");
    }
}
