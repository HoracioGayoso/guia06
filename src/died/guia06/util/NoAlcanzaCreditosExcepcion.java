package died.guia06.util;

public class NoAlcanzaCreditosExcepcion extends Exception {
	public NoAlcanzaCreditosExcepcion() {
		super("El Alumno no cuenta con los suficientes creditos como para inscribirse a este curso");	
	}
	
}
