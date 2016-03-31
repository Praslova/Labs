package shoppraslova;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.ss.usermodel.Row;

public class products{
   BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<Integer> counts = new ArrayList<>();
    ArrayList<Integer> prices = new ArrayList<>();
   
   ArrayList<Integer> pricessale = new ArrayList();
   ArrayList<Integer> idssale = new ArrayList();
   ArrayList<Integer> countssale = new ArrayList();
   ArrayList<String> namessale = new ArrayList();
   ArrayList<Integer> idtovsale = new ArrayList();
   





int ChoiceProductsid;
int ChoiceProductscount;



public void Filestoreread() throws IOException { //считывание текста из файла товаров магазина
POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream("C:\\Users\\Ксю\\Desktop\\store.xls"));
HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
HSSFSheet sheet = workBook.getSheetAt(0);

Iterator<Row> rows = sheet.rowIterator();


while (rows.hasNext()) {
HSSFRow row = (HSSFRow) rows.next();
int id = (int) row.getCell(0).getNumericCellValue();
String name = row.getCell(1).getStringCellValue();
int count = (int) row.getCell(3).getNumericCellValue();
int price = (int) row.getCell(2).getNumericCellValue();

names.add(name);
counts.add(count);
ids.add(id);
prices.add(price);

}
}
public void Filesaleread() throws IOException { //считывание из файла со списком продаж
    POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream("C:\\Users\\Ксю\\Desktop\\sale.xls"));
HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
HSSFSheet sheet = workBook.getSheetAt(0);

Iterator<Row> rows = sheet.rowIterator();


