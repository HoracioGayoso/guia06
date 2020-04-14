package died.guia06;

import java.util.List;
import java.util.Objects;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	



	public int creditosObtenidos() {
		//int creditos=0;
		//for(Curso unCurso : aprobados) {
			//creditos += unCurso.getCreditos();
		//}
		return 1;
	}

	public void aprobar(Curso c) {
		//this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		//this.cursando.add(c);
	}



}
