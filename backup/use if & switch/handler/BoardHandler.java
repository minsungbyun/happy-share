package com.share.ftp.handler;

import java.util.List;
import com.share.ftp.domain.Board;
import com.share.util.Prompt;

public class BoardHandler {

  List<Board> boardList;

  public BoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }


  public void add() {


    //    System.out.println("[새 게시글]");
    //
    //    Board board = new Board();
    //
    //    board.setNo(Prompt.inputInt("번호? "));
    //    board.setTitle(Prompt.inputString("제목? "));
    //    board.setContent(Prompt.inputString("내용? "));
    //    board.setWriter(Prompt.inputString("작성자? "));
    //    board.setRegisteredDate(new Date(System.currentTimeMillis()));
    //
    //    boardList.add(board);
  }

  public void list() {

    //    System.out.println("[게시글 목록]");
    //
    //    // 현재 BoardList에 보관된 값을 담을 수 있는 만큼 크기의 배열을 생성한다. 
    //    Board[] boards = new Board[boardList.size()];
    //
    //    // 배열을 파라미터로 넘겨서 값을 받아 온다.
    //    // => 넘겨 주는 배열의 크기가 충분하기 때문에 toArray()는 새 배열을 만들지 않을 것이다.
    //    boardList.toArray(boards);
    //
    //    // 이렇게 제네릭이 적용된 List를 사용하면 
    //    // List에서 값을 꺼낼 때 마다 형변환 할 필요가 없어 프로그래밍이 편리하다.
    //    for (Board board : boards) {
    //      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
    //          board.getNo(), 
    //          board.getTitle(), 
    //          board.getWriter(),
    //          board.getRegisteredDate(),
    //          board.getViewCount(), 
    //          board.getLike());
  }


  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.setTitle(title);
    board.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    boardList.remove(board);

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    // 일부러 BoardList에 들어 있는 배열 보다 작은 배열을 넘겨준다.
    // => 그러면 toArray()는 새 배열을 만들어 값을 저장한 후 리턴할 것이다.
    Board[] arr = boardList.toArray(new Board[0]);
    for (Board board : arr) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }

  // 함께해요 : 위정욱
  public void registerFinish() {
    System.out.println("등록이 완료 되었습니다.");
  }

  public void volunteerupdate() {
    System.out.println("변경이 완료 되었습니다.");
  }

  public void volunteerdelete() {
    System.out.println("삭제가 완료 되었습니다.");
  }

  // 소통해요 : 변민성

  public void write() {
    System.out.println("게시글을 작성합니다.");
  }

  public void reviewList() {
    System.out.println("1. 오늘 너무 환상적인 봉사였어요");
    System.out.println("2. 오늘 짱이에요");
    System.out.println("3. 날씨도 좋은걸요?");
  }

  public void reviewDetail() {
    System.out.println("오늘 너무 환상적인 봉사였어요");
    System.out.println("너무 환상적인 봉사였어요");
    System.out.println("환상적인 봉사였어요");
    System.out.println("봉사였어요");
  }

  public void reviewChange() {
    System.out.println("해당 게시물이 변경되었습니다.");
  }

  public void reviewDelete() {
    System.out.println("해당 게시물이 삭제되었습니다.");
  }

  public void bestReview() {
    System.out.println("너무너무너무너무너무너무너무");
  }

  public void shortReviewAdd() {
    System.out.println("1. 추가추가추가추가");
  }

  public void shortReviewList() {
    System.out.println("1. 추가하");
    System.out.println("2. 추가요");
    System.out.println("3. 추가욤");
    System.out.println("4. 추가열");

  }

  public void shortReviewUpdate() {
    System.out.println("해당 게시물이 변경되었습니다.");

  }

  public void shortReviewDelete() {
    System.out.println("해당 게시물이 삭제되었습니다.");

  }


  public void monthlyChallengeList() {
    System.out.println("1. 오호라");
    System.out.println("2. 코딩스쿨");
    System.out.println("3. 좋아");
    System.out.println("4. 가는거야");

  }

  public void monthlyChallengeDetail() {
    System.out.println("오호라오호라오호라오호라");
    System.out.println("쫄지마쫄지마쫄지마쫄지마");
    System.out.println("쫄지마쫄지마쫄지마쫄지마");
    System.out.println("쫄지마쫄지마쫄지마");

  }

  public void monthlyRankingList() {
    System.out.println("1. 오호라");
    System.out.println("2. 코딩스쿨");
    System.out.println("3. 좋아");
    System.out.println("4. 가는거야");

  }

  public void monthlyRankingDetail() {
    System.out.println("오호라오호라오호라오호라");
    System.out.println("쫄지마쫄지마쫄지마쫄지마");
    System.out.println("쫄지마쫄지마쫄지마쫄지마");
    System.out.println("쫄지마쫄지마쫄지마");

  }

  public void rankingList() {
    System.out.println("1. 1등");
    System.out.println("2. 2등");
    System.out.println("3. 3등");

  }






  // 모금함 : 박성준


  public void okMessage() {
    System.out.println("감사합니다. 기부가 완료되었습니다!");
  }

  public void donationList() {
    System.out.println("비트캠프 회원님 100000원 기부");
    System.out.println("비트캠프2 회원님 100원 기부");
    System.out.println("비트캠프3 회원님 1000원 기부");
  }

  public void totalList() {
    System.out.println("2021년 총 100분이 100_000_000원을 기부해주셨습니다!!");
  }


  // 마이페이지 : 구백연


  public void checkchange() {
    System.out.println("변경되었습니다.");
  }

  public void checkUpdate() {
    System.out.println("수정되었습니다.");
  }

  public void checkDelete() {
    System.out.println("삭제되었습니다.");
  }

  public void okSubmit() {
    System.out.println("신청완료되었습니다.");
  }

  public void getOutHere() {
    System.out.println("탈퇴되었습니다.");
  }


  // 고객센터 : 이지호

  public void askMesasge() {
    System.out.println("문의가 완료 되었습니다.");
  }

  public void finish() {
    System.out.println("변경이 완료 되었습니다.");
  }

  public void ask() {
    System.out.println("삭제가 완료 되었습니다.");
  }


  // 관리자 페이지 

  public void adminList() {
    System.out.println("1. 홍길동");
    System.out.println("2. 임꺽정");
  }

  public void adminDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminGetOut() {
    System.out.println("선택하신 회원을 추방하였습니다.");
  }

  public void adminDonationList() {
    System.out.println("1. 홍길동");
    System.out.println("2. 임꺽정");  
  }

  public void adminDonationDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminok() {
    System.out.println("승인되었습니다.");
  }

  public void adminOut() {
    System.out.println("반려되었습니다..");
  }

  public void adminVolunteerList() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminVolunteerDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminVolunteerok() {
    System.out.println("승인되었습니다.");
  }

  public void adminVolunteerOut() {
    System.out.println("반려되었습니다..");
  }


  public void adminNoticeAdd() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminNoticeList() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminNoticeDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminNoticeOk() {
    System.out.println("변경되었습니다.");
  }

  public void adminNoticeOut() {
    System.out.println("삭제되었습니다..");
  }


  public void adminaskInfoAdd() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminaskInfoList() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminaskInfoDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminaskInfoOk() {
    System.out.println("변경되었습니다.");
  }

  public void adminaskInfoOut() {
    System.out.println("삭제되었습니다..");
  }


  public void adminChallengeInfoAdd() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminChallengeInfoList() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminChallengeInfoDetail() {
    System.out.println("나이는 20살 ㅎㅎ");
  }

  public void adminChallengeInfoOk() {
    System.out.println("변경되었습니다.");
  }

  public void adminApproveInfoOut() {
    System.out.println("삭제되었습니다..");
  }

  public void adminApproveInfoAdd() {
    System.out.println("1. 오호라");
    System.out.println("2. 임꺽정"); 
  }

  public void adminApproveInfoList() {
    System.out.println("승인되었습니다.");

  }

  public void adminApproveInfoDetail() {
    System.out.println("승인 완료 되었습니다.");

  }

  public void adminApproveNO() {
    System.out.println("반려되었습니다.");
  }







































}








