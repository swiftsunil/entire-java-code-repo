package com.pearson.qa.ocv2.DependencyInjection.Factories;

import com.pearson.qa.ocv2.DependencyInjection.pages.Cars.Car;

/**
 * Created by Sunil Kumar on 10/22/2014.
 */
public interface AssistedInjectCarFactory {

    Car createCar(String key);
}
