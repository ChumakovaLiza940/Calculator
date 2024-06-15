import EquationController.EquationController;
import EquationModel.EquationModel;
import EquationView.EquationView;

public class Main {
    public static void main(String[] args) {
        EquationView view = new EquationView();
        EquationModel model = new EquationModel();
        EquationController controller = new EquationController(view, model);
        view.setVisible(true);
    }
}