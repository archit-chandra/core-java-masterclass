package com.gemalto.O13.challenge2_SortedCollection;

import java.util.Map;

public class Challenge2Main {

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
        //System.out.println("\n-----After 3rd car & spanner purchase------");
        //System.out.println(timBasket);

        sellItem(timBasket, "juice", 4);
        sellItem(timBasket, "cup", 12);
        sellItem(timBasket, "bread", 1);
        //System.out.println("\n-----After juice, cup, bread purchase------");
        //System.out.println(timBasket);

        //System.out.println("--------- Stock List (After purchasing)--------");
        //System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println("-----------Customer Basket----------------");
        System.out.println(basket);

        removeItem(timBasket, "car", 1);
        removeItem(timBasket, "cup", 9);
        removeItem(timBasket, "car", 1);

        // It should not remove any
        // Output: car removed: 0
        System.out.println("car removed: " + removeItem(timBasket, "car", 1));

        System.out.println("-----------Tim Basket----------------");
        System.out.println(timBasket);

        //remove all item from Tim Basket
        removeItem(timBasket, "bread", 1);
        removeItem(timBasket, "cup", 3);
        removeItem(timBasket, "juice", 4);
        removeItem(timBasket, "cup", 3);
        System.out.println("-----------Emptied Tim Basket----------------");
        System.out.println(timBasket);

        System.out.println("\nDisplay stock list before and after Customer basket checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
        System.out.println("-----------------------------------------------------------------");


        // Below will give the UnsupportedOperationException
        // stockList.getItems() returns UnmodifiableMap, and we are trying to modify it
        /*temp = new StockItem("pen", 1.12);
        stockList.getItems().put(temp.getName(), temp);*/

        /*temp = new StockItem("pen", 1.12);
        stockList.addStock(temp);
        System.out.println("---------Adding Pen----------");
        System.out.println(stockList);*/

        // Even though stockList.getItems() returns UnmodifiableMap, it is possible to modify the individual item
        StockItem car = stockList.get("car");
        if (car != null) {
            car.adjustStock(2000);
            car.adjustStock(-1000);
        }

        System.out.println("---------After modifying car stock----------");
        System.out.println(stockList);

        // Here, Collection as well as item inside it becomes unmodifiable
        /*System.out.println("----------Unmodifiable Collections & its items-------------");
        for (Map.Entry<String, Double> price : stockList.getPriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }*/

        System.out.println("\nDisplay before and after Tim basket checkout");
        checkOut(timBasket);
        System.out.println(timBasket);
        System.out.println(stockList);
        System.out.println("-----------------------------------------------------------------");

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // Retriving the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        // when not having sufficient stock
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // Retriving the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.getItems().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
