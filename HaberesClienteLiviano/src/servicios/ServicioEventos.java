package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import DTO.DepartamentoDTO;
import DTO.EventoDTO;
import DTO.EventoNOUDTO;
import DTO.LiquidacionDTO;

public class ServicioEventos extends Servicio{
	
public static List<EventoDTO> getEventos() {
		
		String url = "http://localhost:"+setearRutaServicio("eventos/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<EventoDTO> eventos = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Mostrar el JSON crudo
            System.out.println("JSON recibido:");
            System.out.println(json);

            // Parsear a lista de objetos Eventos
            ObjectMapper mapper = new ObjectMapper();

            eventos = mapper.readValue(json, new TypeReference<List<EventoDTO>>() {});
            
            System.out.println("\nEventos parseados:");
            for (EventoDTO e : eventos) {
            	System.out.println("Id: " + e.getId());
                System.out.println("Descripción: " + e.getDescripcion());
                System.out.println("----");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }   
        return eventos;
	}

	public static void crearEvento(EventoDTO evento){
		String url = "http://localhost:"+setearRutaServicio("eventos");
	    ObjectMapper mapper = new ObjectMapper();
	    ObjectNode json = mapper.createObjectNode();
	    json.put("descripcion", evento.getDescripcion());
	    json.put("identificador", evento.getIdentificador());
	
	    try {
	    	String requestBody = mapper.writeValueAsString(json);
	
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
	
	public static void crearEventoNOU(EventoNOUDTO eventoNOU, Long NouId) {
	    String url = "http://localhost:" + setearRutaServicio("eventosNOUs");
	    ObjectMapper mapper = new ObjectMapper();

	    ObjectNode json = mapper.createObjectNode();

	    json.put("fechaInicio", eventoNOU.getFechaInicio().toString());
	    json.put("fechaFin", eventoNOU.getFechaFin().toString());

	    // Subobjeto evento con solo el id
	    ObjectNode eventoNode = mapper.createObjectNode();
	    eventoNode.put("id", eventoNOU.getEvento().getId());
	    json.set("evento", eventoNode);

	    // Subobjeto nou con solo el id
	    ObjectNode nouNode = mapper.createObjectNode();
	    nouNode.put("id", NouId);
	    json.set("nou", nouNode);

	    try {
	        // Convertir a string para enviar
	        String requestBody = mapper.writerWithDefaultPrettyPrinter()
	                                   .writeValueAsString(json);

	        // Mostrar el JSON generado
	        System.out.println("JSON enviado:\n" + requestBody);

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

}
