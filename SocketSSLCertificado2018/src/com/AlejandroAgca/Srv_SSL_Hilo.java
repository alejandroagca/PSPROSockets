package com.AlejandroAgca;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLSocket;

public class Srv_SSL_Hilo extends Thread {

	SSLSocket miSocket;
	public Srv_SSL_Hilo(SSLSocket unSocket) {
		this.miSocket = unSocket;
	}
	
	@Override
	public void run() {
		InputStreamReader is;
		try {
			is = new InputStreamReader(miSocket.getInputStream(), "utf8");
			BufferedReader br = new BufferedReader(is);
			String mensajeRecibido = br.readLine();
			System.out.println("Mensaje recibido desde el cliente: " + mensajeRecibido);
			
			//Enviamos como respuesta el mensaje en hash SHA-256
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(miSocket.getOutputStream()), true);
			byte[] mensajeEnBytes = mensajeRecibido.getBytes("utf8");
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			pw.println(sha.digest(mensajeEnBytes));
			pw.flush(); //Por si acaso
			pw.close();
			System.out.println("Cerrando socket y el hilo de atención");
			miSocket.close();
		} 
		
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
