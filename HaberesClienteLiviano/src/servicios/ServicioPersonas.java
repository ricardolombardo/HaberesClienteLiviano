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
import DTO.NOUDTO;
import DTO.PersonaDTO;
import controladores.Principal;

public class ServicioPersonas extends Servicio{
	
	public static List<PersonaDTO> gePersonas() {

	    String servicio = Principal.PUERTO.equals("8081")
	        ? "/personas/getAll"
	        : "/HaberesMonolitico-0.0.1-SNAPSHOT/personas/getAll";

	    String url = "http://localhost:" + Principal.PUERTO + servicio;

	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .GET()
	            .build();

	    List<PersonaDTO> personas = null;

	    try {
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        String json = response.body();

	        System.out.println("JSON recibido:");
	        System.out.println(json);

	        ObjectMapper mapper = new ObjectMapper();
	        personas = mapper.readValue(json, new TypeReference<List<PersonaDTO>>() {});

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }

	    return personas;
	}


public static void updatePersona(PersonaDTO persona) {
    if (persona.getId() == null) {
        System.out.println("El ID de la persona no puede ser nulo para una actualización.");
        return;
    }
    
    String servicio;
    
	if(Principal.PUERTO.equals("8081")) {
		servicio="/personas/" + persona.getId();
	}else {
		servicio="/HaberesMonolitico-0.0.1-SNAPSHOT/personas/"+ persona.getId();
	}

    String url = "http://localhost:"+Principal.PUERTO+servicio;

    ObjectMapper mapper = new ObjectMapper();

    // Crear JSON del cuerpo
    ObjectNode personaJson = mapper.createObjectNode();

    personaJson.put("nombre", persona.getNombre());
    personaJson.put("apellidoPaterno", persona.getApellidoPaterno());
    personaJson.put("apellidoMaterno", persona.getApellidoMaterno());
    personaJson.put("departamentoId", persona.getDepartamento().getId());
    personaJson.put("jerarquiaId", persona.getJerarquia().getId());

    try {
        String requestBody = mapper.writeValueAsString(personaJson);

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

	
	public static void createPersona(PersonaDTO persona) {
		
		String servicio;
		
		if(Principal.PUERTO.equals("8081")) {
			servicio="/personas";
		}else {
			servicio="/HaberesMonolitico-0.0.1-SNAPSHOT/personas";
		}
		
		 String url = "http://localhost:8081"+Principal.PUERTO+servicio;

		 // Crear el JSON del cuerpo con Jackson
	     ObjectMapper mapper = new ObjectMapper();

	     ObjectNode personaJson = mapper.createObjectNode();
	     personaJson.put("nombre", persona.getNombre());
	     personaJson.put("apellidoPaterno", persona.getApellidoPaterno());
	     personaJson.put("apellidoMaterno", persona.getApellidoMaterno());

	     // Crear nodo departamento (solo con ID)
	     ObjectNode departamentoJson = mapper.createObjectNode();
	     departamentoJson.put("id", 2);  // Debe ser un ID válido existente en tu BD

	     personaJson.set("departamento", departamentoJson);
	     try {
	    	 String requestBody = mapper.writeValueAsString(personaJson);

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
	
	public static PersonaDTO getPersonaNou(NOUDTO nou) {
		String url = "http://localhost:"+Principal.PUERTO+setearRutaServicio("personas/nou/"+nou.getNumeroNOU());
		System.out.println("envio mensaje a "+url);
		
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        PersonaDTO persona = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Mostrar el JSON crudo
            System.out.println("JSON recibido de persona por Nou:");
            System.out.println(json);

            // Parsear a lista de objetos Jerarquia
            ObjectMapper mapper = new ObjectMapper();
            persona = mapper.readValue(json, new TypeReference<PersonaDTO>() {});
            System.out.println(persona.getId()+" "+persona.getNombre()+" "+persona.getApellidoPaterno());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return persona;
	}
	
}
