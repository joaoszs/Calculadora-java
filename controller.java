import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller implements ActionListener 
{
    private view calcView;
    private StringBuilder currentInput;
    private double firstNumber;
    private String operator;

    public controller(view calcView) 
    {
        this.calcView = calcView;
        this.currentInput = new StringBuilder();
        this.firstNumber = 0;
        this.operator = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) 
        {
            currentInput.append(command);
            calcView.getDisplay().setText(currentInput.toString());
        } else if (command.matches("[/*\\-+]")) {
            firstNumber = Double.parseDouble(currentInput.toString());
            operator = command;
            currentInput.setLength(0);
        } else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (operator) 
            {
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "+":
                    result = firstNumber + secondNumber;
                    break;
            }

            calcView.getDisplay().setText(String.valueOf(result));
            currentInput.setLength(0);
        }
    }
}