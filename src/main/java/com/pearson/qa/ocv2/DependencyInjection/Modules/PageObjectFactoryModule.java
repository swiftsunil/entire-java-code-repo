package com.pearson.qa.ocv2.DependencyInjection.Modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.pearson.qa.ocv2.DependencyInjection.Factories.PageObjectFactory;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.DunlopTires;

/**
 * Created by Sunil Kumar on 10/19/2014.
 */
public class PageObjectFactoryModule extends AbstractModule{

    @Override
    protected void configure() {

        install(new FactoryModuleBuilder().implement(Tire.class,DunlopTires.class)
                                          .implement(Gas.class,Leaded.class)
                                          .build(PageObjectFactory.class));
    }
}
