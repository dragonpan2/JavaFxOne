/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author panbe
 */
public class JavaFXApplication1 extends Application {

    @Override
    public void start(Stage primaryStage)  {
        String barCode;
        Button btnTest = new Button();
        Button btnOperation = new Button("Operation");
        Button btnStatistic = new Button("Statistic");
        Button btnManagement = new Button("Administration");
        Button btnExpansion = new Button("Expansion");
        HBox hboxTop = new HBox(0);
        StackPane root = new StackPane();
        Pane paneOperation = new Pane();
        Pane paneAdmin = new Pane();
        
        Pane selection = new Pane();
        selection.setVisible(false);

        hboxTop.getChildren().addAll(btnOperation, btnStatistic, btnManagement, btnExpansion);
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPrefSize(100, 200);

        TabPane tabPane = new TabPane();
        tabPane.setStyle("-fx-background-color:#2c3e50;");
        Tab tabOperation = new Tab("Operation");
        Tab tabManagement = new Tab("Administration");
        Tab tabStatistic = new Tab("Statistic");
        Tab tabExpansion = new Tab("Expansion");
        tabOperation.setClosable(false);
        tabManagement.setClosable(false);
        tabStatistic.setClosable(false);
        tabExpansion.setClosable(false);
        tabPane.getTabs().addAll(tabOperation, tabStatistic, tabManagement, tabExpansion);
        
        //misc label
        Label statut = new Label("Awaiting Input...");
        
        // l1 hbox
        HBox hBoxOne = new HBox();
        //VBox label description product
        VBox vboxLabel = new VBox();
        vboxLabel.setSpacing(10);
        Label lblProductCode = new Label("Product Code Bar");
        Label lblProductName = new Label("Name");
        Label lblProductPrice = new Label("Price");
        lblProductCode.setTextFill(Color.web("#bdc3c7"));
        lblProductName.setTextFill(Color.web("#bdc3c7"));
        lblProductPrice.setTextFill(Color.web("#bdc3c7"));
        lblProductCode.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        lblProductName.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        lblProductPrice.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vboxLabel.getChildren().addAll(lblProductCode, lblProductName, lblProductPrice);
        //-------------------------------
        //VBox ScanValue  product
        VBox vboxTF = new VBox();
        TextField TFProductCode = new TextField("-");
        TextField TFProductName = new TextField("-");
        TextField TFProductPrice = new TextField("0");
        TFProductCode.setAlignment(Pos.CENTER);
        TFProductName.setAlignment(Pos.CENTER);
        TFProductPrice.setAlignment(Pos.CENTER);

        vboxTF.getChildren().addAll(TFProductCode, TFProductName, TFProductPrice);
        hBoxOne.getChildren().addAll(vboxLabel,vboxTF);
        hBoxOne.setSpacing(25);
        hBoxOne.setMaxSize(350, 50);
        
        StackPane stackH1 = new StackPane();
        stackH1.getChildren().add(hBoxOne);
        stackH1.setStyle("-fx-background-color:#2c3e50;");
        stackH1.setStyle("-fx-background-color: #34495e;");
        stackH1.setLayoutX(250);
        stackH1.setLayoutY(50);
        stackH1.setPrefSize(450, 100);
        StackPane.setAlignment(hBoxOne,Pos.CENTER);
        paneOperation.getChildren().add(stackH1);
        
        //--------------------------------
        //description User
        HBox hBoxTwo = new HBox();
        StackPane stackH2 = new StackPane();
        VBox vboxLabelUser = new VBox();
        vboxLabelUser.setSpacing(10);
        Label lblUserID = new Label("Card ID");
        Label lblUserName = new Label("Name");
        Label lblUserBalance = new Label("Account Balance");
        lblUserID.setTextFill(Color.web("#bdc3c7"));
        lblUserName.setTextFill(Color.web("#bdc3c7"));
        lblUserBalance.setTextFill(Color.web("#bdc3c7"));
        lblUserID.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        lblUserName.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        lblUserBalance.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vboxLabelUser.getChildren().addAll(lblUserID, lblUserName, lblUserBalance);
        
        //TF2
        VBox vboxTF2 = new VBox();
        TextField TFID = new TextField("-");
        TextField TFName = new TextField("-");
        TextField TFBalance = new TextField("0");
        TFID.setEditable(false);
        TFName.setEditable(false);
        TFBalance.setEditable(false);
        TFID.setAlignment(Pos.CENTER);
        TFName.setAlignment(Pos.CENTER);
        TFBalance.setAlignment(Pos.CENTER);
        vboxTF2.getChildren().addAll(TFID, TFName,TFBalance);
        
        //
        hBoxTwo.setSpacing(25);
        hBoxTwo.setMaxSize(350, 50);
        hBoxTwo.getChildren().addAll(vboxLabelUser,vboxTF2);
        stackH2.getChildren().addAll(hBoxTwo);
       // stackH2.setStyle("-fx-background-color:#2c3e50;");
        stackH2.setStyle("-fx-background-color: #34495e;");
        stackH2.setLayoutX(250);
        stackH2.setLayoutY(200);
        stackH2.setPrefSize(450, 100);
         paneOperation.getChildren().add(stackH2);
         vboxLabelUser.setLayoutX(250);
         vboxLabelUser.setLayoutY(150);
         
        //-----------------------------
        btnTest.setText("Button Exemple");
        btnOperation.setPrefSize(100, 50);
        btnStatistic.setPrefSize(100, 50);
        btnManagement.setPrefSize(100, 50);
        btnExpansion.setPrefSize(100, 50);
        TextField textField = new TextField("123");
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Exemple");
            }
        });
        //-----------------------------
        
        ///Operation: Instruction
        StackPane stackIns = new StackPane();
        stackIns.setPrefSize(550, 100);
        VBox instructionVBox = new VBox();
        instructionVBox.setMaxSize(500, 50);
        
        Label insLogin = new Label("To Login: Scan your card until your information is on the screen");
        Label insLogout = new Label("To Logout: Scan your card again while logged in");
        Label insProduct = new Label("To Examine a product: Scan the produit whille logged out");
        Label insBuy = new Label("To Buy a product: First log in with your card then scan the product");
        insLogin.setTextFill(Color.web("#bdc3c7"));
        insLogout.setTextFill(Color.web("#bdc3c7"));
        insProduct.setTextFill(Color.web("#bdc3c7"));
        insBuy.setTextFill(Color.web("#bdc3c7"));
        //
        insLogin.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        insLogout.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        insProduct.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        insBuy.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        instructionVBox.getChildren().addAll(insLogin,insLogout, insProduct, insBuy);
        stackIns.getChildren().add(instructionVBox);
        stackIns.setLayoutX(250);
        stackIns.setLayoutY(450);
        stackIns.setStyle("-fx-background-color: #34495e;");
        
        paneOperation.getChildren().add(stackIns);
        
        paneOperation.setStyle("-fx-background-color:#2c3e50;");
     //   paneOperation.setStyle("-fx-background-color: #34495e;");
        tabOperation.setContent(paneOperation);
        tabManagement.setContent(paneAdmin);
        //root.getChildren().addAll(btnTest,hboxTop);
        root.getChildren().add(tabPane);
        Scene scene = new Scene(root, 1000, 700);
    //    scene.setFill(Color.DARKGREY);
        
         ///-------------------------------------------------------------------------------------------------------------------------------------------------------
         //Admin tab
         ///login tab
         Pane loginPane = new Pane();
         StackPane loginStack = new StackPane();
         PasswordField passField = new PasswordField();
         passField.setAlignment(Pos.CENTER);
         Label passLabel = new Label("Passcode");
         Button passBtn = new Button("Confirm");
         
         passBtn.setTextFill(Color.web("#bdc3c7"));
         passBtn.setFont(Font.font("Abel",FontWeight.BOLD, 12));
         passBtn.setStyle("-fx-background-color: #2E4053;");
         
         loginStack.setAlignment(Pos.CENTER);
         loginPane.setMaxSize(260, 150);
         loginStack.setMinSize(1000, 700);
         loginPane.setStyle("-fx-background-color: #34495e;");
         
         passLabel.setLayoutX(5);
         passField.setLayoutX(75);
         passLabel.setLayoutY(50);
         passField.setLayoutY(50);
         passBtn.setLayoutY(100);
         passBtn.setLayoutX(100);
         
         passLabel.setTextFill(Color.web("#bdc3c7"));
         passLabel.setFont(Font.font("Abel",FontWeight.BOLD, 12));
          
         loginPane.getChildren().addAll(passField, passLabel, passBtn);
         loginStack.getChildren().addAll(loginPane);
         paneAdmin.getChildren().add(loginStack);
         passBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (passField.getText().equals("1")) {
                    loginStack.setVisible(false);
                    selection.setVisible(true);
                    passField.clear();
                }
            }
        });
         ///seletion menu
         
         VBox selectionVB = new VBox();
         selectionVB.setAlignment(Pos.CENTER);
         selectionVB.setSpacing(4);
         Button addProductBtn = new Button("Add new Product");
         Button addUserBtn = new Button("Add new User");
         Button manageProductBtn = new Button("Manage Inventory");
         Button manageUserBtn = new Button("Manage Users");
         Button logoutBtn = new Button("Logout");
         
         addProductBtn.setPrefSize(150, 20);
         addUserBtn.setPrefSize(150, 20);
         manageProductBtn.setPrefSize(150, 20);
         manageUserBtn.setPrefSize(150, 20);
         logoutBtn.setPrefSize(150, 20);
         
         Pane newUserPane = new Pane();
         Pane newProductPane = new Pane();
         Pane manageUserPane = new Pane();
         Pane manageProductPane = new Pane();
         
          iniNewProduct(newProductPane, selection);
          iniNewUser(newUserPane, selection);
          
         paneAdmin.getChildren().add(newProductPane);         
         paneAdmin.getChildren().add(manageProductPane);
         paneAdmin.getChildren().add(newUserPane);
         paneAdmin.getChildren().add(manageUserPane);
         
         addProductBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newProductPane.setVisible(true);
                    selection.setVisible(false);
                
            }
        });
         addUserBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  selection.setVisible(false);
                  newUserPane.setVisible(true);
            }
        });
         manageProductBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  selection.setVisible(false);
                   System.out.println("Open manager");
              //    manageProductPane.setVisible(true);
                   iniManageProduct(manageProductPane, selection);
            }
        });
         manageUserBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  selection.setVisible(false);
                  manageUserPane.setVisible(true);
            }
        });
         logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 selection.setVisible(false);
                 loginStack.setVisible(true);
            }
        });
         selectionVB.getChildren().addAll(addProductBtn,addUserBtn,manageProductBtn,manageUserBtn, logoutBtn);
         StackPane stackPaneSelection = new StackPane();
         stackPaneSelection.setAlignment(Pos.CENTER);
         stackPaneSelection.setLayoutX(400);
         stackPaneSelection.setLayoutY(250);
         stackPaneSelection.getChildren().add(selectionVB);
         stackPaneSelection.setMaxSize(250, 350);
         stackPaneSelection.setMinSize(200, 200);
       selection.getChildren().add(stackPaneSelection);
       stackPaneSelection.setStyle("-fx-background-color: #34495e;");
   //      selection.getChildren().add(selectionVB);
         paneAdmin.getChildren().add(selection);
        ///-----------------------------------------------------------------------------------------------------------------------------------------------------
        //  stage >scene > root > component 
        primaryStage.setTitle("PolyPhoto Inventory Management v0.1");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void iniNewProduct(Pane newProductPane, Pane selection) {
     
        
        Label lblProductCode = new Label("Product Code Bar");
        Label lblProductName = new Label("Name");
        Label lblProductPrice = new Label("Price");
        Label lblProductQuantity = new Label("Quantity");
        TextField TFProductCode = new TextField("-");
        TextField TFProductName = new TextField("-");
        TextField TFProductPrice = new TextField("0");
        TextField TFProductQuantity = new TextField("0");
        
        GridPane newProductGrid = new GridPane();
        
        newProductGrid.add(lblProductCode, 0, 0);
        newProductGrid.add(lblProductName, 0, 1);
        newProductGrid.add(lblProductPrice, 0, 2);
        newProductGrid.add(lblProductQuantity, 0, 3);
        
        newProductGrid.add(TFProductCode, 1, 0);
        newProductGrid.add(TFProductName, 1, 1);
        newProductGrid.add(TFProductPrice, 1, 2);
        newProductGrid.add(TFProductQuantity, 1, 3);
        
        newProductGrid.setStyle("-fx-background-color:#2c3e50;");
        newProductPane.setVisible(false);
        
        Button createButton = new Button("Create New Product");
        Button backButton = new Button("Return to previous menu");
        
        createButton.setLayoutX(50);
        createButton.setLayoutY(50);
        backButton.setLayoutX(50);
        backButton.setLayoutY(100);
        newProductPane.getChildren().addAll(newProductGrid, createButton,backButton);
        
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            ProductList productList = new ProductList();
            productList.productList = new ArrayList<Product>();
           productList = Main.readProductDataFile(productList);
            Product product = new Product();
            product.setProductCode(TFProductCode.getText());
            product.setProductName(TFProductName.getText());
            product.setPrice(Integer.parseInt(TFProductPrice.getText()));
            product.setQuantityLeft(Integer.parseInt(TFProductQuantity.getText()));
            productList.productList.add(product);
            Main.writeProdctDataFile(productList);
            }
        });
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newProductPane.setVisible(false);
                selection.setVisible(true);
            }
        });
        
        
    }
    public void iniNewUser(Pane newUserPane, Pane selection) {
         Label lblUserID = new Label("Card Bar Code");
         Label lblUserName = new Label("UserName");
         Label lblUserFund = new Label("Fund");
         TextField TFUserID = new TextField("0");
         TextField TFUserName = new TextField("-");
         TextField TFUserFund = new TextField("0");
         
           GridPane newUserGrid = new GridPane();
        
        newUserGrid.add(lblUserID, 0, 0);
        newUserGrid.add(lblUserName, 0, 1);
        newUserGrid.add(lblUserFund, 0, 2);
        
        newUserGrid.add(TFUserID, 1, 0);
        newUserGrid.add(TFUserName, 1, 1);
        newUserGrid.add(TFUserFund, 1, 2);
        
       newUserGrid.setStyle("-fx-background-color:#2c3e50;");
        newUserPane.setVisible(false);
        
        Button createButton = new Button("Create New User");
        Button backButton = new Button("Return to previous menu");
        
        createButton.setLayoutX(150);
        createButton.setLayoutY(100);
        backButton.setLayoutX(150);
        backButton.setLayoutY(150);
        newUserPane.getChildren().addAll(newUserGrid, createButton,backButton);
        
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              //  Main.firstTimeProtocol();
            UserList userListMaster = new UserList();
            userListMaster.userList = new ArrayList<User>();
            Main.readUserDataFile(userListMaster);
            User user = new User();
            
            user.setCardId(TFUserID.getText());
            user.setUsername(TFUserName.getText());
            user.setBalance(Integer.parseInt(TFUserFund.getText())); //careful now
            userListMaster.userList.add(user);
            Main.writeUserDataFile(userListMaster);
            }
        });
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newUserPane.setVisible(false);
                selection.setVisible(true);
            }
        });
        
    }
    public void iniManageProduct(Pane manageProductPane, Pane selection) {
       // manageProductPane.setVisible(false);
        ScrollPane productScrollPane = new ScrollPane();
        ProductList masterProductList = new ProductList();
        masterProductList.productList = new ArrayList<Product>();
     masterProductList =  Main.readProductDataFile(masterProductList);
        
        Button backButton = new Button("Return");
        manageProductPane.getChildren().add(backButton);
        backButton.setLayoutX(400);
        backButton.setLayoutY(50);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  selection.setVisible(true);
               //   manageProductPane.setVisible(false);
               //   manageProductPane
            }
        });
        
        for (int i = 0; i < masterProductList.productList.size(); i++) {
          System.out.println("Size: " + masterProductList.productList.size());
          System.out.println(i);
          System.out.println(     masterProductList.productList.get(i).getProductName());
               
//        HBox hBoxOne = new HBox();
//        VBox vboxLabel = new VBox();
//        vboxLabel.setSpacing(10);
//        
//        Label lblProductCode = new Label("Product Code Bar");
//        Label lblProductName = new Label("Name");
//        Label lblProductPrice = new Label("Price");
//        Label lblProductQuantity = new Label("Quantity");
//        lblProductCode.setTextFill(Color.web("#bdc3c7"));
//        lblProductName.setTextFill(Color.web("#bdc3c7"));
//        lblProductPrice.setTextFill(Color.web("#bdc3c7"));
//        lblProductQuantity.setTextFill(Color.web("#bdc3c7"));
//        lblProductCode.setFont(Font.font("Abel",FontWeight.BOLD, 12));
//        lblProductName.setFont(Font.font("Abel",FontWeight.BOLD, 12));
//        lblProductPrice.setFont(Font.font("Abel",FontWeight.BOLD, 12));
//        lblProductQuantity.setFont(Font.font("Abel",FontWeight.BOLD, 12));
//        vboxLabel.getChildren().addAll(lblProductCode, lblProductName, lblProductPrice,lblProductQuantity);
//
//        VBox vboxTF = new VBox();
//        TextField TFProductCode = new TextField("-");
//        TextField TFProductName = new TextField("-");
//        TextField TFProductPrice = new TextField("0");
//        TextField TFProductQuantity = new TextField("0");
//        TFProductCode.setAlignment(Pos.CENTER);
//        TFProductName.setAlignment(Pos.CENTER);
//        TFProductPrice.setAlignment(Pos.CENTER);
//        TFProductQuantity.setAlignment(Pos.CENTER);
//
//        vboxTF.getChildren().addAll(TFProductCode, TFProductName, TFProductPrice,TFProductQuantity);
//        hBoxOne.getChildren().addAll(vboxLabel,vboxTF);
//        hBoxOne.setSpacing(25);
//        hBoxOne.setMaxSize(350, 50);
//        
//        StackPane stackH1 = new StackPane();
//        stackH1.getChildren().add(hBoxOne);
//        stackH1.setStyle("-fx-background-color:#2c3e50;");
//        stackH1.setStyle("-fx-background-color: #34495e;");
//        stackH1.setLayoutX(250);
//        stackH1.setLayoutY(50*(1+i));
//        stackH1.setPrefSize(450, 100);
//        stackH1.setAlignment(hBoxOne,Pos.CENTER);
//        productScrollPane.getChildrenUnmodifiable().add(stackH1);
//        manageProductPane.getChildren().add(productScrollPane);
        }
    }
    public void iniManageUser(Pane manageUserPane, Pane selection) {
        manageUserPane.setVisible(false);
         Button backButton = new Button("Return");
        manageUserPane.getChildren().add(backButton);
        backButton.setLayoutX(400);
        backButton.setLayoutY(50);
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  selection.setVisible(true);
                  manageUserPane.setVisible(false);
            }
        });
        
        
        
        
    }



}
