package com.share.ftp.servlet.vol;

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
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;

@WebServlet("/vol/boardcommentlist")
public class VolunteerBoardCommentListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardCommentDao volunteerBoardCommentDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {

      // 클라이언트 요청을 처리하는데 필요한 데이터 준비
      Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAll();

      // 뷰 컴포넌트가 준비한 데이터를 사용할 수 있도록 저장소에 보관한다.
      request.setAttribute("volunteerBoardCommentList", volunteerBoardCommentList);

      // 출력을 담당할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/vol/VolunteerBoardCommentList.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
