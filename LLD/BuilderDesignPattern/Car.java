package LLD.BuilderDesignPattern;

public class Car {
    String engine;
    int wheels;
    String color;
    String type;
    private Car(CarBuilder carBuilder){
        this.engine=carBuilder.engine;
        this.wheels=carBuilder.wheels;
        this.color=carBuilder.color;
        this.type=carBuilder.type;
    }
    public void getCarPropereties(){
        System.out.println("Car is build with" + "engine --> "+engine + "wheels --> "+wheels + "color--> " + color + "type-->"+type);
    }

    public static class CarBuilder{
        String engine="basic engine";
        int wheels=4;
        String color = "Black";
        String type = "sports";
        public CarBuilder setEngine(String engine){
            this.engine=engine;
            return this;
        }
        public CarBuilder setWheels(int wheels){
            this.wheels=wheels;
            return this;
        }
        public CarBuilder setColor(String color){
            this.color=color;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    } 

    
}
