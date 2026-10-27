package LLD.AdapterDesignPattern.Adapter;

import LLD.AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightAdapterImpl implements WeightAdapter {
    WeightMachine wt ;

    public WeightAdapterImpl(WeightMachine wt) {
        this.wt=wt;
    }
    public double getWeightInKgs(){
        return wt.getWeightInpounds()*0.45;
    }
    
    
}
