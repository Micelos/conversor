package conversor;

import java.util.*;
import javax.swing.JOptionPane;

public class tasa_cambio_monedas {
	
	private final String moneda_base = "Soles(PEN)";
	private final Map<String, Double> monedas;
		
	public tasa_cambio_monedas() {
		monedas=new HashMap<String, Double>();
		monedas.put("Dolares(USD)", 0.26);
		monedas.put("Euros(EUR)", 0.25);
		monedas.put("Libras Esterlinas(GBP)", 0.22);
		monedas.put("Yen Japonés(JPY)", 36.04);
		monedas.put("Won Surcoreano(KRW)", 350.18);
	}
	
	public String[] getMonedas() {
		String[] key = monedas.keySet().toArray(new String[0]);
		return key;
	}
	
	public String[] cambiarMonedaDeA () {	
		String [] opciones_cambio_monedas = new String[getMonedas().length*2];
		for (int i=0; i<getMonedas().length; i++ ) {
			opciones_cambio_monedas[i] = "De " + moneda_base + " a " + getMonedas()[i];
			opciones_cambio_monedas[getMonedas().length+i] = "De " + getMonedas()[i] + " a " + moneda_base;
		}
		return opciones_cambio_monedas;
	}
	
	public void convertir(double monto_convertir, String seleccion_monedas) {
		int i = (seleccion_monedas.indexOf(')'));
		if (seleccion_monedas.endsWith("(PEN)")){
			String moneda_extranjera = seleccion_monedas.substring(3, i+1);
			JOptionPane.showMessageDialog(null, monto_convertir + " " + moneda_extranjera + " es igual a " 
								+ String.format("%.2f", monto_convertir/monedas.get(moneda_extranjera)) + " " + moneda_base );		
		}else {
			String moneda_extranjera = seleccion_monedas.substring(i+4);
			JOptionPane.showMessageDialog(null, monto_convertir + " " + moneda_base + " es igual a " 
					+ String.format("%.2f",monto_convertir*monedas.get(moneda_extranjera)) + " " + moneda_extranjera);
		}
		
	}	
}


