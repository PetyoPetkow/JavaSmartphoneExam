package Models;

import Interfaces.Product;

public class SmartPhone implements Product<SmartPhone>{
    String brand;
    String model;
    int year;
    String color;
    double price;

    public SmartPhone(String brand, String model, int year, String color, double price){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.color=color;
        this.price=price;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(SmartPhone s) {
        double otherPrice = s.price;

        if (price == otherPrice)
            return 0;
        else if (price > otherPrice)
            return 1;
        else
            return -1;
    }

    @Override
    public String getName() {
        return (this.brand + " " +this.model);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(getName()+ " ");
        builder.append(this.year + " ");
        builder.append(this.color + " ");
        builder.append(this.price) ;

        return builder.toString();
    }
}
