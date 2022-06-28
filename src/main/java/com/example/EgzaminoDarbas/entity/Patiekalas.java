package com.example.EgzaminoDarbas.entity;


import javax.persistence.*;

@Entity
@Table(name = "patiekalas")
public class Patiekalas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @Column(name = "aprasas", columnDefinition = "text")
    private String aprasas;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "val_id")
    private Valgiarastis valgiarastis;




    public Patiekalas() {
    }

    public Patiekalas(int id, String pavadinimas, String aprasas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.aprasas = aprasas;
    }

    public Patiekalas(String pavadinimas, String aprasas) {
        this.pavadinimas = pavadinimas;
        this.aprasas = aprasas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAprasas() {
        return aprasas;
    }

    public void setAprasas(String aprasas) {
        this.aprasas = aprasas;
    }

    public Valgiarastis getValgiarastis() {
        return valgiarastis;
    }

    public void setValgiarastis(Valgiarastis valgiarastis) {
        this.valgiarastis = valgiarastis;
    }
}

