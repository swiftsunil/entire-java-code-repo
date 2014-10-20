package com.pearson.qa.ocv2.DependencyInjection.Modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.Cars.Car;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.DunlopTires;

/**
 * Created by Sunil Kumar on 10/18/2014.
 */
public class MyModule implements Module{

    @Override
    public void configure(Binder binder) {
        binder.bind(Tire.class).to(DunlopTires.class);
        binder.bind(Gas.class).to(Leaded.class);
    }
}
