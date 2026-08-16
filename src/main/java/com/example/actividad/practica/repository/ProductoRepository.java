package com.example.actividad.practica.repository;

import com.example.actividad.practica.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
