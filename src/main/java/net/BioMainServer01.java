package net;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于 BIO 实现的简易 server 服务器
 */
public class BioMainServer01 {
    private Logger log= LoggerFactory.getLogger(BioMainServer01.class);
	private ServerSocket server;
	private volatile boolean isStop=false;
	private int port;
	public BioMainServer01(int port) {
		this.port=port;
	}
	public void doStart()throws Exception {
		server=new ServerSocket(port);
		while(!isStop) {
			Socket socket=server.accept();
			log.info("client connect");
			doService(socket);
		}
		server.close();
	}
	public void doService(Socket socket) throws Exception{
		InputStream in=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=-1;
		while((len=in.read(buf))!=-1) {
			String content=new String(buf,0,len);
			log.info("client say {}", content);
		}
		in.close();
		socket.close();
	}
	public void doStop() {
		isStop=false;
	}
	public static void main(String[] args)throws Exception {
		BioMainServer01 server=new BioMainServer01(9999);
		server.doStart();
	}
}
