package Services;

import Model.*;

import java.util.Scanner;

public class Methods {

    private Dog dog = new Dog();
    private Cat cat = new Cat();
    private Hamster hamster = new Hamster();
    private Horse horse = new Horse();
    private Donkey donkey = new Donkey();
    private Camel camel = new Camel();

    public String[] chooseAnimal() {
        System.out.println("Выбирите животное для добавления");
        System.out.print("\n1 - Собака\n2 - Кошка\n3 - Хомяк\n" +
                "4 - Осел\n5 - Лошадь\n6 - Верблюд\n");
        String type;
        String packOrHome;
        Scanner in = new Scanner(System.in);
        String key = in.next();
        switch (key) {
            case "1":
                type = dog.getType();
                packOrHome = dog.getPackOrHome();
                break;
            case "2":
                type = cat.getType();
                packOrHome = cat.getPackOrHome();
                break;
            case "3":
                type = hamster.getType();
                packOrHome = hamster.getPackOrHome();
                break;
            case "4":
                type = donkey.getType();
                packOrHome = donkey.getPackOrHome();
                break;
            case "5":
                type = horse.getType();
                packOrHome = horse.getPackOrHome();
                break;
            case "6":
                type = camel.getType();
                packOrHome = camel.getPackOrHome();
                break;
            default:
                System.out.println("Такого варианта нет");
                return new String[]{};
        }
        System.out.println("Введите имя");
        String name = in.next();
        System.out.println("Введите день рождения (yyyy-mm-dd)");
        String birthday = in.next();
        return new String[]{name, birthday, type, packOrHome};
    }
}
