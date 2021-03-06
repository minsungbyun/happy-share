package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class AdminNoticeUpdateHandler implements Command {

  NoticeDao noticeDao;
  GeneralDao generalDao;
  SqlSession sqlSession;


  public AdminNoticeUpdateHandler(NoticeDao noticeDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.noticeDao = noticeDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 수정 ]");

    int noticeNo = (int) request.getAttribute("noticeNo");

    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s) ▶ ", noticeDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s) ▶ ", noticeDTO.getContent()));
    noticeDTO.setFileUpload(GeneralHelper.promptNoticeFileUpload());
    //    List<QuestionAttachedFile> filepath = GeneralHelper.promptQnaFileUpload();

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("게시물 수정을 취소하였습니다.");
      return;
    }

    noticeDTO.setTitle(title);
    noticeDTO.setContent(content);

    try {
      noticeDao.update(noticeDTO);
      noticeDao.deleteFile(noticeDTO);
      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
      }
      sqlSession.commit();
    } catch (Exception e) {
      // 예외검사
      e.printStackTrace();
      // 예외 발생하면, 발생하기 전 작업이 모두 취소됨
      sqlSession.rollback();
    }
    System.out.println();
    System.out.println("게시물을 수정하였습니다.");
  }
}
