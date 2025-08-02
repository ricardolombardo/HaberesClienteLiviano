package controladores;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistas.VistaPrincipal;

public class Principal {
	
	public static final String PUERTO="8081";
	
	public static void main(String[] args) {
		
		try {
			VistaPrincipal vista=new VistaPrincipal();
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
			vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

}
