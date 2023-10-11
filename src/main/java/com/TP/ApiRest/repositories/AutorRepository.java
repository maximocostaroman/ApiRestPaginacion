package com.TP.ApiRest.repositories;

import com.TP.ApiRest.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long>{
    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%")
    List<Autor> search(@Param("filtro") String filtro);

    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%")
    Page<Autor> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM Autor WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%", nativeQuery = true)
    List<Autor> search1(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM Autor WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%", nativeQuery = true)
    List<Autor> search1(@Param("filtro") String filtro, Pageable pageable);
}
