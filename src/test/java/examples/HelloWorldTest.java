package examples;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 19/07/2017.
 */
public class HelloWorldTest {

    @Test
    public void printText(){
        String text = "Hello world";
        System.out.println(text);
    }
}
