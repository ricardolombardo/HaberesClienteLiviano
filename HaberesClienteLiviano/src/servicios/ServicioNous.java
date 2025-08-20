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

import DTO.EventoDTO;
import DTO.EventoNOUDTO;
import DTO.NOUDTO;
import excepciones.NOUException;

public class ServicioNous extends Servicio{
	
	public static List<NOUDTO> getNous() {
		String url = "http://localhost:"+setearRutaServicio("nous/getAll");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<NOUDTO> nous = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ObjectMapper mapper = new ObjectMapper();
            nous = mapper.readValue(json, new TypeReference<List<NOUDTO>>() {});

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return nous;
	}
	
	
	public static List<NOUDTO> getNousPersona(Long id) {

		String url = "http://localhost:"+setearRutaServicio("nous/persona/"+id);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<NOUDTO> nous = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println("JSON recibido:");
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
            nous = mapper.readValue(json, new TypeReference<List<NOUDTO>>() {});

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return nous;
	}
	
	public static List<EventoNOUDTO> getEventosNou(Long id) {

		String url = "http://localhost:"+setearRutaServicio("nous/"+id+"/eventosNou");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<EventoNOUDTO> eventos = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println("JSON recibido:");
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
            //eventos = mapper.readValue(json, new TypeReference<List<EventoNOUDTO>>() {});
            
            // Validación antes de deserializar
            if (json != null && !json.isBlank()) {
                eventos = mapper.readValue(json, new TypeReference<List<EventoNOUDTO>>() {});
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return eventos;
	}
	
	public static void crearNou(NOUDTO nou) throws NOUException {
	    String url = "http://localhost:" + setearRutaServicio("nous");
	    ObjectMapper mapper = new ObjectMapper();

	    try {
	        // Serializa el NOUDTO completo, incluyendo la persona ---> TENER PRESENTE ESTO CUANDO UN DTO TIENE EMBEBIDO OTRO DTO
	        String requestBody = mapper.writeValueAsString(nou);

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(url))
	                    .header("Content-Type", "application/json")
	                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	                    .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        System.out.println(response.body());

	    } catch (IOException | InterruptedException e) {
	        throw new NOUException();
	    }
	}


}
