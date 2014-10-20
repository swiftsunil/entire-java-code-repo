package com.pearson.qa.ocv2.DependencyInjection.Tests;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.pearson.qa.ocv2.DependencyInjection.Factories.GasFactory;
import com.pearson.qa.ocv2.DependencyInjection.Factories.PageObjectFactory;
import com.pearson.qa.ocv2.DependencyInjection.Factories.TireFactory;
import com.pearson.qa.ocv2.DependencyInjection.Modules.MyModule;
import com.pearson.qa.ocv2.DependencyInjection.Modules.PageObjectFactoryModule;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.Cars.Car;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Leaded;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Unleaded87;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.AvonTires;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


/**
 * Created by Sunil Kumar on 10/18/2014.
 */
public class CarTest {

    private PageObjectFactory pageObjectFactory;

    @Inject
    public void setPageObjectFactory(PageObjectFactory factory) {
        pageObjectFactory = factory;
    }

    // Factory pattern useful when we change to a new dunlop tire.
    @Test(groups = {"java.dependency.injection"} )
    public void verifyNormalInitializationDependencyInjectionAndPageObjectFactory() {

        Logger logger = Logger.getLogger(CarTest.class);
        // 1) using new key word
        Car lexus1 = new Car();
        logger.debug("\n\n::Using new keyword ::");
        logger.debug("Lexus 1 tire, gas status:: " + lexus1.turnOn());
        lexus1.setTires(new AvonTires());
        lexus1.setGas(new Unleaded87());
        logger.debug("Lexus 1 tire, gas status after tire/gas factory injection:: " + lexus1.turnOn());
        logger.debug("Lexus 1 tire value:: " + lexus1.getTires().getTreadType() + " Lexus 2 gas value:: "
                + lexus1.getGas().getOctaneValue());

        // 2) using tire factory and gas factory
        TireFactory tirefactory = new TireFactory();
        GasFactory gasFactory = new GasFactory();
        Car lexus2 = new Car();
        logger.debug("\n\n::Using Normal Tire and Gas factories::");
        logger.debug("Lexus 2 tire, gas status:: " + lexus2.turnOn());
        lexus2.setTires(tirefactory.getTires("Dunlop"));
        lexus2.setGas(gasFactory.getGas("Leaded"));
        logger.debug("Lexus 2 tire, gas status after tire/gas factory injection:: " + lexus2.turnOn());
        logger.debug("Lexus 2 tire value:: " + lexus2.getTires().getTreadType() + " Lexus 2 gas value:: "
                +lexus2.getGas().getOctaneValue());

        // 3) using  google injector
        MyModule module1 = new MyModule();
        Injector injector1 = Guice.createInjector(module1);
        Car lexus3 =  new Car();
        logger.debug("\n\n::Using Google Injector::");
        logger.debug("Lexus 3 tire, gas status:: " + lexus3.turnOn());
        lexus3.setTires(injector1.getInstance(Tire.class));
        lexus3.setGas(injector1.getInstance(Gas.class));
        logger.debug("Lexus 3 tire, gas status:: " + lexus3.turnOn());
        logger.debug("Lexus 3 tire value:: " + lexus3.getTires().getTreadType() + " Lexus 3 gas value:: "
                + lexus3.getGas().getOctaneValue() );

        // 4) using injected page object factory module
        PageObjectFactoryModule pageObjectFactoryModule = new PageObjectFactoryModule();
        Injector injector2 = Guice.createInjector(pageObjectFactoryModule);
        Car lexus4 = new Car();
        logger.debug("\n\n::Using injected page object factory:: ");
        logger.debug("Lexus 4 tire, gas status:: "+ lexus4.turnOn());
        PageObjectFactory pageObjectFactory = injector2.getInstance(PageObjectFactory.class);
        lexus4.setTires(pageObjectFactory.createTireObject());
        lexus4.setGas(pageObjectFactory.createGasObject());
        logger.debug("Lexus 4 tire, gas status:: "+ lexus4.turnOn());
        logger.debug("Lexus 4 tire value:: " + lexus4.getTires().getTreadType() + " Lexus 4 gas value:: "
                + lexus4.getGas().getOctaneValue());

    }

}
