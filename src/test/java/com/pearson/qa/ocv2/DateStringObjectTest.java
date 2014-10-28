package com.pearson.qa.ocv2;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sunil Kumar on 10/27/2014.
 */
public class DateStringObjectTest {


   @Test
    public void validateSimpleDateObject1() {
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
       String dateInString = "7-Jun-2013";

       try {
           Date date = formatter.parse(dateInString);
           System.out.println(date);
           System.out.println(formatter.format(date));
       } catch (ParseException e) {
           e.printStackTrace(); }
   }

    @Test
    public void validateSimpleDateObject2(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "07/06/2013";
        try {
            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateDateObject3(){

        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String dateInString = "Jun 7, 2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void validateDateObject4() {

        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
        String dateInString = "Fri, June 7 2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void validateDateObject5() {


        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
