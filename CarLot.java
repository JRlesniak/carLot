/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlot;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author joelesniak
 */
public class CarLot {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        String carMake, carModel, fileName;
        int year, number_for_sales,  command, i, size = 0;
        float price;
        boolean found;
        car[] carLot = new car[20];

        System.out.println("Enter the name of the car lot file");
        fileName = keyboard.nextLine();

        System.out.println("Does this file exist 1: yes, 2: No");
        command = keyboard.nextInt();

        if (command == 1) {
            FileInputStream ifile = new FileInputStream(fileName);
            ObjectInputStream istream = new ObjectInputStream(ifile);
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    carLot[size] = (car) istream.readObject();
                    size++;
                } catch (IOException e) {
                    endOfFile = true;
                }
            }
        }
        boolean done = false;
        while (!done) {
            System.out.println("Enter a command:\n"
                    + "\t1: Enter new Car\n"
                    + "\t2: Sell a car\n"
                    + "\t3: Add to cars already owned\n"
                    + "\t4: Change price of a car\n"
                    + "\t5: List the car and how many owned\n"
                    + "\t6: Quit\n");
            command = keyboard.nextInt();

            switch (command) {
                case 1:
                    keyboard.nextLine();

                    System.out.println("Enter the make of the car.");
                    carMake = keyboard.nextLine();

                    System.out.println("Enter the model of the car.");
                    carModel = keyboard.nextLine();

                    System.out.println("Enter the year of the car.");
                    year = keyboard.nextInt();
                    keyboard.nextLine();

                    System.out.println("Enter the price of the car.");
                    price = keyboard.nextFloat();
                    keyboard.nextLine();

                    System.out.println("How many do you have to sell?");
                    number_for_sales = keyboard.nextInt();

                    car j = new car(carMake, carModel, year, number_for_sales, price);

                    carLot[size++] = j;
                    break;
                case 2:

                    keyboard.nextLine();

                    System.out.println("Enter the model of the car you "
                            + "would like to buy");
                    carModel = keyboard.nextLine();

                    i = 0;
                    found = false;
                    while (i < size && !found) {

                        if (carModel.compareTo(carLot[i].getModel()) == 0) {
                            found = true;
                        } else {
                            i++;
                        }
                    }
                    if (found) {
                        car car1 = carLot[i];
                        if (carLot[i].getNumber_for_Sale() > 1) {
                            System.out.println("one car has been sold from the lot!\n");
                            number_for_sales = carLot[i].getNumber_for_Sale();

                            number_for_sales--;
                            car1.setNumber_for_Sale(number_for_sales);

                        } else {
                            found = false;

                            System.out.println("SOLD!");
                            for (int t = i; t < size; t++) {
                                carLot[t] = carLot[t + 1];
                                size--;
                            }
                        }

                    } else {
                        System.out.println("We do not own that car");
                    }

                    break;

                case 3:
                    keyboard.nextLine();

                    System.out.println("Enter the model of the car you "
                            + "would like to add to");
                    carModel = keyboard.nextLine();

                    i = 0;
                    found = false;
                    while (i < size && !found) {
                        car car1 = carLot[i];
                        if (carModel.compareTo(carLot[i].getModel()) == 0) {
                            found = true;
                        } else {
                            i++;
                        }

                        if (!found) {
                            System.out.println("We do not own that car");
                        } else {
                            System.out.println("one car has been added!!\n");

                            number_for_sales = carLot[i].getNumber_for_Sale();
                            number_for_sales++;
                            car1.setNumber_for_Sale(number_for_sales);

                        }
                    }

                    break;

                case 4:
                    keyboard.nextLine();

                    System.out.println("Enter the model of the car you "
                            + "would like change the price of");
                    carModel = keyboard.nextLine();

                    i = 0;
                    found = false;
                    while (i < size && !found) {
                        car car1 = carLot[i];
                        if (carModel.compareTo(carLot[i].getModel()) == 0) {
                            found = true;
                        } else {
                            i++;
                        }

                        if (!found) {
                            System.out.println("We do not own that car");
                        } else {
                            System.out.println("what would you like to change the price to?");
                            price = keyboard.nextFloat();
                            keyboard.nextLine();

                            car1.setPrice(price);
                        }
                    }

                    break;
                case 5:

                    for (i = 0; i < size; i++) {
                        System.out.println(carLot[i].getYear() + " "
                                + carLot[i].getMake() + " "
                                + carLot[i].getModel() + " "
                                + " $" + carLot[i].getPrice() + " "
                                + carLot[i].getNumber_for_Sale() + "-Owned\n");
                    }

                    break;
                case 6:
                    done = true;
                    break;
            }
        }
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream ostream = new ObjectOutputStream(file);
        for (i = 0; i < size; i++) {
            ostream.writeObject(carLot[i]);
        }
        ostream.close();
    }
}
