package pronósticosDeportivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Lectura {
	
	String[] pronosticos= new String[2];//Para guardar la cantidad de partidos con pronosticos del archivo	
	
	public String[] leerPronosticos() {
		
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\pronostico.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			int indice=0;
			
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir el null de la última linea
					
					pronosticos[indice]= letras; 									
					indice++;
				}
			}
			buffer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				lectura.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return pronosticos;		
	}
	
	public String[] leerResultados() {
		
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\resultados.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			int indice=0;
			
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir el null final
					
					pronosticos[indice]= letras; 									
					indice++;
				}
			}
			buffer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				lectura.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return pronosticos;		
	}
	
	
}
