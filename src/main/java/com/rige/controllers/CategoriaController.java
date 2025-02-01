package com.rige.controllers;

import com.rige.dto.response.CategoriaResponse;
import com.rige.services.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
@AllArgsConstructor
public class CategoriaController {
    private final ICategoriaService iCategoriaService;

    @GetMapping
    public List<CategoriaResponse> listarCategorias() {
        return iCategoriaService.listarCategorias();
    }
}
