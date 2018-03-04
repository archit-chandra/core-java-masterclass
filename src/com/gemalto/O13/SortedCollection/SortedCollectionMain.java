package com.gemalto.O13.SortedCollection;

import java.util.Map;

public class SortedCollectionMain {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        // Adding additional cups
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);


        System.out.println("--------- Stock List (Unmodifiable Map)--------");
        System.out.println(stockList);

        System.out.println("\n--------- Stock List Name(Regular Map)--------");
        for (String s : stockList.getItems().keySet()) {
            System.out.println(s);
        }

        Basket timBasket = new Basket("Tim");
        sellItem(timBasket, "car", 1);
        System.out.println("\n-----After 1st car purchase------");
        System.out.println(timBasket);

        sellItem(timBasket, "car", 1);
        System.out.println("\n-----After 2nd car purchase------");
        System.out.println(timBasket);

        if (sellItem(timBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }
        sellItem(timBasket, "spanner", 5);
        System.out.println("\n-----After 3rd car & spanner purchase------");
        System.out.println(timBasket);

        sellItem(timBasket, "juice", 4);
        sellItem(timBasket, "cup", 12);
        sellItem(timBasket, "bread", 1);
        System.out.println("\n-----After juice, cup, bread purchase------");
        System.out.println(timBasket);

        System.out.println("--------- Stock List (After purchasing)--------");
        System.out.println(stockList);

        // Below will give the UnsupportedOperationException
        // stockList.getItems() returns UnmodifiableMap, and we are trying to modify it
        /*temp = new StockItem("pen", 1.12);
        stockList.getItems().put(temp.getName(), temp);*/

        temp = new StockItem("pen", 1.12);
        stockList.addStock(temp);
        System.out.println("---------Adding Pen----------");
        System.out.println(stockList);

        // Even though stockList.getItems() returns UnmodifiableMap, it is possible to modify the individual item
        stockList.getItems().get("car").adjustStock(2000);
        stockList.getItems().get("car").adjustStock(-1000);
        System.out.println("---------After modifying car stock----------");
        System.out.println(stockList);

        // Here, Collection as well as item inside it becomes unmodifiable
        System.out.println("----------Unmodifiable Collections & its items-------------");
        for (Map.Entry<String, Double> price : stockList.getPriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // Retriving the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        // when not having sufficient stock
        return 0;
    }
}
