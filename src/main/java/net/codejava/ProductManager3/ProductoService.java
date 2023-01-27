package net.codejava.ProductManager3;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	public List<Producto> listAll(){
		return repo.findAll();
	}
	
	public void save (Producto producto) {
		repo.save(producto);
	}
	
	public Producto get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Producto> getByMarca(String marca) {
		return repo.findByMarcaContaining(marca);
	}
	
	public List<Producto> getPrecioMayorQue(BigDecimal precio){
		return repo.findByPrecioGreaterThan(precio);
	}
}
