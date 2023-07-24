 package Controle;

import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;
import Modelo.Pessoa;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "EditarPerfilPaciente", value = "/EditarPerfilPaciente")
public class EditarPerfilPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession();
       String nome = request.getParameter("nome");
        String nomeMae = request.getParameter("nomeMae");
        String naturalidadeEstado = request.getParameter("naturalidade");
        String naturalidadeMuni = request.getParameter("naturalidadeMun");
        String endereco = request.getParameter("endereco");
        String dataNasc = request.getParameter("dataNasc");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexoOpcao");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Pessoa usuarioLogado=(Pessoa) session.getAttribute("usuario");

        var u = new Pessoa(nome, nomeMae, naturalidadeEstado, naturalidadeMuni, endereco, dataNasc, codigo, senha, sexo,0);

        if (session.getAttribute("usuario")!=null) {

            if (usuarioLogado.getIdPessoa()==codigo) {

                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    dao.editarUsuarioPaciente(u);
                    session.setAttribute("usuario", u);
                    response.sendRedirect("pacientePerfil.jsp?mensagem=" + URLEncoder.encode("Editado com sucesso"));
                } catch (ErroDAO e) {
                    response.sendRedirect("pacientePerfil.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar cadastrar" + e));
                } catch (Exception e) {
                    response.sendRedirect("pacientePerfil.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar fechar a conexão" + e));
                }
            }
            else {
                response.sendRedirect("perfil.jsp?mensagem=" + URLEncoder.encode("Você não é a pessoa logada" ));
            }
        }
        else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar" ));
        }
    }
}
