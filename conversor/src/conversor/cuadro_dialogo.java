package conversor;

import javax.swing.*;

public class cuadro_dialogo extends JOptionPane {

	public cuadro_dialogo() {
		
	}
	
	public static String cuadro_seleccion(String texto_accion , String texto_cuadro, String[] opciones) {
		return (String) JOptionPane.showInputDialog(null,texto_accion, texto_cuadro,JOptionPane.PLAIN_MESSAGE,null,opciones, opciones[0]);
	}

	public static String cuadro_ingresoValores (String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
		
	}	
		
	public  static void cuadro_informativo (String mensaje_informativo) {
		JOptionPane.showMessageDialog(null, mensaje_informativo);
	}

	public static void cuadro_confirmarDialogo (String texto_accion) {
		int respuesta = JOptionPane.showConfirmDialog(null, texto_accion);
		switch (respuesta) {
	    case 0:
	    	break;
	    default:
	    	cuadro_informativo("El programa ha terminado");
	    	System.exit(0);
	    	break;
        }
		
		
		
	}
}