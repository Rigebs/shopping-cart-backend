package com.rige.services;

import com.rige.dto.response.CategoriaResponse;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaResponse> listarCategorias();
}
