package Interfaces;

import Models.SmartPhone;

public interface Product<T> extends Comparable<T>{
    public String getName();
    public double getPrice();
}
