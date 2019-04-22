package mate.academy.webApp.servlets;

import mate.academy.webApp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = User.getUsers();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name, password);
        if (validDate(user).equals("home.jsp")) {
            req.setAttribute("name", name);
        }
        req.getRequestDispatcher(validDate(user)).forward(req, resp);
    }

    private String validDate(User user) {
        List<User> users = new ArrayList<>();
        if (users.contains(user)) {
            if (User.getUser(user).getPassword().equals(user.getPassword())) {
                return "home.jsp";
            }
        }
        return "home.jsp";
    }
}

