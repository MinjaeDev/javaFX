package com.ming.myProject.javaFx;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import org.springframework.stereotype.Component;

@Component
public class ChartController {
    @FXML
    public LineChart<String, Double> chart;
}
