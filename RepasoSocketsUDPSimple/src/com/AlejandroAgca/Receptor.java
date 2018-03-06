package com.AlejandroAgca;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Receptor {

	static final int PUERTO = 4444;
	static final String IPEmisor = "0.0.0.0";
	DatagramSocket dtgrmSocket;
	
	public Receptor() {
		try {
			dtgrmSocket = new DatagramSocket(PUERTO, InetAddress.getByName(IPEmisor));
			System.out.println("El emisor se ha conectado al socket: " + dtgrmSocket.getLocalAddress());
			
			while(true) {
			DatagramPacket packet = new DatagramPacket(new byte [144], 144);
			
			dtgrmSocket.receive(packet);
			
			System.out.println("Paquete recibido de: " + packet.getAddress().getHostName());
			
			System.out.println("Longitud del mensaje recibido: " + packet.getLength());
			
			System.out.println("Mensaje deserializado: " + new String(packet.getData()));
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();						
		}
	}
	
	public static void main(String[] args) {
		new Receptor();
	}
}
