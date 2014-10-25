package com.pearson.qa.ocv2.CopyConstructor;

/**
 * Created by Sunil Kumar on 10/24/2014.
 */
public class CopyConstructorExample {

    int value1;
    int value2;

    // default constructor
    public CopyConstructorExample() {
        value1 = 3;
        value2 = 4;
    }

    // overloaded constructor
    public CopyConstructorExample(int value1, int value2 ) {
        value1 = this.value1;
        value2 = this.value2;
    }
}
