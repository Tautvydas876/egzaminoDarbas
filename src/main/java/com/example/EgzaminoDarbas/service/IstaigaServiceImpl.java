package com.example.EgzaminoDarbas.service;


import com.example.EgzaminoDarbas.dao.IstaigaRepository;
import com.example.EgzaminoDarbas.entity.Istaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IstaigaServiceImpl implements IstaigaService {


    @Autowired
    private IstaigaRepository istaigaRepository;


    @Override
    public List<Istaiga> findAll() {
        return istaigaRepository.findAll();
    }

    @Override
    public void save(Istaiga istaiga) {
        istaigaRepository.save(istaiga);
    }

    @Override
    public Istaiga fintById(int id) {
        return istaigaRepository.findById(id);
    }

    @Override
    public Istaiga findByName(String name) {
        return istaigaRepository.findByPavadinimas(name);
    }
}
