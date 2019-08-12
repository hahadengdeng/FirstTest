package Entity;


public class Product {
    private int productID;
    private String product_name;
    private double product_price;
    private int providerID;
    private int quantity;
    private double sales_price;
    private int categroyID;
    private  String income_time;

    private Category category;
    private Provider provider;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSales_price() {
        return sales_price;
    }

    public void setSales_price(double sales_price) {
        this.sales_price = sales_price;
    }

    public int getCategroyID() {
        return categroyID;
    }

    public void setCategroyID(int categroyID) {
        this.categroyID = categroyID;
    }

    public String getIncome_time() {
        return income_time;
    }

    public void setIncome_time(String income_time) {
        this.income_time = income_time;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public Provider getProvider() { return provider; }

    public void setProvider(Provider provider) { this.provider = provider; }

    public Product() {
    }

    public Product(int productID, String product_name, double product_price, int providerID, int quantity, double sales_price, int categroyID, String income_time) {
        this.productID = productID;
        this.product_name = product_name;
        this.product_price = product_price;
        this.providerID = providerID;
        this.quantity = quantity;
        this.sales_price = sales_price;
        this.categroyID = categroyID;
        this.income_time = income_time;
    }

    public Product(int productID, String product_name, double product_price, int quantity, double sales_price, String income_time, Category category, Provider provider) {
        this.productID = productID;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.sales_price = sales_price;
        this.income_time = income_time;
        this.category = category;
        this.provider = provider;
    }

    public Product(String product_name, double product_price, int providerID, int quantity, double sales_price, int categroyID, String income_time) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.providerID = providerID;
        this.quantity = quantity;
        this.sales_price = sales_price;
        this.categroyID = categroyID;
        this.income_time = income_time;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", provider_name=" + this.getProvider().getProvider_name() +
                ", quantity=" + quantity +
                ", sales_price=" + sales_price +
                ", categroy_name=" + this.getCategory().getCategory_name() +
                ", income_time='" + income_time + '\'' +
                '}';
    }
}
