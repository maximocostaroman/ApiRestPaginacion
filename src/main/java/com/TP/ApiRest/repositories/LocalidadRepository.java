package com.TP.ApiRest.repositories;

import com.TP.ApiRest.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long> {

    List<Localidad> findByDenominacionContaining(String denominacion);

    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query("SELECT d FROM Localidad d WHERE d.denominacion LIKE %:filtro%")
    List<Localidad> search(@Param("filtro") String filtro);

    @Query("SELECT d FROM Localidad d WHERE d.denominacion LIKE %:filtro%")
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM localidad WHERE denominacion LIKE %:filtro%", nativeQuery = true)
    List<Localidad> search1(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM localidad WHERE denominacion LIKE %:filtro%", nativeQuery = true)
    Page<Localidad> search1(@Param("filtro") String filtro, Pageable pageable);
}
