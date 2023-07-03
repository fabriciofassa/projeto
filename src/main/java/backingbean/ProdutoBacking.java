package backingbean;

import bean.Produto;
import jdbc.ConnectionFactory;
import java.sql.*;
import java.util.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 * @author Fabricio
 */
@ManagedBean
@ViewScoped
public class ProdutoBacking {

    public int idProduto;
    public String descricao;
    public String saida;

    public ProdutoBacking() {
        initComponents();
    }

    private void initComponents() { 

    }

    public List getList() throws Exception {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(
                "select "
                + "id, "
                + "descricao "        
                + "from sis_produto "
                + "order by id "
        );

        try {
            return gerarLista(stmt);
        } catch (Exception e) {
            throw new Exception("Erro ao executar query. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }

    public List gerarLista(PreparedStatement stmt) throws Exception {
        List lista = new ArrayList();

        ResultSet rs = stmt.executeQuery();
        Produto c = null;

        while (rs.next()) {
            c = new Produto();
            c.setIdProduto(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            lista.add(c);
        }
        return lista;
    }


    /*
     * Getters e setters.
     */
    public String act() {
        return saida;
    }

    public int getidProduto() {
        return idProduto;
    }

    public void setidProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


  

}
