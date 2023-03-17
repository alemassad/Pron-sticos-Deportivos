package pronósticosDeportivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PronósticosDeportivos {

	public static void main(String[] args) {
		Lectura archivo = new Lectura();
		archivo.leerPronosticos();
		archivo.leerResultados();
		
		
		
		/*Escritura escritura = new Escritura();
		escritura.escribir();
		*/
	}	
}


class Escritura{
	public void escribir() {
		String partido ="Argentina;1;0;0;Arabia saudita \nPolonia;0;1;0;Mexico";
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
}
class Lectura {
	public void leerPronosticos() {
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\pronostico.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir null
									
					System.out.println(letras);
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
	}
	
	public void leerResultados() {
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\resultados.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir null
									
					System.out.println(letras);
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
	}
	
	
}