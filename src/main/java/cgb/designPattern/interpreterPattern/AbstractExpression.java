package cgb.designPattern.interpreterPattern;

/**
 * 声明一个抽象的解释操作
 */
public abstract class AbstractExpression {
    public abstract void interpret(Context context);
}
