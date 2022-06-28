package com.example.EgzaminoDarbas.service;


import com.example.EgzaminoDarbas.dao.ValgiarastisRepository;
import com.example.EgzaminoDarbas.entity.Valgiarastis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValgiarastisServiceImpl implements ValgiarastisService {

    @Autowired
    private ValgiarastisRepository valgiarastisRepository;


    @Override
    public List<Valgiarastis> findAll() {
        return valgiarastisRepository.findAll();
    }

    @Override
    public void save(Valgiarastis valgiarastis) {
        valgiarastisRepository.save(valgiarastis);
    }

    @Override
    public Valgiarastis findByName(String name) {
        return valgiarastisRepository.findByPavadinimas(name);
    }

    @Override
    public void deleteById(int id) {
        valgiarastisRepository.deleteById(id);
    }

    @Override
    public List<Valgiarastis> findAllByIstaigosId(int id) {
        return valgiarastisRepository.findAllByIstaigosId(id);
    }
}
