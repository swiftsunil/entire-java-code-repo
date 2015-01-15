package com.pearson.qa.ocv2.DependencyInjection.Factories;

import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.DunlopTires;

/**
 * Created by Sunil Kumar on 10/17/2014.
 */
public class TireFactory {

    public Tire getTires(String type) {

        if ("Dunlop".equals(type)) {

            return new DunlopTires();
        }
         else return null;
    }
}
