package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewDeleteHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewDeleteHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println();
      System.out.println("[ 참여인증&댓글 삭제 ]");
      System.out.println();
      //
      //      int challengeNo = (int) request.getAttribute("no");
      //      System.out.println();
      //
      //      ChallengeDTO challengeList = findByChallengeNo(challengeNo); 
      //
      //      if (challengeList == null) {
      //        System.out.println("해당 챌린지가 없습니다.");
      //        return;
      //      }

      int deleteNo = (int) request.getAttribute("reviewNo");

      ChallengeDTO challengeDTO = findByChallengeNo(deleteNo);

      ChallengeReviewDTO challengeReviewDTO = findByReviewNo(deleteNo);

      try {
        if (challengeReviewDTO == null) {
          System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
          return;
        }

        if (!challengeReviewDTO.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }

        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println();
          System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println();
          System.out.println("참여인증&댓글을 삭제하였습니다.");

          challengeDTO.removeReviewer(AuthLoginHandler.getLoginUser());
          challengeReviewDTOList.remove(challengeReviewDTO);

          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        }
      } catch (Throwable e) {
      }
    }
  }
}
