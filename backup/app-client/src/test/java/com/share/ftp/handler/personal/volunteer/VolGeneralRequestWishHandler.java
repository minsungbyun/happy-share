package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralRequestWishHandler implements Command {

  VolunteerDao volunteerDao;

  public VolGeneralRequestWishHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  π WISH π  ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO VolunteerRequestDTO = volunteerDao.findByApplyVol(volNo); 

    while (true) {
      String input = Prompt.inputString("[  π κ΄μ¬ λ΄μ¬λ‘ μΆκ°νμκ² μ΅λκΉ?(y/N) π ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  β WISH μ·¨μ β  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        VolunteerRequestDTO.setWish(AuthLoginHandler.getLoginUser());
        volunteerDao.update(VolunteerRequestDTO);
        System.out.println("[  π κ΄μ¬ λ΄μ¬λ‘ λ±λ‘λμμ΅λλ€. π  ]");
        return;

      } else {
        System.out.println("y λλ nμ μλ ₯νμΈμ.");
        continue;
      } 
    } 
  }
}

