package com.share.ftp.handler.personal.challenge;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class ChallengeJoinHandler implements Command {

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  public ChallengeJoinHandler(ChallengeDao challengeDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 챌린지 참여 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);


    System.out.printf("챌린지 번호 ▶ %d\n"
        +"제목[댓글] ▶ %s[%d]\n"
        //        +"작성자 ▶ %s\n"
        +"참여인원 ▶ %d\n"
        +"참여기간 ▶ %s ~ %s\n"
        +"챌린지기간 ▶ %d일\n"
        + GeneralHelper.getRemainTime(challengeDTO.getEndDate().getTime() - System.currentTimeMillis())
        +"등록날짜 ▶ %s\n\n",

        challengeDTO.getNo(), 
        challengeDTO.getTitle(), 
        challengeDTO.getReviewCount(), 
        //        challengeDTO.getAdmin().getName(),
        challengeDTO.getTotalJoinCount(),
        //          challengeDTO.getFileUpload(), 
        challengeDTO.getStartDate(),
        challengeDTO.getEndDate(),
        ((((challengeDTO.getEndDate().getTime() - challengeDTO.getStartDate().getTime()) / 1000)) / (24*60*60)),
        challengeDTO.getRegisteredDate());

    String input = Prompt.inputString("해당 챌린지에 참가하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("해당 챌린지 참여를 취소하였습니다.");
      return;
    }

    if (challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("이미 챌린지 참여를 하셨습니다!");
      return;
    } 

    //    // 출력할 멤버 list에 추가시킨다
    //    challengeDTO.addMembers(AuthLoginHandler.getLoginUser());
    int userNo = AuthLoginHandler.getLoginUser().getNo();
    challengeDao.insertUser(challengeNo, userNo);

    // 포인트 부여 (참여 100포인트)
    //    AuthLoginHandler.getLoginUser().setPoint(AuthLoginHandler.getLoginUser().getPoint() + CHALLENGE_POINT);

    //    // 총 참여 인원을 누적시킨다.
    int count = challengeDTO.getTotalJoinCount();
    challengeDTO.setTotalJoinCount(count += 1); 

    sqlSession.commit();

    System.out.println("[  챌린지 참여가 완료되었습니다. ]");
  }
}
