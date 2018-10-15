import java.util.*;

/**
 * This class stores the information regarding customer like customer first name, last name,
 * mobile number, login ID, customer ID, password, address and status of his ordered items.
 *
 * @author Sharvin
 * @version (10/10/2018 v1.0)
 */
public class Customer
{
    // instance variables for customer class
    private String custId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;
    private String password;

    /**
     * Default Constructor for objects of class Customer
     */
    public Customer()
    {
        // default constructor
    }

    /**
     * Parameterized Constructor for objects of customer class
     */
    public Customer(String custId, String firstName, String lastName, String address, String phoneNo, String email, String password)
    {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }
    
    public void setCustomerId(String customerId)
    {
        custId = customerId;
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
        phoneNo = mobno;
    }
    
    public void setEmail(String mail)
    {
        email = mail;
    }
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    
    public String getCustomerId()
    {
        return custId;
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
        return phoneNo;
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

