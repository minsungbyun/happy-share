package com.share.ftp.web.join.org;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/join/org/form")
public class OrgFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("contentUrl", "/join/org/OrgUserForm.jsp");
    request.getRequestDispatcher("/template1.jsp").forward(request, response);
    //    request.getRequestDispatcher("/join/org/OrgUserForm.jsp").forward(request, response);
  }
}







