package services;

public class CityDiscount{
    private Cities<String>;  
    public double CheckCityDiscount(Customer customer){
        if(customer.getCity().equals("Paris")){
            System.out.println("Apply city discount for Paris!");
            return 0.9;
        }
        return 1;
    }
}