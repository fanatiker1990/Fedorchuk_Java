package org.example;

public class Task_2 {
    public String isVecheslav(String name) {
        return name.trim().equals("Вячеслав") ? String.format("Привет, %s", name) : "Нет такого имени";
    }
}
