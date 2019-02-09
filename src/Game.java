import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Game class is responsible for initiating the game, reading the file, loading the settings, interacting with
 * the other classes, and writing to the file when the game ends.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    /**
    * [main description]
    * @param args [description]
    */
    public static void main(String[] args)  {
        Rounds rounds = new Rounds();
        int score = 0;
        FileIO fileObject = new FileIO();
        // clear screen
        System.out.print('\u000C');
        System.out.println("| ***************************************************************************************** |");
        fileObject.addToLog("| ***************************************************************************************** |");
        System.out.println("|                                 Welcome to Mastermind!                                    |");
        fileObject.addToLog("|                                 Welcome to Mastermind!                                    |");
        System.out.println("| ***************************************************************************************** |");
        fileObject.addToLog("| ***************************************************************************************** |");
        printMessage(fileObject);
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("How many rounds do you want to play?");
        fileObject.addToLog("How many rounds do you want to play?");
        
        // validate for integer
        try {
            
        }
        int numberOfRounds = input.nextInt();
        input.nextLine(); // clears buffer
        
        while(numberOfRounds>rounds.getMaxRounds())
        {
            System.out.println("Number of rounds cannot be greater than "+rounds.getMaxRounds());
            fileObject.addToLog("Number of rounds cannot be greater than "+rounds.getMaxRounds());
            System.out.println("How many rounds do you want to play?");
            fileObject.addToLog("How many rounds do you want to play?");
            numberOfRounds = input.nextInt();
            fileObject.addToLog(Integer.toString(numberOfRounds));
            input.nextLine();
        }
        
        System.out.println("Computer has generated a color grid consisting of "+fileObject.getMaxPegs()+" colors");
        fileObject.addToLog("Computer has generated a color grid consisting of "+fileObject.getMaxPegs()+" colors");
        List<String> allColors = rounds.getAllColors();
        for (int round=0; round<numberOfRounds; round++)
        {   System.out.println("Beginning round "+(round+1));
            fileObject.addToLog("Beginning round "+(round+1));
            System.out.println("Player Score "+score);
            fileObject.addToLog("Player Score "+score);
            ArrayList<String> colors = new ArrayList<String>();
            for (int peg=0; peg<fileObject.getMaxPegs(); peg++)
            {
                System.out.println("Please enter your guess for color"+(peg+1));
                fileObject.addToLog("Please enter your guess for color"+(peg+1));
                String colorInput = input.nextLine();
                colors.add(colorInput);
                
                fileObject.addToLog(colorInput);
                while (!allColors.contains(colorInput)) {
                    System.out.println("Please add color only from provided list");
                    fileObject.addToLog("Please add color only from provided list");
                    System.out.println("Please enter your guess for color"+(peg+1));
                    fileObject.addToLog("Please enter your guess for color"+(peg+1));
                    colorInput = input.nextLine();
                    colors.add(colorInput);
                    fileObject.addToLog(colorInput);
                }
            }
            ArrayList<Integer> response = rounds.getScoreAddGuess(colors);
            score += response.get(0);
            Integer allCorrect = response.get(0);
            if (allCorrect == 1) {
                //all correct
                // print and exit
                System.out.println("You Won!");
                fileObject.addToLog("You Won!");
                System.out.println("Player Score "+score);
                fileObject.addToLog("Player Score "+score);
            }
            
        }
        System.out.println("All rounds are over");
        fileObject.addToLog("All rounds are over");
        System.out.println("Player final Score "+score);
        fileObject.addToLog("Player final Score "+score);
        fileObject.writeToFile();
    }
    
    public static boolean printMessage(FileIO fileObject)
    {
        System.out.println("The game will use the colors defined in the settings file");
        System.out.println("The maximum number of colored pegs in each round is set to "+fileObject.getMaxPegs());
        System.out.print("The available colors which will be used are : ");
        List<String> allColors = fileObject.getColorsInFile();
        for (int i=0; i < allColors.size(); i++)
        {
            System.out.print(allColors.get(i)+", ");
        }
        System.out.println("Press Any Key to Continue");
        return true;
    }
}
