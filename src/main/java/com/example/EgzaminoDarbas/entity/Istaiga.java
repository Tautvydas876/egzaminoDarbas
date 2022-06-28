package com.example.EgzaminoDarbas.entity;


import javax.persistence.*;
import java.util.List;

@Table(name = "istaiga")
@Entity
public class Istaiga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "istaiga_id")
    private int id;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @Column(name = "kodas")
    private int kodas;

    @Column(name = "adresas")
    private String adresas;


    @OneToMany(mappedBy = "istaiga", cascade = CascadeType.ALL)
    private List<Valgiarastis> valgiarastis;

    public Istaiga() {
    }

    public Istaiga(int id, String pavadinimas, int kodas, String adresas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
    }

    public Istaiga(String pavadinimas, int kodas, String adresas) {
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
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

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public List<Valgiarastis> getValgiarastis() {
        return valgiarastis;
    }

    public void setValgiarastis(List<Valgiarastis> valgiarastis) {
        this.valgiarastis = valgiarastis;
    }
}
