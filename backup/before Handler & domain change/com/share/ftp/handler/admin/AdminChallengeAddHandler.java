package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.util.Prompt;

public class AdminChallengeAddHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeAddHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }


  @Override
  public void execute() {
    System.out.println("[챌린지 등록]");

    ChallengeDTO challengeDTO = new ChallengeDTO();

    challengeDTO.setNo(Prompt.inputInt("번호? ")); 
    //    challengeDTO.setAdminId(Prompt.inputString("관리자 아이디? "));
    challengeDTO.setTitle(Prompt.inputString("제목? "));
    challengeDTO.setContent(Prompt.inputString("내용? ")); 
    challengeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    challengeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));


    challengeDTOList.add(challengeDTO);

    System.out.println("챌린지가 정상적으로 등록되었습니다.");
  }
}
