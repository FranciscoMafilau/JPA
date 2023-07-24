
package principal;

import entidades.Autor;
import entidades.Editorial;
import servicio.AutorServicio;
import servicio.EditorialServicio;
import servicio.LibroServicio;


public class Menu {
    private final LibroServicio libroServ = new LibroServicio();
    private final AutorServicio autorServ = new AutorServicio();
    private final EditorialServicio editorialServ = new EditorialServicio();

 public Menu() {
        libroServ.setServicios(autorServ, editorialServ);
        autorServ.setServicios(libroServ, editorialServ);
        editorialServ.setServicios(autorServ, libroServ);
    }


public void crearEntidades(){
Autor autor1 = autorServ.crearAutor("J.R.R.Tolkien");
Editorial editorial1 = editorialServ.crearEditorial("Martins Fontes");
libroServ.crearLibro(9788533608818L, "El Hobbit",1937, 300, 125,  175, true, autor1, editorial1);
}
}
