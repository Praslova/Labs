/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopv2;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Ксю
 */
public class work {

    int ChoiceProductsid;
    int ChoiceProductscount;
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> ids = new ArrayList<>();
    private HashMap<Integer, goods> goodsID = new HashMap<>();
    private HashMap<Integer, salegoods> salesID = new HashMap<>();
    int z = 0;//счетчик количества позиций в списке товаров
    int a = 0; // счетчик количества продаж 

    public void Filestoreread() throws IOException { //считывание текста из файла товаров магазина
        POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream("C:\\Users\\Ксю\\Desktop\\store.xls"));
        HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workBook.getSheetAt(0);

        Iterator<Row> rows = sheet.rowIterator();

        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            int id = (int) row.getCell(0).getNumericCellValue();
            String name = (String) row.getCell(1).getStringCellValue();
            int count = (int) row.getCell(3).getNumericCellValue();
            int price = (int) row.getCell(2).getNumericCellValue();

            goods p = new goods(id, name, price, count);
            this.goodsID.put(p.getID(), p);
            ids.add(id);

            z++;

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
            String name = (String) row.getCell(3).getStringCellValue();
            int count = (int) row.getCell(4).getNumericCellValue();

            salegoods q = new salegoods(id, idtov, price, name, count);
            this.salesID.put(q.getID(), q);
            a++;
        }
    }

    public void Filetable() {
        for (int i = 0; i < z; i++) {
            goods t = this.goodsID.get(ids.get(i));
            t.GoodsShow();
        }
    }

    public void Sale() throws IOException {
        boolean flag = true;

        while (flag) {
            try {

                System.out.println("Введите id товара");
                Scanner scanner = new Scanner(System.in);

                ChoiceProductsid = scanner.nextInt();

                if (this.goodsID.containsKey(ChoiceProductsid)) {
                    goods t = this.goodsID.get(ChoiceProductsid);
                    System.out.println("Введите количество товара");
                    ChoiceProductscount = scanner.nextInt();
                    t.buyProduct(ChoiceProductscount);
                    a++;
                    int pricesale = t.getPrice() * ChoiceProductscount;
                    String namesale = t.getName();
                    salegoods newsale = new salegoods(a, ChoiceProductsid, pricesale, namesale, ChoiceProductscount);
                    this.salesID.put(newsale.getID(), newsale);
                } else {
                    System.out.println("Товар не найден");
                }
            } catch (Exception e) {
                System.out.println("Ошибка");
            }

            System.out.println("1.Назад\n2.Продолжить покупки\n");
            String choice;
            choice = BR.readLine();

            switch (choice) {
                case "1":
                    flag = !flag;
                    break;
            }
        }
    }

    public void deliveryproducts() throws IOException {
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Введите id поставляемого товара");
                Scanner scandelivery = new Scanner(System.in);

                int deliveryid;
                int deliverycounts;
                deliveryid = scandelivery.nextInt();

                if (this.goodsID.containsKey(deliveryid)) {
                    goods t = this.goodsID.get(deliveryid);
                    System.out.println("Введите количество товара");
                    deliverycounts = scandelivery.nextInt();
                    t.addProduct(deliverycounts);
                } else {
                    z++;
                    System.out.println("Товар не найден\n Введите id товара");
                    int newid = scandelivery.nextInt();
                    ids.add(newid);
                    System.out.println("Введите название товара");
                    String newname;
                    newname = BR.readLine();
                    System.out.println("Введите цену товара");
                    int newprice = scandelivery.nextInt();

                    System.out.println("Введите количество товара");
                    int newcount = scandelivery.nextInt();
                    goods newgood = new goods(newid, newname, newprice, newcount);
                    this.goodsID.put(newgood.getID(), newgood);

                }
            } catch (Exception e) {
                System.out.println("Ошибка");
            }

            System.out.println("1.Назад\n2.Продолжить покупки\n");
            String choice;
            choice = BR.readLine();

            switch (choice) {
                case "1":
                    flag = !flag;
                    break;
            }
        }
    }

    public void salestable() {
        for (int i = 1; i <= a; i++) {
            salegoods t = this.salesID.get(i);
            t.GoodsShow();
        }
    }

    public void infosales() throws IOException {
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("\nВведите id продажи для вывода информации");
                Scanner scan = new Scanner(System.in);
                int ChoiceSaleid = scan.nextInt();
                if (this.salesID.containsKey(ChoiceSaleid)) {
                    salegoods t = this.salesID.get(ChoiceSaleid);
                    System.out.println("Введите количество товара");

                    t.ShowInfo();
                }
            } catch (Exception e) {
                System.out.println("Ошибка");
            }

            System.out.println("1.Назад\n2.Продолжить вывод информации\n");
            String choice;
            choice = BR.readLine();

            switch (choice) {
                case "1":
                    flag = !flag;
                    break;
            }
        }
    }

    public void Importstore() throws IOException {
        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet();
        Set<Integer> keys = goodsID.keySet();

        int nr = 0;
        for (Integer key : keys) {
            HSSFRow r = sheet.createRow(nr);
            nr += 1;
            goods p = goodsID.get(key);

            r.createCell(0).setCellValue(p.getID());
            r.createCell(1).setCellValue(p.getName());
            r.createCell(2).setCellValue(p.getPrice());
            r.createCell(3).setCellValue(p.getCount());
        }
        workBook.write(new FileOutputStream("C:\\Users\\Ксю\\Desktop\\store.xls"));
        workBook.close();
    }

    public void Importsale() throws IOException {
        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet();
        Set<Integer> keys = salesID.keySet();

        int nr = 0;
        for (Integer key : keys) {
            HSSFRow r = sheet.createRow(nr);
            nr += 1;
            salegoods p = salesID.get(key);

            r.createCell(0).setCellValue(p.getID());
            r.createCell(1).setCellValue(p.getName());
            r.createCell(2).setCellValue(p.getPrice());
            r.createCell(3).setCellValue(p.getCount());
        }
        workBook.write(new FileOutputStream("C:\\Users\\Ксю\\Desktop\\sale.xls"));
        workBook.close();
    }
}
