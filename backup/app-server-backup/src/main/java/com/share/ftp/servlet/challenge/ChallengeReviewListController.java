package com.share.ftp.servlet.challenge;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

@WebServlet("/challenge/reviewList")
public class ChallengeReviewListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;
  ChallengeReviewDao challengeReviewDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
    challengeReviewDao = (ChallengeReviewDao) 웹애플리케이션공용저장소.getAttribute("challengeReviewDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeNo = Integer.parseInt(request.getParameter("no"));
      ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

      Collection<ChallengeReviewDTO> challengeReviewList = challengeReviewDao.findAllNo(challengeNo);

      request.setAttribute("challengeDTO", challengeDTO);
      request.setAttribute("challengeReviewList", challengeReviewList);

      request.setAttribute("pageTitle", "챌린지 목록");
      request.setAttribute("contentUrl", "/challenge/ChallengeReviewList.jsp");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/template1.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}

