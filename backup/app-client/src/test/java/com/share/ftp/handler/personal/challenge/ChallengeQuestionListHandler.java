package com.share.ftp.handler.personal.challenge;

import java.util.Collection;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeQuestionListHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeQuestionListHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      int challengeNo = (int) request.getAttribute("challengeNo");

      ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

      System.out.println();
      System.out.printf("[ %d번 챌린지 문의 목록 ]\n", challengeNo);
      System.out.println();

      System.out.printf("챌린지 번호 ▶ %d\n"
          + "제목[댓글] ▶ %s[%d]\n"
          //          + "작성자 ▶ %s\n"
          + "참여인원 ▶ %d\n"
          + "참여기간 ▶ %s ~ %s\n", 
          challengeDTO.getNo(), 
          challengeDTO.getTitle(), 
          challengeDTO.getReviewCount(), 
          //          challengeDTO.getAdmin().getName(),
          challengeDTO.getTotalJoinCount(),
          challengeDTO.getStartDate(),
          challengeDTO.getEndDate());

      System.out.println();
      System.out.println("---------------------------------------------------------");
      System.out.println();
      System.out.printf("[ 댓글 %d개 ]\n", challengeDTO.getQuestionCount());


      //      if (challengeDTO.getQuestionCount() == 0 /*|| challengeQuestionDTOList.isEmpty()*/) {
      //        System.out.println("문의댓글이 없습니다!");
      //        System.out.println();
      //      }

      Collection<ChallengeQuestionDTO> list = challengeDao.findAllQuestion();
      for (ChallengeQuestionDTO challengeQuestionDTO : list) {
        if (challengeQuestionDTO.getNo() == challengeNo) {
          System.out.printf("%d, %d, %s, %s, %s\n", 
              challengeQuestionDTO.getNo(), // 테스트 끝나고 지움
              challengeQuestionDTO.getQuestionNo(),
              challengeQuestionDTO.getOwner().getId(),
              challengeQuestionDTO.getContent(),
              challengeQuestionDTO.getRegisteredDate());
        }
      }
      System.out.println();
      System.out.println("1번 ▶ 문의 등록");
      System.out.println("2번 ▶ 문의 변경, 삭제");
      System.out.println("3번 ▶ 문의 검색");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      System.out.println();
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeQuestion/add").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeQuestion/connect").forward(request); break;
        case 3: request.getRequestDispatcher("/challengeQuestion/search").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}
