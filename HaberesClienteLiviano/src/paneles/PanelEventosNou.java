package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import DTO.EventoNOUDTO;
import DTO.NOUDTO;
import componentesGraficos.PanelDato;
import controladores.EventoController;
import modelosVistas.PanelEventosNouModelView;

public class PanelEventosNou extends PanelVista{
	
	private static final long serialVersionUID = 1L;
	private PanelEventosNouModelView modeloVista;
	
	public PanelEventosNou(PanelEventosNouModelView modelo,NOUDTO nou) {
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
		
		if(modelo.getEventosNOU()!=null) {
			for(EventoNOUDTO eventoNou:modelo.getEventosNOU()) {
				PanelDato datoDpto=new PanelDato(eventoNou.getEvento().getIdentificador(),eventoNou.getFechaInicio(), eventoNou.getFechaFin(), null);
				panelDatos.add(datoDpto);
			}	
		}
		
		panelCentro.add(panelDatos,BorderLayout.CENTER);
		
		JButton btnNuevo=new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventoController.preNuevoEventoNOU(modelo.getPadre(),nou);
			}
			
		});
		panelInferior.add(btnNuevo);
	}

}
