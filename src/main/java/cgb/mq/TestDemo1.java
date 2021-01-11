package cgb.mq;

/**
 * 使用 Java 代码连接 RabbitMQ 有以下两种方式
 */
public class TestDemo1 {
    /*public static Connection GetRabbitConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Config.UserName);
        factory.setPassword(Config.Password);
        factory.setVirtualHost(Config.VHost);
        factory.setHost(Config.Host);
        factory.setPort(Config.Port);
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection GetRabbitConnection2() {
        ConnectionFactory factory = new ConnectionFactory();
        // 连接格式：amqp://userName:password@hostName:portNumber/virtualHost
        String uri = String.format("amqp://%s:%s@%s:%d%s", Config.UserName, Config.Password, Config.Host, Config.Port,
                Config.VHost);
        Connection conn = null;
        try {
            factory.setUri(uri);
            factory.setVirtualHost(Config.VHost);
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }*/
}
