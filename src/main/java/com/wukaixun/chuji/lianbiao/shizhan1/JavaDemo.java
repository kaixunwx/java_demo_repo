package com.wukaixun.chuji.lianbiao.shizhan1;

import com.wukaixun.chuji.lianbiao.shouxielianbiao.ILink;
import com.wukaixun.chuji.lianbiao.shouxielianbiao.LinkImpl;

/**
 * 链表实战1 宠物商店
 *
 * @author wukaixun
 * @date 2020.10.10
 */
interface Pet {
    public String getName();

    public String getColor();
}

class Cat implements Pet {
    String name;
    String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cat)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Cat cat = (Cat) obj;
        return this.name.equals(cat.name) && this.color.equals(cat.color);
    }

    public String toString() {
        return "[宠物猫] 名字：" + this.getName() + "，颜色:" + this.getColor();
    }
}


class Dog implements Pet {
    String name;
    String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cat)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Dog dog = (Dog) obj;
        return this.name.equals(dog.name) && this.color.equals(dog.color);
    }

    public String toString() {
        return "[宠物狗] 名字：" + this.getName() + "，颜色:" + this.getColor();
    }
}

class PetShop {
    private ILink<Pet> allPets = new LinkImpl<>();

    public void add(Pet pet) {  // 上架宠物
        this.allPets.add(pet);
    }

    public void delete(Pet pet) {
        this.allPets.remove(pet);
    }

    public ILink<Pet> search(String keyword) {
        ILink<Pet> searchResult = new LinkImpl<>();
        Object result[] = this.allPets.toArray();
        if (result != null) {
            for (Object obj : result) {
                Pet pet = (Pet) obj;
                if (pet.getName().contains(keyword) || pet.getColor().contains(keyword)) {
                    searchResult.add(pet);
                }
            }
        }
        return searchResult;
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        Cat cat = new Cat("橘猫", "黄色");
        shop.add(cat);
        shop.add(new Dog("小黄狗", "黄色"));
        shop.add(new Cat("加菲猫", "绿色"));
        shop.add(new Dog("田园狗", "土黄色"));

        Object[] res = shop.search("黄").toArray();
        for(Object obj: res){
            System.out.println(obj);
        }

        System.out.println("------删除橘猫------");
        shop.delete(cat);
        Object[] res1 = shop.search("黄").toArray();
        for(Object obj: res1){
            System.out.println(obj);
        }

    }
}
