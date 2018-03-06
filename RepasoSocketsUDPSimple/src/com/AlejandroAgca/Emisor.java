package com.AlejandroAgca;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Emisor {

	static final int PUERTOEmisor = 5555;
	static final int PUERTOReceptor = 4444;
	static final String IPReceptor = "localhost";
	
	public Emisor() {
		DatagramPacket packete;
		DatagramSocket socket;
		InetAddress IPLocal;
		InetAddress IPRemota;
		String mensaje = "Mi mensaje";
		
		try {
			IPLocal = InetAddress.getByName("0.0.0.0");
			IPRemota = InetAddress.getByName(IPReceptor);
			
			socket = new DatagramSocket(PUERTOEmisor, IPLocal);
			packete = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, IPRemota, PUERTOReceptor);
			
			socket.send(packete);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch(SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Emisor();

	}

}
