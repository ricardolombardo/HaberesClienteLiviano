package controladores;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import constantes.Modo;
import vistas.VistaPrincipal;

public class Principal {
	
	public static String puerto;
	public static Modo modo=Modo.DESARROLLO;
	
	public static void main(String[] args) {
		
		try {
			if(modo.equals(Modo.DESARROLLO)) {
				puerto="8081";
			}else {
				puerto="8080";
			}
			
			VistaPrincipal vista=new VistaPrincipal();
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
			vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	public static String getPuerto() {
		return puerto;
	}

	public static void setPuerto(String puerto) {
		Principal.puerto = puerto;
	}

}
