package model__entity;

public class Moto {
	//criacao da classe Moto no modelo BEAN
    private String modelo;
    private int anoDeFabricacao, id;
    private Motor motor;

    public Moto(String modelo, int anoDeFabricacao, Motor motor) {
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }
    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }
    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
