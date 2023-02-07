package view;

import java.util.Scanner;

import controller.MotoController;
import controller.MotorController;
import model__entity.Moto;

public class MotorView {
    Scanner sc = new Scanner(System.in);
    String tipoDeCombustivel, modeloMotor;

    public void buscar(){
    	MotoController mc = new MotoController();
    	MotorController mrc = new MotorController();
    	
    	//solicitacao para busca
        System.out.println("Informe o tipo de combustivel: ");
        tipoDeCombustivel = sc.next();
        System.out.println("\nInforme o modelo do motor: ");
        modeloMotor = sc.next();
        
        //busca (utilizei o metodo de criacao de objeto do tipo
        //motor, para conseguir realizar a busca das motos passando
        //por parametros este objeto)
        System.out.println("Dados das motos: \n");
        for (Moto m : mc.buscar(mrc.buscar(modeloMotor, tipoDeCombustivel))) {
			System.out.println("Modelo: "+m.getModelo());
			System.out.println("Ano de Fabricacao: "+m.getAnoDeFabricacao()+"\n");
		}
    }
}
