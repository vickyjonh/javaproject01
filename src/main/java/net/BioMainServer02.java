package net;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BioMainServer02 {
    private Logger log=LoggerFactory.getLogger(BioMainServer02.class);	
	private ServerSocket server;
	private ExecutorService executorService;
	private volatile boolean isStop=false;
	private int port;
	
	public BioMainServer02(int port) {
		this.port=port;
	}
	public void doStart()throws Exception {
		server=new ServerSocket(port);
		executorService=Executors.newCachedThreadPool();
		while(!isStop) {
			final Socket socket=server.accept();
			log.info("client connect");
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					doService(socket);
				}
			});
		}
	}
	public void doService(Socket socket) {
		InputStream in=null;
		byte[] buf=new byte[1024];
		int len=-1;
		try {
		 in=socket.getInputStream();
		 while((len=in.read(buf))!=-1) {
			String content=new String(buf,0,len);
			log.info("client say {}", content);
		 }
		}catch(Exception e) {
		  e.printStackTrace();
		  throw new RuntimeException(e);
		}finally {
		 if(in!=null)try{in.close();}catch(Exception e) {}
		}
	}
	public void doStop() {
		isStop=false;
	}
	public static void main(String[] args)throws Exception {
		BioMainServer02 server=new BioMainServer02(9999);
		server.doStart();
	}
}
