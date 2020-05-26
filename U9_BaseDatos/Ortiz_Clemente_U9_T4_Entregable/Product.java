public class Product {
    /**
     * Atributos de la clase
     */
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantifyInStock;
    private Double buyPrice;
    private Double MSRP;

    /**
     * Contructor por defecto
     */
    public Product() {
    }

    /**
     * Constructor con parámetros
     * @param productCode código del producto
     * @param productName nombre del producto
     * @param productLine
     * @param productScale tamaño del producto
     * @param productVendor
     * @param productDescription descripción del producto
     * @param quantifyInStock cantidad en almacén
     * @param buyPrice precio de compra
     * @param MSRP
     */
    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantifyInStock, Double buyPrice, Double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantifyInStock = quantifyInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    /**
     * Método para mostrar por pantalla los detalles del producto
     * @return una cadena con todos los detalles
     */
    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantifyInStock=" + quantifyInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }

    /**
     * Métodos de GETTER Y SETTER
     * @return
     */
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantifyInStock() {
        return quantifyInStock;
    }

    public void setQuantifyInStock(Integer quantifyInStock) {
        this.quantifyInStock = quantifyInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public void setMSRP(Double MSRP) {
        this.MSRP = MSRP;
    }
}
