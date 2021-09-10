package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolDoJoinHandler implements Command {


  List<PersonalRequestDTO> personalSelectedList;
  List<PersonalRequestDTO> personalRequestApplyDTOList;
  VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler;
  public VolDoJoinHandler(
      List<PersonalRequestDTO> personalSelectedList,
      VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler,
      List<PersonalRequestDTO> personalRequestApplyDTOList
      ) {
    this.personalSelectedList = personalSelectedList;
    this.volRequestPersonalAppliedListDetailHandler = volRequestPersonalAppliedListDetailHandler;
    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");
    System.out.println();
    System.out.println(" ▶ 참여인원을 확인하고 싶은 봉사번호를 입력해주세요.");
    System.out.println();

    int no = Prompt.inputInt("봉사번호 > ");
    System.out.println();

    PersonalRequestDTO owner = findByOwnerVol(no); // 주최자 혼자 볼 때
    PersonalRequestDTO personalRequestSelectedDTO = findBySelectedVol(no); // 참여자 있을 때 

    if (owner == null) {
      System.out.println("해당 봉사가 없습니다.");
      return;
    }

    // 열람만 하는 경우

    // 주최자가 최초로 목록을 보는 경우
    if (AuthLoginHandler.getLoginUser().getName().equals(owner.getOwner().getName()) || 
        personalRequestSelectedDTO == null) {
      System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n           [  봉사자명  ]\n\n%s(%s)\n",
          owner.getTitle(),
          owner.getJoinCount(), // 최초 주최자 1명
          owner.getJoinNum(),
          owner.getUserId(),
          owner.getOwner().getName());


    } else {
      // 주최자 제외한 새로운 사람이 등록한 경우


      if (no == 1) {
        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n           [  봉사자명  ]\n\n%s(%s)\n%s\n",
            owner.getTitle(),
            personalRequestSelectedDTO.getTotalJoinCount(),
            owner.getJoinNum(),
            owner.getUserId(), // 주최자 아이디
            owner.getOwner().getName(), // 주최자 이룸
            personalRequestSelectedDTO.getMemberNames1());
      } else if (no ==2) {
        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n           [  봉사자명  ]\n\n%s(%s)\n%s\n",
            owner.getTitle(),
            personalRequestSelectedDTO.getTotalJoinCount(),
            owner.getJoinNum(),
            owner.getUserId(), // 주최자 아이디
            owner.getOwner().getName(), // 주최자 이룸
            personalRequestSelectedDTO.getMemberNames2());

      } else if (no ==3) {
        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n           [  봉사자명  ]\n\n%s(%s)\n%s\n",
            owner.getTitle(),
            personalRequestSelectedDTO.getTotalJoinCount(),
            owner.getJoinNum(),
            owner.getUserId(), // 주최자 아이디
            owner.getOwner().getName(), // 주최자 이룸
            personalRequestSelectedDTO.getMemberNames3());

      }

    }
  }

  private PersonalRequestDTO findBySelectedVol(int no) {
    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
      if (personalRequestSelectedDTO.getNo() == no) {
        return personalRequestSelectedDTO;
      }
    }
    return null;
  }

  private PersonalRequestDTO findByOwnerVol(int no) {
    for (PersonalRequestDTO owner : personalRequestApplyDTOList) {
      if (owner.getNo() == no) {
        return owner;
      }
    }
    return null;
  }

  //  private int totalJoinCount() {

  //    int sum = volRequestPersonalAppliedListDetailHandler.joinCounts + volRequestPersonalAppliedListDetailHandler.ownerCount;

  //    return sum;

  //}

}