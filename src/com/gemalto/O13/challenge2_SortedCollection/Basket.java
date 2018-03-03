package com.gemalto.O13.challenge2_SortedCollection;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;

        // Unordered
        //this.list = new HashMap<>();

        // TreeMap calls the compareTo() of StockItem
        // Alphabetical Ordered
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            // check if we already have item in the basket
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket + quantity;

            if (newQuantity > 0) {
                list.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                list.remove(item);
            }
        }
        return 0;
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "Shopping basket '" + name + "' contains " + list.size() + (list.size() == 1 ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
