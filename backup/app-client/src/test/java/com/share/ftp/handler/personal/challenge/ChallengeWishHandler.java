package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeWishHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeWishHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  π WISH π  ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeList = challengeDao.findByChallengeNo(challengeNo); 

    while (true) {
      String input = Prompt.inputString("[  π κ΄μ¬ μ±λ¦°μ§λ‘ μΆκ°νμκ² μ΅λκΉ?(y/N) π ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  β WISH μ·¨μ β  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        challengeList.setWish(AuthLoginHandler.getLoginUser());
        challengeDao.update(challengeList);
        System.out.println("[  π κ΄μ¬ μ±λ¦°μ§λ‘ λ±λ‘λμμ΅λλ€. π  ]");
        return;

      } else {
        System.out.println("y λλ nμ μλ ₯νμΈμ.");
        continue;
      } 
    } 
  }
}

