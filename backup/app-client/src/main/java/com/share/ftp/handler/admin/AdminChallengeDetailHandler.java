package com.share.ftp.handler.admin;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeAttachedFile;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class AdminChallengeDetailHandler implements Command {

  ChallengeDao challengeDao;

  public AdminChallengeDetailHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[챌린지 상세보기]");

    System.out.println();
    int challengeNo = Prompt.inputInt("챌린지 번호를 입력해주세요 ▶ ");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    request.setAttribute("challengeNo", challengeNo); 

    System.out.println();
    System.out.printf("챌린지 번호 ▶ %d\n",  challengeDTO.getNo());
    System.out.printf("제목 ▶ %s\n", challengeDTO.getTitle());
    System.out.printf("내용 ▶ %s\n", challengeDTO.getContent());
    System.out.printf("댓글수 ▶ %d\n", challengeDTO.getReviewCount());
    System.out.printf("참여자수 ▶ %d\n", challengeDTO.getTotalJoinCount());
    for (ChallengeAttachedFile file : challengeDTO.getFileUpload()) {
      System.out.printf("첨부파일 ▶ %s\n", file.getFilepath());
    }
    System.out.printf("시작일 ▶ %s\n", challengeDTO.getStartDate());
    System.out.printf("종료일 ▶ %s\n", challengeDTO.getEndDate());
    System.out.printf("챌린지기간 ▶ %d일\n",  ((((challengeDTO.getEndDate().getTime() - challengeDTO.getStartDate().getTime()) / 1000)) / (24*60*60)));
    System.out.printf(GeneralHelper.getRemainTime(challengeDTO.getEndDate().getTime() - System.currentTimeMillis()));
    System.out.printf("등록날짜 ▶ %s\n", challengeDTO.getRegisteredDate());
    System.out.println();

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 챌린지 수정");
      System.out.println("2번 ▶ 챌린지 삭제");
      System.out.println("3번 ▶ 등록문의 목록");
      System.out.println("0번 ▶ 이전");

      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1:
          request.getRequestDispatcher("/adminChallenge/update").forward(request);
          return;
        case 2:
          request.getRequestDispatcher("/adminChallenge/delete").forward(request);
          return;
        case 3:
          request.getRequestDispatcher("/adminChallenge/QuestionList").forward(request);
          break;
        case 0:
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}