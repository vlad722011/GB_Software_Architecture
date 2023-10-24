package abstractFactory;
// Интерфейс для создания семейства животных
interface AnimalFactory {
    Lion createLion();
    Duck createDuck();
}

// Класс Lion (лев)
class Lion {
    public void roar() {
        System.out.println("Lion roars!");
    }
}

// Класс Duck (утка)
class Duck {
    public void quack() {
        System.out.println("Duck quacks!");
    }
}

// Класс AfricanLion (африканский лев)
class AfricanLion extends Lion {
    public void hunt() {
        System.out.println("African Lion hunts for prey!");
    }
}

// Класс AsianLion (азиатский лев)
class AsianLion extends Lion {
    public void performTrick() {
        System.out.println("Asian Lion performs a trick!");
    }
}

// Конкретная фабрика для африканских животных
class AfricanAnimalFactory implements AnimalFactory {
    @Override
    public Lion createLion() {
        return new AfricanLion();
    }

    @Override
    public Duck createDuck() {
        return new Duck();
    }
}

// Конкретная фабрика для азиатских животных
class AsianAnimalFactory implements AnimalFactory {
    @Override
    public Lion createLion() {
        return new AsianLion();
    }

    @Override
    public Duck createDuck() {
        return new Duck();
    }
}