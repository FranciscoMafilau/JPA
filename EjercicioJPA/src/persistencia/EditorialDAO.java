
package persistencia;

import entidades.Editorial;
import javax.persistence.NoResultException;



    public class EditorialDAO extends DAO<Editorial>{
      @Override
    public void editar(Editorial objeto) {
        super.editar(objeto);
    }
    @Override
    public void guardar(Editorial objeto) {
        super.guardar(objeto);
    }

    @Override
    public void eliminar(Editorial objeto){
	super.eliminar(objeto);
    }

    

 public Editorial BuscarEditorialPorNombre(String nombre) {
        try {
            conectar();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                    .setParameter("nombre", nombre).getSingleResult();
            desconectar();

            return editorial;

        } catch (NoResultException e) {
            return null;
        }
    }
}
