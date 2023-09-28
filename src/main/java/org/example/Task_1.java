package org.example;

public class Task_1 {
    public String numericMoreThanSeven(String number) {
        try {
            int num = Integer.parseInt(number);
            return num > 7 ? "Привет" : "Введенное число меньше семи";
        } catch (NumberFormatException e) {
            return "Некорректный ввод.";
        }
    }
}