package cgb.designPattern.interpreterPattern;

public class Main1 {
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        System.out.println("上海滩：");
        context.setText("O 2 E 300 G 2 A 3 ");
        Expression expression = null;
        try{
            while (context.getText().length()>0) {
                String str = context.getText().substring(0,1);
                switch (str) {
                    case "O" :
                        expression = new Scale();
                        break;
                    case "E":
                        expression = new Speed();
                        break;
                    case "A":
                    case "G" :
                        expression = new Note();
                        break;
                }
                expression.interpret(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
