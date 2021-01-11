package cgb.net;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class BioMainClient {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1", 9999));
		OutputStream out=socket.getOutputStream();
		Scanner sc=new Scanner(System.in);
		System.out.println("client input:");
		out.write(sc.nextLine().getBytes());
		out.close();
		sc.close();
		socket.close();
	}
}
