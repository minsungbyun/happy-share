package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;

public class VolRequestPersonalApplyCompleteListHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestPersonalApplyCompleteListHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  나의 봉사 신청서 목록  ]");
    System.out.println();

    if (personalRequestDTOList.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }

    for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
      System.out.printf("번호: %d\n"
          + "봉사제목: %s\n"
          + "주최자: %s\n"
          + "봉사분류: %s\n"
          + "전화번호: %s\n"
          + "이메일: %s\n"
          + "봉사시작기간: %s\n"
          + "봉사종료기간: %s\n"
          + "봉사시작시간: %s\n"
          + "봉사종료시간: %s\n"
          //          + "봉사목록: %s\n"
          + "봉사인원: %d\n"
          + "봉사내용: %s\n"
          + "첨부파일: %s\n"
          + "승인여부: %s \n\n", 

          personalRequestDTO.getVolNo(), 
          personalRequestDTO.getVolTitle(), 
          personalRequestDTO.getOwner().getName(), 
          personalRequestDTO.getVolSort(), 
          personalRequestDTO.getVolTel(),
          personalRequestDTO.getVolEmail(),
          personalRequestDTO.getVolStartDate(),
          personalRequestDTO.getVolEndDate(),
          personalRequestDTO.getVolStartTime(),
          personalRequestDTO.getVolEndTime(),
          //          personalRequestDTO.getVolList(),
          personalRequestDTO.getVolLimitNum(),
          personalRequestDTO.getVolContent(),
          personalRequestDTO.getVolFileUpload(),
          //          personalRequestDTO.isChecked(),
          personalRequestDTO.getIsSigned()
          );
    }
  }

}
