package com.share.ftp.web.donation;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.join.OrgDTO;

//@WebServlet("/donation/boardAdd")
public class DonationBoardAddController extends HttpServlet { 
  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");


  }


  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DonationBoardDTO donationBoardDTO = new DonationBoardDTO();

    Category category = new Category();
    category.setNo(Integer.parseInt(request.getParameter("category")));

    OrgDTO orgDTO = new OrgDTO();
    orgDTO.setOrgNo(Integer.parseInt(request.getParameter("leader")));
    donationBoardDTO.setOrgNo(Integer.parseInt(request.getParameter("leader")));

    //    donationBoardDTO.setUserNo(Integer.parseInt(request.getParameter("owner")));
    donationBoardDTO.setLeader(orgDTO);
    donationBoardDTO.setCategory(category);
    donationBoardDTO.setTitle(request.getParameter("title"));
    donationBoardDTO.setContent(request.getParameter("content")); 
    donationBoardDTO.setTel(request.getParameter("tel"));
    donationBoardDTO.setEmail(request.getParameter("email"));  
    donationBoardDTO.setMoneyTarget(Long.valueOf(request.getParameter("moneyTarget")));  
    donationBoardDTO.setStartDate(Date.valueOf(request.getParameter("startDate")));
    donationBoardDTO.setEndDate(Date.valueOf(request.getParameter("endDate"))); 
    //    donationBoardDTO.setFileUpload(GeneralHelper.promptFileUpload()); 
    donationBoardDTO.setStatus(2);


    try {
      donationBoardDao.insert(donationBoardDTO);
      //      for (VolunteerAttachedFile volunteerAttachedFile : donationBoardDTO.getFileUpload()) {
      //        donationBoardDao.insertFile(donationBoardDTO.getNo(), volunteerAttachedFile.getFilepath());
      //      }
      sqlSession.commit();
      response.sendRedirect("boardList");


    } catch (Exception e) {
      sqlSession.rollback();
      request.setAttribute("error", e);
      e.printStackTrace();

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Error.jsp");
      requestDispatcher.forward(request, response);
    }
  }
}















//
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println();
//    System.out.println("[  봉사신청서 양식  ]");
//
//    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
//
//    if (joinDTO.getType() == 1) {
//      System.out.println("개인 회원은 신청서를 작성할 수 없습니다!");
//      return;
//    }
//
//
//    if (joinDTO == null) {
//      System.out.println("[  ⛔ 로그인 후 사용가능합니다 ⛔  ]");
//      return;
//    }
//    while (true) {
//      try {
//
//        DonationBoardDTO donationBoardDTO = new DonationBoardDTO();
//
//        while (true) {
//          System.out.println(" ▶ 번호를 선택해주세요");
//          System.out.println();
//          System.out.println(" ▶ 1. 단체봉사신청");
//          System.out.println(" ▶ 2. 기관봉사신청");
//          System.out.println();
//
//          int num = Prompt.inputInt("번호입력 ▶ ");
//
//          switch (num) {
//            case 1: donationBoardDTO.setMemberType(GROUP);             break;
//            case 2: donationBoardDTO.setMemberType(ORG);               break;
//            default: System.out.println("올바를 숫자를 입력해주세요."); continue;
//          }
//
//          if (AuthLoginHandler.getLoginUser().getType() != donationBoardDTO.getMemberType()) {
//            System.out.println("당신은 해당 유형봉사를 신청 할 수 없습니다.");
//            System.out.println("단체회원인지 기관회원인지 확인하세요!");
//            continue;
//          }
//          break;
//        }
//
//        donationBoardDTO.setUserNo(AuthLoginHandler.getLoginUser().getNo());
//        donationBoardDTO.setTitle(Prompt.inputString("제목 ▶ "));
//
//        if (donationBoardDTO.getMemberType() == GROUP) {
//          GroupDTO groupUser = (GroupDTO) joinDTO;
//          donationBoardDTO.setOwner(groupUser);
//
//        } else if (donationBoardDTO.getMemberType() == ORG) {
//          OrgDTO orgUser = (OrgDTO) joinDTO;
//          donationBoardDTO.setOwner(orgUser);
//        }
//
//        donationBoardDTO.setCategory(new GeneralHelper(generalDao).promptCategory());
//        donationBoardDTO.setTel(Prompt.inputString("전화번호 ▶ "));
//        donationBoardDTO.setEmail(Prompt.inputString("이메일 ▶ ")); 
//        donationBoardDTO.setStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
//        donationBoardDTO.setEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
//        donationBoardDTO.setStartTime(Prompt.inputString("봉사시작시간(hh:mm) ▶ ")); 
//        donationBoardDTO.setEndTime(Prompt.inputString("봉사종료시간(hh:mm) ▶ ")); 
//        donationBoardDTO.setLimitNum(Prompt.inputInt("봉사인원 ▶ "));
//        donationBoardDTO.setContent(Prompt.inputString("내용 ▶ ")); 
//        donationBoardDTO.setFileUpload(GeneralHelper.promptFileUpload()); 
//        donationBoardDTO.setStatus(WAITING);
//
//        try {
//          volunteerDao.insert(donationBoardDTO);
//          for (VolunteerAttachedFile volunteerAttachedFile : donationBoardDTO.getFileUpload()) {
//            volunteerDao.insertFile(donationBoardDTO.getNo(), volunteerAttachedFile.getFilepath());
//          }
//          sqlSession.commit();
//
//        } catch (Exception e) {
//          sqlSession.rollback();
//        }
//
//      } catch (NumberFormatException e) {
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("올바른 숫자를 입력하세요");
//        System.out.println("--------------------------------------------------------------");
//        continue; // 나중에 설정할거
//
//      } catch (Exception e) {
//        System.out.println("--------------------------------------------------------------");
//        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
//        System.out.println("다시 입력 바랍니다.");
//        System.out.println("--------------------------------------------------------------");
//        continue;
//      }
//      break;
//    }
//    System.out.println("[  ✔️ 봉사신청이 정상적으로 완료되었습니다. ]");
//  }
