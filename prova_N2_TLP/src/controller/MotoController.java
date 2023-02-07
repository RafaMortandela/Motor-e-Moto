package controller;

import java.util.ArrayList;

import model__entity.Moto;
import model__entity.Motor;
import model_dao.MotoDao;
import model_dao.MotorDao;

public class MotoController {

	//chamada do metodo cadastrar da classe MotoDao, para cadastrar no 
	//banco de dados uma nova Moto
    public void cadastrar(String modelo, int anoDeFabricacao, Motor motor){
        Moto m = new Moto(modelo, anoDeFabricacao, motor);
        MotoDao md = new MotoDao();
        md.cadastrar(m);
    }
    
    //chamada do metodo buscar da classe MotoDao, com o retorno de uma
    //lista de motos sendo associadas ao motor passado pelo parametro
    public ArrayList<Moto> buscar(Motor motor){
        MotoDao md = new MotoDao();
        return md.buscar(motor);
    }
    
    //chamada do metodo buscarPorAno da classe MotoDao, tendo o retorno de
    //uma lista de motos, tendo o seu ano de fabricacao igual ao ano passado
    //pelo parametro
    public ArrayList<Moto> buscarPorAno(int ano){
        MotoDao md = new MotoDao();
        return md.buscarPorAno(ano);
    }
}
