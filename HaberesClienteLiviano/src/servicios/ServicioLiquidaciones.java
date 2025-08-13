package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import DTO.LiquidacionDTO;

public class ServicioLiquidaciones extends Servicio{
	
	public static List<LiquidacionDTO> getAll(){
		String url = "http://localhost:"+setearRutaServicio("liquidaciones/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<LiquidacionDTO> liquidaciones = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("JSON recibido:");
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();

            liquidaciones = mapper.readValue(json, new TypeReference<List<LiquidacionDTO>>() {});

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return liquidaciones;
	}
	
	public static void crearLiquidacion(LiquidacionDTO liquidacion){
		String url = "http://localhost:"+setearRutaServicio("liquidaciones");

		 // Crear el JSON del cuerpo con Jackson
	     ObjectMapper mapper = new ObjectMapper();

	     ObjectNode liquidacionJson = mapper.createObjectNode();
	     liquidacionJson.put("descripcion", liquidacion.getDescripcion());
	     liquidacionJson.put("anio", liquidacion.getAnio());
	     liquidacionJson.put("mes", liquidacion.getMes());

	     try {
	    	 String requestBody = mapper.writeValueAsString(liquidacionJson);

	         HttpClient client = HttpClient.newHttpClient();
	         HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(url))
	                    .header("Content-Type", "application/json")
	                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	                    .build();

	         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	         System.out.println(response.body());
	         
	         } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	         }
	}
	
	public static void liquidar(LiquidacionDTO liquidacion){
		System.out.println("Inicio Proceso Liquidacion "+liquidacion.getId());
	    String url = "http://localhost:" +setearRutaServicio("liquidaciones/liquidar/" + liquidacion.getId());
	    System.out.println(url);
	    try {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(url))
	                    .GET()
	                    .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        System.out.println(response.body());

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
