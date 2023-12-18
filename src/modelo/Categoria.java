
package modelo;

import java.sql.Date;
import java.util.Calendar;

public class Categoria {
    
    private int idCategoria;
    private String nome;
    private String ativo;
    private Date dataCriacao;
    private Date dataModificacao;
    
    //método construtor passando todos os campos
    public Categoria(int idCategoria, String nome, String ativo, Date dataCriacao, Date dataModificacao) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
    //método construtor padrão
    public Categoria(){}

    //método para obter o id da categoria
    public int getIdCategoria() {
        return idCategoria;
    }

    //método para setar o id da categoria
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    //método para obter o nome da categoria
    public String getNome() {
        return nome;
    }

    //método para setar o nome da catgoria
    public void setNome(String nome) {
        this.nome = nome;
    }

    //método para obter o ativo da categoria
    public String getAtivo() {
        return ativo;
    }

    //método para setar o ativo da categoria
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    //método para obter a data de criação da categoria
    public Date getDataCriacao() {
        return dataCriacao;
    }

    //método para setar a data de criação da categoria
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
  //método para obter a data de criação da categoria
    public Date getDataModificacao() {
        return dataModificacao;
    }

  //método para setar a data de criação da categoria
    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    
}

