
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



    @Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestante;
    private Boolean alta;
    @ManyToOne
    ////@JoinColumn(name = "autor_id")
    private Autor autor;
    @ManyToOne
    ///@JoinColumn(name = "editorial_id")
    private Editorial editorial;


    public Libro() {
	this.alta = true;
    }


    public Libro(Integer id, long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestante, Boolean alta, Autor autor, Editorial editorial) {
	this.id = id;
	this.isbn = isbn;
	this.titulo = titulo;
	this.anio = anio;
	this.ejemplares = ejemplares;
	this.ejemplaresPrestados = ejemplaresPrestados;
	this.ejemplaresRestante = ejemplaresRestante;
	this.alta = alta;
	this.autor = autor;
	this.editorial = editorial;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public long getIsbn() {
	return isbn;
    }

    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public Integer getAnio() {
	return anio;
    }

    public void setAnio(Integer anio) {
	this.anio = anio;
    }

    public Integer getEjemplares() {
	return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
	this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
	return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
	this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestante() {
	return ejemplaresRestante;
    }

    public void setEjemplaresRestante(Integer ejemplaresRestante) {
	this.ejemplaresRestante = ejemplaresRestante;
    }

    public Boolean isAlta() {
	return alta;
    }

    public void setAlta(Boolean alta) {
	this.alta = alta;
    }

    public Autor getAutor() {
	return autor;
    }

    public void setAutor(Autor autor) {
	this.autor = autor;
    }

    public Editorial getEditorial() {
	return editorial;
    }

    public void setEditorial(Editorial editorial) {
	this.editorial = editorial;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (id != null ? id.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	if (!(object instanceof Libro)) {
	    return false;
	}
	Libro other = (Libro) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return " ID: " + id + " TITULO: " + titulo + " Alta/Baja: " + alta + " AUTOR: " + autor;
    }
}
