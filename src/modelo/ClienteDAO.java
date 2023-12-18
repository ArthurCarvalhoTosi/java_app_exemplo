
package modelo;

import banco_dados.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO implements IDAO<Cliente>{
    
    private Connection conexao;
    private PreparedStatement comando;
    private ResultSet resultado;
    
    @Override
    public boolean insert(Cliente obj){
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "INSERT INTO CLIENTES VALUES(null, ?, ?, ?, ?, ?, ?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getEmail());
            comando.setString(3, obj.getTelefone());
            comando.setString(4, obj.getAtivo());
            comando.setDate(5, obj.getDataCriacao());
            comando.setDate(6, obj.getDataModificacao());
            retorno = comando.execute();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        } finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        return retorno;
    }

    @Override
    public boolean update(Cliente obj) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "UPDATE CLIENTES SET nome = ?, email = ?, telefone = ?, ativo = ?, datacriacao = ?, datamodificacao = ? WHERE idcliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getEmail());
            comando.setString(3, obj.getTelefone());
            comando.setString(4, obj.getAtivo());
            comando.setDate(5, obj.getDataCriacao());
            comando.setDate(6, obj.getDataModificacao());
            comando.setInt(7, obj.getIdCliente());
            retorno = comando.execute();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        } finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        return retorno;
    }

    
    @Override
    public boolean delete(Cliente obj) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try{
            String sql = "DELETE FROM CLIENTES WHERE idcliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, obj.getIdCliente());
            retorno = comando.execute();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        } finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        return retorno;
    }

    @Override
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try{
            String sql = "SELECT * FROM CLIENTES";
            comando = conexao.prepareStatement(sql);
            resultado = comando.executeQuery();
            while(resultado.next()){
                Cliente cliente = new Cliente(
                        resultado.getInt("idcliente"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("telefone"),
                        resultado.getString("ativo"),
                        resultado.getDate("datacriacao"),
                        resultado.getDate("datamodificacao")
                );
                listaClientes.add(cliente);
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        } finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        return listaClientes;
    }

    @Override
    public Cliente findById(int id) {
        Cliente cliente = null;
        try{
            String sql = "SELECT * FROM CLIENTES WHERE idcliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            resultado = comando.executeQuery();
            resultado.next();
            cliente = new Cliente(
                        resultado.getInt("idcliente"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("telefone"),
                        resultado.getString("ativo"),
                        resultado.getDate("datacriacao"),
                        resultado.getDate("datamodificacao")
            );
            
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        } finally{
            ConnectionFactory.closeConnection(conexao, comando);
        }
        return cliente;
    }

    
    
}
