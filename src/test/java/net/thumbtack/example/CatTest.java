package net.thumbtack.example;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CatTest.Configuration.class)
@TestPropertySource(properties = "cat.name = breezy")
public class CatTest {

    @Autowired
    Cat cat;

    static final class Configuration {
        @Bean
        public CatOperatingSystem os() {
            return new Linux();
        }

        @Bean
        public Cat cat(@Value("${cat.name}") String name, CatOperatingSystem os) {
            return new Cat(name, os);
        }
    }

    @Test
    public void shouldHaveName() {
        assertEquals(
                "breezy",
                cat.getName()
        );
    }

    @Test
    public void shouldSayAllFunctions() {
        assertEquals(
                Arrays.asList("bring shoes", "bring good news"),
                cat.findFunction("bring")
        );
    }
}
