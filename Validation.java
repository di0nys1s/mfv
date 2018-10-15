import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The Validation class includes necessary validation 
 * methods for the system. It provides 
 * all the methods required  to create particular validation methods.
 */

public class Validation
{
     /**
     * Empty constructor for the validation class
     */
    public Validation()
    {
        
    }
    
    /**
     * Method for checking whether the length of the String is 
     * equal to the value of integer.
     */
    public boolean checkStringLen(String aString, int aInt)
    {
        if (aString.length() == aInt)
            return true;
        else
            return false;
    }
    
    /**
     * Method for checking the input is empty or only whitespaces or not.
     * 
     */
    public boolean emptyStringCheck(String input)
    {
        String inputWithoutWhiteSpaces = input.replaceAll("\\s","");
        if (inputWithoutWhiteSpaces.length() == 0)
            return true;
        else
            return false;
    }

    /**
     * This method is used to check whether the date is validated.
     */
    public boolean isValidDate(String inDate) 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    
    /**
     * Method for validating that a string only has space and letters
     */
    public boolean letterAndSpaceCheck(String aString)
    {
        boolean state = true;
        for (char aChar : aString.toCharArray())
        {
            if (Character.isLetter(aChar) || aChar == ' ')
            {
                continue;
            }
            state = false;
            break;
        }
        return state;
    }
       
    public boolean stringNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public int containDot(String aString)
    {
        int noDot = 0;   
        for (int index = 0; index < aString.length(); index++)
        {
            if(aString.charAt(index) == '.')
                noDot++;
        }
        return noDot; 
    }
    
    /**
     * Checks whether the input is negative value
     */
    public boolean validateInteger(String aString)
    {   
        int num = 0;
        if (!emptyStringCheck(aString))
            num = Integer.parseInt(aString);
        if (num <= 0)
            return false;
        else
            return true;
    }  
    
    /**
     * Checking whether the input only has numbers and letters.
     */
    public boolean validateString(String aString)
    {   
        boolean state = true;
        for (char aChar : aString.toCharArray())
        {
            if (!Character.isLetterOrDigit(aChar))
            {
                state = false;
                break;
            }
        }
        return state;
    }
}
