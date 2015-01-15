package com.pearson.qa.ocv2.DependencyInjection.Modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.pearson.qa.ocv2.DependencyInjection.Factories.AssistedInjectCarFactory;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded94;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.DunlopTires;

/**
 * Created by Sunil Kumar on 10/18/2014.
 */
public class SedanModule extends AbstractModule {

    @Override
    public void configure() {
        bind(Tire.class).to(DunlopTires.class);
        bind(Gas.class).to(Leaded94.class);
        install(new FactoryModuleBuilder().build(AssistedInjectCarFactory.class));

    }
}
