package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.TabuladoConceptoDTO;
import DTO.TabuladoDTO;
import controladores.Principal;

public class ServicioTabulados extends Servicio{
	
	public static List<TabuladoDTO> getTabuladosPorLiquidacion(Long idLiquidacion){
		String url = "http://localhost:"+Principal.PUERTO+setearRutaServicio("tabulados/porLiquidacion?idLiquidacion="+idLiquidacion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        List<TabuladoDTO> tabulados = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println("JSON recibido:");
            System.out.println(json);

            ObjectMapper mapper = new ObjectMapper();
            tabulados = mapper.readValue(json, new TypeReference<List<TabuladoDTO>>() {});
            
            /*
            System.out.println("\nTabulados parseados:");
            for (TabuladoDTO t : tabulados) {
            	System.out.println("Id: " + t.getId());
                System.out.println("Descripcion: " + t.getDescripcion());
                System.out.println("----");
            }
            */

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return tabulados;
	}
	
	public static TabuladoDTO getTabuladosPorId(Long idTabulado){
		String url = "http://localhost:"+Principal.PUERTO+setearRutaServicio("tabulados/"+idTabulado);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        TabuladoDTO tabulado = null;
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println("JSON recibido:");
            System.out.println(json);

            ObjectMapper mapper = new ObjectMapper();
            tabulado = mapper.readValue(json, new TypeReference<TabuladoDTO>() {});

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        return tabulado;
	}
	
	
}
