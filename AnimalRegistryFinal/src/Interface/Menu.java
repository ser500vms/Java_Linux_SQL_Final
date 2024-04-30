package Interface;

import Model.Dog;
import Services.WorkWithDataBase;

import java.util.Scanner;

public class Menu {
    WorkWithDataBase workWithData = new WorkWithDataBase();

    public void start() {
        System.out.print("Hi");
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "\n1 - Список животных\n2 - Завести новое животное\n" +
                            "3 - Что умеет животное\n4 - Дрессировка\n5 - Удалить животное\n0 - Выход");
            String key = in.next();
            switch (key) {
                case "1":
                    workWithData.getAllAnimals();
                    break;
                case "2":
                    workWithData.addNewAnimal();
                    break;
                case "3":
                    workWithData.findAnimal();
                    break;
                case "4":
                    workWithData.trainAnimal();
                    break;
                case "5":
                    workWithData.deleteAnimal();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("такого варианта нет");
                    break;
            }
        }
    }
}

