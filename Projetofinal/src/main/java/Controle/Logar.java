package Controle;

import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;
import Modelo.Pessoa;
import Util.Validador;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") == null) {
            if (Validador.osDadosNaoSaovazios(new String[]{login, senha})) {
                Pessoa u;
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    u = dao.buscar(login, senha);
                    if (u!= null) {


                        sessao.setAttribute("usuario", u);
                        response.sendRedirect("home.jsp");
                    }
                    else {
                        response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Usuario ou senha incorretos"));
                    }
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar logar"+e));
                } catch (Exception e) {
                    response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar fechar a conexão"));
                }

            } else {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Está faltando dados"));
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Você precisa sair da sua conta antes de tentar logar com outro usuário"));
        }
    }
}