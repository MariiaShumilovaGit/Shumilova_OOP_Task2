package com.company;

import java.util.Scanner;

public abstract class Human {
    private boolean gender;
    private String name;
    private String surname;
    private float height;
    private float weight;

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) { this.gender = gender; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getHeight() { return height; }

    public void setHeight(float height) {
        if (height <= 0) {
            System.out.println("Рост не может быть нулевым или отрицательным!");
        }
        else {
            this.height = height;
        }
    }

    public float getWeight() { return weight; }

    public void setWeight(float weight) {
        if (weight <= 0) {
            System.out.println("Вес не может быть нулевым или отрицательным!");
        }
        else {
            this.weight = weight;
        }
    }

    @Override
    public String toString() {
        return "New human {" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    // methods
    private boolean Speak(Human human) {
        boolean canSpeak;
        if ((getGender() == false && human.getGender() == false)
                || (getGender() == false && human.getGender() == true)
                || (getGender() == true && human.getGender() == false)) {
            canSpeak = true;
        }
        else {
            canSpeak = Math.random() < 0.5;
        }
        System.out.println("    Общение - " + canSpeak);
        return canSpeak;
    }

    private boolean Tolerate(Human human) {
        boolean canTolerate;
        if ((getGender() == false && human.getGender() == false)) {
            canTolerate = Math.random() < 0.05;
        }
        else if ((getGender() == false && human.getGender() == true)
                || (getGender() == true && human.getGender() == false)) {
            canTolerate = Math.random() < 0.7;
        }
        else {
            canTolerate = Math.random() < 0.056;
        }
        System.out.println("    Терпят друг друга - " + canTolerate);
        return canTolerate;
    }

    private boolean SpendTime(Human human) {
        boolean canSpendTime;
        float dif;
        if (getHeight() >= human.getHeight()) {
            dif = ((getHeight() - human.getHeight()) / getHeight()) / 100;
        }
        else {
            dif = ((human.getHeight() - getHeight()) / getHeight()) / 100;
        }
        if (dif >= 10) {
            canSpendTime = Math.random() < 0.85;
        }
        else {
            canSpendTime = Math.random() < 0.95;
        }
        System.out.println("    Проводят время вместе - " + canSpendTime);
        return canSpendTime;
    }

    private Human Relationships(Human human) {
        if (Speak(human) && Tolerate(human) && SpendTime(human)) {
            if (getGender() == human.getGender()) {
                System.out.println("Одинаковый пол");
            }
            else {
                System.out.println("Пара совпала, будет ребенок");
                Woman woman;
                if (getGender() == false) {
                    woman = (Woman)this;
                }
                else {
                    woman = (Woman)human;
                }
                return woman.GiveBirth(human);
            }
        }
        return null;
    }

    public static Human CheckCompatibility(Human human1, Human human2) {
        System.out.println("Проверяем совместимость: ");
        return human1.Relationships(human2);
    }
}
