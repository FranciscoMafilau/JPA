
package servicio;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.LibroDAO;


public class LibroServicio {
    
	private AutorServicio autorServicio;
	private EditorialServicio editorialServicio;
	private final LibroDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public LibroServicio() {
	this.DAO = new LibroDAO();
    }

    public void setServicios(AutorServicio autorServicio, EditorialServicio editorialServicio) {
	this.autorServicio = autorServicio;
	this.editorialServicio = editorialServicio;
    }

// este método invoca el método guardar de la clase DAO padre para 
    // persistir un objeto Mascota
	
public Libro crearLibro (long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestante, Boolean alta, Autor autor, Editorial editorial){
 Libro libro = new Libro();

           if (titulo == null || anio == null || ejemplares == null || ejemplaresPrestados == null || ejemplaresRestante == null || autor == null || editorial == null) {
            throw new IllegalArgumentException("Los campos deben estar completos, no pueden ser nulos.");
            }
            try{ 
                if(DAO.buscarLibroPorTitulo(titulo) == null){
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestante(ejemplaresRestante);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            DAO.guardar(libro);
            return libro;
            }else{
                    System.out.println("El Libro ya existe");
                return null;
                }      
}catch (Exception e){
    System.out.println(e.getMessage());
    return null;
}
}



    public void DarDeAltaoBaja() throws Exception{
        Integer id;
        Libro libro1 = new Libro();
        System.out.println("Seleccione el ID de un libro para dar de alta o baja?");
        for (Libro libro : DAO.listarLibros()) {
            System.out.println(libro);
          }
         id = leer.nextInt();
         libro1 = BuscarLibroPorId(id);
         
         
        
        if(libro1.isAlta()){
            libro1.setAlta(false);
            System.out.println("El Libro fue dado de baja");
         }else{
            libro1.setAlta(true);
            System.out.println("El libro fue dado de alta");
         }
         DAO.editar(libro1);
    
    }
    
//    public void MostrarTabla(){
//     TableBuilder tableBuilder = new TableBuilder();
//        tableBuilder.addRow("Nombre", "Edad", "Correo");
//        tableBuilder.addSeparator();
//        tableBuilder.addRow("Juan", "25", "juan@example.com");
//        tableBuilder.addRow("María", "30", "maria@example.com");
//        tableBuilder.addRow("Pedro", "28", "pedro@example.com");
//
//        String table = tableBuilder.toString();
//        System.out.println(table);
//    
//    }
    public Libro BuscarLibroPorTitulo(String titulo){
        try {
            return DAO.buscarLibroPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    
    }
    
    public List<Libro> buscarLibroPorAutor(String nombre) {

        try {
            return DAO.buscarLibroPorAutor(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Libro BuscarLibroPorIsbn(Long isbn){
        try {
            return DAO.buscarLibroPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     public Libro BuscarLibroPorId(Integer id){
        try {
            return DAO.buscarLibroPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }  
    }
     
    public List<Libro> listarLibros(){
    try {
            return DAO.listarLibros();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }  
    
    }
    
    public List<Libro> buscarLibroPorEditorial(String nombre) {

        try {
            return DAO.buscarLibroPorEditorial(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
