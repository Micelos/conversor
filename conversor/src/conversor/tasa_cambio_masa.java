package conversor;

import java.util.*;
import javax.swing.JOptionPane;

public class tasa_cambio_masa {
	private final String masa_base = "Kilogramos(kg)";
	private final Map<String, Double> masas;
		
	public tasa_cambio_masa() {
		masas=new HashMap<String, Double>();
		masas.put("Gramos(g)", 1000.00);
		masas.put("Toneladas(tn)", 0.00098);
		masas.put("Libras(lb)", 2.2046);
		masas.put("Onzas(oz)", 35.2739);
	}
	
	public String[] getTemperaturas() {
		String[] key = masas.keySet().toArray(new String[0]);
		return key;
	}
	
	public String[] cambiarTemperaturaDeA () {	
		String [] opciones_cambio_temperaturas = new String[getTemperaturas().length*2];
		for (int i=0; i<getTemperaturas().length; i++ ) {
			opciones_cambio_temperaturas[i] = "De " + masa_base + " a " + getTemperaturas()[i];
			opciones_cambio_temperaturas[getTemperaturas().length+i] = "De " + getTemperaturas()[i] + " a " + masa_base;
		}
		return opciones_cambio_temperaturas;
	}
	
	public void convertir(double masa_convertir, String seleccion_masa) {
		int i = (seleccion_masa.indexOf(')'));
		if (seleccion_masa.endsWith("(kg)")){
			String masa_diferente = seleccion_masa.substring(3, i+1);
			JOptionPane.showMessageDialog(null, masa_convertir + " " + masa_diferente + " es igual a " 
								+ String.format("%.2f", masa_convertir/masas.get(masa_diferente)) + " " + masa_base);		
		}else {
			String masa_diferente = seleccion_masa.substring(i+4);
			JOptionPane.showMessageDialog(null, masa_convertir + " " + masa_base + " es igual a " 
					+ String.format("%.2f", masa_convertir*masas.get(masa_diferente)) + " " + masa_diferente);
		}
		
	}	
}

