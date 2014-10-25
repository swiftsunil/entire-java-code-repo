package com.pearson.qa.ocv2.DependencyInjection.Modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.pearson.qa.ocv2.DependencyInjection.Factories.AssistedInjectCarFactory;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Unleaded85;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.AvonTires;

/**
 * Created by Sunil Kumar on 10/22/2014.
 */


public class CoupeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Tire.class).to(AvonTires.class);
        bind(Gas.class).to(Unleaded85.class);
        install(new FactoryModuleBuilder().build(AssistedInjectCarFactory.class));

    }

}


