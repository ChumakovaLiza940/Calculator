package EquationController;

import EquationModel.EquationModel;
import EquationView.EquationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquationController {
    private EquationView view;
    private EquationModel model;

    public EquationController(EquationView view, EquationModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String equation = view.getEquationInput();

            try {
                double result = model.evaluate(equation);
                int termCount = model.countTerms(equation);
                view.setResult(Double.toString(result));
                view.setTermCount(termCount);
            } catch (Exception ex) {
                view.displayErrorMessage("Invalid equation: " + ex.getMessage());
            }
        }
    }
}
