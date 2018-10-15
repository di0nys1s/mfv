
/**
 * The Order class is in order to create the order.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Order
{
    // instance variables - replace the example below with your own
    private String orderID;
    private String custID;
    //orderStatus contains: approved, dorderStatusd and pending.
    private String orderStatus;
    private double shipmentPrice;
    private String orderDate;
    //private ShoppingCart orderItems;
    private String orderItemDetails;
    private double totalPrice;
    /**
     * Constructor for objects of class Order
     */
    public Order()
    {
        orderID = null;
        custID = null;
        orderStatus = "pending";
        shipmentPrice = 0;
        orderDate = null;
        orderItemDetails = null;
        totalPrice = 0;
    }
    
    public Order(
        String orderID,
        String custID,
        String orderStatus,
        double shipmentPrice,
        String orderDate,
        String orderItemDetails,
        double totalPrice
        ){
        this.orderID = orderID;
        this.custID = custID;
        this.orderStatus = orderStatus;
        this.shipmentPrice = shipmentPrice;
        this.orderDate = orderDate;
        this.orderItemDetails = orderItemDetails;
        this.totalPrice = totalPrice;
    }
    
    public Order(
        String orderID,
        String custID,
        double shipmentPrice,
        String orderDate,
        double cartTotal,
        String orderItemDetails
        ){
        this.orderID = orderID;
        this.custID = custID;
        this.orderStatus = "approved";
        this.shipmentPrice = shipmentPrice;
        this.orderDate = orderDate;
        this.totalPrice = shipmentPrice + cartTotal;
        this.orderItemDetails = orderItemDetails;
    }
    
    public String getOrderItemDetails(){
        return orderItemDetails;
    }
    
    public void setOrderItemDetails(String orderItemDetails){
        this.orderItemDetails = orderItemDetails;
    }
    
    public String getOrderID() 
    {
        return orderID;
    }

    public void setOrderID(String orderID) 
    {
        this.orderID = orderID;
    }

    public String getCustID() 
    {
        return custID;
    }

    public void setCustID(String custID) 
    {
        this.custID = custID;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public double getShipmentPrice() 
    {
        return shipmentPrice;
    }

    public void setShipmentPrice(double shipmentPrice) 
    {
        this.shipmentPrice = shipmentPrice;
    }

    public double getTotalPrice() 
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() 
    {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    
}

