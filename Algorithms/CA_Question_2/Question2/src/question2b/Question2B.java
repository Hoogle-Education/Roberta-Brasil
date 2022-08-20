package question2b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Stock;
import question2c.StockList;

public class Question2B extends Thread {

    public static void main(String[] args) { 

        File directory = new File("");
        String filepath = directory.getAbsolutePath() + "//Stock.csv";
        Scanner sc = new Scanner(System.in);
        Stock[] stocks = new Stock[10000];

        // Question 2 - A - Using buffered reader and file reader to extract data
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            // this will just print the header in CSV file
            reader.readLine();

            int i = 0;
            String line = "";
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

            while ((line = reader.readLine()) != null) // get string line
            {
                String[] data = line.split(",");

                Date date = ft.parse(data[4]).before(ft.parse("2022-05-08")) ? ft.parse(data[4])
                        : null;

                stocks[i++] = new Stock(Integer.parseInt(data[0]),
                        Float.parseFloat(data[1]),
                        Float.parseFloat(data[2]),
                        data[3],
                        date,
                        data[5]);
            }

            int entry;
            do {
                
                sortMenu();
                entry = sc.nextInt();
                List<Stock> copy = Arrays.asList(stocks);

                switch (entry) {
                    case 1:
                        Collections.sort(copy, new Stock.SortByStockNo());
                        break;
                    case 2:
                        Collections.sort(copy, new Stock.SortBySize());
                        break;
                    case 3:
                        Collections.sort(copy, new Stock.SortByCost());
                        break;
                    case 4:
                        Collections.sort(copy, new Stock.SortByProductType());
                        break;
                    case 5:
                        Collections.sort(copy, new Stock.SortByDate());
                        break;
                    case 6:
                        Collections.sort(copy, new Stock.SortByProductName());
                        break;
                }

                for(Stock s : stocks){
                    if(entry == 0) break;
                    System.out.println(s);
                }

            }while(entry != 0);

           
        } catch (ParseException pex) {
            System.out.println("Error to parse the file!");
        } catch (IOException iox) {
            System.out.println("Error to open and read the file!");
        }

    }
 

    public static List<Stock> searchingDate(String value, List<Stock> stocks) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = ft.parse(value);
        List<Stock> finalList = new ArrayList<>();
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getBuyDate().getTime() == date.getTime()) {
                finalList.add(stocks.get(i));
            }
        }
        return finalList;
    }

    public static void sortMenu(){
        System.out.println("1 - to sort by Stock number ID\n"
                            + "2 - to sort by Stock Size\n"
                            + "3 - to sort by Cost\n"
                            + "4 - to sort by Product Type\n"
                            + "5 - to sort by Date\n"
                            + "6 - to sort by Product Name\n"
                            + "7 - unorder the list to the original\n"
                            + "0 - to stop sorting");
    }

}
