package com.ming.myProject.javaFx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

public class TextController {

    public ToggleButton toggle;
    public TextField leftText;
    public TextField rightText;
    public Text result;

    public void toggleClick() {
        if (toggle.isSelected()) {
            result.setText(leftText.getText());
        } else {
            result.setText(rightText.getText());
        }
    }
}
