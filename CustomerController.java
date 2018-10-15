import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomerController
{
    // list of customers
    private ArrayList<Customer> customerList;
    /**
     * Constructor for objects of class CustomerController
     */
    public CustomerController()
    {
        customerList = new ArrayList<>();
    }
    
     /**
     * Method for add customers to the customer list including customer information
     */
    public void registerCustomer(String[] cust)
    {
        // Adding new customer object to the list
        customerList.add(new Customer(cust[0],cust[1],cust[2],cust[3],cust[4],cust[5],cust[6]));
    }

     /**
     * Method for getting the customer list
     */
    public ArrayList<Customer> getListOfCustomer()
    {
        return customerList;
    }
    
     /**
     * Method for add registered customer to database
     */
    public void writeCustomerToDatabase(String file)
    {
        try
        {
            PrintWriter output = new PrintWriter(file);
            for(Customer c : customerList)
            {
                String addFile = "";
                StringBuffer db = new StringBuffer(addFile);
                db.append(c.getCustomerId() + ",");
                db.append(c.getFirstName() + ",");
                db.append(c.getLastName() + ",");
                db.append(c.getAddress() + ",");
                db.append(c.getMobileNo() + ",");
                db.append(c.getEmail() + ",");
                db.append(c.getPassword() + ",");
                output.println(db);
            }
            output.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
     /**
     * Method for getting customer by customerid
     */
    public Customer getCustomerById(String custId)
    {
        Customer c = new Customer();
        for(Customer each : customerList)
        {
            if(each.getCustomerId().equals(custId))
            {
                c = each;
            }
        }
        return c;
    }
    
    /**
     * Method for reading customer database
     */
    public void readCustomerDatabase(String file)
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
                    customerList.add(new Customer(att[0],att[1],att[2],att[3],att[4],att[5],att[6]));
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
    
     /**
     * Method for checking whether username already exits or not during registration
     */
    public boolean validateUserName(String username)
    {
        boolean result = false;
        for(Customer c : customerList)
        {
            if(c.getCustomerId().equals(username))
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
            for(Customer c : customerList)
            {
                if(c.getCustomerId().equals(cred[0]))
                {
                    if(c.getPassword().equals(cred[1]))
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                        System.out.println("Wrong password");
                    }
                }
            }
            
        }
        else
        {
            result = false;
            System.out.println("Username is invalid");
        } 
        
        return result;
    }


     /**
     * this method is used for delete customer
     */
    public void deleteCustomerFromList(String customerName)
    {
        for (int index = 0; index < customerList.size(); index++)
        {
            if (customerName.equals(customerList.get(index).getCustomerId()))
            customerList.remove(index);
        }
    }    

    /**
     * this method is used by other two methods: updateCustomerDetails and deleteCsutomerFromList
     */
    public Customer selectCustomer(String customerName)
    {
        Customer aCustomer = new Customer();
        for (int index = 0; index < customerList.size(); index++)
        {
            if (customerName.equals(customerList.get(index).getCustomerId()))
                return customerList.get(index);
        }
        return aCustomer;
    }

     /**
     * this method is used for checking whether there is repeating customer
     */
    public boolean checkRepeatCustomer(String customerName)
    {
        boolean isRepeat = false;
        for (int index = 0; index < customerList.size(); index++)
        {
            if (customerName.equals(customerList.get(index).getCustomerId()))
                return true;
        }
        return isRepeat;
    }

    /**
     * this method is used for customer search
     */
    public ArrayList<String> searchCustomer(String customerName)
    {
        ArrayList<String> listOfCustomerName = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();
        Pattern pattern = Pattern.compile(customerName);
        for (int index = 0; index < customerList.size(); index++)
        {
            listOfCustomerName.add(customerList.get(index).getCustomerId());
        }
        
        for(int i=0; i<listOfCustomerName.size();i++){
            Matcher matcher = pattern.matcher(listOfCustomerName.get(i));
            if(matcher.find()){
                results.add(listOfCustomerName.get(i));
            }
        }
        return results;
    }
}