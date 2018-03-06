package com.AlejandroAgca;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ClienteNTP {

	static final int PUERTORecepcion = 5000;
	static final String IPRemitente = "0.0.0.0";
	
	public ClienteNTP() {
		try {
			InetAddress IP = InetAddress.getByName(IPRemitente);
			DatagramSocket socket = new DatagramSocket(PUERTORecepcion, IP);
			DatagramPacket packet = new DatagramPacket(new byte[200], 200);
			
			while(true) {
				socket.setSoTimeout(5000);
				socket.receive(packet);
				System.out.println(new String(packet.getData()));
			}
		
		}catch(SocketTimeoutException e) {
			System.out.println("TIME OUT");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ClienteNTP();
	}

}
