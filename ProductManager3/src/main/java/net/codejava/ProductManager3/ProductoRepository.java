package net.codejava.ProductManager3;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	List<Producto> findByMarcaContaining(String marca);
	
	List<Producto> findByPrecioGreaterThan(BigDecimal precio);
}
