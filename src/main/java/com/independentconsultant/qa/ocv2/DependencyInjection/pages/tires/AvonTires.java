package com.pearson.qa.ocv2.DependencyInjection.pages.tires;

import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;

/**
 * Created by Sunil Kumar on 10/17/2014.
 */
public class AvonTires  implements Tire {

    @Override
    public String getTreadType() {
        return "AvonCrossCountry";
    }
}
