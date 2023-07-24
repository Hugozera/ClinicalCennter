package Controle;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao=request.getSession(false);
        if(sessao!=null)
        {
//            sessao.removeAttribute("usuario");
            sessao.invalidate();
        }
        response.sendRedirect("index.jsp");
    }
}
