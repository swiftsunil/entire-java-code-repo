package com.pearson.qa.ocv2.DependencyInjection.pages.Cars;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;

/**
 * Created by Sunil Kumar on 10/17/2014.
 */
public class Car {

     Tire tires;
     Gas gas;
     String key;

    // constructors
    @Inject
    public Car(@Assisted String key) {
        this.key = key;
     }

    // getters
    public Tire getTires() {
        return tires;
    }
    public Gas getGas() {
        return gas;
    }

    // annotated setters
    @Inject
    public void setTires(Tire tires) {
        this.tires = tires;
    }

    @Inject
    public void setGas(Gas gas) {
        this.gas = gas;
    }

    // turn on boolean to return exact state whether injection worked or not.
    public boolean turnOn(String key) {
        return (this.tires!=null &&
                this.gas!=null  && this.key.equals(key));
    }

}
