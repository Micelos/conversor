package conversor;

import java.util.*;
import javax.swing.JOptionPane;

public class tasa_cambio_distancia {
	
	private final String distancia_base = "Metros(m)";
	private final Map<String, Double> distancias;
		
	public tasa_cambio_distancia() {
		distancias=new HashMap<String, Double>();
		distancias.put("Centímetros (cm)", 100.00);
		distancias.put("Milímetros(mm)", 1000.00);
		distancias.put("Kilometros(km)", 0.001);
		distancias.put("Milla(mi)", 0.000621371);
		distancias.put("Yarda(yd)", 1.094);
		distancias.put("Pie(ft)", 3.281);
		distancias.put("Pulgadas(in)", 39.37);
	}
	
	public String[] getDistancias() {
		String[] key = distancias.keySet().toArray(new String[0]);
		return key;
	}
	
	public String[] cambiarDistanciaDeA () {	
		String [] opciones_cambio_distancias = new String[getDistancias().length*2];
		for (int i=0; i<getDistancias().length; i++ ) {
			opciones_cambio_distancias[i] = "De " + distancia_base + " a " + getDistancias()[i];
			opciones_cambio_distancias[getDistancias().length+i] = "De " + getDistancias()[i] + " a " + distancia_base;
		}
		return opciones_cambio_distancias;
	}
	
	public void convertir(double distancia_convertir, String seleccion_distancias) {
		int i = (seleccion_distancias.indexOf(')'));
		if (seleccion_distancias.endsWith("(m)")){
			String distancia_diferente = seleccion_distancias.substring(3, i+1);
			JOptionPane.showMessageDialog(null, distancia_convertir + " " + distancia_diferente + " es igual a " 
								+ String.format("%.2f", distancia_convertir/distancias.get(distancia_diferente)) + " " + distancia_base);		
		}else {
			String distancia_diferente = seleccion_distancias.substring(i+4);
			JOptionPane.showMessageDialog(null, distancia_convertir + " " + distancia_base + " es igual a " 
					+ String.format("%.2f",distancia_convertir*distancias.get(distancia_diferente)) + " " + distancia_diferente);
		}
		
	}	
}



	
	

