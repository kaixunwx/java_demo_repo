package com.wukaixun.gaoji.streamshujuliu.mapreduce;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

/**
 * mapreduce基础模型
 * @author wukaixun
 * @date 2020.12.10
 */
public class JavaDemo {
    public static void main(String[] args) {
        List<Order> all = new ArrayList<>();
        all.add(new Order("iphone12", 8499.00, 20));
        all.add(new Order("富光水杯", 49.99, 10));
        all.add(new Order("rtx 3080", 6999.00, 5));
        all.add(new Order("煎饼果子", 8.00, 10));

        Stream<Order> stream = all.stream();
        DoubleSummaryStatistics stat = stream.mapToDouble((orderObject) -> orderObject.getPrice() * orderObject.getAmount()).summaryStatistics();
        System.out.println("购买品种数:" + stat.getCount());
        System.out.println("总花费:" + stat.getSum());
        System.out.println("平均花费:" + stat.getAverage());
        System.out.println("品种最高花费:" + stat.getMax());
        System.out.println("品种最低花费:" + stat.getMin());
    }
}

class Order{
    private String name;
    private double price;
    private int amount;

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
