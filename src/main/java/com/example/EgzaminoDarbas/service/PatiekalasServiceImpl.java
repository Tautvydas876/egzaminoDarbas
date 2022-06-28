package com.example.EgzaminoDarbas.service;


import com.example.EgzaminoDarbas.dao.PatiekalasRepository;
import com.example.EgzaminoDarbas.entity.Patiekalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatiekalasServiceImpl implements PatiekalasService {

    @Autowired
    PatiekalasRepository patiekalasRepository;


    @Override
    public List<Patiekalas> findAll() {
        return patiekalasRepository.findAll();
    }

    @Override
    public void save(Patiekalas patiekalas) {
        patiekalasRepository.save(patiekalas);
    }

    @Override
    public void deleteById(int id) {
        patiekalasRepository.deleteById(id);
    }

    @Override
    public Patiekalas findById(int id) {
        return patiekalasRepository.findById(id);
    }
}
