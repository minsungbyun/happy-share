package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardReplyListHandler extends AbstractCommBoardReplyHandler {

  public CommBoardReplyListHandler(
      List<CommBoardDTO> commBoardDTOList,
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기  / 댓글 목록  ]");
    System.out.println();

    int commNo = (int) request.getAttribute("commNo");

    //    CommBoardDTO commBoardDTOList = findByCommBoardNo(commBoardNo);
    //
    //    if (commBoardDTOList == null) {
    //      System.out.println("작성된 게시글이 없습니다.");
    //      return;
    //    }

    if (commBoardReplyDTOList.isEmpty()) {
      System.out.println("[  작성된 댓글이 없습니다.  ]");
      //return;
    }

    for(CommBoardReplyDTO commBoardReplyDTO : commBoardReplyDTOList) {
      if (commBoardReplyDTO.getCommNo() == commNo) {
        System.out.printf("%d, %d, %s, %s, %s\n", 
            commBoardReplyDTO.getCommNo(),
            commBoardReplyDTO.getCommReplyNo(), 
            commBoardReplyDTO.getOwner().getId(),
            commBoardReplyDTO.getCommentcontent(),
            commBoardReplyDTO.getRegisteredDate());
        //commBoardReplyDTO.getCommReplyPassword(),
      }
    }

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 댓글 등록");
      System.out.println("2번 ▶ 댓글 변경, 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {

        case 1: request.getRequestDispatcher("/commBoardReply/add").forward(request); return;
        case 2: request.getRequestDispatcher("/commBoardReply/connect").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }

    } 
  } 
}

//    System.out.println();
//    int replyNo = Prompt.inputInt("변경, 삭제하고자 하는 댓글 번호를 입력해주세요 (이전: 0) ▶ ");
//
//    if (replyNo == 0) {
//      return;
//    }
//
//    CommBoardReplyDTO commBoardReplyDTO = findByReplyNo(replyNo);
//
//    if (commBoardReplyDTO == null) {
//      System.out.println("해당 번호의 댓글이 없습니다.");
//      return;
//    }
//
//    if (!commBoardReplyDTO.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
//      System.out.println("변경 권한이 없습니다.");
//      return;
//    }
//
//    request.setAttribute("replyNo", replyNo); 

//JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 
//    if (CommBoardReplyDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
//}




