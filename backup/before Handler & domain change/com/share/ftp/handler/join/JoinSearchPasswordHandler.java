package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.util.Prompt;

public class JoinSearchPasswordHandler extends AbstractJoinHandler {

  public JoinSearchPasswordHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);
  }

  // 비밀번호 찾기 (아이디,이메일)
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[아이디를 입력해주세요.]");
    String id = Prompt.inputString("아이디? ");
    System.out.println();
    System.out.println("[이메일을 입력해주세요.]");
    String email = Prompt.inputString("이메일? ");

    JoinDTO joinDTO = findByMember(id, email);

    if (joinDTO == null) {
      System.out.println("해당 아이디를 찾을 수 없습니다.");
      return;
    }
    System.out.println();
    System.out.printf("비밀번호: [ %s ]\n", joinDTO.getPassword());
  }
}



