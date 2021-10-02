package com.share.ftp.handler.personal.support;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminQuestionConnectHandler implements Command {


  public AdminQuestionConnectHandler() {
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();

    while (true) {
      System.out.println();
      System.out.println("1번: 답글 등록");
      System.out.println("2번: 답글 목록");
      //      System.out.println("3번 ▶ 답글 상세보기");
      //      System.out.println("4번 ▶ 답글 수정");
      //      System.out.println("5번 ▶ 답글 삭제");
      //      System.out.println("6번 ▶ 답글 검색");
      System.out.println("0번: 이전");
      System.out.println();
      int input = Prompt.inputInt("번호 입력 > ");
      switch (input) {
        case 1: request.getRequestDispatcher("/question/add").forward(request);
        break;
        case 2: request.getRequestDispatcher("/question/list").forward(request);
        break;
        //        case 3: request.getRequestDispatcher("/question/detail").forward(request);
        //        break;
        //        case 4: request.getRequestDispatcher("/question/update").forward(request);
        //        break;
        //        case 5: request.getRequestDispatcher("/question/delete").forward(request);
        //        break;
        //        case 6: request.getRequestDispatcher("/question/search").forward(request);
        //        break;
        case 0:
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}