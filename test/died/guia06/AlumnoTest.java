package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AlumnoTest {
	Alumno A;

	@BeforeEach
	public void inicializar() {
		A = new Alumno ("Horacio Gayoso", 25312);
	}
	@Test
	void testCreditosObtenidosSinCursar() {
		int creditos = A.creditosObtenidos();
		int esperado = 0;
		assertEquals(esperado, creditos);
	}
	
	@Test
	void testCreditosObtenidosSinAprobarMaterias() {
		Curso c = new Curso();
		c.setCreditos(4);
		A.inscripcionAceptada(c);
		int creditosDeA = A.creditosObtenidos();
		int esperado = 0;
		assertEquals(esperado, creditosDeA);
	}
	@Test
	void testCreditosObtenidosConMateriasAprobadas() {
		Curso c1 = new Curso();
		Curso c2 = new Curso();
		c1.setCreditos(4);
		c2.setCreditos(4);
		A.inscripcionAceptada(c1);
		A.inscripcionAceptada(c2);
		A.aprobar(c1);
		A.aprobar(c2);
		int creditosDeA = A.creditosObtenidos();
		int esperado = 8;
		assertEquals(esperado, creditosDeA);
	}

	@Test
	void testNoAprobarSinCursarMateria() {
		Curso c1 = new Curso();
		A.aprobar(c1);
		boolean aprobo = (A.getAprobados()==null);
		assertTrue(aprobo);
		
	}
	@Test
	void testNoAprobarSinAprobarMateria() {
		Curso c1 = new Curso();
		A.inscripcionAceptada(c1);
		boolean aprobo = (A.getAprobados()==null);
		assertTrue(aprobo);
		
	}
	@Test
	void testAprobarMaterias() {
		Curso c1 = new Curso();
		A.inscripcionAceptada(c1);
		A.aprobar(c1);
		boolean aprobo = (A.getAprobados().contains(c1));
		assertTrue(aprobo);
		
	}

	@Test
	void testNoInscripto() {
		boolean inscripto = (A.getCursando()==null);
		assertTrue(inscripto);
	}

	@Test
	void testInscripcionAceptada() {
		Curso c1 = new Curso();
		A.inscripcionAceptada(c1);
		boolean inscripto = (A.getCursando().contains(c1));
		assertTrue(inscripto);
	}

}
