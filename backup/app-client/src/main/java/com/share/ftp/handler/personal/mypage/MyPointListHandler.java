package com.share.ftp.handler.personal.mypage;

import static com.share.util.MemberHelper.getUserLevel;
import static com.share.util.MemberHelper.getUserPoint;
import static com.share.util.MemberHelper.getUserRemainPoint;
import static com.share.util.MemberHelper.printMyRank;
import java.util.List;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyPointListHandler implements Command {

  PersonalDao personalDao;

  public MyPointListHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    List<PersonalDTO> joinList = personalDao.findAllPersonal();


    PersonalDTO loginUser = (PersonalDTO) AuthLoginHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 포인트 정보입니다 ]\n", loginUser.getName());

    System.out.println("                               _       _   \r\n"
        + " _ __ ___  _   _   _ __   ___ (_)_ __ | |_ \r\n"
        + "| '_ ` _ \\| | | | | '_ \\ / _ \\| | '_ \\| __|\r\n"
        + "| | | | | | |_| | | |_) | (_) | | | | | |_ \r\n"
        + "|_| |_| |_|\\__, | | .__/ \\___/|_|_| |_|\\__|\r\n"
        + "           |___/  |_|                     ");

    //    Prompt.printUserRank(joinDTOList); // 랭킹 리스트 (이달의 랭킹으로 이동 예정)
    System.out.println();
    System.out.println("-----------------------------------------------");
    System.out.println();
    System.out.printf("▶ 당신의 현재 포인트는 %d점 입니다. \n", getUserPoint(loginUser));
    System.out.println();
    System.out.printf("▶ 당신의 현재 등급은 %s입니다. \n", getUserLevel(loginUser)); 
    System.out.println();
    System.out.printf("▶ 다음 등급까지 %d point 남았습니다. ", getUserRemainPoint(loginUser)); 
    System.out.println();
    System.out.printf("▶ 축하합니다! 당신의 랭킹은 %d등입니다. ", printMyRank(joinList)); 
    System.out.println();
    System.out.println("-----------------------------------------------");

  }
}







