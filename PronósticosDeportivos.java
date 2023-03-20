package pronósticosDeportivos;

public class PronósticosDeportivos {

	public static void main(String[] args) {
		
		Escritura escritura = new Escritura();
		
		escritura.escribirPronostico();     // ===> PARA ESCRIBIR PRONOSTICOS
		escritura.escribirResultados();		// ===> PARA ESCRIBIR RESULTADOS
				
		Lectura archivo = new Lectura();	
		
		System.out.println(" ---- PRONOSTICOS ---- ");		
		
		archivo.leerPronosticos();

		System.out.println();	
		System.out.println("----  RESULTADOS  ----");		
		
		archivo.leerResultados();
		
		System.out.println();	
		System.out.println("----  PUNTAJE  ----");	
		
		archivo.leerPuntaje();
	}		
		
}// Game Over

