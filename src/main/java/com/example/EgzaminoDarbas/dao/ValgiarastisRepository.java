package com.example.EgzaminoDarbas.dao;

import com.example.EgzaminoDarbas.entity.Valgiarastis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValgiarastisRepository extends JpaRepository<Valgiarastis, Integer> {

    Valgiarastis findByPavadinimas(String name);


    @Query("select u from Valgiarastis  u where u.istaiga.id =:id")
    List<Valgiarastis> findAllByIstaigosId(@Param("id") int id);
}
