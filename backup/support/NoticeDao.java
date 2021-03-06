package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;

// 게시글 데이터를 처리하는 객체 사용법을 정의
public interface NoticeDao {

  void insert(NoticeDTO addNotice) throws Exception;
  List<NoticeDTO> findAll() throws Exception;
  List<NoticeDTO> findByKeyword(String keyword) throws Exception;
  NoticeDTO findByNoticeNo(int noticeNo) throws Exception;
  void update(NoticeDTO updateNotice) throws Exception;
  void delete(int noticeNo) throws Exception;
  int getNextNum() throws Exception; // 회원 고유번호 지정

}
