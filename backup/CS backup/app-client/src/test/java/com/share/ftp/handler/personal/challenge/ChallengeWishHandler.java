package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeWishHandler extends AbstractAdminChallengeHandler {


  public ChallengeWishHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[  π WISH π  ]");
      System.out.println();

      int no = (int) request.getAttribute("no");

      ChallengeDTO challengeList = findByNo(no); 



      String input = Prompt.inputString("[  π κ΄μ¬ μ±λ¦°μ§λ‘ μΆκ°νμκ² μ΅λκΉ?(y/N) π ] ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  β WISH μ·¨μ β  ]");
        return;
      } else if (input.equals("y")) {
        System.out.println();
        System.out.println("[  π κ΄μ¬ μ±λ¦°μ§λ‘ λ±λ‘λμμ΅λλ€. π  ]");
        challengeList.setWish(AuthLoginHandler.getLoginUser());
        return;
      } else {
        System.out.println("y λλ nμ μλ ₯νμΈμ.");
        continue;
      } 
    } 
  }
}

