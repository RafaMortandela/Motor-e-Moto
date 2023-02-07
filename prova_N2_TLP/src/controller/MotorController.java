package controller;

import java.util.ArrayList;

import model__entity.Motor;
import model_dao.MotorDao;

public class MotorController {

	//chamada do metodo buscarPorTipoDeCombustivel da classe MotorDao,
	//retornando uma lista de motores
    public ArrayList<Motor> buscarPorTipoDeCombustivel(String tipoDeCombustivel){
        MotorDao md = new MotorDao();
        return md.buscarPorTipoDeCombustivel(tipoDeCombustivel);
    }

    //chamada do metodo buscar da classe MotorDao, para ser possivel
    //o retorno de um objeto do tipo Motor a partir de suas variaveis
    //sendo passadas pelo parametro
    public Motor buscar(String modelo, String tipoDeCombustivel){
        MotorDao md = new MotorDao();
        return md.buscar(modelo, tipoDeCombustivel);
    }
}
