package com.unbosque.mbController;


public class CifrarClave {

	public String cifradoClave(String claveTextoPlano) {
		String claveTextoCifrado = GeneraClave.getStringMessageDigest(
				claveTextoPlano, GeneraClave.MD5);

		return claveTextoCifrado;

	}
}
