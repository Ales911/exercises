package com.example.exercises.patterns.factory;

enum CatType {
    LION,
    TIGER
}

abstract class Cat {

    private final CatType catType;

    Cat(CatType catType) {
        this.catType = catType;
    }

    public String maay() {
        return catType + " says maay.";
    }
}

class Lion extends Cat {

    Lion() {
        super(CatType.LION);
    }
}

class Tiger extends Cat {

    Tiger() {
        super(CatType.TIGER);
    }
}

public class CatFactory {

    static Cat createCat(CatType catType) {
        Cat cat = null;
        switch (catType) {
            case LION ->
                cat = new Lion();
            case TIGER ->
                cat = new Tiger();
            default ->
                throw new IllegalArgumentException("Cat not found.");
        }
        return cat;
    }

}
