package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import died.guia06.util.NoAlcanzaCreditosExcepcion;
import died.guia06.util.NoHayCupoExcepcion;
import died.guia06.util.Registro;
import died.guia06.util.RegistroAuditoriaException;
import died.guia06.util.TodasMateriasRegularesExcepcion;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 * 
 * 
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	
	
	public Curso(String nombre, Integer cicloLectivo, Integer cupo, Integer creditos,
			Integer creditosRequeridos) {
		this();
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
	}



	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	public Registro getLog() {
		return log;
	}


	public void setLog(Registro log) {
		this.log = log;
	}


	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		if(a.creditosObtenidos() >= this.creditosRequeridos &&
				inscriptos.size() < this.cupo &&
				a.materiasCursando() < 3) {
			try {
				log.registrar(this, "inscribir ",a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this); 
				return true;
		}catch (IOException excepcion1) {
			System.out.println("No se pudo inscribir alumno");
			excepcion1.printStackTrace();
			return false; 
		}
		}else
			return false;
		
	}
	
	public void inscribirAlumno (Alumno a) throws NoAlcanzaCreditosExcepcion, NoHayCupoExcepcion, TodasMateriasRegularesExcepcion, RegistroAuditoriaException{
		if(a.creditosObtenidos() < this.creditosRequeridos) {
			throw new NoAlcanzaCreditosExcepcion();
		}
		if(inscriptos.size() >= this.cupo) {
			throw new NoHayCupoExcepcion();	
			}
		if(a.materiasCursando() > 2) {
			throw new TodasMateriasRegularesExcepcion();
				}
			try {
				log.registrar(this, "inscribir ",a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this); 
		}catch (IOException excepcion1) {
			throw new RegistroAuditoriaException();
		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos(Orden Ordenamiento) {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			switch(Ordenamiento) {
				
			
			case ALFABETICAMENTE:
					Collections.sort(this.inscriptos);
					System.out.println(this.inscriptos);
					break;
					//ORDENA LA LISTA DE INSCRIPTOS POR ORDEN ALFABETICO
				
				
				case NROLIBRETA:
					Collections.sort(this.inscriptos, new Comparator<Alumno>() {
						public int compare (Alumno a1, Alumno a2) {
						return a1.getNroLibreta()-a2.getNroLibreta();
						}
					});
						System.out.println(this.inscriptos);
						break;
			//ORDENA LA LISTA DE INSCRIPTOS POR NRO DE LIBRETA, DE MENOR A MAYOR
				
			
				case CREDITOS:
					Collections.sort(this.inscriptos, new Comparator<Alumno>() {
						public int compare (Alumno a1, Alumno a2) {
						return a2.creditosObtenidos()-a1.creditosObtenidos(); 
						}
					});
						System.out.println(this.inscriptos);
						break;
						//ORDENA LA LISTA DE INSCRIPTOS POR CANTIDAD DE CREDITOS OBTENIDOS, DE MAYOR A MENOR
			}
				
		
			
		}catch (IOException excepcion1) {
			System.out.println("No se pudo imprimir lista de Inscriptos");
			excepcion1.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + "]";
	}

}
