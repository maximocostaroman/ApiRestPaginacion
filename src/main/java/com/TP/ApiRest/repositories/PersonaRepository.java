package com.TP.ApiRest.repositories;

import com.TP.ApiRest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long > {

    //Metodo query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsByDni(int dni);

    //Anotacion JPQL indexados
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM persona WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%", nativeQuery = true)
    List<Persona> search1(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM persona WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%",countQuery = "SELECT count(*) FROM persona", nativeQuery = true)
    Page<Persona> search1(@Param("filtro") String filtro, Pageable pageable);


}
