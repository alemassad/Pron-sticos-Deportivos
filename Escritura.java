package pronósticosDeportivos;

import java.io.FileWriter;
import java.io.IOException;

class Escritura{
	public void escribirPronostico() {
		
		String partido ="Argentina;1;0;0;Arabia Saudita \nPolonia;0;1;0;Mexico";// Escribimos los pronósticos
		
		try {
			FileWriter archivo = new FileWriter("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\pronostico.csv");
			
			for(int i=0; i< partido.length(); i++) {
				archivo.write(partido.charAt(i));
			}
			archivo.close();
		} catch (IOException e) {
			System.out.println("El archivo no se pudo escribir");
			e.printStackTrace();
		}
		
	}
	public void escribirResultados() {
		
		String partido ="Argentina;1;2;Arabia Saudita \nPolonia;1;1;Mexico";// Escribimos los resultados
		
		try {
			FileWriter archivo = new FileWriter("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\resultado.csv");
			
			for(int i=0; i< partido.length(); i++) {
				archivo.write(partido.charAt(i));
			}
			archivo.close();
		} catch (IOException e) {
			System.out.println("El archivo no se pudo escribir");
			e.printStackTrace();
		}
		
	}
}

