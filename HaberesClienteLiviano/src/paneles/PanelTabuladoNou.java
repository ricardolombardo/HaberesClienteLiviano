package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import DTO.TabuladoConceptoDTO;
import componentesGraficos.BotonSeleccion;
import modelosVistas.PanelTabuladoNouModelView;

public class PanelTabuladoNou extends PanelVista{

	private PanelTabuladoNouModelView modeloVista;
	private JPanel panelConceptos;
	private JPanel panelDatosPersona;
	
	public PanelTabuladoNou(PanelTabuladoNouModelView modelo) {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.modeloVista=modelo;
		
		setTituloPrincipal("Tabulados");
		panelCentro=new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelCentro.setBackground(Color.white);
		
		panelDatosPersona =new JPanel();
		panelDatosPersona.setLayout(new GridLayout(3,1,5,5));
		panelDatosPersona.setBackground(Color.white);
		
		Font fuenteDatos=new Font("Arial", java.awt.Font.PLAIN, 22);
		
		JLabel ldatosTabulado=new JLabel(modelo.getTabulado().getDescripcion());
		ldatosTabulado.setFont(fuenteDatos);
		panelDatosPersona.add(ldatosTabulado);
		
		JLabel lNombrePersona=new JLabel(modelo.getPersona().getNombre()+" "+modelo.getPersona().getApellidoPaterno());
		lNombrePersona.setFont(fuenteDatos);
		panelDatosPersona.add(lNombrePersona);
		
		panelCentro.add(panelDatosPersona,BorderLayout.NORTH);
		
		panelConceptos =new JPanel();
		panelConceptos.setLayout(new GridLayout(20,1,5,5));
		panelConceptos.setBackground(Color.white);
		panelCentro.add(panelConceptos,BorderLayout.CENTER);
		
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,7,0,0));
		
		this.setearTitulos("CONCEPTO");
		this.setearTitulos("DEBE");
		this.setearTitulos("HABER");
		this.setearTitulos("EDITAR");
		panelConceptos.add(titulos);
		titulos.setBackground(new Color(169, 223, 191));
		
		this.add(panelCentro,BorderLayout.CENTER);
		
		panelInferior=new JPanel();
		panelInferior.setLayout(new GridLayout(1,8,1,1));
		panelInferior.setBackground(Color.white);
		this.add(panelInferior,BorderLayout.SOUTH);
		
		for(TabuladoConceptoDTO tabuladoConcepto:modeloVista.getTabulado().getTabuladoConceptos()) {
			JPanel container=new JPanel();
			container.setLayout(new GridLayout(1,5,20,0));
			Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);

			JLabel lNombre= new JLabel((tabuladoConcepto.getConcepto().getNombre()),SwingConstants.CENTER);
			lNombre.setFont(fuenteFila);
			container.add(lNombre);
			
			if(tabuladoConcepto.getSentido().equals("D")) {
				JLabel lDebe= new JLabel(String.valueOf(tabuladoConcepto.getMonto()),SwingConstants.CENTER);
				lDebe.setFont(fuenteFila);
				container.add(lDebe);
				
				JLabel lHaber= new JLabel("",SwingConstants.CENTER);
				lHaber.setFont(fuenteFila);
				container.add(lHaber);
			}else {
				JLabel lDebe= new JLabel("",SwingConstants.CENTER);
				lDebe.setFont(fuenteFila);
				container.add(lDebe);
				
				JLabel lHaber= new JLabel(String.valueOf(tabuladoConcepto.getMonto()),SwingConstants.CENTER);
				lHaber.setFont(fuenteFila);
				container.add(lHaber);
			}

			BotonSeleccion btnEditar =new BotonSeleccion("Editar");
			btnEditar.setDto(tabuladoConcepto);
			btnEditar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
			container.add(btnEditar);
						
			container.setBackground(new Color(214, 234, 248));
			container.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					container.setBackground(new Color(253, 235, 208));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					container.setBackground(new Color(214, 234, 248));
					
				}
				
			});
			panelConceptos.add(container);
			validate();
		}
		
	}
	
}
