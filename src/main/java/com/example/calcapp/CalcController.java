package com.example.calcapp;

import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {

    @FXML
    private Label printLabel;
    private double firstNumber = Double.NaN;
    private double secondNumber = Double.NaN;
    private int resultNumber  = Integer.MIN_VALUE;
    private String currentNumber = "";
    private  String mathAction = "";
    private boolean dotChecker = false;
    private boolean signChecker = true;

    @FXML
    void addNumber(ActionEvent event) {

        if (resultNumber != Integer.MIN_VALUE) {

            currentNumber = "";
            printLabel.setText("");
            resultNumber = Integer.MIN_VALUE;

        }

        currentNumber += ((Button)event.getSource()).getText();
        if (currentNumber.equals("00") || currentNumber.equals("000")) currentNumber = "0";
        if (signChecker ) printLabel.setText(currentNumber);
        else printLabel.setText("-" + currentNumber);

    }

    @FXML
    void addDot(ActionEvent event) {

        if (!dotChecker){

            dotChecker = true;
            if (!currentNumber.equals("")) currentNumber += ((Button)event.getSource()).getText();
            else currentNumber = "0" + ((Button)event.getSource()).getText();
            printLabel.setText(currentNumber);

        }

    }

    @FXML
    void clearAll(){

        firstNumber = Double.NaN;
        secondNumber = Double.NaN;
        currentNumber = "";
        mathAction = "";
        dotChecker = false;
        signChecker = true;
        printLabel.setText("");

    }

    @FXML
    void changeSign(){

        if (signChecker)
        {
            printLabel.setText("-" + currentNumber);
            signChecker = false;
        }
        else
        {
            printLabel.setText(currentNumber);
            signChecker = true;
        }

    }

    @FXML
    void actionClick(ActionEvent event){

        if (!currentNumber.equals(""))
        {

            mathAction = ((Button)event.getSource()).getText();
            if (signChecker) firstNumber = Double.parseDouble(currentNumber);
            else firstNumber = Double.parseDouble("-" + currentNumber);

            currentNumber = "";
            dotChecker = false;
            signChecker = true;
            printLabel.setText("");

        }

    }

    @FXML
    void percentClick (){

        if (!Double.isNaN(firstNumber) && !currentNumber.equals("")){

            secondNumber = Double.parseDouble(currentNumber);

            switch (mathAction){

                case "+":
                {
                    resultNumber = (int)(firstNumber + firstNumber / 100 * secondNumber);
                    if (resultNumber == (firstNumber + firstNumber / 100 * secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber + firstNumber / 100 * secondNumber).toPlainString());

                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "-":
                {
                    resultNumber = (int)(firstNumber - firstNumber / 100 * secondNumber);
                    if (resultNumber == (firstNumber - firstNumber / 100 * secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber - firstNumber / 100 * secondNumber).toPlainString());

                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "×":
                {
                    resultNumber = (int)(firstNumber / 100 * secondNumber);
                    if (resultNumber == (firstNumber / 100 * secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber / 100 * secondNumber).toPlainString());

                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "÷":
                {
                    if (secondNumber != 0){

                        resultNumber = (int)(firstNumber * 100 / secondNumber);
                        if (resultNumber == (firstNumber * 100 / secondNumber)) printLabel.setText(""+resultNumber);
                        else printLabel.setText(""+new BigDecimal(firstNumber * 100 / secondNumber).toPlainString());

                        firstNumber = Double.NaN;
                        secondNumber = Double.NaN;
                        currentNumber = printLabel.getText();
                        mathAction = "";
                        dotChecker = false;
                        signChecker = true;

                    }
                    break;
                }

            }
        }
    }

    @FXML
    void equalClick (){

        if (!Double.isNaN(firstNumber) && !currentNumber.equals("")){


            if (signChecker) secondNumber = Double.parseDouble(currentNumber);
            else secondNumber = Double.parseDouble("-" + currentNumber);

            switch (mathAction){

                case "+":
                {
                    resultNumber = (int)(firstNumber + secondNumber);
                    if (resultNumber == (firstNumber + secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber + secondNumber).toPlainString());

                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "-":
                {
                    resultNumber = (int)(firstNumber - secondNumber);
                    if (resultNumber == (firstNumber - secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber - secondNumber).toPlainString());


                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "×":
                {
                    resultNumber = (int)(firstNumber * secondNumber);
                    if (resultNumber == (firstNumber * secondNumber)) printLabel.setText(""+resultNumber);
                    else printLabel.setText(""+new BigDecimal(firstNumber * secondNumber).toPlainString());

                    firstNumber = Double.NaN;
                    secondNumber = Double.NaN;
                    currentNumber = printLabel.getText();
                    mathAction = "";
                    dotChecker = false;
                    signChecker = true;
                    break;
                }

                case "÷":
                {
                    if (secondNumber != 0){

                        resultNumber = (int)(firstNumber / secondNumber);
                        if (resultNumber == (firstNumber / secondNumber)) printLabel.setText(""+resultNumber);
                        else printLabel.setText(""+new BigDecimal(firstNumber / secondNumber).toPlainString());

                        firstNumber = Double.NaN;
                        secondNumber = Double.NaN;
                        currentNumber = printLabel.getText();
                        mathAction = "";
                        dotChecker = false;
                        signChecker = true;

                    }
                    break;
                }

            }

        }

    }

    @FXML
    void initialize() {}

}