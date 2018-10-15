import java.util.*;
/**
 * This class stores the information regarding customer like unique ID, his ABN number, first name, last name,
 * mobile number, login ID, customer ID, password, address etc.
 * @author Sharvin
 * @version (10/10/2018 v1.0)
 */
public class Owner
{
    // instance variables - replace the example below with your own
    private String ownId;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNo;
    private String email;
    private String password;

    /**
     * Default constructor for Owner class
     */
    public Owner()
    {
        // initialise instance variables
    }

    /**
     * Parameterized Constructor for objects of owner class
     */
    public Owner(String ownId, String firstName, String lastName, String address, String phoneNo, String email, String password)
    {
        this.ownId = ownId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNo = phoneNo;
        this.email = email;
        this.password = password;
    }
    
    public void setOwnerId(String ownerId)
    {
        ownId = ownerId;
    }
    
    public void setFirstName(String fname)
    {
        firstName = fname;
    }
    
    public void setLastName(String lname)
    {
        firstName = lname;
    }
    
    public void setAddress(String add)
    {
        address = add;
    }
    
    public void setMobileNo(String mobno)
    {
        mobileNo = mobno;
    }
    
    public void setEmail(String mail)
    {
        email = mail;
    }
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    
    public String getOwnerId()
    {
        return ownId;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getMobileNo()
    {
        return mobileNo;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getPassword()
    {
        return password;
    }
}
