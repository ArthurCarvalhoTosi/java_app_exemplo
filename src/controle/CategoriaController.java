
package controle;

import modelo.Categoria;
import modelo.CategoriaDAO;
import java.util.ArrayList;

/*
 * Essa classe implementa os métodos da interface IController passando o tipo
 * da classe.
 * 
 */

public class CategoriaController implements IController<Categoria>{

    private CategoriaDAO xpto = new CategoriaDAO();
    
    
    @Override
    public String save(Categoria obj) {
        String mensagem = "";
        try{
            if(obj.getNome().isEmpty() || obj.getAtivo().isEmpty()){
                mensagem = "Existe(m) campo(s) obrigatório(s) vazio(s).";
            } else{
                if(obj.getIdCategoria() == 0){
                    xpto.insert(obj);
                } else {
                    xpto.update(obj);
                }
                mensagem = "Categoria salva com sucesso...";
            }
        }
        catch(Exception erro){
            mensagem = "Erro ao salvar a catgegoria - " + erro.getMessage();
        }
        return mensagem;
    }

    @Override
    public String delete(Categoria obj) {
        String mensagem = "";
        try{
            
           xpto.delete(obj);
            
        }
        catch(Exception erro){
            mensagem = "Erro ao deletar a catgegoria - " + erro.getMessage();
        }
        return mensagem;
    }

    @Override
    public ArrayList<Categoria> findAll() {
        
        return xpto.findAll();
    }

    @Override
    public Categoria findById(int id) {
        return xpto.findById(id);
    }
    
}
