package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import DTO.TareaDTO;
import DTO.TareaLiquidacionDTO;

public class ServicioTareas extends Servicio{
	
	public static List<TareaDTO> getTareas() {
		
		String url = "http://localhost:"+setearRutaServicio("tareas/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<TareaDTO> tareas = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("JSON recibido:");
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();

            tareas = mapper.readValue(json, new TypeReference<List<TareaDTO>>() {});
            
            System.out.println("\nTareas parseados:");
            for (TareaDTO t : tareas) {
            	System.out.println("Id: " + t.getId());
            	System.out.println("Nombre: " + t.getNombre());
            	System.out.println("Descripción: " + t.getDescripcion());
                System.out.println("----");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }   
        return tareas;
	}

	public static List<TareaLiquidacionDTO> getTareaLiquidacion(Long idLiquidacion) {
		
		String url = "http://localhost:"+setearRutaServicio("tareaLiquidacion/porLiquidacion/"+idLiquidacion);
	
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .GET()
	            .build();
	    List<TareaLiquidacionDTO> tareas = null;
	    
	    try {
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        String json = response.body();
	
	        // Mostrar el JSON crudo
	        System.out.println("JSON recibido:");
	        System.out.println(json);
	
	        // Parsear a lista de objetos Tarea
	        ObjectMapper mapper = new ObjectMapper();
	
	        tareas = mapper.readValue(json, new TypeReference<List<TareaLiquidacionDTO>>() {});
	        
	        System.out.println("\nTareas de la Liquidacion: "+idLiquidacion+" "+tareas.size());
	
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }   
	    return tareas;
	}
	
	public static void crearTareaLiquidacion(List<TareaLiquidacionDTO> dtos) {
	    String url = "http://localhost:" + setearRutaServicio("tareaLiquidacion/actualizarPorLiquidacion");
	    System.out.println(url);

	    ObjectMapper mapper = new ObjectMapper();
	    ArrayNode arrayNode = mapper.createArrayNode();

	    for (TareaLiquidacionDTO dto : dtos) {
	        ObjectNode json = mapper.createObjectNode();
	        json.put("idTarea", dto.getIdTarea());
	        json.put("idLiquidacion", dto.getIdLiquidacion());
	        json.put("orden", dto.getOrden());
	        json.put("estadoEjecucion", dto.getEstadoEjecucion());
	        arrayNode.add(json);
	    }

	    try {
	        String requestBody = mapper.writerWithDefaultPrettyPrinter()
	                                   .writeValueAsString(arrayNode);

	        System.out.println("JSON enviado:\n" + requestBody);

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .header("Content-Type", "application/json")
	                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
	                .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        System.out.println("Respuesta:\n" + response.body());

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}



}
