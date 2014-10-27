package com.pearson.qa.ocv2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.pearson.qa.ocv2.DependencyInjection.Factories.*;
import com.pearson.qa.ocv2.DependencyInjection.Modules.CoupeModule;
import com.pearson.qa.ocv2.DependencyInjection.Modules.PageObjectFactoryModule;
import com.pearson.qa.ocv2.DependencyInjection.Modules.SedanModule;
import com.pearson.qa.ocv2.DependencyInjection.Tests.CarTest;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;
import com.pearson.qa.ocv2.DependencyInjection.pages.Cars.Car;
import com.pearson.qa.ocv2.DependencyInjection.pages.gas.Unleaded87;
import com.pearson.qa.ocv2.DependencyInjection.pages.tires.AvonTires;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by Sunil Kumar on 10/25/2014.
 */
public class DependencyInjectorTests {

    private PageObjectFactory pageObjectFactory;
    Logger logger = Logger.getLogger(CarTest.class);

    @Test(groups = {"java.dependency.injection.newAndIndividualPageObjectFactory"} )
    public void verifyNewOperatorAndIndividualPageObjectFactoryInstantiation() {

        // 1) using new key word
        Car lexus1 = new Car("lexus1");
        logger.debug("\n\n::Using new keyword ::");
        logger.debug("Lexus 1 tire, gas status:: " +
                lexus1.turnOn("lexus1"));
        lexus1.setTires(new AvonTires());
        lexus1.setGas(new Unleaded87());
        logger.debug("Lexus 1 tire, gas status after tire/gas " +
                "factory injection:: " + lexus1.turnOn("lexus1"));
        logger.debug("Lexus 1 tire value:: " + lexus1.getTires().getTreadType() +
                " Lexus 2 gas value:: " + lexus1.getGas().getOctaneValue());


        // 2) using tire factory and gas factory
        TireFactory tirefactory = new TireFactory();
        GasFactory gasFactory = new GasFactory();
        Car lexus2 = new Car("lexus2");
        logger.debug("\n\n::Using Normal Tire and Gas factories::");
        logger.debug("Lexus 2 tire, gas status:: " + lexus2.turnOn("lexus2"));
        lexus2.setTires(tirefactory.getTires("Dunlop"));
        lexus2.setGas(gasFactory.getGas("Leaded"));
        logger.debug("Lexus 2 tire, gas status after tire/gas factory injection:: " +
                lexus2.turnOn("lexus2"));
        logger.debug("Lexus 2 tire value:: " + lexus2.getTires().getTreadType() +
                " Lexus 2 gas value:: "+ lexus2.getGas().getOctaneValue());


    }

    @Test(groups ={"java.dependency.injection.google.injection"})
    public void verifyGoogleInjectorInstantiation() {

        // 3) using  google injector
        SedanModule sedanModule = new SedanModule();
        Injector injector1 = Guice.createInjector(sedanModule);
        Car lexus3 =  new Car("Lexus");
        logger.debug("\n\n::Using Google Injector::");
        logger.debug("Lexus 3 tire, gas status:: " + lexus3.turnOn("Lexus"));
        lexus3.setTires(injector1.getInstance(Tire.class));
        lexus3.setGas(injector1.getInstance(Gas.class));
        logger.debug("Lexus 3 tire, gas status:: " + lexus3.turnOn("Lexus"));
        logger.debug("Lexus 3 tire value:: " + lexus3.getTires().getTreadType() + " Lexus 3 gas value:: "
                + lexus3.getGas().getOctaneValue() );

    }

   @Test(groups ={"java.injection.pageObjectFactoryAndAssistedPageObjectFactory"})
    public void verifyPageObjectFactiryAndAssistedPageObjectFactoryInstantiation() {

       // 4) using injected page object factory module
       PageObjectFactoryModule pageObjectFactoryModule = new PageObjectFactoryModule();
       Injector injector2 = Guice.createInjector(pageObjectFactoryModule);
       Car lexus4 = new Car("lexus4");
       logger.debug("\n\n::Using injected page object factory:: ");
       logger.debug("Lexus 4 tire, gas status:: "+ lexus4.turnOn("lexus4"));
       PageObjectFactory pageObjectFactory = injector2.getInstance(PageObjectFactory.class);
       lexus4.setTires(pageObjectFactory.createTireObject());
       lexus4.setGas(pageObjectFactory.createGasObject());
       logger.debug("Lexus 4 tire, sgas status:: "+ lexus4.turnOn("lexus4"));
       logger.debug("Lexus 4 tire value:: " + lexus4.getTires().getTreadType() + " Lexus 4 gas value:: "
               + lexus4.getGas().getOctaneValue());


       // 4) using assisted injector oage object factory.
       CoupeModule coupeModule6 = new CoupeModule();
       Injector coupeInjector6 = Guice.createInjector(coupeModule6);
       AssistedInjectCarFactory coupeFactory = coupeInjector6.getInstance(AssistedInjectCarFactory.class);
       Car coupe6 = coupeFactory.createCar("Coupe6");
       logger.debug("\n\n::Using Assisted Injector without calling setter methods::");
       logger.debug("Coupe6 tire, gas status:: " + coupe6.turnOn("Coupe6"));
       logger.debug("Coupe6 tire value:: " + coupe6.getTires().getTreadType() + " Coupe6 gas value:: "
               + coupe6.getGas().getOctaneValue() );



   }


}
