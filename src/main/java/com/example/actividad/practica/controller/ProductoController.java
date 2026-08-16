package com.example.actividad.practica.controller;

import com.example.actividad.practica.dto.ProductoDTO;
import com.example.actividad.practica.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> guardar(@Valid @RequestBody ProductoDTO dto) {
        ProductoDTO creado = productoService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}