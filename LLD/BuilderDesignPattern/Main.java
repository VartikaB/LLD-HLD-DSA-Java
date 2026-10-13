package LLD.BuilderDesignPattern;

import LLD.BuilderDesignPattern.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder().setColor("pink").setEngine("horse").setWheels(100).build();
    car.getCarPropereties();
        
    }
    

    
}
