package died.guia06;

import java.util.List;
import java.util.Objects;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public int creditosObtenidos() {
		int creditos=0;
		for(Curso unCurso : aprobados) {
			creditos += unCurso.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}

	@Override
	public int compareTo(Alumno a) {
		 return (this.nombre.compareTo(a.nombre));
	}

	public boolean equals(Alumno a) {
		if(this.nroLibreta == a.nroLibreta) {
			return true;
		}else 
			return false;
	}

}
