package examples;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 21/07/2017.
 */
public class CarGame {

    @Test
    public void startGame1(){
        Auto auto1 = new Auto();
        auto1.setColor("Rood");
        System.out.println("The color of the car: " + auto1.getColor());

        Auto auto2 = new Auto();
        auto2.setColor("Paars");
        System.out.println("The color of the car: " + auto2.color);

        Auto auto3 = new Auto();
        System.out.println("Torque: " + auto3.calculateTorque(10,5252));
    }
    @Test
    public void startGame2(){
        AutoAdvanced autoAdvanced1 = new AutoAdvanced("BMW");
        autoAdvanced1.printBrand();

        AutoAdvanced autoAdvanced2 = new AutoAdvanced("Audi",10,252);
        autoAdvanced2.printBrand();
        autoAdvanced2.printTorque();
        autoAdvanced2.calculateTorque(20,252);
        autoAdvanced2.printTorque();

        AutoAdvanced autoAdvanced3 = new AutoAdvanced("Toyota");
        autoAdvanced3.printBrand();
        autoAdvanced3.printTorque();
    }
}
