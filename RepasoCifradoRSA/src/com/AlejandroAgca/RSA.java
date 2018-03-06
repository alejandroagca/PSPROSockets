package com.AlejandroAgca;

import java.rmi.server.UnicastRemoteObject;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSA {

	static final String MENSAJE = "Calvos";
	
	public static void main(String[] args) {
		try {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair claves = generator.generateKeyPair();
		String encriptado = encriptar(claves);
		System.out.println(encriptado);
		System.out.println(desencriptar(encriptado, claves));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static String encriptar(KeyPair claves) throws Exception {
			Cipher encriptador = Cipher.getInstance("RSA");
			encriptador.init(Cipher.ENCRYPT_MODE, claves.getPublic());
			byte [] cifradoEnBytes = Base64.getEncoder().encode(encriptador.doFinal(MENSAJE.getBytes("utf-8")));
			return new String(cifradoEnBytes);			
	}
	
	public static String desencriptar(String mensaje, KeyPair claves) throws Exception {
		Cipher descifrador = Cipher.getInstance("RSA");
		descifrador.init(Cipher.DECRYPT_MODE, claves.getPrivate());
		byte [] descifradoEnBytes = Base64.getDecoder().decode(mensaje);
		return new String(descifrador.doFinal(descifradoEnBytes));
	}
}
