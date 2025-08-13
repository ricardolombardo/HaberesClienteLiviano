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
import DTO.DepartamentoDTO;

public class ServicioDepartamentos extends Servicio{
		
	public static List<DepartamentoDTO> getDepartametos() {
		
		String url = "http://localhost:"+setearRutaServicio("departamentos/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<DepartamentoDTO> departamentos = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Mostrar el JSON crudo
            System.out.println("JSON recibido:");
            System.out.println(json);

            // Parsear a lista de objetos Departamento
            ObjectMapper mapper = new ObjectMapper();

            departamentos = mapper.readValue(json, new TypeReference<List<DepartamentoDTO>>() {});
            
            System.out.println("\nDepartamentos parseados:");
            for (DepartamentoDTO d : departamentos) {
            	System.out.println("Id: " + d.getId());
                System.out.println("Nombre: " + d.getNombre());
                System.out.println("Descripción: " + d.getDescripcion());
                System.out.println("----");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return departamentos;
	}
	
	
	public static void updateDepartamento(DepartamentoDTO departamento) {
	    if (departamento.getId() == null) {
	        System.out.println("El ID de la persona no puede ser nulo para una actualización.");
	        return;
	    }

	    String url = "http://localhost:"+setearRutaServicio("departamentos/"+ departamento.getId());
	    
	    ObjectMapper mapper = new ObjectMapper();

	    // Crear JSON del cuerpo
	    ObjectNode departamentoJson = mapper.createObjectNode();

	    departamentoJson.put("id", departamento.getId());
	    departamentoJson.put("nombre", departamento.getNombre());
	    departamentoJson.put("descripcion", departamento.getDescripcion());

	    try {
	        String requestBody = mapper.writeValueAsString(departamentoJson);

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .header("Content-Type", "application/json")
	                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // Cambiar a PUT
	                .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	        System.out.println("Código de respuesta: " + response.statusCode());
	        System.out.println("Respuesta del servidor:");
	        System.out.println(response.body());

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}
		
}

