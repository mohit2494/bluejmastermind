import java.util.ArrayList;
import java.util.List;
/**
* The ColorGrid class will specify the attributes and behaviours 
* of all coloured peg sequences within the game.
* @author (your name)
* @version (a version number or a date)
*/
public class ColorGrid
{
   ArrayList<Peg> pegs;
   int noOfPegs;
  
    /**
    * Constructor
    */
    ColorGrid(int noOfPegs)
    {
        this.noOfPegs = noOfPegs;
        pegs = new ArrayList<Peg>();
    }
    
    /**
    * function returns number of pegs
    */
    public int getNumberOfPegs()
    {
       return noOfPegs;
    }
    
    /**
     * Function returns pegs
     */
    public ArrayList<Peg> getPegs()
    {
        return pegs;
    }   
    
    public boolean addPeg(Peg peg)
    {
        pegs.add(peg);
        return true;
    }
    
    /**
     * Function creates color grids
     */
    public boolean createColorGrid(List<String> colors)
    {
        RNG random = new RNG(colors.size()-1);
        for (int i=0; i<noOfPegs; i++)
        {
            // get random values for scores
            Peg peg = new Peg(colors.get(i),random.generateRandomNumber());
            pegs.add(peg);
        }
        return true;
    }    
}
