import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.concurrent.TimeUnit;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * This class stores the information regarding display menu, login menu, user registration, 
 * product selection,list of users and ordered items.
 * @author Team121
 * @version (15/10/2018 v6.1)
 */
public class MainMenu
{
    private String userInput;
    private Scanner console;
    private Validation validate;
    private CustomerController customerControl;
    private OwnerController ownerControl;
    private ProductController productControl;
    private String loginUserId;
    private double curShipmentPrice;

    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu()
    {
        userInput = "none";
        console = new Scanner(System.in);
        validate = new Validation();
        customerControl = new CustomerController();
        ownerControl = new OwnerController();
        productControl = new ProductController();
        customerControl.readCustomerDatabase("CustomerDB.txt");
        ownerControl.readOwnerDatabase("OwnerDB.txt");
        productControl.readProductDatabase("ProductDB.txt");
        productControl.readOrderDatabase("OrderDB.txt");
        loginUserId = "";
        curShipmentPrice = 10.5;
    }

    /**
     * A method to display the main menu
     */
    private void displayMainMenu()
    {
        clear();
        System.out.println("Welcome to the MFV Food Store");
        System.out.println("========================================================");
        System.out.println("(1) Login");
        System.out.println("(2) Register");
        System.out.println("(3) Visit our store");
        System.out.println("(4) Exit");
        System.out.print("Please select an option: ");
    }
    
    /**
     * A method to display the register menu
     */
    private void displayRegisterMenu()
    {
       clear();
       System.out.println("Please select 1 for register or 2 for back to main menu.");
       System.out.println("========================================================");
       System.out.println("(1) Register");
       System.out.println("(2) Back to Main Menu");
       System.out.print("Please select an option: ");
    }
    
    /**
     * A method to display the login menu
     */
    private void displayLoginMenu()
    {
       clear();
       System.out.println("Login Page:");
       System.out.println("========================================================");
       System.out.println("(1) I am customer");
       System.out.println("(2) I am the store owner");
       System.out.println("(3) Back to Main Menu");
       System.out.print("Please select an option: ");
    }
    
    /**
     * A method to display the owner dashboard menu
     */
    private void displayOwnerDashboard()
    {
       clear();
       System.out.println("Hi Owner, Welcome to your MFV Store");
       System.out.println("========================================================");
       System.out.println("Choose the option you wish to for administrator management");
       System.out.println("========================================================");
       System.out.println("(1) Customer Management");
       System.out.println("(2) Product Management");
       System.out.println("(3) Order Management");
       System.out.println("(4) Log out");
       System.out.print("Please select an option: ");
    }
    
     /**
     * A method to display the customer management dashboard
     */
    private void displayCustomerManagementMenu()
    {
        clear();
        System.out.println("Hi Owner, Welcome to the MFV Customer Management Dashboard!");
        System.out.println("========================================================");
        System.out.println("(1) Get list of customers");
        System.out.println("(2) Search customers");
        System.out.println("(3) Edit customer details");
        System.out.println("(4) Delete customers from database");
        System.out.println("(5) Back to Owner Dashboard");
        System.out.println("Please select an option: ");
    }
    
     /**
     * A method to display the product management dashboard
     */
    private void displayProductManagementMenu()
    {
        clear();
        System.out.println("Hi Owner, Welcome to the MFV Product Management Dashboard!");
        System.out.println("========================================================");
        System.out.println("(1) Get list of products");
        System.out.println("(2) Search products");
        System.out.println("(3) Add products");
        System.out.println("(4) Edit products details");
        System.out.println("(5) Delete products from database");
        System.out.println("(6) Back to Owner Dashboard");
        System.out.println("Please select an option: ");
    }
    
     /**
     * A method to display the order management dashboard
     */
        
    /**
     * A method to display the visitor dashboard
     */
    private void displayVisitorDashboard()
    {
        clear();
        System.out.println("Hi Guest, Welcome to the MFV Management!");
        System.out.println("========================================================");
        System.out.println("(1) Get list of products");
        System.out.println("(2) Search Products");
        System.out.println("(3) Back to Main Menu");
        System.out.println("Please select an option: ");
    }
    
     /**
     * A method to display the customer dashboard
     */
    private void displayCustomerDashboard()
    {
        clear();
        System.out.println("Hey " + loginUserId + "," + "You can choose from a range of options :)");
        System.out.println("========================================================");
        System.out.println("(1) View our product list.");
        System.out.println("(2) Search product by name");
        System.out.println("(3) View your shopping cart");
        System.out.println("(4) Checkout");
        System.out.println("(5) View your orders");
        System.out.println("(6) Log out");
        System.out.println("Please select an option: ");      
    }
    
     /**
     * A method to display the add product dashboard
     */
    private void displayCustomerPurchaseMenu()
    {
        clear();
        System.out.println("========================================================");
        System.out.println("(1) Add product to your shopping cart."); //add product should be after display
        System.out.println("(2) Back to customer Dashboard"); //add product should be after display
        System.out.println("Please select an option");        
    }    
    
