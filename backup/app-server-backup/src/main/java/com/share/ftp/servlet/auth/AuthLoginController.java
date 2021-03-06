package com.share.ftp.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/auth/login")
public class AuthLoginController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  JoinDao joinDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String id = request.getParameter("id");
    String password = request.getParameter("password");
<<<<<<< HEAD:app-server/src/main/java/com/share/ftp/servlet/auth/AuthLoginController.java
    try {
      Cookie cookie = null;
      if (request.getParameter("saveId") != null) {
        cookie = new Cookie("id", id);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setPath(getServletContext().getContextPath() + "/auth");
      } else {
        cookie = new Cookie("id", "");
        cookie.setMaxAge(0);
      }
      response.addCookie(cookie);
=======

    try {
>>>>>>> 927a6172a1e99a6e899b3348ac4001899ce67632:app-server-backup/src/main/java/com/share/ftp/servlet/auth/AuthLoginController.java

      Cookie cookie  = null;
      if (request.getParameter("saveId") != null) {

        cookie = new Cookie("id", id);
        cookie.setMaxAge(60 * 60 * 24 * 7 * 4);
        cookie.setPath(getServletContext().getContextPath() + "/auth");

      } else {
        cookie = new Cookie("id", "");
        cookie.setMaxAge(0);
      }

      response.addCookie(cookie);

      JoinDTO loginUser = joinDao.findByIdPassword(id, password);

      HttpSession session = null;
      if (loginUser != null) {
<<<<<<< HEAD:app-server/src/main/java/com/share/ftp/servlet/auth/AuthLoginController.java
        HttpSession session = request.getSession();
=======
        if (loginUser.getId().equals("admin")) {
          session = request.getSession();
          session.setAttribute("loginUser", loginUser);
          response.sendRedirect("../auth/loginList");
          return;
        }
        session = request.getSession();
>>>>>>> 927a6172a1e99a6e899b3348ac4001899ce67632:app-server-backup/src/main/java/com/share/ftp/servlet/auth/AuthLoginController.java
        session.setAttribute("loginUser", loginUser);
        response.sendRedirect("../home");

      } else {
        //        response.sendRedirect("loginForm");
        request.setAttribute("contentUrl", "/auth/Login.jsp");
        request.getRequestDispatcher("/template1.jsp").forward(request, response);
      }

    } catch (Exception e) {
      request.setAttribute("error", e);
    }
  }
}







