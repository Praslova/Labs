/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopv2;

/**
 *
 * @author Ксю
 */
public class goods {

    private int id = -1;
    private String name = "";
    private int price = -1;
    private int count = -1;

    public goods(int id, String name, int price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;

    }

    public void buyProduct(int k) {
        if (k > this.count) {
            System.out.println("Недостоточное количество товаров");
        } else {
            this.count -= k;
        }
    }

    public void GoodsShow() {
        System.out.println(this.id + " " + this.name + " " + this.price + " " + this.count);

    }

    public void addProduct(int n) {
        this.count += n;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }
}
