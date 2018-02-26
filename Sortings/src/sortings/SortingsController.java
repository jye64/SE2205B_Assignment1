/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
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
import javafx.scene.shape.*;



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
    
    Model model = new Model();
   
   
    @FXML
    public void SetSortStrategy(){
        
        algorithm.getValue().toString();
       
    }
    
    @FXML
    public void sortBtn_Click(){
        
        model.setArraySize((int) arraySizeSlider.getValue());
        model.getUnsortedList();
        

        
    }
    
    @FXML
    public void resetBtn_Click(){
        algorithm.setValue(null);
        arraySizeSlider.setValue(50);
        
    }
    
    @FXML
    public int arraySizeSlider_ValueChanged(){
       return (int)arraySizeSlider.getValue();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        algorithm.getItems().addAll("Merge Sort", "Selection Sort");
        arraySizeSlider.setMin(32);
        arraySizeSlider.setMax(125);
        arraySizeSlider.setValue(50);
        arraySizeSlider.setShowTickMarks(true);
        arraySizeSlider.setShowTickLabels(true);
        arraySize.setText(Double.toString(arraySizeSlider.getValue()));
        
        arraySizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            
            arraySize.setText(Double.toString(newValue.intValue()));
       
        });
   
    }    
    

}
