package Controle;

import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;

import Modelo.Pessoa;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

@WebServlet(name = "EditarPaciente", value = "/EditarPaciente")
public class EditarPaciente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codigo = request.getParameter("codigo");
        Pessoa paciente;
        Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuario");
        int codigo1 = usuarioLogado.getIdPessoa();
        if (session.getAttribute("usuario") != null) {
            if (usuarioLogado.getIdPessoa() == codigo1) {
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    paciente = dao.buscarPaciente((codigo));
                    session.setAttribute("pacientes", paciente);
                    request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);
                } catch (ErroDAO e) {
                    throw new RuntimeException(e);
                }
            } else {
                response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar"));
            }
        } else {
            response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String nomeMae = request.getParameter("nomeMae");
        String naturalidadeEstado = request.getParameter("naturalidade");
        String naturalidadeMuni = request.getParameter("naturalidadeMun");
        String endereco = request.getParameter("endereco");
        String dataNasc = request.getParameter("dataNasc");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexoOpcao");
        String flag = request.getParameter("flag");
        Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuario");

        int codigo = usuarioLogado.getIdPessoa();
        var paciente = new Pessoa(login, senha, nome, nomeMae, naturalidadeEstado, naturalidadeMuni, endereco, dataNasc, sexo, codigo, Integer.parseInt(flag));
        if (session.getAttribute("usuario") != null) {
            if (usuarioLogado.getIdPessoa() == codigo) {
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    dao.editarPaciente(paciente);
                    session.removeAttribute("pacinetes");
                    request.getRequestDispatcher("pacientes.jsp").forward(request, response);
                } catch (ErroDAO ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar" ));
            }
        }
        else {
            response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa estar logado para alterar" ));
        }
    }
}
