package servicios;

import controladores.Principal;

public class Servicio {
	
	private static String rutaServicio;
	
	public static String setearRutaServicio(String servicio) {
		if(Principal.PUERTO.equals("8081")) {
			rutaServicio="/"+servicio;
		}else {
			rutaServicio="/HaberesMonolitico-0.0.1-SNAPSHOT/"+servicio;
		}
		
		return rutaServicio;
	}

}