         /**
     * A method to display the shopping cart dashboard
     */
    private void displayCustomerShoppingCart()
    {
        clear();
        System.out.println("========================================================");
        System.out.println("(1) Edit product in your cart.");
        System.out.println("(2) Delete product from your shopping cart"); //add product should be after display
        System.out.println("(3) Back to product menu"); //add product should be after display
        System.out.println("Please select an option");        
    }
    
     /**
     * A method to start the MFV system
     */
    public void beginMFV()
    {
        clear();
        boolean state = true;
        while (state)
        {
            displayMainMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                userLogin();
                                break;
                        case "2":
                                register();
                                break;
                        case "3":
                                visitorDashBoard();
                                break;
                        case "4":
                                customerControl.writeCustomerToDatabase("CustomerDB.txt");
                                productControl.writeProductToDatabase("ProductDB.txt");
                                productControl.writeOrderToDatabase("OrderDB.txt");
                                state = false;
                                System.out.println("Bye " + loginUserId + "! " + "Hope to see you again :)");
                                break;
                        default:
                                System.out.println("Invalid number entered");
                                break;
                    }
                }
                else
                    System.out.println("No negative numbers are acceptable.");
            }
            else
                System.out.println("Please enter numbers only.");
        }
    }
    
     /**
     * A method to for user registeration
     */
    private void register()
    {
        boolean state = true;
        while (state)
        {
            displayRegisterMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                addCustomerToDatabase();
                                break;
                        case "2":
                                // back to main menu
                                state = false;
                                break;
                        default:
                                System.out.println("Invalid number entered.");
                                break;
                    }
                }
                else
                    System.out.println("You cannot enter negative numbers are acceptable.");
            }
            else
                System.out.println("Only numeric values are acceptable.");
        }
    }
    
      /**
     * A method to for user login selection
     */
    private void userLogin()
    {
        boolean state = true;
        while (state)
        {
            displayLoginMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                customerLogin();
                                break;
                        case "2":
                                ownerLogin();
                                break;
                        case "3":
                                // back to main menu
                                state = false;
                                break;
                        default:
                                System.out.println("Invalid number entered.");
                                break;
                    }
                }
                else
                    System.out.println("Non-negative numbers are not accepted in the system");
            }
            else
                System.out.println("System accepts only numeric values");
        }
    }
    
     /**
     * A method for owner login
     */
    private void ownerLogin()
    {
        // empty array for storing owner credentials
        String[] ownerCredentials = new String[2];
        for (int i = 0; i < ownerCredentials.length; i++)
        {
            boolean state = true;
            while (state)
            {   
                System.out.println(loginText(i));
                String temp = console.nextLine();
                if (!validate.emptyStringCheck(temp))
                {
                    ownerCredentials[i] = temp;
                    state = false;
                }
                else
                    System.out.println("Area cannot be empty");
            }
        }
        if(ownerControl.validateLogin(ownerCredentials))
        {
            System.out.println("Cool! You successfully logged in to your store!");
            loginUserId = ownerCredentials[0];
            ownerDashBoard();
        }
        else
        {
            System.out.println("Sorry, login unsuccessful. Please check your username or password.");
        }
    }
    
    /**
     * A method to visitor dashboard without login
     */
    private void visitorDashBoard()
    {
        boolean state = true;
        while (state)
        {
            displayVisitorDashboard();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                //View list of products
                                getListOfProduct();
                                break;
                        case "2":
                                //Search product by name
                                searchProductByName();
                                break;
                        case "3":
                                // back to main menu
                                state = false;
                                break;
                        default:
                                System.out.println("Please insert a valid option");
                                break;
                    }
                    System.out.println("Press enter to continue..");
                    console.nextLine();
                }
                else
                    System.out.println("No negative numbers are acceptable.");
            }
            else
                System.out.println("Only numeric values are acceptable.");
        }
    }
    
     /**
     * A method to to display owner dashboard after login
     */
    private void ownerDashBoard()
    {
        boolean state = true;
        while (state)
        {
            displayOwnerDashboard();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1": //list for customer management menu
                                customerManagementMenu();
                                break;
                        case "2": //product management menu
                                productManagementMenu();
                                break;
                        case "3": //order management menu
                                orderManagementMenu();
                                break; 
                        case "4":
                                // logout back to the main menu
                                state = false;
                                break;
                        default:
                                System.out.println("Please enter one of the options.");
                                break;
                    }
                    System.out.println("Press enter to continue..");
                    console.nextLine();
                }
                else
                    System.out.println("Negative numbers are not acceptable.");
            }
            else
                System.out.println("Please enter numeric values for your selection.");
        }
    }
        
    /**
    * A method to to display owner dashboard for customer management
    */
    private void customerManagementMenu()
    {
        boolean state = true;
        while (state)
        {
            displayCustomerManagementMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1" :
                                getListOfCustomer();
                           
                                break;
                        case "2":
                                searchCustomerByName();
                                break;
                        case "3":
                                updateCustomer();
                                break; 
                        case "4":
                                deleteCustomer();
                                break;
                        case "5":
                                state = false;
                                break;
                        default:
                                System.out.println("Please enter one of the options.");
                                break;
                    }
                    //System.out.println("Press enter to continue..");
                    //console.nextLine();
                }
                else
                    System.out.println("Negative numbers are not acceptable.");
            }
            else
                System.out.println("Please enter numeric values for your selection.");
        }
    }
    
    /**
    * A method to to display owner dashboard for product management
    */
    private void productManagementMenu()
    {
        boolean state = true;
        while (state)
        {
            displayProductManagementMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                getListOfProduct();
                                break;
                        case "2":
                                searchProductByName();
                                break;
                        case "3":
                                displayCreateNewProduct();
                                break; 
                        case "4":
                                updateProduct();
                                displayUpdateProduct();
                                break;
                        case "5":
                                removeProduct();
                                break;                               
                        case "6":
                                state = false;
                                break;
                        default:
                                System.out.println("Please enter one of the options.");
                                break;
                    }
                    //System.out.println("Press enter to continue..");
                    //console.nextLine();
                }
                else
                    System.out.println("Negative numbers are not acceptable.");
            }
            else
                System.out.println("Please enter numeric values for your selection.");
        }
    }
    
    private void displayOrderManagementMenu()
    {
        displayAllOrder();
        System.out.println("Please select:");
        System.out.println("(1). Approve an order");
        System.out.println("(2). Disapprove an order");
        System.out.println("(3). Back to ");
    
    }
    
    /**
    * A method to to display owner dashboard for order management
    */
    private void orderManagementMenu()
    {
        //Methods for order management
         boolean state = true;
        while (state)
        {
            displayOrderManagementMenu();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                approveAnOrder();
                                break;
                        case "2":
                                disapproveAnOrder();
                                break;
                        case "3":
                                state = false;
                                break;                                 
                        default: 
                                System.out.println("Please enter one of the options.");
                                break;
                    }
                    System.out.println("Press enter to continue..");
                    console.nextLine();
                }
                else
                    System.out.println("Negative numbers are not acceptable.");
            }
            else
                System.out.println("Please enter numeric values for your selection.");
        }
        
        
    }
    
     /**
     * A method for customer login
     */
    private void customerLogin()
    {
        String[] customerCredentials = new String[2];
        for (int i = 0; i < customerCredentials.length; i++)
        {
            boolean state = true;
            while (state)
            {   
                System.out.println(loginText(i));
                String temp = console.nextLine();
                if (!validate.emptyStringCheck(temp))
                {
                    customerCredentials[i] = temp;
                    state = false;
                }
                else
                    System.out.println("Empty area is not acceptable.");
            }
        }
        if(customerControl.validateLogin(customerCredentials))
        {
            System.out.println("Cool! You have successfully logged in! Welcome to MFV Store!");
            System.out.println("========================================================");
            System.out.println("Lets begin shopping in Monash Fruit Vegetables!");
            loginUserId = customerCredentials[0];
            customerDashBoard();
        }
        else
        {
            System.out.println("Sorry, login unsuccessful. Please check your username or password.");
        }
    }
    
    /**
     * A method to to display login messages
     */
    private String loginText(int i)
    {
        String[] messages = {"Please enter your username: ","Please enter your password: "};
        return messages[i];
    }
    
    //A method to display shoppingCart Menu after viewing list of product 
    private void menuAfterViewProduct()
    {
        System.out.println("---------------------------------");
        System.out.println("Please select your option.");
        System.out.println("1. Add a product into my shopping cart.");
        System.out.println("2. Back.");
        System.out.println("---------------------------------");
    }
    
    //A method to process user input to menuAfterViewProduct
    private void processMenuAfterViewProduct(){
        boolean isValid = true;
        menuAfterViewProduct();
        while (isValid)
        {
            System.out.print("Your option: ");
            String userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if (validate.validateInteger(userInput))
                {
                    if (userInput.equals("1"))
                    {
                        selectProductIntoCart();
                        isValid = false;
                    }
                    else if (userInput.equals("2"))
                    {
                            customerDashBoard();
                            isValid = false;
                    }
                    else
                    System.out.println("The option should be 1 or 2.");
                }
                else
                    System.out.println("The number entered is negative.");
            }
            else
                System.out.println("The input should be number only.");
        }
        
    }

     /**
     * A method to to display customer dashboard after login
     */
    private void customerDashBoard()
    {
        boolean state = true;
        while (state)
        {
            displayCustomerDashboard();
            userInput = console.nextLine();
            if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    switch (userInput)
                    {
                        case "1":
                                //View list of products
                                getListOfProduct();
                                processMenuAfterViewProduct();                              
                                break;
                        case "2":
                                //Search product by name
                                searchProductByName();
                                break;
                        case "3":
                                printShoppingCart();//View shopping cart, then give them options to edit/delete
                                break;
                        case "4":
                                displayCheckOutConfirm();//Checkout
                                break;   
                        case "5":
                                displayOrderDetailByCustId();
                                break;                                
                        case "6":
                                //log out
                                state = false;
                                break;
                        default:
                                System.out.println("Please insert a valid option");
                                break;
                    }
                }
                else
                    System.out.println("No negative numbers are acceptable.");
            }
            else
                System.out.println("Only numeric values are acceptable.");
        }
    } 
    
    /**
     * A method to to display customer register page
     */
    private String customerRegisterPopup(int i)
    {
        String[] messages = {"To register in MFV System, Please enter your username: ",
        "Please enter your first name: ",
        "Please enter your last name: ",
        "Please enter your address: ",
        "Please enter your mobile number: ",
        "Please enter your email address: ",
        "Please enter your password: "};
        return messages[i];
    }

    /**
     * A method to to add customer to the system
     */
    private void addCustomerToDatabase()
    {
        //an empty temporary array for storing user attributes
        String[] customerAttributes = new String[7];
        for (int i = 0; i < customerAttributes.length; i++)
        {
            boolean state = true;
            while (state)
            {   
                System.out.println(customerRegisterPopup(i));
                String temp = console.nextLine();
                if (customerValidation(temp,i))
                {
                    customerAttributes[i] = temp;
                    state = false;
                }
                else
                    System.out.println("Invalid input entered!!!");
            }
        }
        customerControl.registerCustomer(customerAttributes);
        System.out.println("========================================================");
        System.out.println("Congratulations! Registration successful. Please select 2 back to the menu.");
    }
    
     /**
     * A method for checking customer credential validations
     */
    private boolean customerValidation(String val, int i)
    {
        boolean result = true;
        if(i == 0)
        {
            if(!validate.emptyStringCheck(val))
            {
                if(!customerControl.validateUserName(val))
                {
                    result = true;
                }
                else
                {
                    System.out.println("User Information already exists in our system.");
                    result = false;
                }
            }
            else
            {
                System.out.println("Empty space is not allowed for this area.");
                result = false;
            }
        }
        else if(i == 4)
        {
             if(!validate.emptyStringCheck(val))
            {
                if(val.length() == 10)
                {
                    if(validate.stringNumeric(val))
                    {
                        result = true;
                    }
                    else
                    {
                        System.out.println("Phone number should only include numbers");
                        result = false;
                    }
                }
                else
                {
                    System.out.println("Phone number should contain only 10 digits!!!");
                    result = false;
                }
                
            }
            else
            {
                System.out.println("Please don't leave the space blank");
                result = false;
            }
        }
        else if(i == 6)
        {
             if(!validate.emptyStringCheck(val))
            {
                if(val.length() < 8)
                {
                    System.out.println("Password should at least contain only 8 digits!!!");
                    result = false;
                }
            }
        }       
        else if(i == 5) 
        {
            if(!validate.emptyStringCheck(val))
            {
                if(val.contains("@"))
                {
                    result = true;
                }
                else 
                {
                    System.out.println("Email should have one @ character!!");
                    result = false;
                }
            }
        }              
        else
        {
            if(!validate.emptyStringCheck(val))
            {
                result = true;
            }
            else
            {
                System.out.println("Empty space is not allowed!");
                result = false;
            }
        }
        return result;
    }
    
     /**
     * A method to clear console
     */
    private void clear() 
    {
        System.out.print('\u000C');
    }

    private void getListOfCustomer()
    {
        clear();
        if (customerControl.getListOfCustomer().size() == 0) 
        {
            System.out.println("There is no customer in the list.");
        }
        else
        {
            for (int index = 0; index < customerControl.getListOfCustomer().size(); index++)
            {
                displayCustomerInfo(index);
            }
        }
        pressContinue();
    }

    private void deleteCustomer()
    {
        //display all customers
        getListOfCustomer();
        boolean state = true;
        
        while(state)
        {
            System.out.println("Please enter the customerid to remove (enter q to cancel)");
            String userInput = console.nextLine();
            if(!validate.emptyStringCheck(userInput))
            {
                if(customerControl.checkRepeatCustomer(userInput))
                {
                    customerControl.deleteCustomerFromList(userInput);
                    System.out.println("The customer " + userInput + " has been deleted.");
                    state = false;
                }
                else
                {
                    if(userInput.equals("q")){
                        break;
                    }else{
                        System.out.println("The customer you type does not exist.");
                    }
                }
            }
            else
            {
                System.out.println("Input cannot be left empty.");
            }
        }
    }

    private void searchCustomerByName()
    {
        boolean state = true;
        
        while(state)
        {
            System.out.println("Please enter the customer name to search (enter q to cancel)");
            String userInput = console.nextLine();
            if (!validate.emptyStringCheck(userInput)){   
                    if(userInput.equals("q")){
                        break;
                    }else{
                        ArrayList<String> results = customerControl.searchCustomer(userInput);
                        if(results.isEmpty()){
                        }else{
                            System.out.println("Here are the search results:");
                            for(String each : results){
                                displayCustomerDetailByName(each);
                            }
                        }
                    }
                }
            else
                System.out.println("Input cannot be left empty.");
            
        }
    }

    private void displayCustomerDetailByName(String customerName)
    {
        customerControl.selectCustomer(customerName);
        System.out.println("--------------------------------------------------");
        System.out.println("Username: " + customerControl.selectCustomer(customerName).getCustomerId());
        System.out.println("Name: " + customerControl.selectCustomer(customerName).getFirstName() + " " + customerControl.selectCustomer(customerName).getLastName());
        System.out.println("Address: " + customerControl.selectCustomer(customerName).getAddress());
        System.out.println("Mobile No: " + customerControl.selectCustomer(customerName).getMobileNo());
        System.out.println("Email: " + customerControl.selectCustomer(customerName).getEmail());
        System.out.println("Password: " + customerControl.selectCustomer(customerName).getPassword());       
    }

    private void updateCustomer()
    {
        //owner shouuld be able to edit customers
        //display all customers
        getListOfCustomer();
        boolean state = true;
        while(state){
            System.out.println("Please enter the customer name to update (enter q to cancel)");
            String userInput = console.nextLine();
            if(!validate.emptyStringCheck(userInput)){
                if(customerControl.checkRepeatCustomer(userInput)){
                    customerControl.deleteCustomerFromList(userInput);
                    displayUpdateCustomer();
                    state = false;
                }else{
                    if(userInput.equals("q") || userInput.equals("Q"))
                    {
                        break;
                    }else{
                        System.out.println("The customer you type does not exist.");
                    }
                }
            }else{
                System.out.println("Input cannot be left empty.");
            }
        }
    }

    private void displayUpdateCustomer()
    {
        Scanner userInputs = new Scanner(System.in);
        String[] tempString = new String[7];
        
        System.out.println("Please enter a new customer information.");
        System.out.println();
        for (int index = 0; index < 7; index++)
        {
            boolean isNext = false;
            System.out.println(customerRegisterPopup(index));
            while (!isNext)
            {
                String aInput = userInputs.nextLine();
                if (customerValidation(aInput, index))
                {
                    tempString[index] = aInput;
                    isNext = true;
                }
            }
        }
        customerControl.registerCustomer(tempString);
    }

    private void displayCustomerInfo(int index)
    {
        System.out.println("---------------------------------------");
        System.out.println("Username: " + customerControl.getListOfCustomer().get(index).getCustomerId());
        System.out.println("Name: " + customerControl.getListOfCustomer().get(index).getFirstName() + " " + customerControl.getListOfCustomer().get(index).getLastName());
        System.out.println("Address: " + customerControl.getListOfCustomer().get(index).getAddress());
        System.out.println("Mobile No: " + customerControl.getListOfCustomer().get(index).getMobileNo());
        System.out.println("Email: " + customerControl.getListOfCustomer().get(index).getEmail());
        System.out.println("Password: " + customerControl.getListOfCustomer().get(index).getPassword()); 
    }
    
    private void getListOfProduct()
    {
        if (productControl.getListOfProduct().size() == 0)
            System.out.println("There is no product in the list.");
        else
        {
            for (int index = 0; index < productControl.getListOfProduct().size(); index++)
            {
                displayProductInfo(index);
            }
        }
        pressContinue();
    }
    
    private void displayProductInfo(int index)
    {
        System.out.println("====================================================");
        System.out.println("Name: " + productControl.getListOfProduct().get(index).getProductName());
        System.out.println("Description: " + productControl.getListOfProduct().get(index).getProductDesc());
        System.out.println("Type: " + productControl.getListOfProduct().get(index).getProductType());
        System.out.println("Source: " + productControl.getListOfProduct().get(index).getProductSource());
        System.out.println("Price: " + productControl.getListOfProduct().get(index).getProductUnitPrice());
        System.out.println("Selling in: " + productControl.getListOfProduct().get(index).getPackageType());
        System.out.println("Promotion:" + productControl.getListOfProduct().get(index).getPromotionDiscount());
        if (loginUserId.equals("owner"))
        {
            System.out.println("Unit cost: " + productControl.getListOfProduct().get(index).getProductUnitCost());
            System.out.println("Exipry date: " + productControl.getListOfProduct().get(index).getExpiryDate());
            System.out.println("Inventory: " + productControl.getListOfProduct().get(index).getQty());
        }
        System.out.println("====================================================");
    }
    
    private void displayCreateNewProduct()
    {
        Scanner userInputs = new Scanner(System.in);
        String[] tempString = new String[10];
        
        System.out.println("Please enter a new product.");
        System.out.println();
        for (int index = 0; index < 10; index++)
        {
            boolean isNext = false;
            System.out.println(askForProductInfo(index));
            while (!isNext)
            {
                String aInput = userInputs.nextLine();
                if (productValidation(aInput, index))
                {
                    tempString[index] = aInput;
                    isNext = true;
                }
                else
                    System.out.println("Please re-enter.");
            }
        }
        productControl.createANewProduct(tempString);
        System.out.println("The product has been created successfully.");
    }
    
    private String askForProductInfo(int i)
    {
        String[] messages = {"Please enter the new product name ",
        "Please describe the new product ",
        "Please describe the product type (veggie/fruit) ",
        "Please enter the product source: ",
        "Please enter the product unit cost: ",
        "Please enter the product selling price: ",
        "Please set the expiry date (dd-mm-yyyy) ",
        "Please put the stock numbers ",
        "Please enter product packaged type ",
        "Please enter the promotion discount (if not, just enter 0) "};
        
        return messages[i];
    }
    
    private boolean productValidation(String aString, int index)
    {
        boolean isValid = true;
        if (!validate.emptyStringCheck(aString))
        {
            switch (index) {
            case 0: 
            if (!productControl.checkRepeatProduct(aString))
                isValid = true;
            else
            {
                System.out.println("Product already exists in the system.");
                isValid = false;
            }
            break;
            case 1: 
                System.out.println("The product description added successfully.");
                isValid = true;
            break;
            case 2:
            if (aString.equals("veggie") || aString.equals("fruit"))
            {    
                System.out.println("The product type entered successfully.");
                isValid = true;
            }
            else
            {
                System.out.println("Please enter veggie/fruit.");
                isValid = false;
            }
            break;
            case 3:
                System.out.println("The product source entered successfully.");
                isValid = true;
            break;
            case 4://productunitcost enter negative number might work....
            if (validate.containDot(aString) <= 1 && validate.stringNumeric(aString.replaceAll("\\.","")))
            {    
                System.out.println("The unit cost entered successfully.");
                isValid = true;
            }
            else
            {
                System.out.println("Please enter a numberical amount, up to 2 decimal places.");
                isValid = false;
            }
            break;
            case 5:
            if (validate.containDot(aString) <= 1 && validate.stringNumeric(aString.replaceAll("\\.","")))
            {    
                System.out.println("The unit price entered successfully.");
                isValid = true;
            }
            else
            {
                System.out.println("Please enter a numberical amount, up to 2 decimal places.");
                isValid = false;
            }
            break;
            case 6: 
            if (validate.isValidDate(aString))
            {
                System.out.println("The expiry date entered is successful.");
                isValid = true;
            }
            else
            {
                System.out.println("The date input is incorrect, please re-enter (dd-mm-yyyy).");
                isValid = false;
            }
            break;
            case 7: 
            if (validate.stringNumeric(aString) && validate.validateInteger(aString))
            {
                System.out.println("The quantity for product is entered.");
                isValid = true;
            }
            else
            {
                System.out.println("Please enter positive number only.");
                isValid = false;
            }
            break;
            case 8: //packagetype
            System.out.println("The product package type added successfully.");
            isValid = true;
            break;
            case 9: //promotiondiscount
            if (validate.containDot(aString) <= 1 && validate.stringNumeric(aString.replaceAll(".","")) && Double.valueOf(aString) < 1 && Double.valueOf(aString) >= 0)
            {    
                System.out.println("The discount entered successfully.");
                isValid = true;
            }
            else
            {
                System.out.println("Please enter a numberical amount, up to 2 decimal places.");
                isValid = false;
            }
            break;
            default: 
            System.out.println("There is some wrong existing, please retry later.");
            isValid = false;
            break;
            }
        }
        else
        {
            System.out.println("The information enterred can not be empty.");
            isValid = false;
        }
        return isValid;
    }

    private void updateProduct()
    {
        //admin shouuld be able to edit products
        //display all products
        getListOfProduct();
        boolean state = true;
        while(state){
            System.out.println("Please enter the product name to update (enter q to cancel)");
            String userInput = console.nextLine();
            if(!validate.emptyStringCheck(userInput)){
                if(productControl.checkRepeatProduct(userInput)){
                    productControl.deleteProductFromList(userInput);
                    displayUpdateProduct();
                    state = false;
                }else{
                    if(userInput.toLowerCase().equals("q"))
                    {
                        break;
                    }else{
                        System.out.println("The product you type does not exist.");
                    }
                }
            }else{
                System.out.println("Input cannot be left empty.");
            }
        }
    }
    
    private void displayUpdateProduct()
    {
        Scanner userInputs = new Scanner(System.in);
        String[] tempString = new String[10];
        
        System.out.println("Please enter a new product information.");
        System.out.println();
        for (int index = 0; index < 10; index++)
        {
            boolean isNext = false;
            System.out.println(askForProductInfo(index));
            while (!isNext)
            {
                String aInput = userInputs.nextLine();
                if (productValidation(aInput, index))
                {
                    tempString[index] = aInput;
                    isNext = true;
                }
            }
        }
        productControl.createANewProduct(tempString);
    }
    
    private void removeProduct()
    {
        //display all products
        getListOfProduct();
        boolean state = true;
        
        while(state)
        {
            System.out.println("Please enter the product name to remove (enter q to cancel)");
            String userInput = console.nextLine();
            if(!validate.emptyStringCheck(userInput)){
                if(productControl.checkRepeatProduct(userInput)){
                    productControl.deleteProductFromList(userInput);
                    System.out.println("The product " + userInput + " has been deleted.");
                    state = false;
                }else{
                    if(userInput.toLowerCase().equals("q")){
                        break;
                    }else{
                        System.out.println("The product you type does not exist.");
                    }
                }
            }else{
                System.out.println("Input cannot be left empty.");
            }
        }
    }
    
    private void searchProductByName()
    {
        boolean state = true;
        
        while(state)
        {
            System.out.println("Please enter the product name to search (enter q to cancel)");
            String userInput = console.nextLine();
            if (!validate.emptyStringCheck(userInput)){   
                    if(userInput.toLowerCase().equals("q")){
                        break;
                    }else{
                        ArrayList<String> results = productControl.searchProduct(userInput);
                        if(results.isEmpty()){
                        }else{
                            System.out.println("Here are the search results:");
                            for(String each : results){
                                displayProductDetailByName(each);
                            }
                        }
                    }
                }
            else
                System.out.println("Input cannot be left empty.");
            
        }
    }
    
    private void displayProductDetailByName(String productName)
    {
        productControl.selectProduct(productName);
        ArrayList<String> productDetail = productControl.createProductDetailByName(productName);
        for(String each : productDetail){
            System.out.println(each);
        }
    }
    
    private void selectProductIntoCart()
    {
        int index = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.println("Please enter the product name to select (enter q to cancel)");
            String productName = console.nextLine();
            if (!validate.emptyStringCheck(productName))
            {   
                if (productName.toLowerCase().equals("q"))
                    break;
                else if (productControl.checkRepeatProduct(productName))
                {
                    System.out.println("Please enter the quantity for " + productName);
                    String quantity = console.nextLine();
                    if (validate.stringNumeric(quantity) && validate.validateInteger(quantity)) //two validations are nearly same
                    {
                        if (productControl.insertToCart(productName, productControl.convertString(quantity)))
                        {
                            System.out.println("The product is added successfully.");
                            isValid = true;
                        }
                        else
                            System.out.println("The quantity is over limit.");
                    }
                    else
                        System.out.println("Quantity is incorrect. ");
                }
                else
                    System.out.println(productName + " is incorrect or is not in the system. ");
            }
            else
                System.out.println("Input cannot be left empty.");
        }
    }
    
    private void printShoppingCart()
    {
        if (!productControl.getACart().getShoppingCart().isEmpty()) 
        {
            for (int index = 0; index < productControl.setShoppingCart().size() ; index ++)
            {
                String[] temp = new String [3];
                temp = productControl.setShoppingCart().get(index);
                System.out.println("Product Name: " + temp[0]);
                System.out.println("Quantity " + temp[1]);
                System.out.println("Subtotal: $" + temp[2]);
            }
            System.out.println("Total: $" + productControl.getACart().calculateTotal());
            displayEditProductFromCart();
        }
        else
        {
            System.out.println("Your shopping cart is empty.");
            pressContinue();
        }
    }
    
    private void pressContinue()
    {
        System.out.println("Please press enter to continue..");
        console.nextLine();
    }
    
    /**
     * my new codes
     **/
       
    private String getSysTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
        "HH:mm:ss"
        );
        Date date = new Date();
        return (formatter.format(date));
        
    }
    
    private String getSysDate(){
        SimpleDateFormat formatter = new SimpleDateFormat(
        "dd/MM/yyyy"
        );
        Date date = new Date();
        return (formatter.format(date));
    }

    private void displayCheckOutConfirm()
    {
        System.out.println("#################################");
        System.out.println("Please enter 'y' to confirm or 'n' to cancel checkout (y/n)");
        System.out.println("#################################");
        System.out.println();
        String userInput = console.nextLine();
        boolean state = true;
        while(state)
        {
            if (!validate.emptyStringCheck(userInput))
            {   
                if (userInput.equals("n") ||  userInput.equals("N"))
                    {
                        state = false;
                     }
                else if(userInput.equals("y") ||  userInput.equals("Y"))
                {
                    String [] orderInfo = {
                    getSysDate()+getSysTime()+loginUserId,
                    loginUserId,
                    Double.toString(curShipmentPrice),
                    getSysDate(),
                    Double.toString(productControl.getACart().getCartTotal()),
                    productControl.generateCartDetail(productControl.getACart().getShoppingCart())
                    };
                    productControl.createANewOrder(orderInfo,productControl.getACart().getShoppingCart());
                    state = false;
                    System.out.println("Order is successfully created.");
                }
                pressContinue();
            }
        }   
    }
    
    private void displayOrderDetailByCustId(){
        if(productControl.checkOrderByCustId(loginUserId))
        {
            System.out.println("Here is your order history:"); 
            for(int i=0; i<productControl.selectOrdersByCustId(loginUserId).size();i++){
                System.out.println("--------------------------------------");
                //System.out.println(productControl.selectOrdersByCustId(loginUserId).get(i).getOrderItemDetails());
                System.out.println("Order No. "+ (i+1) );
                System.out.println("Order Id: "+ (productControl.selectOrdersByCustId(loginUserId)).get(i).getOrderID());
                System.out.println("Order Status: "+ (productControl.selectOrdersByCustId(loginUserId)).get(i).getOrderStatus());
                System.out.println("Order Shipment Price "+ (productControl.selectOrdersByCustId(loginUserId)).get(i).getShipmentPrice());
                System.out.println("Order Date "+ (productControl.selectOrdersByCustId(loginUserId)).get(i).getOrderDate());
                System.out.println("Order Total Price "+ (productControl.selectOrdersByCustId(loginUserId)).get(i).getTotalPrice());
                System.out.println("Order items are:");
                ArrayList<String> cartItemDetails = productControl.decodeCartDetail((productControl.selectOrdersByCustId(loginUserId)).get(i).getOrderItemDetails());
                for (String cartItemDetail: cartItemDetails){
                ArrayList<String> productAttributes = productControl.decodeProductDetail(cartItemDetail);
                for(String productAttributeDesc : productAttributes){
                    System.out.println(productAttributeDesc);
                }
                
            }

        }
        }
        else
        {
            System.out.println("You have not made any order.");
        }
        pressContinue();
    }
    
    private void displayAllOrder(){
        clear();
        System.out.println("Here are all orders:");
            for(int i=0; i<productControl.getOrderList().size();i++)
            {
                System.out.println("--------------------------------------");
                System.out.println("Order No. "+ (i+1) );
                System.out.println("Order Id: "+ (productControl.getOrderByIndex(i)).getOrderID());
                System.out.println("Order Status: "+ (productControl.getOrderByIndex(i)).getOrderStatus());
                System.out.println("Order Shipment Price "+ (productControl.getOrderByIndex(i)).getShipmentPrice());
                System.out.println("Order Date "+ (productControl.getOrderByIndex(i)).getOrderDate());
                System.out.println("Order Total Price "+ (productControl.getOrderByIndex(i)).getTotalPrice());
                System.out.println("Order items are:");
                ArrayList<String> cartItemDetails = productControl.decodeCartDetail((productControl.getOrderByIndex(i)).getOrderItemDetails());
                for (String cartItemDetail: cartItemDetails){
                ArrayList<String> productAttributes = productControl.decodeProductDetail(cartItemDetail);
                for(String productAttributeDesc : productAttributes){
                    System.out.println(productAttributeDesc);
                }
            }
        }
    }
    
    private void approveAnOrder()
    {
        int maxSelectNumber = productControl.getOrderList().size();
        System.out.println("Please enter the order number to approve it");
        String userInput = console.nextLine();
        if (validate.stringNumeric(userInput))
        {
            if(validate.validateInteger(userInput))
            {
                if(productControl.convertString(userInput) <= maxSelectNumber)
                {
                    int index = productControl.convertString(userInput);
                    productControl.approveOrderByOrderNum(index);
                }
                else
                {
                    System.out.println("Invalid selection");
                }
                }
            else
                System.out.println("No negative numbers are acceptable.");
        }
        else
            System.out.println("Please enter numbers only.");
        }
        
    private void disapproveAnOrder()
    {
        int maxSelectNumber = productControl.getOrderList().size();
        System.out.println("Please enter the order number to disapprove it");
        String userInput = console.nextLine();
        if (validate.stringNumeric(userInput))
            {
                if(validate.validateInteger(userInput))
                {
                    if(productControl.convertString(userInput) <= maxSelectNumber){
                        int index = productControl.convertString(userInput);
                    productControl.disapproveOrderByOrderNum(index);
                    }else{
                        System.out.println("Invalid selection");
                    }
                }
                else
                    System.out.println("No negative numbers are acceptable.");
            }
            else
                System.out.println("Please enter numbers only.");
        }
    
    /**
     *  BUG here
     */
    private void displayEditProductFromCart()
    {
        int index = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.println("Please enter the product name to select (enter q to cancel)");
            String productName = console.nextLine();
            if (!validate.emptyStringCheck(productName))
            {
                if (productName.toLowerCase().equals("q"))
                    break;
                else if (productControl.getACart().isExist(productControl.selectProduct(productName)))
                {
                    boolean isContinue = true;
                    System.out.println("Please select an option:");
                    System.out.println("(1) Edit quantity for " + productName);
                    System.out.println("(2) Delete " + productName + " from your cart.");
                    System.out.println("(3) Back to menu");
                    String option = console.nextLine();
                    while (isContinue)
                    {
                        if (option.equals("1"))
                        {
                            System.out.println("Please enter the quantity for " + productName);
                            String quantity = console.nextLine();
                            if (validate.stringNumeric(quantity) && validate.validateInteger(quantity)) //two validations are nearly same
                            {
                                if (productControl.insertToCart(productName, productControl.convertString(quantity))) //BUG
                                {
                                    System.out.println("The quantity of " + productName + " changed successfully.");
                                    isValid = true;
                                    isContinue = false;
                                    pressContinue();
                                }
                                else
                                    System.out.println("The quantity is over limit.");
                            }
                            else
                                System.out.println("Quantity is incorrect. ");
                        }
                        else if (option.equals("2"))
                        {
                            productControl.deleteProductFromCart(productControl.selectProduct(productName));
                            System.out.println(productName + " is deleted from your cart.");
                            pressContinue();
                            isValid = true;
                            isContinue = false;
                            pressContinue();
                        }
                        else if (option.equals("3"))
                        {
                            isValid = true;
                            isContinue = false;
                        }
                        else
                            System.out.println("Your selection is incorrect, please enter the numbers given above.");
                    }
                }
                else
                    System.out.println(productName + " is not in your cart, please enter product name or press q to quit.");
            }
            else
                System.out.println("Input can't be empty");
        }
        
    }
        

}