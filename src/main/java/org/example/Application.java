package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Application extends JFrame {
    private JTextArea jTextArea;

    public Application() {
        super("Aston задачи");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setIconImage(loadIconImage());
        initComponent();
        setLocale(null);
        setVisible(true);
        setTextFromFile();
    }

    private void initComponent() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel taskLabel = new JLabel("Задача №1: Введите число");
        taskLabel.setBounds(15, 5, 225, 20);
        contentPane.add(taskLabel);

        JTextField Task_1 = new JTextField();
        Task_1.setName("Task_1");
        Task_1.setHorizontalAlignment(SwingConstants.LEFT);
        Task_1.setBounds(15, 25, 225, 25);
        Task_1.setForeground(Color.BLACK);
        Task_1.setOpaque(true);  // Allows background color to be set
        Task_1.setBackground(Color.WHITE);
        contentPane.add(Task_1);

        JLabel taskLabel1 = new JLabel("Задача №2: Введите имя");
        taskLabel1.setBounds(15, 90, 225, 20);
        contentPane.add(taskLabel1);

        JTextField Task_2 = new JTextField();
        Task_2.setName("Task_2");
        Task_2.setHorizontalAlignment(SwingConstants.LEFT);
        Task_2.setBounds(15, 115, 225, 25);
        Task_2.setForeground(Color.BLACK);
        Task_2.setOpaque(true);  // Allows background color to be set
        Task_2.setBackground(Color.WHITE);
        contentPane.add(Task_2);

        JLabel taskLabel2 = new JLabel("Задача №3: Введите массив");
        taskLabel2.setBounds(15, 185, 225, 20);
        contentPane.add(taskLabel2);

        JTextField Task_3 = new JTextField();
        Task_3.setName("Task_3");
        Task_3.setHorizontalAlignment(SwingConstants.LEFT);
        Task_3.setBounds(15, 205, 225, 25);
        Task_3.setForeground(Color.BLACK);
        Task_3.setOpaque(true);  // Allows background color to be set
        Task_3.setBackground(Color.WHITE);
        contentPane.add(Task_3);

        JTextField Task_4 = new JTextField();
        Task_4.setName("Task_3");
        Task_4.setHorizontalAlignment(SwingConstants.LEFT);
        Task_4.setBounds(15, 205, 225, 25);
        Task_4.setForeground(Color.BLACK);
        Task_4.setOpaque(true);  // Allows background color to be set
        Task_4.setBackground(Color.WHITE);
        contentPane.add(Task_4);

        JButton Start_1 = new JButton("Проверить");
        Start_1.setName("Parentheses");
        Start_1.setBounds(15, 60, 100, 25);
        Start_1.setContentAreaFilled(true);
        Start_1.setBackground(new Color(153, 255, 153));
        Start_1.addActionListener(e -> {
            String currentText = Task_1.getText();
            Task_1 task1 = new Task_1();
            Task_1.setText(task1.numericMoreThanSeven(currentText));
        });
        contentPane.add(Start_1);

        JButton Start_2 = new JButton("Проверить");
        Start_2.setName("Parentheses");
        Start_2.setBounds(15, 150, 100, 25);
        Start_2.setContentAreaFilled(true);
        Start_2.setBackground(new Color(153, 255, 153));
        Start_2.addActionListener(e -> {
            String currentText = Task_2.getText();
            Task_2 task2 = new Task_2();
            Task_2.setText(task2.isVecheslav(currentText));
        });
        contentPane.add(Start_2);

        JButton Clear = new JButton("Очистить");
        Clear.setName("Clear");
        Clear.setBounds(139, 60, 100, 25);
        Clear.setContentAreaFilled(true);
        Clear.setBackground(new Color(0, 255, 255));
        Clear.addActionListener(e -> Task_1.setText(""));
        contentPane.add(Clear);

        JButton Clear2 = new JButton("Очистить");
        Clear2.setName("Clear");
        Clear2.setBounds(139, 150, 100, 25);
        Clear2.setContentAreaFilled(true);
        Clear2.setBackground(new Color(0, 255, 255));
        Clear2.addActionListener(e -> Task_2.setText(""));
        contentPane.add(Clear2);

        JButton Start_3 = new JButton("Проверить");
        Start_3.setName("Parentheses");
        Start_3.setBounds(15, 240, 100, 25);
        Start_3.setContentAreaFilled(true);
        Start_3.setBackground(new Color(153, 255, 153));
        Start_3.addActionListener(e -> {
            String currentText = Task_3.getText();
            Task_3 task3 = new Task_3();
            Task_3.setText(task3.MultiplesOfThree(currentText));
        });
        contentPane.add(Start_3);

        JButton Clear3 = new JButton("Очистить");
        Clear3.setName("Clear");
        Clear3.setBounds(139, 240, 100, 25);
        Clear3.setContentAreaFilled(true);
        Clear3.setBackground(new Color(0, 255, 255));
        Clear3.addActionListener(e -> Task_3.setText(""));
        contentPane.add(Clear3);

        JLabel taskLabel4 = new JLabel("Задача №4");
        taskLabel4.setBounds(300, 5, 225, 20);
        contentPane.add(taskLabel4);

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);  // Перенос по строкам
        jTextArea.setWrapStyleWord(true);  // Перенос по словам
        jTextArea.setBounds(300, 25, 270, 425);
        contentPane.add(jTextArea);
    }

    private void setTextFromFile() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("answer_4.txt");
            if (inputStream != null) {
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
                jTextArea.setText(content.toString());  // Устанавливаем текст из файла в JTextField
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Image loadIconImage() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("icon.png");
            if (inputStream != null) {
                BufferedImage originalImage = ImageIO.read(inputStream);
                Image scaledImage = originalImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImage).getImage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
