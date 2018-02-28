/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 *
 * @author alanye
 */
public class SortingsController implements Initializable {
    
    @FXML
    private ComboBox algorithm;
    
    @FXML
    private Slider arraySizeSlider;
    
    @FXML
    private Pane view;
    
    @FXML
    private Label arraySize;
    
    @FXML
    Button sort;
    @FXML
    Button reset;
    @FXML
    Button exit;
           
    Model model = new Model();
    
    private String choice;
    
    
    @FXML
    public void SetSortStrategy(){
        choice = algorithm.getValue().toString();
    }
    
    @FXML
    public void exitBtn_Click(){
        Stage stage = (Stage)view .getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void sortBtn_Click(){
        
       if (choice == "Merge Sort"){
           MergeSort merge = new MergeSort();
           merge.sort(model.getUnsortedList());
           new Thread(()->{
               try{
                   while(true){
                       Platform.runLater(()->{
                           update(model.getUnsortedList());
                       });
                       Thread.sleep(50);   
                   }
               }catch (InterruptedException ex){
                   
               }
           
           }).start();
            
           
       }else if (choice == "Selection Sort"){
           
           SelectionSort select = new SelectionSort();
           select.sort(model.getUnsortedList());
           new Thread(()-> {  
               try{
                   while(true){
                   Platform.runLater(()->{  
                       update(model.getUnsortedList());
                   });
                   Thread.sleep(50);    
                   }
               }
               catch (InterruptedException ex){
                   
               }
           }).start();   
       }
  
    }
    
    @FXML
    public void resetBtn_Click(){
        
        model.reset((int)arraySizeSlider.getValue());
        update(model.getUnsortedList());
       
    }
    
    @FXML
    public void arraySizeSlider_ValueChanged(){
        
        model.reset((int)arraySizeSlider.getValue());
        update(model.getUnsortedList());
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        algorithm.getItems().addAll("Selection Sort","Merge Sort");
        arraySizeSlider.setMin(32);
        arraySizeSlider.setMax(125);
        arraySizeSlider.setValue(50);
//        arraySizeSlider.setShowTickMarks(true);
//        arraySizeSlider.setShowTickLabels(true);
        arraySize.setText(Double.toString(arraySizeSlider.getValue()));
        
        arraySizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            arraySize.setText(Double.toString(newValue.intValue()));
            arraySizeSlider_ValueChanged();
        }); 
        
        resetBtn_Click();
   
    }    
    
    public void update(int [] Arr){
        
        view.getChildren().clear();
        for (int i=0; i<arraySizeSlider.getValue(); i++){
            double width  = (view.widthProperty().getValue()/arraySizeSlider.getValue());
            double height = (Arr[i]/arraySizeSlider.getValue())*view.heightProperty().getValue();

            double x = width*i;
            double y = view.heightProperty().getValue()-height;

            Rectangle r = new Rectangle();
            r.setX(x);
            r.setY(y);
            r.setWidth(width-1);
            r.setHeight(height);
            r.setFill(Color.RED);
            
            view.getChildren().add(r);
        }
    }
    

}
