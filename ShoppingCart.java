import java.util.HashMap;

/**
 * This is a shopping cart which is used to store the products selected by 
 * the customer.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShoppingCart
{
    private HashMap<Product, Integer> listOfSelectedProducts;
    private double cartTotal;
  
    public ShoppingCart()
    {
        listOfSelectedProducts = new HashMap<Product, Integer>();
        cartTotal = 0;
    }
    
    public void clearShoppingCart() {
        listOfSelectedProducts.clear();
    }  
  
    public HashMap<Product, Integer> getShoppingCart()
    {
        return listOfSelectedProducts;
    }
    
    public double getCartTotal()
    {
        return cartTotal;
    }
    
    public void setCartTotal(double aDouble)
    {
        cartTotal = aDouble;
    }
    
    /**
     * This method is used to compare the inventory number with the quantity entered by customer.
     * 
     */
    public boolean compareQty(Product aProduct, int enterNumber)
    {
        int qty = aProduct.getQty();
        if (qty >= enterNumber)
            return true;
        else
            return false;
    }
    
    public boolean isExist(Product aProduct)
    {
        if (listOfSelectedProducts.containsKey(aProduct))
            return true;
        else
            return false;
    }
    
    public double calculateProductSubtotal(Product aProduct)
    {
        double subtotal = 0;
        if (isExist(aProduct))
            subtotal = aProduct.getProductUnitPrice() * getQtyForAProduct(aProduct);
        return subtotal;
    }
    
    public double calculateTotal()
    {
        double sum = 0.0;
        for (Product aProduct : listOfSelectedProducts.keySet())
        {
            sum += calculateProductSubtotal(aProduct);
        }
        return sum;
    }
    
    /**
     * This method is used to get the quantity
     */
    public int getQtyForAProduct(Product aProduct)
    {
        if (listOfSelectedProducts.get(aProduct) != null)
            return listOfSelectedProducts.get(aProduct);
        else
            return 0;
    }
}
