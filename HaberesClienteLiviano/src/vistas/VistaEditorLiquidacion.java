package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DTO.LiquidacionDTO;
import controladores.LiquidacionController;
import servicios.ServicioLiquidaciones;

public class VistaEditorLiquidacion extends JDialog{
	
	static final long serialVersionUID = 1L;
	private VistaEditorLiquidacion mismo;
	private JTextField txtDesctipcion;
	private JTextField txtAnio;
	private JTextField txtMes;
	
	public VistaEditorLiquidacion(VistaPrincipal padre,LiquidacionDTO liquidacion) {

		
		super(new JFrame(),"Editor Departamento",true);
		this.setLocationRelativeTo(null);
		this.setSize(400,150);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		mismo=this;
	
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(4,1,2,2));
		panelCentro.setBackground(Color.white);
		
		JPanel cont1=new JPanel();
		cont1.setLayout(new GridLayout(1,2,0,0));
		cont1.add(new JLabel("Descripcion"));
		txtDesctipcion=new JTextField();
		cont1.add(txtDesctipcion);
		panelCentro.add(cont1);
		
		JPanel cont2=new JPanel();
		cont2.setLayout(new GridLayout(1,2,0,0));
		cont2.add(new JLabel("Año"));
		txtAnio=new JTextField();
		cont2.add(txtAnio);
		panelCentro.add(cont2);
		
		JPanel cont3=new JPanel();
		cont3.setLayout(new GridLayout(1,2,0,0));
		cont3.add(new JLabel("Mes"));
		txtMes=new JTextField();
		cont3.add(txtMes);
		panelCentro.add(cont3);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				LiquidacionDTO liquidacion=new LiquidacionDTO();
				liquidacion.setDescripcion(txtDesctipcion.getText());
				liquidacion.setAnio(Integer.valueOf(txtAnio.getText()));
				liquidacion.setMes(Integer.valueOf(txtMes.getText()));
				LiquidacionController.posNuevaLiquidacion(padre, liquidacion);
				mismo.dispose();
			}
		});
			
		
		panelCentro.add(cont1);
		panelCentro.add(cont2);
		panelCentro.add(cont3);
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
		
	}

}
