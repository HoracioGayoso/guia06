package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	



	public Alumno(String nombre, Integer nroLibreta, List<Curso> cursando, List<Curso> aprobados) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = cursando;
		this.aprobados = aprobados;
	}
	

	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}


	public Alumno() {
		super();
	}


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
		if(aprobados != null) {
		for(Curso unCurso : aprobados) {
			creditos+=unCurso.getCreditos();
		}
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		if(cursando!=null && cursando.contains(c)) {
			if(aprobados==null) {aprobados = new ArrayList<Curso>();}
			this.aprobados.add(c);
			this.cursando.remove(c);
			}
	}

	public void inscripcionAceptada(Curso c) {
		if(cursando==null) cursando = new ArrayList<Curso>(); 
		if(!cursando.contains(c)) this.cursando.add(c);
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
