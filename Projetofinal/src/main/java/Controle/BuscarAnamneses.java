package Controle;

import DAO.AnamneseDaoClasse;
import DAO.ErroDAO;
import Modelo.Pessoa;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BuscarAnamneses", value = "/BuscarAnamneses")
public class BuscarAnamneses extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String datai = request.getParameter("dataI");
        String dataf = request.getParameter("dataF");
        String codigo = request.getParameter("codigo");
        String filtrar = request.getParameter("filtrar");
        filtrar ="null";
        ArrayList a;
        Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuario");
        int codigo1 = usuarioLogado.getIdPessoa();
        if (session.getAttribute("usuario") != null) {
            if (usuarioLogado.getIdPessoa() == codigo1 && usuarioLogado.getFlagMedico() == 1) {
                if (filtrar.equalsIgnoreCase("todos")) {
                    try (AnamneseDaoClasse dao = new AnamneseDaoClasse()) {
                        a = dao.anamnesesGeral(codigo);
                        request.setAttribute("anamneses", a);
                        request.getRequestDispatcher("pacienteAnamneses.jsp").forward(request, response);
                    } catch (ErroDAO e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {

                    try (AnamneseDaoClasse dao = new AnamneseDaoClasse()) {
                        a = dao.anamnesesPordata(datai, dataf, codigo);
                        request.setAttribute("anamneses", a);
                        request.getRequestDispatcher("pacienteAnamneses.jsp").forward(request, response);
                    } catch (ErroDAO e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            } else if (usuarioLogado.getIdPessoa() == codigo1 || usuarioLogado.getFlagMedico() !=1) {
                if (filtrar.equalsIgnoreCase("todos")) {
                    try (AnamneseDaoClasse dao = new AnamneseDaoClasse()) {
                        a = dao.anamnesesGeral(codigo);
                        request.setAttribute("anamneses", a);
                        request.getRequestDispatcher("minhasAnamneses.jsp").forward(request, response);
                    } catch (ErroDAO e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {

                    try (AnamneseDaoClasse dao = new AnamneseDaoClasse()) {
                        a = dao.anamnesesPordata(datai, dataf, codigo);
                        request.setAttribute("anamneses", a);
                        request.getRequestDispatcher("minhasAnamneses.jsp").forward(request, response);
                    } catch (ErroDAO e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }
}
