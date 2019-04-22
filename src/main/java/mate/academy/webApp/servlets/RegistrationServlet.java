package mate.academy.webApp.servlets;

import mate.academy.webApp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name, password);
        if (name.isEmpty() || password.isEmpty()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
            out.println("<font color=red>Please fill all the fields</font>");
            dispatcher.include(req, resp);
        } else {
            user.addUser(user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
