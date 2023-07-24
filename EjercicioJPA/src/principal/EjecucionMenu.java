
package principal;

import entidades.Libro;
import java.util.Scanner;
import servicio.AutorServicio;
import servicio.EditorialServicio;
import servicio.LibroServicio;


public class EjecucionMenu {

   
    public static void main(String[] args) {
		LibroServicio libroServ = new LibroServicio();
	AutorServicio autorServ = new AutorServicio();
	EditorialServicio editorialServ = new EditorialServicio();
	Scanner leer = new Scanner(System.in).useDelimiter("\n");
 int resp;
     System.out.println("--------------------MENU---------------------");
        System.out.println("#############################################");
        System.out.println("1. Listar todos los libros.");
        System.out.println("2. Dar de alta o baja un Autor, una Editorial o un libro.");
        System.out.println("3. Buscar un Autor por Nombre.");
        System.out.println("4. Búscar un libro por ISBN.");
        System.out.println("5. Buscar un libro por título.");
        System.out.println("6. Buscar un libro/s por nombre de Autor.");
        System.out.println("7. Buscar un libro/s por nombre de Editorial.");

        resp = leer.nextInt();

        switch (resp) {
            case 1:
                // Listar todos los libros
                for (Libro libros : libroServ.listarLibros()) {
                    System.out.println(libros);
                }
                break;
            case 2:
                String resp1;
                System.out.println("A. Dar De Baja/Alta un Autor");
                System.out.println("B. Dar de Baja/Alta una Editorial");
                System.out.println("C. Dar de Baja/Alta un Libro");
                resp1 = leer.next();
                if (resp1.equalsIgnoreCase("A")) {
                    System.out.println("Ingrese el nombre del autor");
                    String nombreA = leer.next();
                    System.out.println(autorServ.buscarAutorPorNombre(nombreA));
                }
        }

}
    }
    
