package com.example.EgzaminoDarbas.entity;


import javax.persistence.*;
import java.util.List;

@Table(name = "valgiarastis")
@Entity
public class Valgiarastis {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "val_id")
    private int id;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @OneToMany(mappedBy = "valgiarastis", cascade = CascadeType.ALL)
    private List<Patiekalas> patiekalasList;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "istaiga_id")
    private Istaiga istaiga;


    public Valgiarastis() {
    }

    public Valgiarastis(int id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
    }

    public Valgiarastis(String pavadinimas) {
        this.pavadinimas = pavadinimas;
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

    public List<Patiekalas> getPatiekalasList() {
        return patiekalasList;
    }

    public void setPatiekalasList(List<Patiekalas> patiekalasList) {
        this.patiekalasList = patiekalasList;
    }

    public Istaiga getIstaiga() {
        return istaiga;
    }

    public void setIstaiga(Istaiga istaiga) {
        this.istaiga = istaiga;
    }
}
