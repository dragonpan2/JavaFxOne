/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        hboxTop.getChildren().addAll(btnOperation, btnStatistic, btnManagement, btnExpansion);
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPrefSize(100, 200);

        TabPane tabPane = new TabPane();
        tabPane.setStyle("-fx-background-color:#2c3e50;");
        Tab tabOperation = new Tab("Operation");
        Tab tabManagement = new Tab("Administration");
        Tab tabStatistic = new Tab("Statistic");
        Tab tabExpansion = new Tab("Expansion");
       // tabOperation.setStyle("-fx-background-color:#2c3e50;");
        tabOperation.setClosable(false);
        tabManagement.setClosable(false);
        tabStatistic.setClosable(false);
        tabExpansion.setClosable(false);
        tabPane.getTabs().addAll(tabOperation, tabStatistic, tabManagement, tabExpansion);
        
        //misc label
        Label statut = new Label("Awaiting Input...");
        
        
        //VBox label description product
        VBox vboxLabel = new VBox();
        vboxLabel.setSpacing(10);
        Label lblProductCode = new Label("Product Code Bar");
        Label lblProductName = new Label("Name");
        Label lblProductPrice = new Label("Price");
        lblProductCode.setTextFill(Color.web("#bdc3c7"));
        lblProductCode.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vboxLabel.getChildren().addAll(lblProductCode, lblProductName, lblProductPrice);
        paneOperation.getChildren().add(vboxLabel);
        vboxLabel.setLayoutX(250);
        vboxLabel.setLayoutY(50);
      //  vboxLabel.setStyle("-fx-background-color: #757575;");
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
        paneOperation.getChildren().add(vboxTF);
        vboxTF.setLayoutX(550);
        vboxTF.setLayoutY(50);
        //--------------------------------
        //description User
        VBox vboxLabelUser = new VBox();
        vboxLabelUser.setSpacing(10);
        Label lblUserID = new Label("Card ID");
        Label lblUserName = new Label("Name");
        Label lblUserBalance = new Label("Account Balance");
        vboxLabelUser.getChildren().addAll(lblUserID, lblUserName, lblUserBalance);
         paneOperation.getChildren().add(vboxLabelUser);
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
        
         
        
        paneOperation.setStyle("-fx-background-color: #34495e;");
        tabOperation.setContent(paneOperation);
        tabManagement.setContent(paneAdmin);
        //root.getChildren().addAll(btnTest,hboxTop);
        root.getChildren().add(tabPane);
        Scene scene = new Scene(root, 1000, 800);
    //    scene.setFill(Color.DARKGREY);
        
         
        
        adminTabIni(paneAdmin);
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
    
    public  void adminTabIni(Pane paneAdmin) {
        /// create new user
        /// create new product
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
        paneAdmin.getChildren().add(newProductGrid);
   //    GridPane.setStyle("-fx-background-color:#2c3e50;");
        
        /// manager user
        ///manage inventory
        
    }

//    public void keyPressed(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key != KeyEvent.VK_ENTER) {
//            System.out.println("Triggered");
//        } else {
//
//        }
//    }

}
