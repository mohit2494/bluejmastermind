import java.util.Random;
/**
* The RNG class will specify the attributes and behaviours of generating 
* random numbers which will be used by the Game class.
* @author (your name)
* @version (a version number or a date)
*/
public class RNG
{
    // we already know the minimum value to be 1
    int minimumValue = 1;
    int maximumValue;
    
    /**
     * Class constructor
     */
    RNG(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
    
    /**
     * Function for generating a random number b/w
     * minimumValue and maximumValue
     */
    public int generateRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(maximumValue + 1 - minimumValue) + minimumValue;
    }
}
