package model__entity;

import java.util.ArrayList;

public class Motor {
	//criacao da classe Motor no modelo BEAN
    private String modelo;
    private String tipoDeCombustivel;
    private int id;
    private ArrayList<Moto> lista;

    public Motor(String modelo, String tipoDeCombustivel) {
        this.modelo = modelo;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.lista = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }
    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }
    public ArrayList<Moto> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Moto> lista) {
        this.lista = lista;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}