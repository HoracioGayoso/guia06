package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CursoTest{
	Curso C1, C2, C3, C4, C5;
	Alumno a1, a2, a3, a4;
	
	@BeforeEach
	public void inicializar() {
		C1 = new Curso("Matematica", 2020, 1, 4, 6);
		C2 = new Curso("Algebra", 2020, 3, 10, 0);
		C3 = new Curso("DIED", 2020, 3, 50, 0);
		C4 = new Curso("Fisica", 2020, 3, 100, 0);
		C5 = new Curso("AEDD", 2020, 3, 100, 0);
		a1 = new Alumno("Horacio Gayoso", 25312);
		a2 = new Alumno("Atilio Gayoso", 28313);
		a3 = new Alumno("Matias Gayoso", 22314);
		a4 = new Alumno("Mauro Alvarez Arigos", 25315);
		
	}

	
	@Test
	void NoInscribirPorFaltaDeCreditos() {
		boolean inscribir = C1.inscribir(a1);
		int creditos = a1.creditosObtenidos();
		assertFalse(inscribir);
		assertEquals(creditos, 0);
		}
	@Test
	void NoInscribirPorExcesoDeInscriptos() {
		C2.inscribir(a1);
		C2.inscribir(a2);
		C2.inscribir(a3);
		boolean inscribir = C2.inscribir(a4);
		assertFalse(inscribir);
	}
	@Test
	void NoInscribirPorExcesoDeMateriasCursando() {
		C2.inscribir(a1);
		C3.inscribir(a1);
		C4.inscribir(a1);
		boolean inscribir = C5.inscribir(a1);
		assertFalse(inscribir);
	}
	@Test
	void inscribirCorrectamente() {
		C2.inscribir(a1);
		a1.aprobar(C2);
		C3.inscribir(a1);
		a1.aprobar(C3);
		boolean inscripto = C1.inscribir(a1);
		assertTrue(inscripto);
	}
	@Test
	void OrdenarInscriptosAlfabeticamente() {
		List<Alumno> listaAux = new ArrayList<Alumno>();
		listaAux.add(a2);
		listaAux.add(a1);
		listaAux.add(a3);
		C2.inscribir(a1);
		C2.inscribir(a2);
		C2.inscribir(a3);
		C2.imprimirInscriptos(Orden.ALFABETICAMENTE);
		assertEquals(listaAux, C2.getInscriptos());
	}
	@Test
	void OrdenarInscriptosPorNroLibreta() {
		List<Alumno> listaAux = new ArrayList<Alumno>();
		listaAux.add(a3);
		listaAux.add(a4);
		listaAux.add(a2);
		C2.inscribir(a2);
		C2.inscribir(a3);
		C2.inscribir(a4);
		C2.imprimirInscriptos(Orden.NROLIBRETA);
		assertEquals(listaAux, C2.getInscriptos());
	}
	@Test
	void OrdenarInscriptosPorCreditos() {
		List<Alumno> listaAux = new ArrayList<Alumno>();
		listaAux.add(a1);
		listaAux.add(a3);
		listaAux.add(a2);
		C3.inscribir(a3);
		a3.aprobar(C3);
		C5.inscribir(a1);
		a1.aprobar(C5);
		C2.inscribir(a1);
		C2.inscribir(a2);
		C2.inscribir(a3);
		C2.imprimirInscriptos(Orden.CREDITOS);
		assertEquals(listaAux, C2.getInscriptos());
	}
	
}
