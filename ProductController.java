import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.lang.*;

/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductController
{
    // instance variables - replace the example below with your own
    private ArrayList<Product> listOfProduct;
    private ArrayList<Order> listOfOrder;
    private ShoppingCart aCart;
    
    /**
     * Constructor for objects of class Controller
     */
    public ProductController()
    {
        listOfProduct = new ArrayList<Product>();
        listOfOrder = new ArrayList<Order>();
        aCart = new ShoppingCart();
    }
    
    public ArrayList<Product> getListOfProduct()
    {
        return listOfProduct;
    }
    
    public ShoppingCart getACart()
    {
        return aCart;
    }
          
    public void deleteProductFromList(String productName)
    {
        for (int index = 0; index < listOfProduct.size(); index++)
        {
            if (productName.equals(listOfProduct.get(index).getProductName()))
            listOfProduct.remove(index);
        }
    }
    
    /**
     * to invoke updateProductDetails, proudctToUpdate should be the same object as the return result from the method "selectProduct"
     * updatedProduct is a temp product object that is for storing the information of product to be updated
     * the boundary class, the information of updatedProduct should be asked for from the user's input.
       */
    public void updateProductDetails(Product updatedProduct, Product productToUpdate)
    {
      productToUpdate.setProductName(updatedProduct.getProductName());
      productToUpdate.setProductDesc(updatedProduct.getProductDesc());
      productToUpdate.setProductType(updatedProduct.getProductType());
      productToUpdate.setProductSource(updatedProduct.getProductSource());
      productToUpdate.setProductUnitCost(updatedProduct.getProductUnitCost());
      productToUpdate.setProductUnitPrice(updatedProduct.getProductUnitPrice());
      productToUpdate.setExpiryDate(updatedProduct.getExpiryDate());
      productToUpdate.setQty(updatedProduct.getQty());
      productToUpdate.setPackageType(updatedProduct.getPackageType());
      productToUpdate.setPromotionDiscount(updatedProduct.getPromotionDiscount());
    }
    
    /**
     * public void searchProductInListByName(String productName)
    */
    
    public void addProductToList(Product aProduct){
       listOfProduct.add(aProduct);
    }
    
    /**
     * 
     */
    public void createANewProduct(String[] attributes) /*String productName, 
    String productDesc, 
    String productType, 
    String productSource, 
    double productUnitCost, 
    double productUnitPrice, 
    String expiryDate, 
    int qty, 
    String packageType, 
    double promotionDiscount*/
    {
        Product newProduct = new Product();
        
        newProduct.setProductName(attributes[0].toString());
        newProduct.setProductDesc(attributes[1].toString());
        newProduct.setProductType(attributes[2].toString());
        newProduct.setProductSource(attributes[3].toString());
        newProduct.setProductUnitCost(stringToDouble(attributes[4]));
        newProduct.setProductUnitPrice(stringToDouble(attributes[5]));
        newProduct.setExpiryDate(attributes[6].toString());
        newProduct.setQty(convertString(attributes[7]));
        newProduct.setPackageType(attributes[8].toString());
        newProduct.setPromotionDiscount(stringToDouble(attributes[9]));
        
        addProductToList(newProduct);
        
        
    }
    
    public double stringToDouble(String aString)
    {
        return Double.valueOf(aString.toString());
    }
    
    public int convertString(String aString)
    {
       int aNumber = Integer.parseInt(aString);
       return aNumber;
    }
    
    public void readProductDatabase(String file)
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
                    listOfProduct.add(new Product(
                    att[0],
                    att[1],
                    att[2],
                    att[3],
                    Double.valueOf(att[4]),
                    Double.valueOf(att[5]),
                    att[6],
                    Integer.valueOf(att[7]),
                    att[8],
                    Double.valueOf(att[9])
                    ));
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
    
    public void writeProductToDatabase(String file)
    {
        try
        {
            PrintWriter output = new PrintWriter(file);
            for(Product p : listOfProduct)
            {
                String addFile = "";
                StringBuffer db = new StringBuffer(addFile);
                db.append(p.getProductName() + ",");
                db.append(p.getProductDesc() + ",");
                db.append(p.getProductType() + ",");
                db.append(p.getProductSource() + ",");
                db.append(p.getProductUnitCost() + ",");
                db.append(p.getProductUnitPrice() + ",");
                db.append(p.getExpiryDate() + ",");
                db.append(p.getQty() + ",");
                db.append(p.getPackageType() + ",");
                db.append(p.getPromotionDiscount() + ",");
                output.println(db);
            }
            output.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    public boolean checkRepeatProduct(String productName)
    {
        boolean isRepeat = false;
        for (int index = 0; index < listOfProduct.size(); index++)
        {
            if (productName.equals(listOfProduct.get(index).getProductName()))
                return true;
        }
        return isRepeat;
    }

    /**
     * this method is used by other two methods: updateProductProductDetails and deleteProductFromList
     */
    public Product selectProduct(String productName)
    {
        Product aProduct = new Product();
        for (int index = 0; index < listOfProduct.size(); index++)
        {
            if (productName.equals(listOfProduct.get(index).getProductName()))
                return listOfProduct.get(index);
        }
        return aProduct;
    }
    
    public ArrayList<String> searchProduct(String productName)
    {
        ArrayList<String> listOfProductName = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();
        Pattern pattern = Pattern.compile(productName);
        for (int index = 0; index < listOfProduct.size(); index++)
        {
            listOfProductName.add(listOfProduct.get(index).getProductName());
        }
        
        for(int i=0; i<listOfProductName.size();i++){
            Matcher matcher = pattern.matcher(listOfProductName.get(i));
            if(matcher.find()){
                results.add(listOfProductName.get(i));
            }
        }
        
        return results;
    }
    
    /**
     * 
     */
    public boolean insertToCart(String productName, int qty) //purchase quantity
    {
        int savedQty = 0; //the quantity in cart
        Product aProduct = selectProduct(productName);
        if (aCart.isExist(aProduct))
            savedQty = aCart.getQtyForAProduct(aProduct) + qty;
        else
            savedQty = qty;
        if (aCart.compareQty(aProduct, savedQty) && savedQty != qty) //compare qty with inventory, check if the product is already in the cart
            editProductQty(aProduct, savedQty);
        else if (aCart.compareQty(aProduct, savedQty) && savedQty == qty)
        {
            aCart.getShoppingCart().put(aProduct, savedQty);
        }
        else
            return false;
        updateTotal();
        return true;
    }

    public void updateTotal()
    {
        aCart.setCartTotal(aCart.calculateTotal());
    }
    
    public boolean deleteProductFromCart(Product aProduct)
    {
        if (aCart.isExist(aProduct))
        {    
            aCart.getShoppingCart().remove(aProduct);
            updateTotal();
            return true;
        }
        else
            return false;
    }
    
    public void editProductQty(Product aProduct, int newQty)
    {
        if (aCart.isExist(aProduct))
        {
            aCart.getShoppingCart().remove(aProduct);
            aCart.getShoppingCart().put(aProduct, newQty);
        }
    }
    
    public ArrayList<String[]> setShoppingCart()
    {
        ArrayList<String[]> shoppingCartList = new ArrayList<>();
        if (!aCart.getShoppingCart().isEmpty())
        {
            for (Product aProduct: aCart.getShoppingCart().keySet())
            {
                String[] productCheckout = new String [3];
                String productName = aProduct.getProductName();
                String quantity = aCart.getShoppingCart().get(aProduct).toString();
                String subtotal = Double.toString(aCart.calculateProductSubtotal(aProduct));
                productCheckout[0] = productName;
                productCheckout[1] = quantity;
                productCheckout[2] = subtotal;
                shoppingCartList.add(productCheckout);
            }
            
        }
        return shoppingCartList;
    }
    
    public void createANewOrder(
        String[] attributes,
        HashMap<Product, Integer> shoppingCart
        ) 
        {
        for(Product p : shoppingCart.keySet()){
            p.setQty(p.getQty()-shoppingCart.get(p));
        }
        Order newOrder = new Order(
        attributes[0],
        attributes[1],
        stringToDouble(attributes[2]),
        attributes[3],
        stringToDouble(attributes[4]),
        attributes[5]
        );

        addOrderToList(newOrder);
        aCart.clearShoppingCart();
    }
    
    public void addOrderToList(Order newOrder){
        listOfOrder.add(newOrder);
        
    }
    
    public ArrayList<String> createProductDetailByName(String productName){
        ArrayList<String> productDetail = new ArrayList<String>();
        productDetail.add("====================================================");
        productDetail.add(("Name: " + selectProduct(productName).getProductName()).toString());
        productDetail.add(("Description: " + selectProduct(productName).getProductDesc()).toString());
        productDetail.add(("Type: " + selectProduct(productName).getProductType()).toString());
        productDetail.add(("Source: " + selectProduct(productName).getProductSource()));
        productDetail.add(("Price: " + selectProduct(productName).getProductUnitPrice()));
        productDetail.add("Qty: " + selectProduct(productName).getQty());
        productDetail.add(("Selling in: " + selectProduct(productName).getPackageType()));
        productDetail.add(("Promotion:" + selectProduct(productName).getPromotionDiscount()));
        productDetail.add("====================================================");
        return productDetail;
    }
    
    public ArrayList<String> createOrderItemDetailByName(String productName){
        ArrayList<String> productDetail = new ArrayList<String>();
        productDetail.add("====================================================");
        productDetail.add(("Name: " + selectProduct(productName).getProductName()).toString());
        productDetail.add(("Description: " + selectProduct(productName).getProductDesc()).toString());
        productDetail.add(("Type: " + selectProduct(productName).getProductType()).toString());
        productDetail.add(("Source: " + selectProduct(productName).getProductSource()));
        productDetail.add(("Price: " + selectProduct(productName).getProductUnitPrice()));
        productDetail.add("Qty: " + aCart.getQtyForAProduct(selectProduct(productName)));
        productDetail.add(("Selling in: " + selectProduct(productName).getPackageType()));
        productDetail.add(("Promotion:" + selectProduct(productName).getPromotionDiscount()));
        productDetail.add("====================================================");
        return productDetail;
    }
    
    public String generateCartDetail(HashMap<Product, Integer> shoppingCart){
        String cartDetail ="^";
        for(Product key : shoppingCart.keySet()){
            String productDetailInLine = "_";
            ArrayList<String> productDetail = new ArrayList<String>();
            productDetail = createOrderItemDetailByName(key.getProductName());
            for(int i = 0; i<10; i++){
                productDetailInLine += (productDetail.get(i) + "_");
            }
            cartDetail += (productDetailInLine +"^");
        }
        
        return cartDetail;
        
    }
    
    public boolean checkOrderByCustId(String custId)
    {
        for (int index = 0; index < listOfOrder.size(); index++)
        {
            if (custId.equals(listOfOrder.get(index).getCustID()))
                return true;
        }
        return false;
    }
    
    public ArrayList<Order> selectOrdersByCustId(String custId){
        ArrayList<Order> custOrders = new ArrayList<Order>();
        if(checkOrderByCustId(custId)){
            for(Order each : listOfOrder){
                if(each.getCustID().equals(custId))
                    custOrders.add(each);
                }
            }
        return custOrders;
        }
    
    public ArrayList<String> decodeProductDetail(String orderDetail){
        ArrayList<String> productAttributes = new ArrayList<String>(Arrays.asList(orderDetail.split("_")));
        return productAttributes; 
    }
    
    public ArrayList<String> decodeCartDetail(String orderDetail){
        ArrayList<String> cartItems = new ArrayList<String>(Arrays.asList(orderDetail.split("^")));
        return cartItems;
    }
    
    public ArrayList<Order> getOrderList(){
        return listOfOrder;
    }
    
    public Order getOrderByIndex(int i){
        return listOfOrder.get(i);
    }
    
    public void approveOrderByOrderNum(int i){
        if(getOrderList().get(i-1).getOrderStatus().equals("disapproved")){
        getOrderList().get(i-1).setOrderStatus("approved");
        String OrderDetail = getOrderList().get(i-1).getOrderItemDetails();
        ArrayList<String> cartItemDetails = decodeCartDetail((getOrderByIndex(i-1)).getOrderItemDetails());
        for (String cartItemDetail: cartItemDetails){
                ArrayList<String> productAttributes = decodeProductDetail(cartItemDetail);
                int qty = convertString(productAttributes.get(7).substring(7,100));                
                String targetProduct =productAttributes.get(0);
                selectProduct(targetProduct).setQty(
                selectProduct(targetProduct).getQty()-qty
                );
            }
        }
    }
    
    public void disapproveOrderByOrderNum(int i){
         if(getOrderList().get(i-1).getOrderStatus().equals("approved")){
        getOrderList().get(i-1).setOrderStatus("disapproved");
        String OrderDetail = getOrderList().get(i-1).getOrderItemDetails();
        ArrayList<String> cartItemDetails = decodeCartDetail((getOrderByIndex(i-1)).getOrderItemDetails());
        for (String cartItemDetail: cartItemDetails){
                ArrayList<String> productAttributes = decodeProductDetail(cartItemDetail);
                int qty = convertString(productAttributes.get(7).substring(5,(productAttributes.get(7).length())));                
                String targetProduct =productAttributes.get(2).substring(6,productAttributes.get(7).length());
                selectProduct(targetProduct).setQty(
                selectProduct(targetProduct).getQty()+qty
                );
            }
        }
    }
    
    public void readOrderDatabase(String file)
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
                    listOfOrder.add(new Order(
                    att[0],
                    att[1],
                    att[2],
                    Double.valueOf(att[3]),
                    att[4],
                    att[5],
                    Double.valueOf(att[6])
                    ));
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
    
    public void writeOrderToDatabase(String file)
    {
        try
        {
            PrintWriter output = new PrintWriter(file);
            for(Order o : listOfOrder)
            {
                String addFile = "";
                StringBuffer db = new StringBuffer(addFile);
                db.append(o.getOrderID() + ",");
                db.append(o.getCustID() + ",");
                db.append(o.getOrderStatus() + ",");
                db.append(o.getShipmentPrice() + ",");
                db.append(o.getOrderDate() + ",");
                db.append(o.getOrderItemDetails() + ",");
                db.append(o.getTotalPrice() + ",");
                output.println(db);
            }
            output.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}
