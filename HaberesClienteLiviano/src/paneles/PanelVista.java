package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import componentesGraficos.BordeRedondeado;

public class PanelVista extends JPanel{

	private static final long serialVersionUID = 1L;
	protected JPanel panelTituloPrincipal;
	protected JPanel titulos;
	protected JPanel panelCentro;
	protected JPanel panelInferior;
	
	
	public PanelVista() {
		
	}
	
	public void setTituloPrincipal(String titulo) {
		panelTituloPrincipal=new JPanel();
		panelTituloPrincipal.setBackground(Color.white);
		JLabel lTituloPrincipal=new JLabel(titulo);
		Font fuente=new Font("Georgia", java.awt.Font.BOLD, 45);
		lTituloPrincipal.setFont(fuente);
		panelTituloPrincipal.add(lTituloPrincipal);
		panelTituloPrincipal.setBorder(new BordeRedondeado(20));
		
		this.add(panelTituloPrincipal,BorderLayout.NORTH);
	}
	
	public void setearTitulos(String titulo) {
		Font fuente=new Font("Arial", java.awt.Font.BOLD, 24);
		JLabel lTitulo=new JLabel(titulo,SwingConstants.CENTER);
		lTitulo.setFont(fuente);
		titulos.add(lTitulo);
	}

}
