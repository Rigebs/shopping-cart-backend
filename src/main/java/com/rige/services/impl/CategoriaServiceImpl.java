package com.rige.services.impl;

import com.rige.dto.response.CategoriaResponse;
import com.rige.entities.CategoriaEntity;
import com.rige.repositories.ICategoriaRepository;
import com.rige.services.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository iCategoriaRepository;

    @Override
    public List<CategoriaResponse> listarCategorias() {
        List<CategoriaEntity> listaEntidad = iCategoriaRepository.findAll();

        List<CategoriaResponse> listaResponse = new ArrayList<>();

        for (CategoriaEntity categoria : listaEntidad) {
            CategoriaResponse categoriaResponse = new CategoriaResponse();
            categoriaResponse.setId(categoria.getId());
            categoriaResponse.setNombre(categoria.getNombre());
            listaResponse.add(categoriaResponse);
        }
        return listaResponse;
    }
}
