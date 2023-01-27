package net.codejava.ProductManager3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_Id", nullable = false, insertable = false, updatable = false)
    private Integer id;
	
	@Column(name = "PRO_Nombre", nullable = false, insertable = true, updatable = true)
    private String nombre;
	
	@Column(name = "PRO_Marca", nullable = false, insertable = true, updatable = true)
    private String marca;
	
	@Column(name = "PRO_Elaborado", nullable = false, insertable = true, updatable = true)
    private String elaborado;
	
	@Column(name = "PRO_Precio", nullable = false, insertable = true, updatable = true)
    private float precio;

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getElaborado() {
		return elaborado;
	}

	public void setElaborado(String elaborado) {
		this.elaborado = elaborado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
