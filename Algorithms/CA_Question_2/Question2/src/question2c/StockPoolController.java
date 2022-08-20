package question2c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import entities.Stock;

public class StockPoolController extends Thread {
  
  private List<Stock> stocks;
  private int stockListID;

  public StockPoolController(Stock[] stocks , int stockListID){
    this.stocks = Arrays.asList(stocks);
    this.stockListID = stockListID;
  }
    
  @Override
  public void run() {

    // improving security sorting the copy of stock data
    List<Stock> aux = stocks;
    
    // sorting by controller id
    switch(stockListID){
      case 1: Collections.sort(aux, new Stock.SortByStockNo());
        break;
      case 2: Collections.sort(aux, new Stock.SortBySize());
        break;
      case 3: Collections.sort(aux, new Stock.SortByCost());
        break;
      case 4: Collections.sort(aux, new Stock.SortByProductType());
        break;
      case 5: Collections.sort(aux, new Stock.SortByDate());
        break;
      case 6: Collections.sort(aux, new Stock.SortByProductName());
        break;
    }

    // saving the list into csv and wait others in pool
    try {
      listToCSV(aux, stockListID);
      Thread.sleep(2000);
    } catch (InterruptedException interrExcep) {
      interrExcep.printStackTrace();
    }
  }

  // save sorted list file into csv fies
  private void listToCSV(List<Stock> aux, int i) {
    File file = new File("sorted_C" + i + ".csv");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)) ){
      
      writer.write("stock_no,product_size,cost,product_type,buy_date,product_name\n");

      for(Stock stock : aux){
        String csvLine = getLineCSV(stock);
        writer.write(csvLine);
      }

    } catch (IOException excep){
      excep.printStackTrace();
    }
  }

  private String getLineCSV(Stock stock){
    return stock.getStockNo() + "," + stock.getStockSize() + ","
            + stock.getCost() + "," + stock.getProductType() 
            + "," + stock.getBuyDate() + "," + stock.getProductName() + "\n" ;
  }
}
