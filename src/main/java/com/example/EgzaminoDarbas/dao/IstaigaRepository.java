package com.example.EgzaminoDarbas.dao;

import com.example.EgzaminoDarbas.entity.Istaiga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IstaigaRepository extends JpaRepository<Istaiga, Integer> {

    Istaiga findById(int id);
    Istaiga findByPavadinimas(String name);
}
