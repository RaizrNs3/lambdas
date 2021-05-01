package com.practica.lambdas;

import com.practica.lambdas.dto.AlumnoDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasService {
    public static void main(String[] args) {
        List<AlumnoDTO> listaAlumnos = generaListaAlumnos();

        System.out.println("*** Obtener lista de alumnos ***");
        listaAlumnos.forEach(System.out::println);

        System.out.println("\n*** Alumnos cuyo nombre empieza con el caracter L o G ***");
        listaAlumnos.stream().
                filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G')
                .forEach(System.out::println);

        System.out.println("\n**** Numero de Alumnos ***");
        System.out.println((long) listaAlumnos.size());

        System.out.println("\n**** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
        listaAlumnos.stream().
                filter(a -> a.getNota() >= 9 && a.getNombreCurso().equals("PHP"))
                .forEach(System.out::println);

        System.out.println("\n**** Imprimir los 2 primeros Alumnos de la lista ***");
        listaAlumnos.stream().limit(2).forEach(System.out::println);

        System.out.println("\n**** Imprimir el alumno con menor edad ***");
        System.out.println(listaAlumnos.stream().min(Comparator.comparingInt(AlumnoDTO::getEdad)));

        System.out.println("\n**** Imprimir el alumno con mayor edad ***");
        System.out.println(listaAlumnos.stream().max(Comparator.comparingInt(AlumnoDTO::getEdad)));

        System.out.println("\n**** Encontrar el primer Alumno***");
        System.out.println(listaAlumnos.stream().findFirst());

        System.out.println("\n**** Alumnos en los  que los nombres de los cursos (lenguajes) que terminan en t ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().endsWith("t")).forEach(System.out::println);

        System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);

        System.out.println("\n**** Alumnos en que su tamaño de su nombre es mayor a 10 caracteres ***");
        listaAlumnos.stream().filter(a -> a.getNombres().length() > 10).forEach(System.out::println);

        // combinar predicados
        System.out.println("\n**** Combinación de predicados ***");
        Predicate<AlumnoDTO> empiezaConP = a -> a.getNombreCurso().startsWith("P");
        Predicate<AlumnoDTO> longitud = a -> a.getNombreCurso().length() <= 6;
        // Obtiene los alumnos en los cuales el nombre del curso empieza con el
        // caracter 'P' y la longitud sea <= a 6
        listaAlumnos.stream().filter(empiezaConP.and(longitud)).forEach(System.out::println);


        /* Asignar resultado a una lista */
        List<AlumnoDTO> nuevaLista= listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).collect(Collectors.toList());
        nuevaLista.forEach(System.out::println);
    }

    public static List<AlumnoDTO> generaListaAlumnos(){
        List<AlumnoDTO> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new AlumnoDTO(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new AlumnoDTO(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new AlumnoDTO(3, "1717328901", "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
        listaAlumnos.add(new AlumnoDTO(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new AlumnoDTO(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new AlumnoDTO(6, "1717678456", "Germán Antonio", "Lotero Upegui", "Java 8", 8, 34));
        listaAlumnos.add(new AlumnoDTO(7, "1102156732", "Oscar Darío", "Murillo González", "Java 8", 8, 32));
        listaAlumnos.add(new AlumnoDTO(8, "1103421907", "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new AlumnoDTO(9, "1717297015", "César Oswaldo", "Alzate Agudelo", "Java 8", 8, 26));
        listaAlumnos.add(new AlumnoDTO(10, "1717912056", "Gloria Amparo", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new AlumnoDTO(11, "1717912058", "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new AlumnoDTO(12, "1717912985", "John Jairo", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new AlumnoDTO(13, "1717913851", "Julio Cesar", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new AlumnoDTO(14, "1717986531", "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
        listaAlumnos.add(new AlumnoDTO(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez", "Java Script", 10, 18));
        return listaAlumnos;
    }
}
