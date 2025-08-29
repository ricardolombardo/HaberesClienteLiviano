package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import DTO.TituloDTO;

public class ServicioTitulos extends Servicio{

public static List<TituloDTO> getTitulos() {
		
		String url = "http://localhost:"+setearRutaServicio("titulos/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<TituloDTO> titulos = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Mostrar el JSON crudo
            System.out.println("JSON recibido:");
            System.out.println(json);

            ObjectMapper mapper = new ObjectMapper();
            titulos = mapper.readValue(json, new TypeReference<List<TituloDTO>>() {});
            
            System.out.println("\n Titulos parseados:");
            for (TituloDTO t : titulos) {
            	System.out.println("Id: " + t.getId());
                System.out.println("Descripcion: " + t.getDescripcion());
                System.out.println("Monto: " + t.getMonto());
                System.out.println("----");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return titulos;
	}
	
}
