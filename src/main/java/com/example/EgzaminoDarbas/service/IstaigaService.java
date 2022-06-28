package com.example.EgzaminoDarbas.service;

import com.example.EgzaminoDarbas.entity.Istaiga;

import java.util.List;

public interface IstaigaService {

    List<Istaiga> findAll();

    void save(Istaiga istaiga);

    Istaiga fintById(int id);

    Istaiga findByName(String name);
}
