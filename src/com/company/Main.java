package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Human human1;
        System.out.println("Введите пол первого человека (true - мужчина, false - женщина): ");
        boolean firstPersonGender = scan.nextBoolean();
        scan.nextLine();
        if (firstPersonGender == true) {
            human1 = new Man();
        }
        else {
            human1 = new Woman();
        }
        System.out.println("Введите имя первого человека: ");
        human1.setName(scan.nextLine());
        System.out.println("Введите фамилию первого человека: ");
        human1.setSurname(scan.nextLine());
        System.out.println("Введите рост первого человека: ");
        human1.setHeight(scan.nextFloat());
        System.out.println("Введите вес первого человека: ");
        human1.setWeight(scan.nextFloat());

        Human human2;
        System.out.println("Введите пол второго человека (true - мужчина, false - женщина): ");
        boolean secondPersonGender = scan.nextBoolean();
        scan.nextLine();
        if (secondPersonGender == true) {
            human2 = new Man();
        }
        else {
            human2 = new Woman();
        }
        System.out.println("Введите имя второго человека: ");
        human2.setName(scan.nextLine());
        System.out.println("Введите фамилию второго человека: ");
        human2.setSurname(scan.nextLine());
        System.out.println("Введите рост второго человека: ");
        human2.setHeight(scan.nextFloat());
        System.out.println("Введите вес второго человека: ");
        human2.setWeight(scan.nextFloat());

        Human newHuman = Human.CheckCompatibility(human1, human2);

        if (newHuman == null) {
            System.out.println("Разбежались");
        }
        else {
            System.out.println(newHuman.toString());
        }
    }

}

