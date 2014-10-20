package com.pearson.qa.ocv2.DependencyInjection.Factories;

import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;
import com.pearson.qa.ocv2.DependencyInjection.interfaces.Tire;

/**
 * Created by Sunil Kumar on 10/18/2014.
 */
public interface  PageObjectFactory {
    Tire createTireObject();
    Gas createGasObject();
}
