package DAO;

import Modelo.Anamnese;
import Modelo.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class AnamneseDaoClasse implements AnamneseInterface, AutoCloseable  {
    private Connection con;

    public AnamneseDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Anamnese u) throws ErroDAO {
        Date dataTime = new Date();
        String sql = "insert into anamnese(exameFisico, data, pessoa_id_Paciente, Pessoa_id_Medico, hipotesesdiag, diagDefinitivo, laudo, exameComplementar) values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, u.getExameFisico());
            pstm.setString(2, String.valueOf(dataTime));
            pstm.setInt(3, u.getIdPessoa());
            pstm.setInt(4, u.getIdMedico());
            pstm.setString(5, u.getHipoteseDiagnostica());
            pstm.setString(6, u.getDiagnosticoDefinitivo());
            pstm.setString(7, u.getTratamentoEfetuado());
            pstm.setString(8, u.getExameComplementar());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    public String validarTipoUsuario(String u){
        String sql = "SELECT pessoa.id_pessoa from  pessoa inner join usuario on pessoaID = pessoa.id_pessoa   WHERE login  =  ? AND flagMedico <> 1";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u);
            ResultSet rs = pstm.executeQuery();
            if (rs.next())
            {
                u=rs.getString(1);

            }
            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String pegaMedico(String id){
        String sql = "select * from pessoa where  id_pessoa = ?";

        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1,id);
            ResultSet rs = pstm.executeQuery();
            Pessoa p  = new Pessoa();
            while (rs.next()){
                p.setNome(rs.getString("nome"));
            }
            return p.getNome();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //SELECT *FROM anamnese WHERE STR_TO_DATE(data, '%a %b %d %H:%i:%s BRT %Y') BETWEEN STR_TO_DATE('09/06/2023', '%d/%m/%Y') AND STR_TO_DATE('31/12/2023', '%d/%m/%Y');
    public ArrayList anamnesesPordata(String dataI, String dataF,String codigo) throws ErroDAO {
        String sql ="SELECT DATE_FORMAT(STR_TO_DATE(data, '%a %b %d %H:%i:%s BRT %Y'), '%d-%m-%Y %H:%i:%s') AS data_formatada, anamnese.* FROM anamnese WHERE STR_TO_DATE(data, '%a %b %d %H:%i:%s BRT %Y') BETWEEN STR_TO_DATE(?, '%d-%m-%Y') AND STR_TO_DATE(?, '%d-%m-%Y') AND Pessoa_id_Paciente = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, dataI);
            pstm.setString(2, dataF);
            pstm.setString(3,codigo);
           ResultSet rs = pstm.executeQuery();
            ArrayList arrayList = new ArrayList<>();
            while (rs.next()) {
                Anamnese u = new Anamnese();
                Pessoa p = new Pessoa();
                u.setExameComplementar(rs.getString("exameComplementar"));
                u.setDiagnosticoDefinitivo(rs.getString("diagDefinitivo"));
                u.setHipoteseDiagnostica(rs.getString("hipotesesDiag"));
                u.setTratamentoEfetuado(rs.getString("laudo"));
                u.setExameFisico(rs.getString("exameFisico"));
                u.setData(rs.getString("data"));
                p.setCodigo(rs.getString("Pessoa_id_Medico"));
                String codigoP = rs.getString("Pessoa_id_Medico");
                u.setData(rs.getString("data_formatada"));
                u.setMedicoResponsavel(pegaMedico(codigoP));
                arrayList.add(u);
            }
            return arrayList;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }
    public ArrayList anamnesesGeral(String codigo) throws ErroDAO {
        String sql ="SELECT DATE_FORMAT(STR_TO_DATE(data, '%a %b %d %H:%i:%s BRT %Y'), '%d-%m-%Y %H:%i:%s') AS data_formatada, anamnese.* FROM anamnese WHERE Pessoa_id_Paciente = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1,codigo);
            ResultSet rs = pstm.executeQuery();
            ArrayList arrayList = new ArrayList<>();
            while (rs.next()) {
                Anamnese u = new Anamnese();
                Pessoa p = new Pessoa();
                u.setExameComplementar(rs.getString("exameComplementar"));
                u.setDiagnosticoDefinitivo(rs.getString("diagDefinitivo"));
                u.setHipoteseDiagnostica(rs.getString("hipotesesDiag"));
                u.setTratamentoEfetuado(rs.getString("laudo"));
                u.setExameFisico(rs.getString("exameFisico"));
                u.setData(rs.getString("data"));
                p.setCodigo(rs.getString("Pessoa_id_Medico"));
                String codigoP = rs.getString("Pessoa_id_Medico");
                u.setData(rs.getString("data_formatada"));
                u.setMedicoResponsavel(pegaMedico(codigoP));
                arrayList.add(u);
            }
            return arrayList;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void close() throws Exception {

    }

    public static void main(String[] args) {
        try {
            AnamneseDaoClasse dao = new AnamneseDaoClasse();
            System.out.println(dao.anamnesesGeral("15"));
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }
    }

}
