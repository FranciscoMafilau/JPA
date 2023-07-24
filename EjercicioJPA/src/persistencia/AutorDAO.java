
package persistencia;

import entidades.Autor;
import javax.persistence.NoResultException;

public class AutorDAO extends DAO<Autor>{
   @Override
public void editar(Autor objeto) {
        super.editar(objeto);
    }
@Override
    public void guardar(Autor objeto) {
        super.guardar(objeto);
    }

   @Override
    public void eliminar(Autor objeto) {
        super.eliminar(objeto);
    }

     public Autor buscarAutorPorNombre(String nombre) {
        try {
            conectar();
            Autor autor = (Autor) em.createQuery(" SELECT A FROM Autor  A WHERE A.nombre = :nombre and A.alta = 1")
                    .setParameter("nombre", nombre).getSingleResult();
            desconectar();
            return autor;
        } catch (NoResultException e) {
            return null;
        }

    }
    }

