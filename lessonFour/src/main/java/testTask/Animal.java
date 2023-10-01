package testTask;

public class Animal {
    private String name;
    private int hungerLevel;

    public Animal(String name) {
        this.name = name;
        this.hungerLevel = 0;
    }

    /**
     * Метод, который позволяет животному поесть и уменьшает его уровень голода.
     *
     * @param foodName Название еды, которую животное съедает.
     * @param foodQuantity Количество еды, которое животное съедает.
     * @return true, если животное успешно поело, false, если не удалось по каким-либо причинам.
     * @pre Животное должно быть живым.
     * @pre Уровень голода животного должен быть больше 0.
     * @pre Количество еды должно быть больше 0.
     * @post Уровень голода животного уменьшается на количество съеденной еды.
     */
    public boolean eat(String foodName, int foodQuantity) {
        if (isAlive() && hungerLevel > 0 && foodQuantity > 0) {
            // Уменьшаем уровень голода
            hungerLevel -= foodQuantity;
            System.out.println(name + " поел " + foodQuantity + " единиц(у) " + foodName);
            return true;
        } else {
            System.out.println(name + " не может поесть.");
            return false;
        }
    }

    public boolean isAlive() {
        return hungerLevel > 0;
    }
}