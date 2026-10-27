package LLD.AdapterDesignPattern;

import LLD.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import LLD.AdapterDesignPattern.Adapter.WeightAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightAdapterImpl wt = new WeightAdapterImpl(new WeightMachineForBabies());
        System.out.println("start");
        System.out.println(wt.getWeightInKgs());
    }
    
}
