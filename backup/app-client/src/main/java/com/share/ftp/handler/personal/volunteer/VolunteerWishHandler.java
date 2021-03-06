package com.share.ftp.handler.personal.volunteer;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerWishHandler implements Command {

  VolunteerDao volunteerDao;
  SqlSession sqlSession;

  public VolunteerWishHandler(VolunteerDao volunteerDao,SqlSession sqlSession) {
    this.volunteerDao = volunteerDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  π WISH π  ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO VolunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo); 

    while (true) {
      String input = Prompt.inputString("[  π κ΄μ¬ λ΄μ¬λ‘ μΆκ°νμκ² μ΅λκΉ?(y/N) π ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  β WISH μ·¨μ β  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();


        try {

          VolunteerRequestDTO.setWish(AuthLoginHandler.getLoginUser());

          volunteerDao.addWish(AuthLoginHandler.getLoginUser().getNo(),VolunteerRequestDTO.getNo());
          sqlSession.commit();
          System.out.println("[  π κ΄μ¬ λ΄μ¬λ‘ λ±λ‘λμμ΅λλ€. π  ]");
          return;

        } catch (Exception e) {
          System.out.println("μ΄λ―Έ μ°νμμ΅λλ€.");
          return;
        }

      } else {
        System.out.println("y λλ nμ μλ ₯νμΈμ.");
        continue;
      } 
    } 
  }
}

