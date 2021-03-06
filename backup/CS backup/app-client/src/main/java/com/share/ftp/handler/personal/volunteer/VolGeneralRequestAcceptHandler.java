package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolGeneralRequestAcceptHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳

  public VolGeneralRequestAcceptHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  봉사신청서 승인  ]");
    System.out.println();

    if (generalRequestDTOList.isEmpty()) {
      System.out.println("승인할 봉사 신청서가 없습니다!");

    }


    if(validPersonalVol()) {

      int no = Prompt.inputInt("번호 ▶ ");
      System.out.println();

      GeneralRequestDTO generalRequestDTO = findByVol(no);

      if (generalRequestDTO == null) {
        System.out.println("해당 번호의 봉사신청서가 없습니다.");
        return;
      }

      String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
      if (!input.equals("y") || input.length() == 0) {
        System.out.println("[  해당 봉사신청 승인을 취소하였습니다. ]");
        return;
      }

      generalRequestDTO.setIsSigned("승인됨");
      generalRequestDTO.addMembers(generalRequestDTO.getOwner());

      generalRequestApplyDTOList.add(generalRequestDTO);

      System.out.println("[  ✔️ 해당 봉사신청을 승인하였습니다. ]");

    } else if (validOrgVol()) {

      int no = Prompt.inputInt("번호 ▶ ");
      System.out.println();

      GeneralRequestDTO generalRequestDTO = findByVol(no);

      if (generalRequestDTO == null) {
        System.out.println("해당 번호의 봉사신청서가 없습니다.");
        return;
      }

      String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
      if (!input.equals("y") || input.length() == 0) {
        System.out.println("[  해당 봉사신청 승인을 취소하였습니다. ]");
        return;
      }

      generalRequestDTO.setIsSigned("승인됨");
      generalRequestDTO.addMembers(generalRequestDTO.getOwner());

      generalRequestApplyDTOList.add(generalRequestDTO);

      System.out.println("[  ✔️ 해당 봉사신청을 승인하였습니다. ]");
    } else {
      System.out.println("해당 번호의 봉사는 없습니다.");
      return;
    }







  }
}















//  private List<JoinDTO> addOwner(PersonalRequestDTO owner) {
//
//    if (owner.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
//      members.add(owner.getOwner());
//    }
//    return members;
//  }


