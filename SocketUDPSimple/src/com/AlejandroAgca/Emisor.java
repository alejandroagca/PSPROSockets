package com.AlejandroAgca;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Emisor{
	
	public static final int PuertoEmisor = 5555;
	public static final int PuertoReceptor = 4444;
	public static String IPReceptor = "192.168.3.57";
	
	public Emisor() {
		DatagramSocket emisor;
		DatagramPacket dgp;
		InetAddress IPLocal;
		InetAddress IPRemota;
		
		//Contruimos el mensaje a enviar
		byte [] contenido = new byte[144];
		String mensaje = "Alejandro Aguilar";
		
		try {
			IPLocal = InetAddress.getByName("0.0.0.0");
			IPRemota = InetAddress.getByName(IPReceptor);
			
			emisor = new DatagramSocket(PuertoEmisor, IPLocal); // Por donde sale el mensaje
			
			contenido = mensaje.getBytes();
			dgp = new DatagramPacket(contenido, contenido.length, IPRemota, PuertoReceptor);
			
			emisor.send(dgp);
			
			
			System.out.println("Datos enviados correctamente");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
			new Emisor();
	}

}
