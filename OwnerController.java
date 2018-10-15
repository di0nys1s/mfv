import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class OwnerController
{
    // instance variables - replace the example below with your own
    private ArrayList<Owner> ownerList;
    /**
     * Constructor for objects of class Controller
     */
    public OwnerController()
    {
        // initialise instance variables
        ownerList = new ArrayList<>();
    }
    
     /**
     * Method for checking whether username already exits or not during registration
     */
    public boolean validateUserName(String userName)
    {
        boolean result = false;
        for(Owner o : ownerList)
        {
            if(o.getOwnerId().equals(userName))
            {
                result = true;
            }
        }
        
        return result;
    }
    
     /**
     * Method for login valdation
     */
    public boolean validateLogin(String[] cred)
    {
        boolean result = true;
        if(validateUserName(cred[0]))
        {
            for(Owner o : ownerList)
            {
                if(o.getOwnerId().equals(cred[0]))
                {
                    if(o.getPassword().equals(cred[1]))
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                        System.out.println("Password is not correct.");
                    }
                }
            }
            
        }
        else
        {
            result = false;
            System.out.println("Username is not correct.");
        } 
        
        return result;
    }

    
    /**
     * Method for getting owner
     */
    public Owner getOwnerById(String ownId)
    {
        Owner o = new Owner();
        for(Owner each : ownerList)
        {
            if(each.getOwnerId().equals(ownId))
            {
                o = each;
            }
        }
        return o;
    }
    
    
    /**
     * Method for reading owner database
     */
    public void readOwnerDatabase(String file)
    {
        try
        {
            FileReader inputFile = new FileReader(file);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String line = parser.nextLine();
                    String[] att = line.split(",");
                    ownerList.add(new Owner(att[0],att[1],att[2],att[3],att[4],att[5],att[6]));
                }             
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(file + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured.");
        }
    }
}