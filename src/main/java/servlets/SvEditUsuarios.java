package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {
    
    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usu = control.traerUsuario(id);

            HttpSession misession = request.getSession();
            misession.setAttribute("usuEditar", usu);

            System.out.println("El usuario es: " + (usu != null ? usu.getNombreUsuario() : "No encontrado"));

            response.sendRedirect("editarUsuarios.jsp");
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Solicitud inválida. El ID del usuario no es correcto.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreUsu = request.getParameter("nombreusu");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        
        usu.setNombreUsuario(nombreUsu);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
        control.editarUsuario(usu);
                
        response.sendRedirect("SvUsuarios");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para editar usuarios";
    }
}
