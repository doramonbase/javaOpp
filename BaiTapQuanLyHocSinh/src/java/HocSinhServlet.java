/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author admin
 */
public class HocSinhServlet extends HttpServlet {
    private HocSinhCRUD hocSinhDao;
    
    
    @Override
    public void init() {
        String url = getServletContext().getInitParameter("url");
        String userName = getServletContext().getInitParameter("userName");
        String pw = getServletContext().getInitParameter("pw");
        
        hocSinhDao = new HocSinhCRUD(url, userName, pw);
    }

    public void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<HocSinh> listStudent = hocSinhDao.studentList();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
        disp.forward(request,response);
    }
}
