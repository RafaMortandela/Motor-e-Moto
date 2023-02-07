package view;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        MotoView motoV = new MotoView();
        MotorView motorV = new MotorView();

        do {
            System.out.println("Escolha uma opcao: ");
            System.out.println("1- Cadastro de moto");
            System.out.println("2- Busca motos por motor");
            System.out.println("3- Busca motos por ano");
            System.out.println("4- Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    motoV.cadastro();
                break;
            
                case 2:
                    motorV.buscar();
                break;

                case 3:
                    motoV.buscarPorAno();
                break;
            }

        } while (opcao != 4);
    }
}

/*

Codigos SQL: 

create table motor(
	modelo varchar,
	tipoDeCombustivel varchar,
	id serial primary key
);

create table moto(
	modelo varchar,
	anoDeFabricacao int,
	idMotor int references motor(id),
	id serial primary key
);

insert into motor values ('modelo1', 'gasolina');
insert into motor values ('modelo2', 'diesel');
insert into motor values ('modelo3', 'gasolina');

*/
