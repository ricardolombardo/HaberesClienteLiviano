package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import DTO.NOUDTO;
import componentesGraficos.BotonSeleccion;
import componentesGraficos.PanelDato;
import controladores.NOUController;
import modelosVistas.PanelDatosPersonaModelView;

public class PanelDatosPersona extends PanelVista{
	
	private static final long serialVersionUID = 1L;
	private PanelDatosPersonaModelView modeloVista;
	
	public PanelDatosPersona(PanelDatosPersonaModelView modelo) {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.modeloVista=modelo;
		
		setTituloPrincipal("DATOS DE "+modelo.getPersona().getNombre()+" "+modelo.getPersona().getApellidoPaterno());
		panelCentro=new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelCentro.setBackground(Color.white);
		
		panelInferior=new JPanel();
		panelInferior.setLayout(new GridLayout(1,8,1,1));
		panelInferior.setBackground(Color.white);
		this.add(panelInferior,BorderLayout.SOUTH);
		
		this.add(panelCentro,BorderLayout.CENTER);
		JPanel panelDatos=new JPanel();
		panelDatos.setLayout(new GridLayout(20,1,5,5));
		
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,3,0,0));
		this.setearTitulos("CAMPO");
		this.setearTitulos("VALOR");
		this.setearTitulos("ACCION");
		titulos.setBackground(new Color(169, 223, 191));
		panelDatos.add(titulos);

		PanelDato datoDpto=new PanelDato("Departamento",modelo.getPersona().getDepartamento().getNombre(), null);
		panelDatos.add(datoDpto);
		
		PanelDato datoJerarquia=new PanelDato("Jerarquia",modelo.getPersona().getJerarquia().getNombre(), null);
		panelDatos.add(datoJerarquia);
		
		panelDatos.setBackground(Color.white);
		
		for(NOUDTO nou:modelo.getPersona().getNous()) {
			BotonSeleccion btnNou=new BotonSeleccion("Ver");
			btnNou.setDto(nou);
			btnNou.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					NOUDTO nouSeleccionado=(NOUDTO) btnNou.getDto();
					NOUController.preRecuperarEventosNou(nouSeleccionado, modelo.getPadre(),modelo.getPersona());
				}
				
			});
			PanelDato datoNou=new PanelDato("NOU",String.valueOf(nou.getNumeroNOU()), btnNou);
			panelDatos.add(datoNou);
		}
		panelCentro.add(panelDatos,BorderLayout.CENTER);
		
		JButton btnNuevo=new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NOUController.preCrearNou(modeloVista.getPadre(), modeloVista.getPersona());
			}
			
		});
		panelInferior.add(btnNuevo);
		
	}

}
