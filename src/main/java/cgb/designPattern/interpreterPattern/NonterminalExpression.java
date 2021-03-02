package cgb.designPattern.interpreterPattern;


/**
 * 终结符表达式
 */
public class NonterminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
