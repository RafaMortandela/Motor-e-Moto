package model_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model__entity.Moto;
import model__entity.Motor;

public class MotoDao {
	
	//metodo para cadastro de uma Moto no banco de dados
    public void cadastrar(Moto moto){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "insert into moto values(?, ?, ?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, moto.getModelo());
            statement.setInt(2, moto.getAnoDeFabricacao());
            statement.setInt(3, moto.getMotor().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //metodo para retornar uma lista de motos a partir de seu motor,
    //sendo passado este pelo parametro
    public ArrayList<Moto> buscar(Motor motor){
        Connection conexao = ConectaBanco.getConnection();
        ArrayList<Moto> lista = new ArrayList<Moto>();
        try{
            String sql = "select * from moto, motor where motor.id = moto.idMotor"
            		+ " and motor.modelo = ? and motor.tipoDeCombustivel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, motor.getModelo());
            statement.setString(2, motor.getTipoDeCombustivel());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Moto moto = new Moto(rs.getString("modelo"), rs.getInt("anoDeFabricacao"), motor);
                moto.setId(rs.getInt("id"));
                lista.add(moto);
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    //metodo para retornar uma lista de motos a partir de seu ano
    //de fabricacao, que é passado pelo parametro
    public ArrayList<Moto> buscarPorAno(int ano){
        Connection conexao = ConectaBanco.getConnection();
        ArrayList<Moto> lista = new ArrayList<Moto>();
        //chamada da classe MotorDao para ser possivel utilizar o metodo
        //comentado abaixo
        MotorDao md = new MotorDao();
        try{
            String sql = "select * from moto, motor where motor.id = moto.idMotor"
            		+ " and moto.anoDeFabricacao = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, ano);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            	//aqui utilizei o metodo buscarPorId, da classe MotorDao, para ser possivel 
            	//a construcao de um objeto do tipo Moto, sendo passado o objeto Motor pelos
            	//seus parametros (utilizei a logica motor.id = moto.idMotor)
                Moto moto = new Moto(rs.getString("modelo"), rs.getInt("anoDeFabricacao"), md.buscarPorId(rs.getInt("id")));
                moto.setId(rs.getInt("id"));
                lista.add(moto);
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
