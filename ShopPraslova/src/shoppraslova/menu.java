/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppraslova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class menu {
     products punktone = new products();
       
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    public void MenuShow() throws IOException{ 
        punktone.Filestoreread();
        punktone.Filesaleread();
        
        boolean flag = true;
        while(flag){
            
        try{
        
     System.out.println(" 1.Продажа товара\n 2.Поставка товара\n 3.Данные по продажам\n 4.Выход");
     System.out.println("Выберите пункт меню:");
        
        String choice ;
        choice = BR.readLine();
       
        
       
        
       
        
        
        switch (choice){
            case "1" : punktone.Filetable();
                       punktone.Sale();
                      
            break;
            
            case "2" : punktone.deliveryproducts();
                
            break;
            
            case "3" : 
            punktone.salestable();
            
            punktone.infosales();
            // System.out.println("\n");
            break;
            
            case "4":  
            punktone.Importstore();   
            punktone.Importsale();
            flag = !flag; 
            break;
            
            default : System.out.println("Ошибка");
             break;
       
        }
        } catch (IOException e) {System.out.println("Ошибка");}
        }}
}