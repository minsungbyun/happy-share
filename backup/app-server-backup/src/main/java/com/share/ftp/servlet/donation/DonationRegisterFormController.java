package com.share.ftp.servlet.register;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.donation.DonationRegisterPayType;

@WebServlet("/register/form")
public class DonationRegisterFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  GeneralDao generalDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("boardNo"));
      System.out.println(no);
      //      List<JoinDTO> user = joinDao.findAll();
      List<DonationRegisterPayType> payTypes = generalDao.findAllPayType();

      // 출력을 담당할 뷰를 호출한다.
      request.setAttribute("payTypes", payTypes);
      request.setAttribute("donationBoardNo", no);
      request.getRequestDispatcher("/register/DonationRegisterForm.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







