package org.example;

import java.util.Arrays;
import java.util.StringJoiner;

public class Task_3 {
    public String MultiplesOfThree(String arrayOfNumbers) {
        StringJoiner numbers = new StringJoiner(" ");
        try {
            int[] number = Arrays.stream(arrayOfNumbers.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.stream(number)
                    .filter(num -> num % 3 == 0)
                    .forEach(num -> numbers.add(String.valueOf(num)));
        } catch (NumberFormatException e) {
            return "Некорректный ввод. Пожалуйста, введите числа, разделенные пробелами.";
        }
        return numbers.toString();
    }
}
