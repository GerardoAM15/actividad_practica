package com.example.actividad.practica.service;

import com.example.actividad.practica.dto.ProductoDTO;
import com.example.actividad.practica.entity.Producto;
import com.example.actividad.practica.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listar() {
        return productoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ProductoDTO guardar(ProductoDTO dto) {
        Producto producto = toEntity(dto);
        Producto guardado = productoRepository.save(producto);
        return toDTO(guardado);
    }

    private ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    private Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return producto;
    }
}
