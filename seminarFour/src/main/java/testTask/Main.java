package testTask;


public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal("Лев");
        Animal zebra = new Animal("Зебра");

        // Лев попытается съесть 5 единиц мяса
        lion.eat("мясо", 5);

        // Зебра попытается съесть 3 порции травы
        zebra.eat("трава", 3);

        // Лев попытается съесть еще 2 единицы мяса
        lion.eat("мясо", 2);

        // Проверим, живы ли лев и зебра после попыток покормить их
        System.out.println("Лев жив? " + lion.isAlive());
        System.out.println("Зебра жива? " + zebra.isAlive());


    }
}
