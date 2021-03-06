package fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import simple.ConnectionUtil;

/**
 * @author 徒有琴
 */
public class FanoutSender {
    //direct指定路由key，key要完全匹配才能收到，竞争消费，一条消息只能被一个消费者消费
    //fanout不指定key,不需要匹配key,广播模式，一条消息只能被多个消费者消费，注意业务中不要重复处理（别重复给浩哥发钱）
    private static String exchange_name = "exchanhe_name_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange_name, BuiltinExchangeType.FANOUT);
        String message = "hello abc fanout";
        channel.basicPublish(exchange_name, "", null, message.getBytes());
        channel.close();
        connection.close();
    }
}
