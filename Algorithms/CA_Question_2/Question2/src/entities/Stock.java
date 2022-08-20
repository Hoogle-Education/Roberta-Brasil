package entities;
import java.util.Comparator;
import java.util.Date;

public class Stock {

  private int stockNo;
  private float stockSize;
  private float cost;
  private String productType;
  private Date buyDate;
  private String productName;

  // constructor
  public Stock(int stockNo, float stockSize, float cost, String productType, Date buyDate, String productName) {
    super();
    this.stockNo = stockNo;
    this.stockSize = stockSize;
    this.cost = cost;
    this.productType = productType;
    this.buyDate = buyDate;
    this.productName = productName;
  }

  // setters and getters
  public int getStockNo() {
    return stockNo;
  }

  public void setStockNo(int stockNo) {
    this.stockNo = stockNo;
  }

  public float getStockSize() {
    return stockSize;
  }

  public void setStockSize(float stockSize) {
    this.stockSize = stockSize;
  }

  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public Date getBuyDate() {
    return buyDate;
  }

  public void setBuyDate(Date buyDate) {
    this.buyDate = buyDate;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  @Override
  public String toString() {
    return "Stock [StockNo =" + stockNo + ", Stock size = " + stockSize + ", Cost = " + cost + ", Product Type = "
        + productType + ", Buy date = " + buyDate +
        ", Product name = " + productName + "\n";
  }

  // PART B

  public static class SortByStockNo implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
      return Integer.compare(o1.stockNo, o2.stockNo);
    }
  }

  public static class SortBySize implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
      return Float.compare(o1.stockSize, o2.stockSize);
    }
  }

  public static class SortByCost implements Comparator<Stock>{
    @Override
    public int compare(Stock o1, Stock o2) {
      return Float.compare(o1.cost, o2.cost);
    }    
  }

  public static class SortByProductType implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
      return o1.productType.compareToIgnoreCase(o2.productType);
    }
  }

  public static class SortByDate implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
      return o1.buyDate.compareTo(o2.buyDate);
    }
  }

  public static class SortByProductName implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
      return o1.productName.compareToIgnoreCase(o2.productName);
    }
  }

  
}
