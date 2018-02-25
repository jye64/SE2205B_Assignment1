/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
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

/**
 *
 * @author alanye
 */
public class SortingEngineController implements Initializable {
    
    @FXML
    private ComboBox algorithm;
    
    @FXML
    private Slider arraySizeSlider;
    
    @FXML
    private Pane view;
    
    @FXML
    private Label arraySizeLabel;
    
    @FXML
    Button sort;
    @FXML
    Button reset;
    
    final ObservableList<String> data = FXCollections.observableArrayList();
    
    @FXML
    public void SetSortStrategy(){
        
    }
    
    @FXML
    public void sortBtn_Click(){
        int arraySize = (int) arraySizeSlider.getValue();
    }
    
    @FXML
    public void resetBtn_Click(){
        algorithm.setValue(null);
        arraySizeSlider.setValue(50);
        
    }
    
    @FXML
    public void arraySizeSlider_ValueChanged(){
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        algorithm.getItems().addAll("Merge Sort", "Selection Sort");
        arraySizeSlider.setMin(0);
        arraySizeSlider.setMax(100);
        arraySizeSlider.setValue(50);
        arraySizeSlider.setShowTickMarks(true);
        arraySizeSlider.setShowTickLabels(true);
        
        arraySizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            arraySizeLabel.setText(Double.toString(newValue.intValue()));
            
        });
            
    }    
    
}
