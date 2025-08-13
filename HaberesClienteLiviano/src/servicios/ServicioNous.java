package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import DTO.EventoNOUDTO;
import DTO.NOUDTO;

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
            eventos = mapper.readValue(json, new TypeReference<List<EventoNOUDTO>>() {});

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return eventos;
	}

}
