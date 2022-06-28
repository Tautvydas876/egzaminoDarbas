package com.example.EgzaminoDarbas.service;

import com.example.EgzaminoDarbas.entity.Valgiarastis;

import java.util.List;

public interface ValgiarastisService {

    List<Valgiarastis> findAll();
    void save(Valgiarastis valgiarastis);

    Valgiarastis findByName(String name);

    void deleteById(int id);

    List<Valgiarastis> findAllByIstaigosId(int id);
}
