
package modelo;

import banco_dados.ConnectionFactory;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoriaDAO implements IDAO<Categoria>{

    private Connection conexao;
    private PreparedStatement comando;
    private ResultSet resultado;
    
    @Override
    public boolean insert(Categoria obj) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
        	
        	String sql = "INSERT INTO CATEGORIAS VALUES(null,"+obj.getNome()+","+obj.getAtivo()+","+
        	obj.getDataCriacao()+","+obj.getDataModificacao();
        	
        	/*
            String sql = "INSERT INTO CATEGORIAS VALUES(null, ?, ?, ?, ?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getAtivo());
            comando.setDate(3, obj.getDataCriacao());
            comando.setDate(4, obj.getDataModificacao());
            */
            retorno = comando.execute();
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        
        return retorno;
    }

    @Override
    public boolean update(Categoria obj) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
            //String sql = "UPDATE CATEGORIAS SET nome = ?, ativo = ?, datacriacao = ?, datamodificacao = ? WHERE idcategoria = ?";
        	String sql = "UPDATE CATEGORIAS SET nome = "+obj.getNome()+","+obj.getAtivo()+","+
                	obj.getDataCriacao()+","+obj.getDataModificacao()+"WHERE idcategoria = "+obj.getIdCategoria();
        	/*
        	comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getAtivo());
            comando.setDate(3, obj.getDataCriacao());
            comando.setDate(4, obj.getDataModificacao());
            comando.setInt(5, obj.getIdCategoria());
            */
            retorno = comando.execute();
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        finally{
        //    ConnectionFactory.closeConnection(conexao, comando);
        }
       
        return retorno;
    }

    @Override
    public boolean delete(Categoria obj) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "DELETE FROM CATEGORIAS WHERE idcategoria = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, obj.getIdCategoria());
            retorno = comando.execute();
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
       
        return retorno;
        
    }

    @Override
    public ArrayList<Categoria> findAll() {
        ArrayList<Categoria> listaCategorias = null;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "SELECT * FROM CATEGORIAS";
            comando = conexao.prepareStatement(sql);
            resultado = comando.executeQuery();
            while(true){
                listaCategorias.add(
                        new Categoria(
                                resultado.getInt("idcategoria"),
                                resultado.getString("nome"),
                                resultado.getString("ativo"),
                                resultado.getDate("datacriacao"),
                                resultado.getDate("datamodificacao")
                        )
                );
            }
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        finally{
            ConnectionFactory.closeConnection(conexao, comando, resultado);
        }
        
        
    }

    @Override
    public Categoria findById(int id) {
        Categoria categoria = null;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "SELECT * FROM CATEGORIAS WHERE idcategoria = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            resultado = comando.executeQuery();
            resultado.next();
                
            categoria = new Categoria(
                                resultado.getInt("idcategoria"),
                                resultado.getString("nome"),
                                resultado.getString("ativo"),
                                resultado.getDate("datacriacao"),
                                resultado.getDate("datamodificacao")
            );     
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        finally{
            ConnectionFactory.closeConnection(conexao, comando, resultado);
        }
        
        return categoria;
    }
    
}
