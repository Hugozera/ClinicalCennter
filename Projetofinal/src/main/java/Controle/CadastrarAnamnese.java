package Controle;

import DAO.AnamneseDaoClasse;
import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;
import Modelo.Anamnese;
import Modelo.Pessoa;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CadastrarAnamnese", value = "/CadastrarAnamnese")
public class CadastrarAnamnese extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String cpfPaciente = request.getParameter("cpfPaciente");
        String exameFisico = request.getParameter("exameFisico");
        String exameComplementar = request.getParameter("exameComplementar");
        String hipoteseDiagnostica = request.getParameter("hipoteseDiagnostica");
        String diagnosticoDefinitivo = request.getParameter("diagnosticoDefinitivo");
        String tratamento = request.getParameter("tratamento");
        int idPessoa =0;
        int idMedico = Integer.parseInt(request.getParameter("medico"));

        try( AnamneseDaoClasse dao = new AnamneseDaoClasse())  {
            idPessoa = Integer.parseInt(dao.validarTipoUsuario(cpfPaciente));
            var u = new Anamnese(cpfPaciente, exameFisico, exameComplementar, hipoteseDiagnostica, diagnosticoDefinitivo, tratamento, idPessoa, idMedico);
            if (idPessoa == 0){
                response.sendRedirect("anamnese.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar cadastrar"));
            }
            else {
                dao.inserir(u);
                response.sendRedirect("anamnese.jsp?mensagem=" + URLEncoder.encode("Cadastrado com sucesso"));
            }
        } catch (ErroDAO e) {
            response.sendRedirect("anamnese.jsp?mensagem=" + URLEncoder.encode("Paciente inexistente ou cpf incorreto"));
        } catch (Exception e) {
            response.sendRedirect("anamnese.jsp?mensagem=" + URLEncoder.encode("Não pode ser introduzido letras no campo CPF" ));
        }
    }
}
