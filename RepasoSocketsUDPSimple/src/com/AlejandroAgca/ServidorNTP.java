package com.AlejandroAgca;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorNTP {

	static final int PUERTOEmisor = 4999;
	static final int PUERTOReceptor = 5000;
	static final String IPEmisor = "0.0.0.0";
	static final String IPReceptor = "localhost";
	
	public ServidorNTP() {
		Date fecha = new Date(System.currentTimeMillis());
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
		String fechaString = formato.format(fecha);
		try {
			InetAddress IPLocal = InetAddress.getByName(IPEmisor);
			InetAddress IPRemota = InetAddress.getByName(IPReceptor);
			
			DatagramSocket socket = new DatagramSocket(PUERTOEmisor, IPLocal);
			DatagramPacket packet = new DatagramPacket(fechaString.getBytes(), fechaString.getBytes().length, IPRemota, PUERTOReceptor);
			
			socket.send(packet);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServidorNTP();
	}
}
