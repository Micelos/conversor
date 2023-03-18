package conversor;

public class test_conversor {

	public static void main(String[] args) {
		
		int regreso_inicio = 0;
		while (regreso_inicio == 0) {
			tipos_conversor conversoUnidades = new tipos_conversor();
			String conversor = cuadro_dialogo.cuadro_seleccion("Selecciona una opción de conversión", "Menu", conversoUnidades.getSeleccion_conversor());
			if (conversor != null) {
				int regreso_entradaDatos = 0;
				while (regreso_entradaDatos == 0) {
					String texto_convertir = cuadro_dialogo.cuadro_ingresoValores("Ingrese el valor que desea convertir: ");
					if (texto_convertir != null){
						try {
							double monto_convertir = Double.parseDouble(texto_convertir);					
							switch (conversor) {
							case "Conversor de Monedas":	
								tasa_cambio_monedas cambio_moneda = new tasa_cambio_monedas();
								String seleccion_monedas = cuadro_dialogo.cuadro_seleccion("Elige la moneda a la que deseas convertir tu dinero: ", conversor, cambio_moneda.cambiarMonedaDeA());
								if (seleccion_monedas != null) {	
									cambio_moneda.convertir(monto_convertir, seleccion_monedas);
									regreso_entradaDatos++;
									cuadro_dialogo.cuadro_confirmarDialogo("¿Desea continuar");
								}else {
									continue;
								}
								break;
							
							case "Conversor de Distancias":
								tasa_cambio_distancia cambio_distancia = new tasa_cambio_distancia();
								String seleccion_distancias = cuadro_dialogo.cuadro_seleccion("Elige la medida a la que deseas convertir el valor: ", conversor, cambio_distancia.cambiarDistanciaDeA());
								if (seleccion_distancias != null) {	
									cambio_distancia.convertir(monto_convertir, seleccion_distancias);
									regreso_entradaDatos++;
									cuadro_dialogo.cuadro_confirmarDialogo("¿Desea continuar");
								}else {
									continue;
								}
								break;
							
							case "Conversor de Masas":
								tasa_cambio_masa cambio_masas = new tasa_cambio_masa();
								String seleccion_masas = cuadro_dialogo.cuadro_seleccion("Elige la medida a la que deseas convertir el valor: ", conversor, cambio_masas.cambiarTemperaturaDeA());
								if (seleccion_masas != null) {	
									cambio_masas.convertir(monto_convertir, seleccion_masas);
									regreso_entradaDatos++;
									cuadro_dialogo.cuadro_confirmarDialogo("¿Desea continuar");
								}else {
									continue;
								}
								break;
							
							default:
								cuadro_dialogo.cuadro_informativo("El programa ha terminado");
								break;
							
							}
						}catch(NumberFormatException e) {
							cuadro_dialogo.cuadro_informativo("Valor NO válido, Por favor ingrese un valor numérico.");
							}
					}else {
						regreso_entradaDatos++;
					}
				}
			}else {
				cuadro_dialogo.cuadro_informativo("El programa ha terminado");;
				regreso_inicio++;
			}
		}		
	}
}