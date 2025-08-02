package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import DTO.EventoNOUDTO;
import componentesGraficos.PanelDato;
import modelosVistas.PanelEventosNouModelView;

public class PanelEventosNou extends PanelVista{
	
	private static final long serialVersionUID = 1L;
	private PanelEventosNouModelView modeloVista;
	
	public PanelEventosNou(PanelEventosNouModelView modelo) {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.modeloVista=modelo;
		
		setTituloPrincipal("EVENTOS DE "+modelo.getPersona().getNombre()+" "+modelo.getPersona().getApellidoPaterno());
		panelCentro=new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelCentro.setBackground(Color.white);
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,7,0,0));
		
		panelInferior=new JPanel();
		panelInferior.setLayout(new GridLayout(1,8,1,1));
		panelInferior.setBackground(Color.white);
		this.add(panelInferior,BorderLayout.SOUTH);
		
		this.add(panelCentro,BorderLayout.CENTER);
		JPanel panelDatos=new JPanel();
		panelDatos.setLayout(new GridLayout(15,1,5,5));
		panelDatos.setBackground(Color.white);
		
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,4,0,0));
		this.setearTitulos("EVENTO");
		this.setearTitulos("DESDE");
		this.setearTitulos("HASTA");
		this.setearTitulos("ACCION");
		titulos.setBackground(new Color(169, 223, 191));
		panelDatos.add(titulos);
		
		for(EventoNOUDTO eventoNou:modelo.getEventosNOU()) {
			PanelDato datoDpto=new PanelDato(eventoNou.getEvento().getIdentificador(),eventoNou.getFechaInicio(), eventoNou.getFechaFin(), null);
			panelDatos.add(datoDpto);
		}
		panelCentro.add(panelDatos,BorderLayout.CENTER);
	}

}
