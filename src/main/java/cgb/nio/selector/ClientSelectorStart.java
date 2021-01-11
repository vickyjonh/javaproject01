package cgb.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Selector是Java NIO中实现多路复用技术的关键，多路复用技术又是提高通讯性能的一个重要因素
 * 通道触发了一个事件意思是该事件已经就绪。所以，某个 channel 成功连接到另一个服务器称为“连接就绪”。一个server socket channel准备好接收新进入的连接称为“接收就绪”。一个有数据可读的通道可以说是“读就绪”。等待写数据的通道可以说是“写就绪”。
 *
 * 这四种事件用SelectionKey的四个常量来表示：
 * 1)  SelectionKey.OP_CONNECT
 * 2)  SelectionKey.OP_ACCEPT
 * 3)  SelectionKey.OP_READ
 * 4)  SelectionKey.OP_WRITE
 */
public class ClientSelectorStart {
	
	public static void main(String[] args) throws Exception {
		SocketChannel sc=SocketChannel.open();
		sc.configureBlocking(false);
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		//Selector的创建通过调用Selector.open()方法创建一个Selector
		Selector selector=Selector.open();
		// 客户端注册选择器，并监听连接事件
		sc.register(selector, SelectionKey.OP_CONNECT);
		
		while(true){
			selector.select();
			Set<SelectionKey> set= selector.selectedKeys();
			Iterator<SelectionKey> it=set.iterator();
			
			while(it.hasNext()){
				SelectionKey sk= it.next();
				//channel与Selector一起使用时，Channel必须处于非阻塞模式下。
				// 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。
				// 而套接字通道都可以。
				// 表示客户端成功连接服务端
				if(sk.isConnectable()){
					SocketChannel client=(SocketChannel) sk.channel();
					client.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
					
				}
				// 服务端发数据过来，我们客户端读数据
				if(sk.isReadable()){
					SocketChannel client=(SocketChannel) sk.channel();
					ByteBuffer data=ByteBuffer.allocate(10);
					while(data.hasRemaining()){
						client.read(data);
					}
				}
				// 表示我们客户端要给服务发数据，而且服务端已准备好
				if(sk.isWritable()){
					
				}
				it.remove();
			}
	
		}
	}

}
