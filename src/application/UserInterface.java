package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import java.util.*;

public class UserInterface extends Application {
  private HashMap<String, BorderPane> screenMap = new HashMap<>();
  private Scene main;  // Scene to display different panes
  BorderPane root;  // the main menu
  private int loadNum = 0;  // 
  
  /**
   * 
   * @return
   */
  public BorderPane addPane() {
    return null;
  }

  /**
   * This method 
   * @return
   */
  public HBox addButtonForRootScreen() {
    HBox hbox = new HBox();
    Button addButton = new Button("Add Question");  // add button for "add question" screen
    Button loadButton = new Button("Load Question");  // button for "load question" screen
    Button saveButton = new Button("Save");  // button for "save" screen
    // set preferred size
    addButton.setPrefSize(100, 60);
    loadButton.setPrefSize(100, 60);
    saveButton.setPrefSize(100, 60);
    // add buttons to hbox
    hbox.getChildren().addAll(addButton, loadButton, saveButton);
    hbox.setAlignment(Pos.CENTER);
    hbox.setSpacing(10);

    // EventHandler goes here
    addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        activate("add");  // call activate method to set scene
        setupScreens("add");
        System.out.println("add new question");
      }
    });

    loadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        activate("load");
        System.out.println("load questions");
      }
    });

    saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent me) {
        activate("save");  // call activate method to set scene
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
  
  public void initializeScreens() {
    String[] screenNames = {"add", "load1", "load2", "next", "save"};
    for (String name: screenNames) {
      this.addScreen(name);
    }
  }
  
  public void setupScreens(String name) {
    VBox vbox;
    Insets insets = new Insets(10);
    switch(name) {
      case "add":
        vbox = new VBox();
        // Set the text at the top
        screenMap.get(name).setTop(new Text("Add new question"));
        // initialize a HBox for text of the question
        // and add to the vbox
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Text("Text: "), new TextField());
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);  // align to the center
        // initialize a new HBox for topic of the question
        hbox = new HBox();
        hbox.getChildren().addAll(new Text("Topic: "), new TextField());
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);
        // initialize a new HBox for Image file name of the question
        hbox = new HBox();
        hbox.getChildren().addAll(new Text("Image: "), new TextField());
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);
        // initialize a new HBox for texts
        hbox = new HBox();
        hbox.getChildren().add(new Text("Choices: "));
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);
        
        // toggle group of radio buttons so that only one selection can be chosen
        ToggleGroup group = new ToggleGroup();
        RadioButton button = new RadioButton();
        button.setToggleGroup(group);
        button.setSelected(true);
        hbox = new HBox();
        hbox.getChildren().addAll(button, new TextField());
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
          hbox = new HBox();
          button = new RadioButton();
          button.setToggleGroup(group);
          hbox.getChildren().addAll(button, new TextField());
          vbox.getChildren().add(hbox);
          hbox.setAlignment(Pos.CENTER);
        }
        
        Button saveButton = new Button("Save");
        screenMap.get(name).setBottom(saveButton);
        screenMap.get(name).setAlignment(saveButton, Pos.CENTER_RIGHT);
        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent me) {
            main.setRoot(root);
            System.out.println("Go back to root");
          }
        });
        
        screenMap.get(name).setCenter(vbox);
        screenMap.get(name).setAlignment(vbox, Pos.CENTER);
        screenMap.get(name).setMargin(screenMap.get(name).getCenter(), insets);
        screenMap.get(name).setMargin(screenMap.get(name).getBottom(), insets);
        
        break;
      case "load1":
        break;
      case "load2":
        break;
      case "next":
        break;
      case "save":
        vbox = new VBox();
        vbox.getChildren().addAll(new Text("Filename:"), new TextField());
        screenMap.get(name).setTop(new Text("Text"));
        screenMap.get(name).setCenter(vbox);
        screenMap.get(name).setAlignment(vbox, Pos.CENTER);
        screenMap.get(name).setMargin(screenMap.get(name).getTop(), insets);
        screenMap.get(name).setMargin(vbox, insets);
        screenMap.get(name).setBottom(this.addButtonForSaveScreen());
        screenMap.get(name).setMargin(screenMap.get(name).getBottom(), insets);
        break;
    }
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

  /**
   * This method changes scene to desired pane
   * @param name
   */
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
      
      initializeScreens();
      
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
