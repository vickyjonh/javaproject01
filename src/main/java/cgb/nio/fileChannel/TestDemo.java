package cgb.nio.fileChannel;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO是基于通道（Channel）和缓冲区（Buffer）进行操作，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中
 */
public class TestDemo {
	@Test
	public void write() throws Exception{
		// 获取文件通道。基于某种流（比如文件输出流或输入流来创建)
		FileChannel fc = new FileOutputStream(new File("1.txt")).getChannel();
		ByteBuffer buffer = ByteBuffer.wrap("helloWorld".getBytes());
		fc.write(buffer);
		fc.close();

	}

	@Test
	public void read() throws Exception{
		FileChannel fc = new FileInputStream(new File("1.txt")).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(10);
		// 文件通道可以通过位置灵活的操作数据
		// 文件通道底层可以使用zero copy 零拷贝技术
		fc.position(4);
		fc.read(buffer);
		System.out.println(new String(buffer.array()));
		fc.close();
	}

	@Test
	public void testWrite() throws Exception {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		FileChannel fileChannel = new FileInputStream("1.txt").getChannel();
		// 用来发送文件的大小
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf.asLongBuffer().put(fileChannel.size());
		sc.write(buf);
		fileChannel.transferTo(0,fileChannel.size(),sc);
		fileChannel.close();
		sc.close();
	}

	@Test
	public void testRead() throws Exception{
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.bind(new InetSocketAddress(8888));
		SocketChannel sc = ssc.accept();
		FileChannel fileChannel = new FileOutputStream("2.txt").getChannel();
		ByteBuffer buf = ByteBuffer.allocate(8);
		sc.read(buf);
		buf.flip();
		long fileSize = buf.getLong();
		System.out.println("fileSize:"+fileChannel.size());
		fileChannel.transferFrom(sc,0,fileSize);
		fileChannel.close();
	}
}
