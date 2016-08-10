package net.thumbtack.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Cat {

    private final String name;
    private final CatOperatingSystem os;

    public Cat(String name, CatOperatingSystem os) {
        this.name = name;
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public CatOperatingSystem getOs() {
        return os;
    }

    ArrayList<String> findFunction(String functionPattern) {
        Collection<String> functions = os.allFunctions();
        ArrayList<String> eligible = new ArrayList<>();
        for (String function : functions) {
            if (function.contains(functionPattern)) {
                eligible.add(function);
            }
        }
        return eligible;
    }
}

interface CatOperatingSystem {

    Collection<String> allFunctions();
}

class Linux implements CatOperatingSystem {

    public Collection<String> allFunctions() {
        return Arrays.asList("sleep", "eat", "drink", "update", "bring shoes", "bring good news");
    }
}

class Mac implements CatOperatingSystem {

    public Collection<String> allFunctions() {
        return Collections.singletonList("meow");
    }
}
