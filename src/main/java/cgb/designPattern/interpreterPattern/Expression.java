package cgb.designPattern.interpreterPattern;

/**
 * 表达式类
 */
public abstract class Expression {
    public void interpret(PlayContext context) {
        if(context.getText().length() == 0) {
            return;
        } else {
            // 将当前的演奏文本第一条命令获得命令字母和其参数值，例如“O 3 E 0.5 G 0.5 A 3”,则playKey为O，而playValue为3
            String playKey = context.getText().substring(0,1);
            context.setText(context.getText().substring(2));
            double playValue = Double.parseDouble(context.getText().substring(0,
                    context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
            execute(playKey,playValue);

        }
    }

    public abstract void execute(String key,double value);
}
