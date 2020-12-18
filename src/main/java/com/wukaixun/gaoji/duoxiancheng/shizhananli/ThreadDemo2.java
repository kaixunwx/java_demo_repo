package com.wukaixun.gaoji.duoxiancheng.shizhananli;

/**
 * 多线程实战2
 * 生产一台电脑  卖出一台电脑
 *
 * @author wukaixun
 * @date 2020.10.14
 */
class Computer {
    public static int count = 0;
    private String brand;
    private double price;

    public Computer(String brand, double price) {
        this.brand = brand;
        this.price = price;
        count ++;
    }

    public String toString() {
        return String.format("[第%s台电脑] 品牌: %s, 价格: %s", count, this.brand, this.price);
    }
}

/**
 * 操作电脑资源
 */
class ComputerResource {
    private Computer computer;

    // 生产电脑
    public synchronized void produce(String brand, double price) throws Exception {
        while (this.computer != null) {  // 表示生产过了，需要售出电脑
            super.wait();
        }
        this.computer = new Computer(brand, price);
        System.out.println("[生产]" + this.computer);

        super.notifyAll();
    }

    // 售出电脑
    public synchronized void sale() throws Exception {
        while (this.computer == null) {  // 该等待生产电脑
            super.wait();
        }
        System.out.println("[卖出]:" + this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

class ProduceTread implements Runnable {
    private ComputerResource computerResource;

    public ProduceTread(ComputerResource computerResource) {
        this.computerResource = computerResource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            if (x % 2 == 0) {
                try {
                    this.computerResource.produce("联想", 4699.9);
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    this.computerResource.produce("小米", 8699.0);
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SaleThread implements Runnable{
    private ComputerResource computerResource;

    public SaleThread(ComputerResource computerResource) {
        this.computerResource = computerResource;
    }

    @Override
    public void run() {
        for(int x = 0; x < 50; x ++){
            try {
                this.computerResource.sale();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        ComputerResource computerResource = new ComputerResource();
        new Thread(new ProduceTread(computerResource)).start();
        new Thread(new SaleThread(computerResource)).start();
    }
}
