package com.pearson.qa.ocv2.ObjectMapper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sunil Kumar on 10/23/2014.
 */
public class User {

    private int age = 29;
    private String name = "mkyong";
    private ArrayList<String> messages = new ArrayList<String>(Arrays.asList("msg 1", "msg 2", "msg 3"));

    public String toString() {

        return "User [age=" + age + ", name=" + name + ", "+ "messages=" + messages + "]";

    }
}
