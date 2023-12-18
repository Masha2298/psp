package part1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends Frame implements ActionListener {
    private TextField operand1field, operand2field, resultfield;
    private CheckboxGroup operationCheckboxGroup;
    public Calculator(){
        setTitle("Calculator");
        setSize(400, 200);
        setLayout(new GridLayout(4,2));

        Label operand1label = new Label("Operand 1:");
        operand1field = new TextField();
        add(operand1label);
        add(operand1field);
        Label operand2label = new Label("Operand 2:");
        operand2field = new TextField();
        add(operand2label);
        add(operand2field);
        Label operationLabel = new Label("Operation:");
        add(operationLabel);
        operationCheckboxGroup = new CheckboxGroup();
        Checkbox sumCheckbox = new Checkbox("Сумма", operationCheckboxGroup, false);
        Checkbox subtractionCheckbox = new Checkbox("Разность", operationCheckboxGroup, false);
        Checkbox divisionCheckbox = new Checkbox("Деление", operationCheckboxGroup, false);
        Checkbox multiplicationCheckbox = new Checkbox("Умножение", operationCheckboxGroup, false);
        Checkbox clearCheckbox = new Checkbox("Стереть", operationCheckboxGroup, false);
        add(sumCheckbox);
        add(subtractionCheckbox);
        add(divisionCheckbox);
        add(multiplicationCheckbox);
        add(clearCheckbox);

        Button calculateButton = new Button("Калькулятор");
        calculateButton.addActionListener(this);
        add(calculateButton);

        Label resultLabel = new Label("Результат:");
        resultfield = new TextField();
        resultfield.setEditable(false);
        add(resultLabel);
        add(resultfield);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double operand1 = Double.parseDouble(operand1field.getText());
        double operand2 = Double.parseDouble(operand2field.getText());
        double result = 0;

        if (operationCheckboxGroup.getSelectedCheckbox().getLabel().equals("Сумма")){
            result = operand1 + operand2;
        }
        else if (operationCheckboxGroup.getSelectedCheckbox().getLabel().equals("Вычитание")){
            result = operand1 - operand2;
        }
        else if (operationCheckboxGroup.getSelectedCheckbox().getLabel().equals("Деление")){
            result = operand1 / operand2;
        }
        else if (operationCheckboxGroup.getSelectedCheckbox().getLabel().equals("Умножение")){
            result = operand1 * operand2;
        }
        else if (operationCheckboxGroup.getSelectedCheckbox().getLabel().equals("Стереть")){

            operand1field.setText("");
            operand2field.setText("");
            resultfield.setText("");
            return;
        }
        resultfield.setText(Double.toString(result)); }

    public static void main(String[] args) {
        new Calculator();
    }

    }

