package com.TP.ApiRest.services;

import com.TP.ApiRest.entities.Autor;
import com.TP.ApiRest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorService extends BaseService<Autor,Long> {
    List<Autor> search(String filtro) throws Exception;

    Page<Autor> search(String  filtro, Pageable pageable) throws Exception;
}
