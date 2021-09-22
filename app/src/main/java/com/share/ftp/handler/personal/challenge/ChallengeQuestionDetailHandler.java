package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDetailHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionDetailHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[문의 상세보기]");
    System.out.println(" ▶ 챌린지 번호를 입력해주세요.");
    System.out.println();

    int challengeNo = Prompt.inputInt("챌린지 번호: ");
    System.out.println();

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    int detailNo = Prompt.inputInt("번호? ");

    ChallengeQuestionDTO challengeQuestion = findByQuestionNo(detailNo);

    if (challengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if (challengeQuestion.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      System.out.println("읽을 권한이 없습니다.");
      return;
    }

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeQuestionDTO.getNo() == challengeNo) {
        System.out.printf("아이디: %s\n", challengeQuestion.getOwner().getId());
        System.out.printf("제목: %s\n", challengeQuestion.getTitle());
        System.out.printf("내용: %s\n", challengeQuestion.getContent());
        System.out.printf("등록날짜: %s\n", challengeQuestion.getRegisteredDate());
      }
    }
  }
}
