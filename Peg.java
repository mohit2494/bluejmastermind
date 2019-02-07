/**
* The Peg class will specify the attributes and behaviours of a single coloured peg 
* which can be used within any guess sequence within the game.
* @author (your name)
* @version (a version number or a date)
*/
public class Peg
{
    // color string
    String color;  
    // color value
    int value;
    
    // set color and value
    Peg(String color, int value)
    {
        this.color = color;
        this.value = value;
    }
    
    /**
     * Function returns color
     */
    public String getColor()
    {
        return color;
    }
    /**
     * Function returns string value
     */
    public int getValue()
    {
        return value;
    }
}
