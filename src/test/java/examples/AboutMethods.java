package examples;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 19/07/2017.
 */
public class AboutMethods {

    @Test
    public void printProducts(){
        System.out.println(multiply(5.1,3));
    }

    private double multiply(double a, double b){
        double result = a * b;
        return result;
    }
}
