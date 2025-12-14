package service;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ThreadServiceImplement implements ThreadService {
    @Override
    public void updatePrice(String file) {
        Random r = new Random();
        int valueChange = r.nextInt(10);
        boolean typeChange = r.nextBoolean();
        File filePath = new File(file);
        int currentPrice = 0;
        try (Scanner myReader = new Scanner(filePath)) {
            currentPrice = myReader.nextInt();
            if (typeChange) {
                currentPrice += currentPrice * valueChange / 100;
            } else {
                currentPrice -= currentPrice * valueChange / 100;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(currentPrice);

        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }
}
