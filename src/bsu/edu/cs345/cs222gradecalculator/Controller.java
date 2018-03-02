package bsu.edu.cs345.cs222gradecalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.text.DecimalFormat;


public class Controller {

    public Label Iteration1FractionGrade;
    public Label Iteration2FractionGrade;
    public Label Iteration3FractionGrade;
    public Label FinalFractionGrade;
    public Label Iteration1PercentGrade;
    public Label Iteration2PercentGrade;
    public Label Iteration3PercentGrade;
    public Label FinalPercentGrade;
    private Iteration iteration1 = new Iteration(32);
    private Iteration iteration2 = new Iteration(128);
    private Iteration iteration3 = new Iteration(320);
    private double finalGrade;

    public void updateIterationCodeGrade(ActionEvent actionEvent) {
        RadioButton button = (RadioButton) actionEvent.getSource();
        if (button.getId().equals("1")) {
            iteration1.setCodeQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else if (button.getId().equals("2")){
            iteration2.setCodeQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else if (button.getId().equals("3")){

            iteration3.setCodeQuality(Integer.parseInt(button.getAccessibleText()));
        }
        calculateFinalGrade();
    }
    public void updateIterationProcessGrade(ActionEvent actionEvent) {
        RadioButton button = (RadioButton) actionEvent.getSource();
        if (button.getId().equals("1")) {
            iteration1.setProcessQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else if (button.getId().equals("2")){
            iteration2.setProcessQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else {
            iteration3.setProcessQuality(Integer.parseInt(button.getAccessibleText()));
        }
        calculateFinalGrade();
    }

    public void updateIterationPresentationGrade(ActionEvent actionEvent) {
        RadioButton button = (RadioButton) actionEvent.getSource();
        if (button.getId().equals("1")) {
            iteration1.setPresentationQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else if (button.getId().equals("2")){
            iteration2.setPresentationQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else {
            iteration3.setPresentationQuality(Integer.parseInt(button.getAccessibleText()));
        }
        calculateFinalGrade();
    }

    public void updateIterationReflectionGrade(ActionEvent actionEvent) {
        RadioButton button = (RadioButton) actionEvent.getSource();
        if (button.getId().equals("1")) {
            iteration1.setReflectionQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else if (button.getId().equals("2")){
            iteration2.setReflectionQuality(Integer.parseInt(button.getAccessibleText()));
        }
        else {
            iteration3.setReflectionQuality(Integer.parseInt(button.getAccessibleText()));
        }
        calculateFinalGrade();
    }



    private double calculateFinalGrade(){
        finalGrade = (iteration1.calculateIterationGrade() + iteration2.calculateIterationGrade() + iteration3.calculateIterationGrade());
        displayFinalGrade(finalGrade);
        return finalGrade;
    }

    private void displayFinalGrade(double finalGrade){

        DecimalFormat df = new DecimalFormat("###.##");

        Iteration1FractionGrade.setText(df.format(iteration1.calculateIterationGrade())+"/32");
        Iteration2FractionGrade.setText(df.format(iteration2.calculateIterationGrade())+"/128");
        Iteration3FractionGrade.setText(df.format(iteration3.calculateIterationGrade())+"/320");
        FinalFractionGrade.setText(df.format(finalGrade)+"/480");
        Iteration1PercentGrade.setText(df.format((iteration1.calculateIterationGrade()/32)*100)+"%");
        Iteration2PercentGrade.setText(df.format((iteration2.calculateIterationGrade()/128)*100)+"%");
        Iteration3PercentGrade.setText(df.format((iteration3.calculateIterationGrade()/320)*100)+"%");
        FinalPercentGrade.setText(df.format((finalGrade/480)*100)+"%");

    }

}
