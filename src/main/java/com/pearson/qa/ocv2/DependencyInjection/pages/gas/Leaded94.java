package com.pearson.qa.ocv2.DependencyInjection.pages.gas;

import com.pearson.qa.ocv2.DependencyInjection.interfaces.Gas;

/**
 * Created by Sunil Kumar on 10/17/2014.
 */
public class Leaded94 implements Gas {
    @Override
    public int getOctaneValue() {
        return 94;
    }
}
