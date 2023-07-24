package Controle;

import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;
import Modelo.Pessoa;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CadastrarPessoa", value = "/CadastrarPessoa")
public class CadastrarPessoa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int flagMedico;
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String nomeMae = request.getParameter("nomeMae");
        String endereco = request.getParameter("endereco");
        String sexo = request.getParameter("sexo");
        String dataNascimento = request.getParameter("dataNascimento");
        String naturalidadeMunicipio = request.getParameter("naturalidadeMunicipio");
        String naturalidadeEstado = request.getParameter("naturalidadeEstado");
        String flag = request.getParameter("flag");
        Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuario");
        int codigo = usuarioLogado.getIdPessoa();
        if (session.getAttribute("usuario") != null) {
            if (usuarioLogado.getIdPessoa() == codigo) {
                if ("medico".equalsIgnoreCase(flag)) flagMedico = 1;
                else flagMedico = 2;
                var u = new Pessoa(login, senha, nome, nomeMae, naturalidadeEstado, naturalidadeMunicipio, endereco, dataNascimento, sexo, flagMedico, 0);
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    dao.inserirPessoa(u);
                    response.sendRedirect("home.jsp");
                } catch (ErroDAO e) {
                    response.sendRedirect("cadastro.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar cadastrar" + e));
                } catch (Exception e) {
                    response.sendRedirect("home.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar fechar a conexão"));
                }
            }else{
                    response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar"));
                }
            } else {
                response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar"));
            }
        }
    }


