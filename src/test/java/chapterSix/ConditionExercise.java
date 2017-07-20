package chapterSix;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 20/07/2017.
 */
public class ConditionExercise {

    public void bootcampAgeChecker(int[] leeftijd)
    {
        for (int i = 0; i < leeftijd.length; i++)
        {
            if(leeftijd[i]>=65)
                System.out.println("Leeftijd = "+leeftijd[i]+ " : Check manager");
            else {
                if (leeftijd[i]>=21)
                    System.out.println("Leeftijd = "+leeftijd[i]+ " : Toegelaten");
                else
                    System.out.println("Leeftijd = "+leeftijd[i]+ " : Te jong");
            }
        }
    }
    @Test
    public void checkAge(){
        int[] leeftijd = {12,21,64,65};
        bootcampAgeChecker(leeftijd);
    }
}
