package servicios;

import constantes.Modo;
import controladores.Principal;

public class Servicio {
	
	private static String rutaServicio;
	
	public static String setearRutaServicio(String servicio) {
		/*
		if(Principal.modo.equals(Modo.DESARROLLO)) {
			rutaServicio=Principal.getPuerto()+"/"+servicio;
		}else {
			rutaServicio=Principal.getPuerto()+"/HaberesMonolitico-0.0.1-SNAPSHOT/"+servicio;
		}
		*/
		
	    rutaServicio = Principal.modo.equals(Modo.DESARROLLO)
	        ? Principal.getPuerto()+"/"+servicio
	        : Principal.getPuerto()+"/HaberesMonolitico-0.0.1-SNAPSHOT/"+servicio;
		
		return rutaServicio;
	}

}
