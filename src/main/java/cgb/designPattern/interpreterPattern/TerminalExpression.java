package cgb.designPattern.interpreterPattern;


/**
 * 终结符表达式
 */
public class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
