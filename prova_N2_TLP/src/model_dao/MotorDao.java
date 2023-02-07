package model_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model__entity.Motor;

public class MotorDao {

	//metodo para buscar uma lista de motores a partir do seu tipo de combustivel
    public ArrayList<Motor> buscarPorTipoDeCombustivel(String tipoDeCombustivel) {
        ArrayList<Motor> lista = new ArrayList<>();
        Motor m = null;
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from motor where tipoDeCombustivel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, tipoDeCombustivel);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Motor(rs.getString("modelo"), rs.getString("tipoDeCombustivel"));
                m.setId(rs.getInt("id"));
                lista.add(m);
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    //metodo para retornar um objeto do tipo Motor, com todas as
    //suas variaveis sendo passados pelo parametro
    public Motor buscar(String modelo, String tipoDeCombustivel) {
        Motor m = null;
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from motor where tipoDeCombustivel = ? and modelo = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, tipoDeCombustivel);
            statement.setString(2, modelo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Motor(rs.getString("modelo"), rs.getString("tipoDeCombustivel"));
                m.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    //metodo para buscar e retornar um objeto de Motor a partir do seu id,
    //sendo passado pelo parametro
    public Motor buscarPorId(int id) {
        Motor m = null;
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from motor where id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Motor(rs.getString("modelo"), rs.getString("tipoDeCombustivel"));
                m.setId(id);
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
}
