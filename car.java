/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlot;

import java.io.Serializable;

/**
 *
 * @author joelesniak
 */
public class car implements Serializable {

    private String make, model;
    private int year, Number_for_Sale;
    private Float price;
    private CarLot[] cars = new CarLot[20];
    private int numberOfCars;

    public car() {
        year = 0;
        Number_for_Sale = 0;
        numberOfCars = 0;
    }

    public car(String Make, String Model, int year, int Number_for_Sale, Float price) {
        this.make = Make;
        this.model = Model;
        this.year = year;
        this.Number_for_Sale = Number_for_Sale;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String Make) {
        this.make = Make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String Model) {
        this.model = Model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        this.year = Year;
    }

    public int getNumber_for_Sale() {
        return Number_for_Sale;
    }

    public void setNumber_for_Sale(int Number_for_Sale) {
        this.Number_for_Sale = Number_for_Sale;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
