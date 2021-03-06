package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardReplyListHandler implements Command {

  CommunityDao communityDao;

  public CommBoardReplyListHandler (CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 댓글 목록  ]");
    System.out.println();

    int commBoardNo = (int) request.getAttribute("commBoardNo");
    communityDao.findByCommBoardNo(commBoardNo);

    //    if (commBoardReplyDTO.isEmpty()) {
    //      System.out.println("[  작성된 댓글이 없습니다.  ]");
    //      //return;
    //    }

    Collection<CommBoardReplyDTO> commBoardReplyDTOList = communityDao.findAllCommBoardReply();

    for(CommBoardReplyDTO commBoardReplyDTO : commBoardReplyDTOList) {
      if (commBoardReplyDTO.getNo() == commBoardNo) {
        System.out.printf("%d, %d, %s, %s, %s\n", 
            commBoardReplyDTO.getNo(),
            commBoardReplyDTO.getReplyNo(), 
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
