package com.pearson.qa.ocv2.DependencyInjection.pages.Cars;

import com.google.inject.Inject;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.Factories.TireFactory;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.DunlopTires;
import org.testng.annotations.Test;

/**
 * Created by Sunil Kumar on 10/17/2014.
 */
public class Car {

     Tire tires;
     Gas gas;

    // constructors
    public Car() {
     }

    // getters
    public Tire getTires() {
        return tires;
    }
    public Gas getGas() {
        return gas;
    }

    // setters
    @Inject
    public void setTires(Tire tires) {
        this.tires = tires;
    }

    @Inject
    public void setGas(Gas gas) {
        this.gas = gas;
    }

    // turn on boolean to return exact state whether injection worked or not.
    public boolean turnOn() {
        return (this.tires!=null && this.gas!=null );
    }

}
