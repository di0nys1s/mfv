
import java.util.*;

/**
 * Product class
 * All the Product details kept in the class.
 * Creating a new Product
 * @author (Burak Seyhan - 28867041) 
 * @version (V2) 11.Oct.2018s
 */
public class Product
{
    private String productName;
    private String productDesc;
    private String productType;
    private String productSource;
    private double productUnitCost; 
    private double productUnitPrice;
    private String expiryDate; 
    private int qty;
    private String packageType;
    private double promotionDiscount; 

    /**
     * Constructor for objects of class Product
     */
    public Product(
    String productName, 
    String productDesc, 
    String productType, 
    String productSource, 
    double productUnitCost, 
    double productUnitPrice, 
    String expiryDate, 
    int qty, 
    String packageType, 
    double promotionDiscount
    )
    {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productType = productType;
        this.productSource = productSource;
        this.productUnitCost = productUnitCost;
        this.productUnitPrice = productUnitPrice;
        this.expiryDate = expiryDate;
        this.qty = qty;
        this.packageType = packageType;
        this.promotionDiscount = promotionDiscount;

    }

    /**
     * Default constructor.
     */
    public Product()
    {

    }
    
    /**
     * Getting the Product name
     * @param
     * @return productName
     */
    public String getProductName()
    {   
        return productName;
    }

    /**
     * Setting the Product name
     * @param productName
     * @return
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    } 

    /**
     * Getting the Product description
     * @param
     * @return productDesc
     */
    public String getProductDesc()
    {   
        return productDesc;
    }

    /**
     * Setting the Product description
     * @param productDesc
     * @return
     */
    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    } 
    
    /**
     * Getting Product type
     * @param
     * @return productType
     */
    public String getProductType()
    {   
        return productType;
    }

    /**
     * Setting Product type
     * @param productType
     * @return
     */
    public void setProductType(String productType)
    {
        this.productType = productType;
    } 

    /**
     * Getting Product source
     * @param
     * @return productSource
     */
    public String getProductSource()
    {   
        return productSource;
    }

    /**
     * Setting Product source
     * @param productSource
     * @return 
     */
    public void setProductSource(String productSource)
    {
        this.productSource = productSource;
    }

    /**
     * Getting Product unit cost
     * @param
     * @return productUnitCost
     */   
    public double getProductUnitCost()
    {   
        return productUnitCost;
    }

    /**
     * Setting Product unit cost
     * @param productUnitCost
     * @return 
     */
    public void setProductUnitCost(double productUnitCost)
    {
        this.productUnitCost = productUnitCost;
    }

        /**
     * Getting Product unit price
     * @param
     * @return productUnitPrice
     */   
    public double getProductUnitPrice()
    {   
        return productUnitPrice;
    }

    /**
     * Setting Product unit price
     * @param productUnitPrice
     * @return 
     */
    public void setProductUnitPrice(double productUnitPrice)
    {
        this.productUnitPrice = productUnitPrice;
    }

     /**
     * Getting expiry date
     * @param
     * @return ExpiryDate
     */
    public String getExpiryDate()
    {   
        return expiryDate;
    }

    /**
     * Setting expiry date
     * @param expiryDate
     * @return
     */
    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

     /**
     * Getting stock quantity
     * @param
     * @return qty
     */
    public int getQty()
    {   
        return qty;
    }

    /**
     * Setting Stock quantity
     * @param qty
     * @return
     */
    public void setQty(int qty)
    {
        this.qty = qty;
    }

     /**
     * Getting package type
     * @param
     * @return packageType
     */
    public String getPackageType()
    {   
        return packageType;
    }

    /**
     * Setting package type
     * @param packageType
     * @return
     */
    public void setPackageType(String packageType)
    {
        this.packageType = packageType;
    }

     /**
     * Getting promotion discount
     * @param
     * @return promotionDiscount
     */
    public Double getPromotionDiscount()
    {   
        return promotionDiscount;
    }

    /**
     * Setting  promotionDiscount
     * @param promotionDiscount
     * @return
     */
    public void setPromotionDiscount(Double promotionDiscount)
    {
        this.promotionDiscount = promotionDiscount;
    }
}
