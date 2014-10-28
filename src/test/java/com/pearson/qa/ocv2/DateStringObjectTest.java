package com.pearson.qa.ocv2;

import com.pearson.qa.common.exceptions.RequirementsException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sunil Kumar on 10/27/2014.
 */
public class DateStringObjectTest {

//        Letter	Description	Examples
//        y	Year	2013
//        M	Month in year	July, 07, 7
//        d	Day in month	1-31
//        E	Day name in week	Friday, Sunday
//        a	Am/pm marker	AM, PM
//        H	Hour in day	0-23
//        H	Hour in am/pm	1-12
//        m	Minute in hour	0-60
//        s	Second in minute	0-60

    Logger logger = Logger.getLogger(DateStringObjectTest.class);

    @Test
    public void validateCourseStartDate() throws RequirementsException {
     String stringToBeTested = "Starts on Sunday, July 31, 2014";
     String endDateString =  "Friday, October 28, 2044";
        StringBuilder retreiveDateString = new StringBuilder();
        retreiveDateString.append(stringToBeTested);
        retreiveDateString.delete(0,10);

        logger.debug("\nAppended string:: "+ retreiveDateString );

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEE, MMMM dd, yyyy");

         try {

             Date date1 = simpleDateFormat.parse(retreiveDateString.toString());
             Date endDate = simpleDateFormat.parse(endDateString);
             logger.debug("\nDate object extracted:: "+ date1);
             boolean isInputDateBefore = true;
             if (endDate.before(date1))
                logger.debug("\nendDate:: " + endDateString +
                        " \nis before \ndate1:: " + retreiveDateString.toString() );
               else
                 logger.debug("\nendDate:: " + endDateString +
                         " \nis after \ndate1:: " + retreiveDateString.toString() );

         }catch (ParseException e ) {
           e.printStackTrace(); }
    }

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
