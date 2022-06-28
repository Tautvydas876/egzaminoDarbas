package com.example.EgzaminoDarbas.service;

import com.example.EgzaminoDarbas.entity.Patiekalas;

import java.util.List;

public interface PatiekalasService {

    List<Patiekalas> findAll();

    void save(Patiekalas patiekalas);
    void deleteById(int id);
    Patiekalas findById(int id);
}
