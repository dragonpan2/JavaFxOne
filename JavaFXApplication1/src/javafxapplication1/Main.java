/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author panbe
 */
public class Main {
    public void MainMethod() {
        
        
        
    }
    
    public void buyOperation() {
//        readUserDataFile(userListMaster);
//        readProductDataFile(productListMaster);
//        
//        productListMaster.productList.get(1);
//        //userListMaster.userList.get(1).buyProduct();
//        
//        userListMaster.lookUpUser(null);
//        productListMaster.lookUpProduct(null);
//        
//        writeUserDataFile(userListMaster);
//        writeProdctDataFile(productListMaster);
    }
    public void userProductLookup(String barcode) {
        
        
        
    }
    public static ReadReturn readOperation(String barCode, int userIndice, int productIndice) {
        ReadReturn readReturn = new ReadReturn();
        ProductList productListMaster = new ProductList();
        UserList userListMaster = new UserList();
        
        userListMaster.userList = new ArrayList<User>();
        productListMaster.productList = new ArrayList<Product>();
        
        productListMaster = readProductDataFile(productListMaster);
        userListMaster = readUserDataFile(userListMaster);
        
                userIndice= userListMaster.lookUpUser(barCode);
                productIndice = productListMaster.lookUpProduct(barCode);
        if (userIndice != -1 && productIndice == userIndice) {
            //major problem, barcode is in both database
        }
        if (userIndice != -1) {
            //then it's a user lookup
            ///next is wait for product then do buy
        }
        else if (productIndice != -1) {
            
            if (userIndice != -1 && productIndice != userIndice) {
                double userBalance = userListMaster.userList.get(userIndice).getBalance();
                int quantity = productListMaster.productList.get(productIndice).getQuantityLeft();
                double itemPrice = productListMaster.productList.get(productIndice).getPrice();
                
                userListMaster.userList.get(userIndice).setBalance(userBalance-itemPrice);
                productListMaster.productList.get(productIndice).setQuantityLeft(quantity-1);
            }
            //then the barcode is in product data base
            ///next is diplay product information
        }
        
        else {
            // barcode is not in any database
            /// next is ready for new operation
        }
        
        ///saved all database
        writeUserDataFile(userListMaster);
        writeProdctDataFile(productListMaster);
        
        return readReturn;
    }
    public static void writeUserDataFile (UserList userListMaster) {
        try {
            
        FileOutputStream fileOut = new FileOutputStream("userData.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userListMaster);
        out.close();
        fileOut.close();
        }
        
        catch (IOException i) {
            
            System.out.println("Exception");
        }
    }
    public static void writeProdctDataFile (ProductList productListMaster) {
        System.out.println("Writing File");
        try {
        FileOutputStream fileOut = new FileOutputStream("productData.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(productListMaster);
        out.close();
        fileOut.close();
        }
        
        catch (IOException i) {
            i.printStackTrace();
            System.out.println("Exception");
        }
        System.out.println("File Writed");
    }
    public static ProductList readProductDataFile(ProductList productListMaster) {
        System.out.println("Reading File");
        try {
        FileInputStream fileIn = new FileInputStream("productData.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        productListMaster = (ProductList) in.readObject();
        in.close();
        fileIn.close();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Exception");
        }
        catch (IOException i) {
            i.printStackTrace();
            System.out.println("Exception");
        }
        System.out.println("File Read");
       // System.out.println(productListMaster.productList.get(0).getProductCode());
        return productListMaster;
    }
    public static UserList readUserDataFile(UserList userListMaster) {
        try {
        FileInputStream fileIn = new FileInputStream("userData.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        userListMaster = (UserList) in.readObject();
        in.close();
        fileIn.close();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Exception");
        }
        catch (IOException i) {
            System.out.println("Exception");
        }
        return userListMaster;
    }
    public static void addNewProduct(ProductList productListMaster, String productCode, String productName, double price, int quantityToAdd) {
        Product newProduct = new Product();
        
        newProduct.setProductCode(productCode);
        newProduct.setProductName(productName);
        newProduct.setPrice(price);
        newProduct.setQuantityLeft(quantityToAdd);
        
        productListMaster.productList.add(newProduct);
    }
    public static void addNewProduct(ProductList productListMaster, String productCode, String productName, double price) {
        Product newProduct = new Product();
        newProduct.setProductCode(productCode);
        newProduct.setProductName(productName);
        newProduct.setPrice(price);
        newProduct.setQuantityLeft(0);
        
        productListMaster.productList.add(newProduct);
    }
    public static void addNewUser(UserList userListMaster, String idBarcode, String name, double balance ) {
        User newUser = new User();
        newUser.setCardId(idBarcode);
        newUser.setUsername(name);
        newUser.setBalance(balance);
        
        
        userListMaster.userList.add(newUser);
    }
    public void userBalanceAdjust(User user,double adjustAmount) {
        user.setBalance(user.getBalance()+adjustAmount);
    }
    public void productPriceAdjust(Product product, double newPrice) {
        product.setPrice(newPrice);
    }
    public void productAdjustQuantity(Product product,int quantityAdjust) {
        product.setQuantityLeft(product.getQuantityLeft()+quantityAdjust);
    }
    public static void firstTimeProtocol() {
        System.out.println("Executing First Time Protocol");
        try {
        FileOutputStream fileOut = new FileOutputStream("productData.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(new ProductList());
        out.close();
        fileOut.close();
        }
        
        catch (IOException i) {
            
            System.out.println("Exception");
        }
        System.out.println("Done");
    }
}
