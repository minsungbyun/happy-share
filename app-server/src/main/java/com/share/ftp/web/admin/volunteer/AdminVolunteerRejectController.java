package com.share.ftp.web.admin.volunteer;

import static com.share.util.General.check.REJECTED;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;


@WebServlet("/admin/volunteer/reject")
public class AdminVolunteerRejectController extends HttpServlet { 

  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  SqlSession sqlSession;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      int volNo = Integer.parseInt(request.getParameter("no"));

      VolunteerRequestDTO volunteerRequest = volunteerDao.findByVolunteerNo(volNo);

      volunteerRequest.setStatus(REJECTED);

      volunteerDao.updateVolunteer(volunteerRequest);
      sqlSession.commit();

      response.sendRedirect("list");
      //      response.setHeader("Refresh", "1;url=adminList");
      //      request.getRequestDispatcher("VolunteerSuccess.jsp").forward(request, response);

    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}














