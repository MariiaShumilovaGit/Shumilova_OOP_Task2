package com.company;

import java.util.Scanner;

public class Woman extends Human {
    public Woman() {
         setGender(false);
    }

    public Human GiveBirth(Human father) {
        Human newHuman;

        if (getGender() == false) {
            boolean newHumanGender = Math.random()<0.5;
            if (newHumanGender == true) {
                newHuman = new Man();
            }
            else {
                newHuman = new Woman();
            }
            System.out.println("Введите имя ребенка ");
            Scanner scan = new Scanner(System.in);
            newHuman.setName(scan.nextLine());
            newHuman.setSurname(father.getSurname());
            if (newHuman.getGender() == true) {
                newHuman.setHeight(father.getHeight()+0.1f*((getHeight())- father.getHeight()));
                newHuman.setWeight(father.getWeight()+0.1f*((getWeight())- father.getWeight()));
            }
            else {
                newHuman.setHeight(getHeight()+0.1f*((father.getHeight())- getHeight()));
                newHuman.setWeight(getWeight()+0.1f*((father.getWeight())- getWeight()));
            }
            return newHuman;
        }
        else return null;
    }
}
