package com.example.EgzaminoDarbas.dao;

import com.example.EgzaminoDarbas.entity.Patiekalas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatiekalasRepository  extends JpaRepository<Patiekalas, Integer> {

    Patiekalas findById(int id);
}
