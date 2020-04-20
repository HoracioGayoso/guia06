package died.guia06;

public class App {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("Horacio Gayoso", 25312);
		Alumno a2 = new Alumno("Matias Gayoso", 22717);
		Alumno a3 = new Alumno("Atilio Gayoso", 23546);
		Alumno a4 = new Alumno("Mauro Alvarez Arigos", 25432);
		Alumno a5 = new Alumno("Victoria Bertero", 25654);
		
		Curso C1 = new Curso("Matematica", 2020, 1, 4, 6);
		Curso C2 = new Curso("Algebra", 2020, 5, 10, 0);
		Curso C3 = new Curso("Fisica", 2020, 3, 100, 0);
		Curso C4 = new Curso("AEDD", 2020, 3, 100, 0);
		
		C2.inscribir(a1);
		C2.inscribir(a2);
		C2.inscribir(a3);
		C2.inscribir(a4);
		C2.inscribir(a5);
		
		System.out.println("Alumnos cursando el curso: "+ C2.getNombre());
		System.out.println(C2.getInscriptos());

		C3.inscribir(a1);
		C3.inscribir(a2);
		C3.inscribir(a3);
		
	
	
		a1.aprobar(C2);
		a1.aprobar(C3);
		a2.aprobar(C2);
		a3.aprobar(C2);
		a3.aprobar(C3);
		
		System.out.println("Materias que esta cursando el Alumno: "+ a2.getNombre());
		System.out.println(a2.getCursando());

		System.out.println("Alumnos cursando el curso "+C3.getNombre());
		System.out.println("Ordenados por NRO de Libreta: ");
		C3.imprimirInscriptos(Orden.NROLIBRETA);
		System.out.println("Ordenados Alfabeticamente: ");
		C3.imprimirInscriptos(Orden.ALFABETICAMENTE);
		System.out.println("Ordenados por Cantidad de Creditos-: ");
		C3.imprimirInscriptos(Orden.CREDITOS);
		
		C1.inscribir(a1);
		C4.inscribir(a3);
		C4.inscribir(a4);
		C4.inscribir(a5);
		
		System.out.println("Los alumnos estan cursando: ");
		System.out.println(a1.getNombre()+": "+a1.getCursando());
		System.out.println(a2.getNombre()+": "+a2.getCursando());
		System.out.println(a3.getNombre()+": "+a3.getCursando());
		System.out.println(a4.getNombre()+": "+a4.getCursando());
		System.out.println(a5.getNombre()+": "+a5.getCursando());
		
		System.out.println("Cantidad de creditos del alumno "+ a3.getNombre()+": "+a3.creditosObtenidos());
		System.out.println("Cantidad de materias cursando del alumno "+ a3.getNombre()+": "+a3.materiasCursando());
	}
}
