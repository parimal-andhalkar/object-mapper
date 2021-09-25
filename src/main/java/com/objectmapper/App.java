package com.objectmapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.objectmapper.pojo.Bike;
import com.objectmapper.pojo.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws StreamWriteException, DatabindException, IOException
    {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
                
        Car car = new Car("White","dzire");        
        mapper.writeValue(new File("car.json"), car);
        
        Bike bike = new Bike();
        bike.setColor("Red");
        bike.setModel("Hero");
        bike.setName("Moped");
        bike.setOwner("AAAAA");
        bike.setPrice(50000);        
        mapper.writeValue(new File("bike2.json"), bike);
        
        String valueAsString = mapper.writeValueAsString(car);
        System.out.println(valueAsString);
        
        Car c = mapper.readValue(new File("a.json"), Car.class);
        
        System.out.println(c);
        
        ObjectMapper mapper2 = new ObjectMapper();
        //mapper2.configure(DeserializationFeature., false)
        mapper2.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        mapper2.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, false);
        
        Bike b1 = mapper2.readValue(new File("bike1.json"), Bike.class);
        Bike b2 = mapper2.readValue(new File("bike2.json"), Bike.class);        
    }
}
