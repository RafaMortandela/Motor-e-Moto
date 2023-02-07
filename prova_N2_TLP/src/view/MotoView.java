package view;

import java.util.Scanner;

import controller.MotoController;
import controller.MotorController;
import model__entity.Moto;
import model__entity.Motor;

public class MotoView {
    Scanner sc = new Scanner(System.in);
    //variaveis do motor
    String tipoDeCombustivel, modeloMotor;
    //variaveis da moto
    String modeloMoto;
    int anoDeFabricacao;

    public void cadastro(){
        MotorController mc = new MotorController();
        MotoController motoC = new MotoController();
        
        //solicitacao e apresentacao dos motores
        System.out.println("Informe um tipo de combustivel: ");
        tipoDeCombustivel = sc.next();
        System.out.println("Motores: \n");
        for (Motor m : mc.buscarPorTipoDeCombustivel(tipoDeCombustivel)) {
            System.out.println(m.getModelo());
        }
        //solicitacao para cadastro do motor
        System.out.println("\nInforme o modelo do motor: ");
        modeloMotor = sc.next();
        //cadastro do motor
        Motor motor = mc.buscar(modeloMotor, tipoDeCombustivel);

        //solicitacao para cadastro da moto
        System.out.println("Informe o modelo da Moto: ");
        modeloMoto = sc.next();
        System.out.println("Informe o ano de fabricacao da Moto: ");
        anoDeFabricacao = sc.nextInt();
        //cadastro da moto
        motoC.cadastrar(modeloMoto, anoDeFabricacao, motor);
    }
    
    public void buscarPorAno() {
    	MotoController motoC = new MotoController();
    	
    	//solicitacao para busca
    	System.out.println("Informe um ano de Fabricacao: ");
    	anoDeFabricacao = sc.nextInt();
    	
    	//busca
    	System.out.println("\nDados das motos: ");
    	for (Moto m : motoC.buscarPorAno(anoDeFabricacao)) {
			System.out.println("\tModelo: "+m.getModelo());
			System.out.println("\tAno de fabricacao: "+m.getAnoDeFabricacao());
			System.out.println("\tModelo do motor: "+m.getMotor().getModelo());
			System.out.println("\tTipo de combustivel: "+m.getMotor().getTipoDeCombustivel()+"\n");
		}
    }
}
