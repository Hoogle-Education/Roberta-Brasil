package question2c;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.Stock;

public class StockList implements Runnable {

  List<Stock> list;
  Comparator <? super Stock> c;

  public StockList(Stock[] stocks, Comparator <? super Stock> c) {
    list = Arrays.asList(stocks);
    this.c = c;
  }

  @Override
  public void run() {
    Collections.sort(list, c);
  }

}
