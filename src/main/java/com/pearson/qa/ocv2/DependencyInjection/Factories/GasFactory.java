package com.pearson.qa.ocv2.DependencyInjection.Factories;

import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded94;

/**
 * Created by Sunil Kumar on 10/18/2014.
 */
public class GasFactory {

    public Gas getGas(String gasType) {

        if ("Leaded".equals(gasType))
        return (new Leaded94());

        else return null;
    }
}
