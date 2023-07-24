package DAO;

import Modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDaoClasse  implements UsuarioDaoInterface, AutoCloseable{
    private Connection con;

    public UsuarioDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Pessoa u) throws ErroDAO {
        String sql = "insert into usuario(login,senha,nome) values(?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getNome());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                u.setCodigo(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(Pessoa u) throws ErroDAO {

    }

    @Override
    public void deletar(int codigo) throws ErroDAO {

    }

    @Override
    public void editar(Pessoa u) throws ErroDAO {

    }

    @Override
    public Pessoa buscar(int codigo) throws ErroDAO {
        String sql = "select * from usuario where codigo=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Pessoa u = new Pessoa();
                u.setCodigo(rs.getInt("codigo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Pessoa buscar(Pessoa u) throws ErroDAO {
        return buscar(u.getCodigo());
    }

    @Override
    public Pessoa buscar(String login, String senha) throws ErroDAO {
        String sql = "select * from usuario where login=? and senha=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Pessoa u = new Pessoa();
                u.setCodigo(rs.getInt("codigo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }

    }
    public static boolean validadorTipoUsuario(Pessoa u){


        return false;

    }

    @Override
    public void close() throws Exception {

    }
    public static void main(String[] args) {
       Pessoa u=new Pessoa();

        try (UsuarioDaoClasse dao=new UsuarioDaoClasse()){
            UsuarioDaoClasse uu = new UsuarioDaoClasse();
            System.out.println(dao.buscar("1","123"));
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
