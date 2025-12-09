package services;
import models.Customer;
import java.util.ArrayList;

public class CityDiscount{
    private ArrayList<String> Cities ;   
    public double CheckCityDiscount(Customer customer){
        if(customer.getCity().equals("Paris")){
            System.out.println("Apply city discount for Paris!");
            return 0.9;
        }
        return 1;
    }
}