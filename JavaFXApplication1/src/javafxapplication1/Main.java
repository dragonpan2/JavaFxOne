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
    private static String previousType = "null";
    private static int previousUserIndice = -1;
    private static int previousProductIndice = -1;
    public void MainMethod() {
        
        
        
    }
    
    public void buyOperation() {

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
                
                readReturn.productIndice = productIndice;
                readReturn.userIndice = userIndice;
                
                System.out.println("ReadOperation Debut:");
                System.out.println("PreviousType: "+previousType);
                System.out.println("PreviousProductIndice: " +previousProductIndice);
                System.out.println("PreviousUserIndice: " +previousUserIndice);
                System.out.println("ProductIndice: "+productIndice);
                System.out.println("UserIndice: " +userIndice);
                System.out.println("---------------------");
                
        if (userIndice != -1 && productIndice != -1) {
            previousType = "both";
            //major problem, barcode is in both database
            previousProductIndice = -1;
            previousUserIndice = -1;
        }
        else if (productIndice != -1 && !previousType.equals("user")) {
            //just a product scan
            previousType = "product";
            previousProductIndice = productIndice;
            previousUserIndice = -1;
        }
        else if (productIndice != -1 && previousType.equals("user")) {
            //buying product
            previousType = "null";
            previousProductIndice = -1;
            previousUserIndice = -1;
            
            System.out.println("Buying product");
                double userBalance = userListMaster.userList.get(userIndice).getBalance();
                int quantity = productListMaster.productList.get(productIndice).getQuantityLeft();
                double itemPrice = productListMaster.productList.get(productIndice).getPrice();
                
                userListMaster.userList.get(userIndice).setBalance(userBalance-itemPrice);
                productListMaster.productList.get(productIndice).setQuantityLeft(quantity-1);
                        
        }
        else if (userIndice != -1 && !previousType.equals("product")) {
            //
            previousType = "user";
            previousProductIndice = -1;
            previousUserIndice = userIndice;
            System.out.println("userIndice != -1 && !previousType.equals(\"product\")");
        }
        else if (userIndice != -1 && previousType.equals("product")) {
            //then it's a user lookup
            ///next is wait for product then do buy
            previousType = "user";
            previousProductIndice = -1;
            previousUserIndice = userIndice;

        }
        
        if (productIndice == -1 && userIndice != -1) {
            previousType = "null";
            previousProductIndice = -1;
            previousUserIndice = -1;
        }
        
        else {
            previousProductIndice = -1;
            previousUserIndice = -1;
            previousType = "null";
            // barcode is not in any database
            /// next is ready for new operation
        }
        
        ///saved all database
        writeUserDataFile(userListMaster);
        writeProdctDataFile(productListMaster);
        readReturn.productListMaster = productListMaster;
        readReturn.userListMaster = userListMaster;
        //readReturn.productIndice = productIndice;
        //readReturn.userIndice = userIndice;
        
        return readReturn;
    }
    public static void writeUserDataFile (UserList userListMaster) {
        System.out.println("Writing UserData");
        try {
        FileOutputStream fileOut = new FileOutputStream("userData.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userListMaster);
        out.close();
        fileOut.close();
        }
        
        catch (IOException i) {
            i.printStackTrace();
            System.out.println("Exception");
        }
        System.out.println("UserData Written");
    }
    public static void writeProdctDataFile (ProductList productListMaster) {
        System.out.println("Writing ProductData");
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
        System.out.println("ProductData Written");
    }
    public static ProductList readProductDataFile(ProductList productListMaster) {
        System.out.println("Reading ProductList");
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
        System.out.println("ProductList Read");
        return productListMaster;
    }
    public static UserList readUserDataFile(UserList userListMaster) {
        System.out.println("Reading UserList");
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
        System.out.println("UserList Read");
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
