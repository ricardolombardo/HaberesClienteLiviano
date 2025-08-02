package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import DTO.JerarquiaDTO;
import controladores.Principal;


public class ServicioJerarquias extends Servicio{

	public static List<JerarquiaDTO> getJerarquias() {
		
		String url = "http://localhost:"+Principal.PUERTO+setearRutaServicio("jerarquias/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<JerarquiaDTO> jerarquias = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Mostrar el JSON crudo
            System.out.println("JSON recibido:");
            System.out.println(json);

            // Parsear a lista de objetos Jerarquia
            ObjectMapper mapper = new ObjectMapper();

            jerarquias = mapper.readValue(json, new TypeReference<List<JerarquiaDTO>>() {});
            
            System.out.println("\nJerarquias parseados:");
            for (JerarquiaDTO p : jerarquias) {
            	System.out.println("Id: " + p.getId());
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Monto: " + p.getMonto());
                System.out.println("----");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return jerarquias;
	}
	
}
