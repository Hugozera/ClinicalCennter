package DAO;

import Modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDaoClasse implements UsuarioDaoInterface, AutoCloseable {
    private Connection con;

    public UsuarioDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    private void inserirUsuario(Pessoa u) throws ErroDAO {
        String sql = "insert into usuario (login, senha, pessoaid) values(?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setInt   (3,u.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    @Override
    public void inserirPessoa(Pessoa u) throws ErroDAO {
        String sql = "insert into pessoa(nome, flagMedico, dataNasc, sexo, nomeMae, NaturalidadeMuni, Endereco, naturalidadeEsta) values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, u.getNome());
            pstm.setInt(2, u.getFlagMedico());
            pstm.setString(3, u.getDataNasc());
            pstm.setString(4, u.getSexo());
            pstm.setString(5, u.getNomeMae());
            pstm.setString(6, u.getNaturalidadeMun());
            pstm.setString(7, u.getEndereco());
            pstm.setString(8, u.getNaturalidade());
            pstm.executeUpdate();
             ResultSet rs = pstm.getGeneratedKeys();
           if (rs.next()) {
            u.setCodigo(rs.getInt(1));
           }
            System.out.println(u.getCodigo());
            inserirUsuario(u);
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    public void editarUsuarioPaciente(Pessoa u) throws ErroDAO {
        String sql = "UPDATE pessoa INNER JOIN usuario ON pessoaid = id_pessoa SET endereco = ?, usuario.senha =? WHERE pessoaid = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u.getEndereco());
            pstm.setString(2, u.getSenha());
            pstm.setInt(3, u.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public void editarUsuario(Pessoa u) throws ErroDAO {
        System.out.println(u);
        String sql = "UPDATE pessoa SET nome = ?, dataNasc = ?,  nomeMae = ?, naturalidadeMuni = ?, endereco = ?, naturalidadeEsta = ? WHERE id_pessoa = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getDataNasc());
            pstm.setString(3, u.getNomeMae());
            pstm.setString(4, u.getNaturalidadeMun());
            pstm.setString(5, u.getEndereco());
            pstm.setString(6, u.getNaturalidade());
            pstm.setInt(7, u.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    public void editarPaciente(Pessoa u) throws ErroDAO {
        System.out.println(u);
        String sql = "UPDATE pessoa  INNER JOIN usuario ON pessoa.id_pessoa = usuario.pessoaID SET pessoa.nome = ?, pessoa.dataNasc = ?, pessoa.nomeMae = ?, pessoa.naturalidadeMuni = ?,  pessoa.endereco = ?, pessoa.naturalidadeEsta = ?, usuario.senha = ?, usuario.login = ?, pessoa.flagMedico = ?, pessoa.sexo = ? WHERE pessoa.id_pessoa = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getDataNasc());
            pstm.setString(3, u.getNomeMae());
            pstm.setString(4, u.getNaturalidadeMun());
            pstm.setString(5, u.getEndereco());
            pstm.setString(6, u.getNaturalidade());
            pstm.setString(7, u.getSenha());
            pstm.setString(8, u.getLogin());
            pstm.setString(11, String.valueOf(u.getFlagMedico()));
            pstm.setString(10, u.getSexo());
            pstm.setInt(9, u.getCodigo());
            pstm.executeUpdate();
            System.out.println(u);
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


    public Pessoa buscarPaciente(String codigo) throws ErroDAO {
        String sql = "select * from pessoa p inner join usuario u on p.id_pessoa = u.pessoaID where id_pessoa = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            Pessoa u = new Pessoa();
            if (rs.next()) {
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setIdPessoa(Integer.parseInt(codigo));
                u.setNome(rs.getString("nome"));
                u.setNomeMae(rs.getString("nomeMae"));
                u.setEndereco(rs.getString("endereco"));
                u.setFlagMedico(rs.getInt("flagMedico"));
                u.setDataNasc(rs.getString("dataNasc"));
                u.setNaturalidade(rs.getString("naturalidadeEsta"));
                u.setNaturalidadeMun(rs.getString("naturalidadeMuni"));
                u.setSexo(rs.getString("sexo"));
            }
            return u;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
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
        String sql = "select * from pessoa p inner join usuario u on p.id_pessoa = u.pessoaID where u.login = ? and u.senha =?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            Pessoa u = new Pessoa();
            if (rs.next()) {
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setIdPessoa(rs.getInt("id_pessoa"));
                u.setNome(rs.getString("nome"));
                u.setNomeMae(rs.getString("nomeMae"));
                u.setEndereco(rs.getString("endereco"));
                u.setFlagMedico(rs.getInt("flagMedico"));
                u.setDataNasc(rs.getString("dataNasc"));
                u.setNaturalidade(rs.getString("naturalidadeEsta"));
                u.setNaturalidadeMun(rs.getString("naturalidadeMuni"));
                u.setSexo(rs.getString("sexo"));
                u.setCodigo(rs.getString("pessoaID"));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public ArrayList relatorioGeral() throws ErroDAO {

        String sql = "select login, nome, datanasc, sexo, senha, pessoaID,nomeMae,naturalidadeEsta,NaturalidadeMuni,flagMedico,endereco from pessoa inner join usuario on pessoaID = id_pessoa where flagmedico <> 1;";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList p= new ArrayList<>();
            while (rs.next()) {
                Pessoa u = new Pessoa();
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setIdPessoa(rs.getInt("pessoaID"));
                u.setNome(rs.getString("nome"));
                u.setNomeMae(rs.getString("nomeMae"));
                u.setEndereco(rs.getString("endereco"));
                u.setFlagMedico(rs.getInt("flagMedico"));
                u.setDataNasc(rs.getString("dataNasc"));
                u.setNaturalidade(rs.getString("naturalidadeEsta"));
                u.setNaturalidadeMun(rs.getString("naturalidadeMuni"));
                u.setSexo(rs.getString("sexo"));
                p.add(u);
            }
            System.out.println(p.toString());
            return p;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public ArrayList relatorioNome(String nome) throws ErroDAO {
        nome = nome +"%";
        String sql = "SELECT u.login, p.* FROM usuario u JOIN pessoa p ON u.pessoaid = p.id_pessoa WHERE LOWER(p.nome) LIKE LOWER(?) OR LOWER(p.nome) = LOWER(?);";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, nome);
            pstm.setString(2, nome);
            ResultSet rs = pstm.executeQuery();
            ArrayList p = new ArrayList<>();

            while (rs.next()) {
                Pessoa u = new Pessoa();
                u.setLogin(rs.getString("login"));
                u.setIdPessoa(rs.getInt("id_pessoa"));
                u.setNome(rs.getString("nome"));
                u.setNomeMae(rs.getString("nomeMae"));
                u.setEndereco(rs.getString("endereco"));
                u.setFlagMedico(rs.getInt("flagMedico"));
                u.setDataNasc(rs.getString("dataNasc"));
                u.setNaturalidade(rs.getString("naturalidadeEsta"));
                u.setNaturalidadeMun(rs.getString("naturalidadeMuni"));
                u.setSexo(rs.getString("sexo"));
                p.add(u);
            }
            System.out.println(p.toString());
            return p;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void close() throws ErroDAO {
    }


    public static void main(String[] args) {

        try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
            Pessoa u = new Pessoa();
            System.out.println(dao.buscarPaciente(String.valueOf(3)));
            System.out.println();
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }

    }
}
