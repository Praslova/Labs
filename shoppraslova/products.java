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
   private ArrayList<String> names = new ArrayList<>();
   private ArrayList<Integer> ids = new ArrayList<>();
   private ArrayList<Integer> counts = new ArrayList<>();
   private ArrayList<Integer> prices = new ArrayList<>();
   
  /* ArrayList<Integer> pricessale = new ArrayList();
   ArrayList<Integer> idssale = new ArrayList();
   ArrayList<Integer> countssale = new ArrayList();
   ArrayList<String> namessale = new ArrayList();*/
int i;
int s=0;
int p=0;
    public void Filetable() throws IOException  {
        
POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream("C:\\Users\\Ксю\\Desktop\\store.xls"));
HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
HSSFSheet sheet = workBook.getSheetAt(0);

Iterator<Row> rows = sheet.rowIterator();

 i=0;
while (rows.hasNext()) {
HSSFRow row = (HSSFRow) rows.next();
int id = (int) row.getCell(0).getNumericCellValue();
String name = row.getCell(1).getStringCellValue();
int count = (int) row.getCell(3).getNumericCellValue();
int price = (int) row.getCell(2).getNumericCellValue();
i++;
names.add(name);
counts.add(count);
ids.add(id);
prices.add(price);

}
for(int k=0; k<i; k++) {
System.out.print(ids.get(k));
System.out.print(" "+names.get(k));
System.out.print(" "+prices.get(k));
System.out.println(" "+counts.get(k));
    }

    }

   public void  Sale () throws IOException
   { boolean flag = true;
        while(flag){
            try{
       System.out.println("Введите id товара");
   
    Scanner scanner = new Scanner(System.in);
    
    int ChoiceProductsid = scanner.nextInt();
    System.out.println("Введите количество товара");
    int ChoiceProductscount = scanner.nextInt(); 
      
    if(ids.contains(ChoiceProductsid))
    { p = ids.indexOf(ChoiceProductsid);
      if ((counts.get(p)-ChoiceProductscount)<0)
          System.out.println("Недостаточно товара на складе");
      else {counts.set(p, counts.get(p)-ChoiceProductscount);
      }
    }
    else System.out.println("Товар не найден");
        
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

  public void deliveryproducts() throws IOException{
   boolean flag = true;
        while(flag){
            try{
       System.out.println("Введите id поставляемого товара");
       Scanner scandelivery = new Scanner(System.in);
  
       int deliveryid;
       int deliverycounts;
       deliveryid = scandelivery.nextInt();
       System.out.println("Введите количество поставляемого товара");
       deliverycounts = scandelivery.nextInt();
       
       if(ids.contains(deliveryid))
    { p = ids.indexOf(deliveryid);
      counts.set(p, counts.get(p)+deliverycounts);
      
    }
    else System.out.println("Товар не найден");
        
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
   
   public void salestable() throws IOException {
/*POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream("C:\\Users\\Ксю\\Desktop\\sale.xls"));
HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
HSSFSheet sheet = workBook.getSheetAt(0);
Iterator<Row> rows = sheet.rowIterator();
rows.next();
while (rows.hasNext()) {
HSSFRow row = (HSSFRow) rows.next();
int idsale = (int) row.getCell(0).getNumericCellValue();
int pricesale = (int) row.getCell(1).getNumericCellValue();
int countsale = (int) row.getCell(2).getNumericCellValue();
String namesale = row.getCell(3).getStringCellValue();
s++;
idssale.add(idsale);
pricessale.add(pricesale);
countssale.add(countsale);
namessale.add(namesale);
}
for(int k=0; k<s; k++) {
System.out.print(idssale.get(k));
System.out.print(" "+pricessale.get(k));
    }
*/       
   }
   public void Import() throws IOException{
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
   
   public void infosales(){
    /*   Scanner scan = new Scanner(System.in);
       int ChoiceSaleid = scan.nextInt();
    
       for(int k=0; k<s; k++)
       if (idssale.get(k)==ChoiceSaleid) 
       { System.out.print(idssale.get(k));
         System.out.print(" "+namessale.get(k));
         System.out.print(" "+countssale.get(k));
         System.out.print(" "+pricessale.get(k));}
     */  
   }
    }