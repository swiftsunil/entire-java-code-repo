package com.pearson.qa.ocv2;

import com.pearson.qa.ocv2.ObjectMapper.Employee;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Sunil Kumar on 10/26/2014.
 */
public class ObjectMapperTests {
Logger logger =  Logger.getLogger(ObjectMapperTests.class);

     @Test (groups = {"java.objectmapper.JavaObjToJson"})
    public void verifyEmployeeJavaToJson() throws IOException {

       @SuppressWarnings("deprecation")
       Employee employee = new Employee(1, "Lokesh", "Gupta", new Date(1981,8,18));
       ObjectMapper mapper = new ObjectMapper();

           mapper.defaultPrettyPrintingWriter().writeValue(new File("C:\\Users\\Sunil Kumar\\Desktop\\Tools and Languages" +
                   "\\Automation Installation and Training folder\\TRAINING PROJECTS\\ENTIRE JAVA CODE project" +
                   "\\entire-java-code-project\\EmployeeLokeshWrite.json"), employee);
    }

    @Test
    public void verifyJsonToJavaObj() throws IOException {

            Employee employee = null;
            ObjectMapper mapper = new ObjectMapper();
                employee =  mapper.readValue(new File("C:\\Users\\Sunil Kumar\\Desktop\\Tools and Languages" +
                        "\\Automation Installation and Training folder\\TRAINING PROJECTS\\ENTIRE JAVA CODE project" +
                        "\\entire-java-code-project\\EmployeeLokeshRead.json"), Employee.class);

            logger.debug("Employee java object extracted from EmployeeLokeshRead.json:: "+employee);
        }
}



