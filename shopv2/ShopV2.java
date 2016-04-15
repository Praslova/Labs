/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopv2;

import java.io.IOException;

/**
 *
 * @author Ксю
 */
public class ShopV2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            menu MenuShop = new menu(); // объект класса menu
            MenuShop.MenuShow(); // обращение к методу MenuShow
        } catch (Exception e) {
            System.out.println("Ошибка");
        }

    }
}
