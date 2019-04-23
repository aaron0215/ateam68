package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import java.awt.TextField;
import java.util.*;

public class UserInterface extends Application {
  private HashMap<String, BorderPane> screenMap = new HashMap<>();
  private Scene main;
  BorderPane root;

  public BorderPane addPane() {
    return null;
  }

  public HBox addButtonForRootScreen() {
    HBox hbox = new HBox();
    Button add = new Button("Add Question");
    Button load = new Button("Load Question");
    Button save = new Button("Save");
    add.setPrefSize(100, 60);
    load.setPrefSize(100, 60);
    save.setPrefSize(100, 60);
    hbox.getChildren().addAll(add, load, save);
    hbox.setAlignment(Pos.CENTER);
    hbox.setSpacing(10);

    // EventHandler goes here
    add.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        System.out.println("add new question");
      }
    });

    load.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        System.out.println("load questions");
      }
    });

    save.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        activate("save");
        System.out.println("save questions");
      }
    });

    return hbox;
  }
  
  public HBox addButtonForSaveScreen() {
    HBox hbox = new HBox();
    Button save = new Button("Save");
    save.setPrefSize(100, 60);
    hbox.getChildren().addAll(save);
    hbox.setAlignment(Pos.CENTER_RIGHT);
    
    save.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        main.setRoot(root);
        System.out.println("Go back to root");
      }
    });
    
    return hbox;
  }

  public TextField addQuestion() {
    return null;
  }

  public CheckBox addCheckBox() {
    return null;
  }

  public ComboBox addComboBox() {
    return null;
  }

  public void addScreen(String name) {
    BorderPane pane = new BorderPane();
    screenMap.put(name, pane);
  }

  protected void removeScreen(String name) {
    screenMap.remove(name);
  }

  protected void activate(String name) {
    main.setRoot(screenMap.get(name));
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      root = new BorderPane();
      main = new Scene(root, 400, 400);

      Text title = new Text("Quiz Generator");
      title.setFont(Font.font("Courier", 26));
      root.setTop(title);
      root.setAlignment(title, Pos.CENTER);
      root.setCenter(this.addButtonForRootScreen());
      
      this.addScreen("save");
      screenMap.get("save").setTop(new Text("Text"));
      screenMap.get("save").setBottom(this.addButtonForSaveScreen());
      
      main.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(main);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch(args);
  }

  // private class SceneNode{
  // private String name;
  // private BorderPane pane;
  //
  // SceneNode(String name) {
  // this.name = name;
  // pane = new BorderPane();
  // }
  //
  // private String getName() {
  // return name;
  // }
  //
  // private BorderPane getBorderPane() {
  // return pane;
  // }
  //
  // private void updatePane(BorderPane pane) {
  // this.pane = pane;
  // }
  // }

}
