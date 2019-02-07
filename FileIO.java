import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;

/**
* The FileIO class will specify the attributes and 
* behaviours for reading and writing to a file.
* @author (your name)
* @version (a version number or a date)
*/
public class FileIO
{
    String inputFile = "colors.txt";
    String outputFile = "output.txt";
    ArrayList<String> Log = new ArrayList<String>();
    
    List<String> fileContents = new ArrayList<String>();
    
    /**
    * Function for reading input file
    */
    FileIO()
    {
        BufferedReader reader; 
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while ( line!= null) {
               fileContents.add(line);
               line = reader.readLine();
            }
            fileContents.add(line);
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Function returns maximum pegs as 
     * stored in settings file
     */
    public int getMaxPegs()
    {
        return Integer.parseInt(fileContents.get(0));
    }
    
    /**
     * Get colors in file
     */
    public List<String> getColorsInFile()
    {
        return fileContents.subList(1,fileContents.size()-1);
    }
    
    public boolean addToLog(String text)
    {
        Log.add(text);
        return true;
    }
    
    public boolean writeToFile()
    {
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String str : Log) {
                writer.write(str + "\n");
            }
        }
        catch (IOException e) {
            System.err.print("Something went wrong");
            return false;
        }
        return true;
    }
}
