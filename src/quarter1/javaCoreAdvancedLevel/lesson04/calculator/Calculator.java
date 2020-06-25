package quarter1.javaCoreAdvancedLevel.lesson04.calculator;

public class Calculator {

    private String display = "0.0";
    private String history ="";
    private double result = 0;
    String last ="";

    public void btnFun(String textBtn) {


        if (this.display.equals("0") || this.display.equals("0.0") || this.last.equals("=")) {
            return;
        }

        if (textBtn.equals("=")) {
            calculate(this.last);
            setHistory(this.display+"="+result);
            this.last = "=";
            displayClear();
            return;
        }


            calculate(this.last);
            setHistory(this.display+textBtn);
            this.last = textBtn;
            displayClear();

    }

    private void calculate(String textBtn) {
        double num = Double.parseDouble(this.display);

        if (this.last.equals("")) {
            this.result = num;
            return;
        }


        if (textBtn.equals("+")) {
            this.result += num;
        }
        if (textBtn.equals("-")) {
            this.result -= num;
        }
        if (textBtn.equals("*")) {

            if (this.result == 0){
                this.result = num;
            } else {
                System.out.println("1***"+this.result);
                this.result *= num;
                System.out.println("2***"+this.result);
            }

        }
        if (textBtn.equals("/")) {
            if (this.result == 0){
                this.result = num;
            } else {
                this.result /= num;
            }

        }
    }

    private void displayClear() {
        display = "0.0";
    }

    private void setHistory(String text){
        this.history +=text;
    }

    public void setDisplay(String text) {
        if (last.equals("=")){
            last ="";
            history ="";
            result = 0;
        }

        if (display.equals("0.0")) {
            display = text;
        }else {
            display += text;
        }

    }

    public String getDisplay() {
        return display;
    }

    public String getHistory() {
        return history;
    }

    public String getResult() {
        return ""+result;
    }

    public void clear() {
        this.display = "0.0";
        this.history = "";
        this.last = "";
        this.result = 0;
    }
}