while (rows.hasNext()) {
HSSFRow row = (HSSFRow) rows.next();
int id = (int) row.getCell(0).getNumericCellValue();
int idtov = (int) row.getCell(1).getNumericCellValue();
int price = (int) row.getCell(2).getNumericCellValue();
String name =  row.getCell(3).getStringCellValue();

int count = (int) row.getCell(4).getNumericCellValue();


idssale.add(id);
idtovsale.add(idtov);
pricessale.add(price);
namessale.add(name);
countssale.add(count);
}

}

    public void Filetable() throws IOException  { //вывод списка товаров
 
for(int k=0; k<ids.size(); k++) {
System.out.print(ids.get(k));
System.out.print(" "+names.get(k));
System.out.print(" "+prices.get(k));
System.out.println(" "+counts.get(k));
    }

    }

   public void  Sale () throws IOException //оформление покупки товара
   { boolean flag = true;
  
     
      
        while(flag){
            try{ 
    System.out.println("Введите id товара");
    int s = idssale.size()+1;
    Scanner scanner = new Scanner(System.in);
    
    ChoiceProductsid = scanner.nextInt();
    System.out.println("Введите количество товара");
    ChoiceProductscount = scanner.nextInt(); 
    int p; // номер выбранного товара в массиве
    
    if(ids.contains(ChoiceProductsid))
    { p = ids.indexOf(ChoiceProductsid);
    
      if ((counts.get(p)-ChoiceProductscount)<0)
          System.out.println("Недостаточно товара на складе");
      else {counts.set(p, counts.get(p)-ChoiceProductscount);
       idssale.add(s);
       pricessale.add(prices.get(p)*ChoiceProductscount);
       countssale.add(ChoiceProductscount);
       namessale.add(names.get(p));
       idtovsale.add(ChoiceProductsid);
      
      
      
      
           }
    }
    else System.out.println("Товар не найден\n ");
  
        }  catch (Exception e) {System.out.println("Ошибка");}
        
        System.out.println("1.Назад\n2.Продолжить покупки\n");
        String choice ;
        choice = BR.readLine();
            
            switch (choice){
            case "1" : 
            flag = !flag;
            break;
            }
   }}
   

  public void deliveryproducts() throws IOException{ // оформление доставки товаров
   boolean flag = true;
  

        while(flag){
            try{
       System.out.println("Введите id поставляемого товара");
       Scanner scandelivery = new Scanner(System.in);
  
       int deliveryid;
       int deliverycounts;
       deliveryid = scandelivery.nextInt();
       int p; // номер выбранного товара в массиве
       
       if(ids.contains(deliveryid))
    { p = ids.indexOf(deliveryid);
     System.out.println("Введите количество поставляемого товара");
       deliverycounts = scandelivery.nextInt();
      counts.set(p, counts.get(p)+deliverycounts);
      
    }
    else {
           System.out.println("Товар не найден\n Введите id товара");
    int newid = scandelivery.nextInt();
        System.out.println("Введите название товара");
        String newname ;
        newname = BR.readLine();
        System.out.println("Введите цену товара");
        int newprice = scandelivery.nextInt();
        
        System.out.println("Введите количество товара");  
        int newcount = scandelivery.nextInt();
        
        ids.add(newid);
        names.add(newname);
        prices.add(newprice);
        counts.add(newcount);
       
       } 
   }catch (Exception e) {System.out.println("Ошибка");}
          
        System.out.println("1.Назад\n2.Продолжить покупки\n");
        String choice ;
        choice = BR.readLine();
            
            switch (choice){
            case "1" : 
            flag = !flag;
            break;
            }
   }
       
        
       
   }
   
   public void salestable() throws IOException { //вывод списка продаж

for(int k=0; k<idssale.size(); k++) {
System.out.print(idssale.get(k));
System.out.println(" "+pricessale.get(k));

   
}
   }
   
   
    public void infosales() throws IOException{//вывод полной информации о продаже
        
        
        boolean flag = true;
  
     
      
        while(flag){
            try{ 
       System.out.println("\nВведите id продажи для вывода информации");
       Scanner scan = new Scanner(System.in);
       int ChoiceSaleid = scan.nextInt();
    
       for(int k=0; k<idssale.size(); k++)
       if (idssale.get(k)==ChoiceSaleid) 
       { System.out.print(idssale.get(k));
         System.out.print(" "+idtovsale.get(k));
         System.out.print(" "+pricessale.get(k));
         System.out.print(" "+namessale.get(k));
         System.out.println(" "+countssale.get(k));
        
         }
            } catch (Exception e) {System.out.println("Ошибка");}
          
        System.out.println("1.Назад\n2.Продолжить вывод информации\n");
        String choice ;
        choice = BR.readLine();
            
            switch (choice){
            case "1" : 
            flag = !flag;
            break;
            }
        }
     
   }
   
   
   public void Importstore() throws IOException{
HSSFWorkbook workBook = new HSSFWorkbook();
HSSFSheet sheet = workBook.createSheet(); 

for (int j=0; j<ids.size();++j){
HSSFRow r = (HSSFRow) sheet.createRow(j);
r.createCell(0).setCellValue(ids.get(j));
r.createCell(1).setCellValue(names.get(j));
r.createCell(2).setCellValue(prices.get(j));
r.createCell(3).setCellValue(counts.get(j));
   }
workBook.write(new FileOutputStream("C:\\Users\\Ксю\\Desktop\\store.xls"));
workBook.close();
   }
   
   
   
   public void Importsale() throws IOException {
HSSFWorkbook workBook = new HSSFWorkbook();
HSSFSheet sheet = workBook.createSheet(); 
for (int q = 0; q<idssale.size(); ++q) {
HSSFRow row = (HSSFRow) sheet.createRow(q);

row.createCell(0).setCellValue(idssale.get(q));
row.createCell(1).setCellValue(idtovsale.get(q));
row.createCell(2).setCellValue(pricessale.get(q));
row.createCell(3).setCellValue(namessale.get(q));
row.createCell(4).setCellValue(countssale.get(q));
}
workBook.write(new FileOutputStream("C:\\Users\\Ксю\\Desktop\\sale.xls"));
workBook.close();

   }
   
  
    }