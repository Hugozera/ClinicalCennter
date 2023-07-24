package Controle;

import DAO.ErroDAO;
import DAO.UsuarioDaoClasse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

@WebServlet(name = "BuscarPacientes", value = "/BuscarPacientes")
public class BuscarPacientes extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String nomeFiltro = request.getParameter("filtroNome");
        ArrayList u;
            if (codigo.equals("1")) {
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    u = dao.relatorioGeral();
                    request.setAttribute("pacientes", u);
                    request.getRequestDispatcher("pacientes.jsp").forward(request, response);
                    ;
                } catch (ErroDAO e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (nomeFiltro.length() > 0) {
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    u = dao.relatorioNome(nomeFiltro);
                    request.setAttribute("pacientes", u);
                    request.getRequestDispatcher("pacientes.jsp").forward(request, response);
                    ;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {

                response.sendRedirect("pacientes.jsp?mensagem=" + URLEncoder.encode("Preencha o campo para filtrar por nome"));

            }
        }
    }
