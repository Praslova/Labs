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
public class salegoods {

    private int id = 0;
    private int idtov = 0;
    private String name = "";
    private int price = 0;
    private int count = 0;

    public salegoods(int id, int idtov, int price, String name, int count) {
        this.id = id;
        this.idtov = idtov;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void GoodsSaleShow() {
        System.out.println(this.id + " " + this.price);

    }

    public void ShowInfo() {
        System.out.println(this.id + " " + this.idtov + " " + this.price + " " + this.name + " " + this.count);

    }

    public int getID() {
        return this.id;
    }

    public int getIDtov() {
        return this.idtov;
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

    public int getIdtov() {
        return this.idtov;
    }
}
