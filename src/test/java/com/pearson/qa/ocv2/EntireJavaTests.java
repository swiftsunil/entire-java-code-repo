package com.pearson.qa.ocv2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.pearson.qa.ocv2.DependencyInjection.Factories.AssistedInjectCarFactory;
import com.pearson.qa.ocv2.DependencyInjection.Factories.GasFactory;
import com.pearson.qa.ocv2.DependencyInjection.Factories.PageObjectFactory;
import com.pearson.qa.ocv2.DependencyInjection.Factories.TireFactory;
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
public class EntireJavaTests {

    private PageObjectFactory pageObjectFactory;
    Logger logger = Logger.getLogger(CarTest.class);

    @Test(groups = {"java.dependency.injection"} )
    public void verifyNewOperatorInstantiation() {

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
    }


}
