package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.context.ApplicationContextListener;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.dao.CommReviewDao;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.dao.impl.NetChallengeDao;
import com.share.ftp.dao.impl.NetCommBoardDao;
import com.share.ftp.dao.impl.NetCommReviewDao;
import com.share.ftp.dao.impl.NetDonationBoardDao;
import com.share.ftp.dao.impl.NetDonationRegisterDao;
import com.share.ftp.dao.impl.NetJoinDao;
import com.share.ftp.dao.impl.NetQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AdminChallengeAddHandler;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeQuestionListHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyAddHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyConnectlHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyUpdateHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeSearchHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.join.AuthDisplayUserHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.AuthUpdateUserHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.MyPageDeleteUserHandler;
import com.share.ftp.handler.join.MyPageUpdateUserHandler;
import com.share.ftp.handler.org.MyVolApplyListHandler;
import com.share.ftp.handler.org.MyVolApproveListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeRankingHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeWishHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeListHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeWishHandler;
import com.share.ftp.handler.personal.community.CommBestDetailHandler;
import com.share.ftp.handler.personal.community.CommBestListHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyAddHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyConnectHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyListHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyUpdateHandler;
import com.share.ftp.handler.personal.community.CommBoardSearchHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewSearchHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationAdminPrompt;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDetailRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRegisterListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDeleteHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDetailHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointListHandler;
import com.share.ftp.handler.personal.mypage.MyRankingHandler;
import com.share.ftp.handler.personal.support.AdminQuestionConnectHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionSearchHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolDetailHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyRejectedVolHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAcceptHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyCompleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestBookmarkHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralTotalApprovedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestApplyListHandler;
import com.share.ftp.listener.AppInitListener;
import com.share.ftp.listener.FileListener;
import com.share.menu.Menu;
import com.share.menu.MenuFilter;
import com.share.menu.MenuGroup;
import com.share.request.RequestAgent;
import com.share.util.Prompt;

public class ClientApp {

  RequestAgent requestAgent;

  List<JoinDTO> joinDTOList = new ArrayList<>();
  // ???????????? ?????????(???)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // ??????, ?????? ?????? ?????????
  List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestApplyDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestRejectDTOList = new ArrayList<>();

  // ???????????? ?????????(???)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();
  List<CommBoardReplyDTO> commBoardReplyDTOList = new ArrayList<>();

  // ????????? ?????????(???)
  List<ChallengeJoinDTO> challengeJoinDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> challengeQuestionDTOList = new ArrayList<>();
  List<ChallengeReviewDTO> challengeReviewDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> challengeReplyList = new ArrayList<>();

  // ????????? ?????? ?????? ?????? ?????????(???)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardApplyDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardRejectDTOList = new ArrayList<>();

  // ?????? ?????????(???)
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationMyRegisterDTOList;

  // ??????????????? ?????????(???)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();

  // ????????? ?????????(???)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  //  List<QuestionDTO> questionDTOList = new ArrayList<>();
  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();


  // HashMap
  HashMap<String,Command> challengeReviewMap = new HashMap<>();

  // ?????? ?????? ?????????(Map)
  HashMap<String,Command> commands = new HashMap<>();

  // => ?????????(?????????) ??????
  List<ApplicationContextListener> listeners = new ArrayList<>();

  // => ?????????(?????????)??? ???????????? ?????????
  public void addApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.add(listener);
  }

  // => ?????????(?????????)??? ???????????? ?????????
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.remove(listener);
  }

  private void notifyOnApplicationStarted() {
    HashMap<String, Object> params = new HashMap<>();
    params.put("joinDTOList", joinDTOList);
    params.put("volListDTOList", volListDTOList);
    params.put("generalRequestDTOList", generalRequestDTOList);
    params.put("generalRequestApplyDTOList", generalRequestApplyDTOList);
    params.put("generalRequestRejectDTOList", generalRequestRejectDTOList);
    params.put("commBoardDTOList", commBoardDTOList);
    params.put("commReviewDTOList", commReviewDTOList);
    params.put("commBoardReplyDTOList", commBoardReplyDTOList);
    params.put("challengeJoinDTOList", challengeJoinDTOList);
    params.put("challengeQuestionDTOList", challengeQuestionDTOList);
    params.put("challengeReviewDTOList", challengeReviewDTOList);
    params.put("donationBoardDTOList", donationBoardDTOList);
    params.put("donationBoardApplyDTOList", donationBoardApplyDTOList);
    params.put("donationBoardRejectDTOList", donationBoardRejectDTOList);
    params.put("donationRegisterDTOList", donationRegisterDTOList);
    params.put("myProfileDTOList", myProfileDTOList);
    params.put("myQuestionListDTOList", myQuestionListDTOList);
    params.put("challengeDTOList", challengeDTOList);
    params.put("noticeDTOList", noticeDTOList);
    //    params.put("questionDTOList", questionDTOList);
    params.put("approveOrgDTOList", approveOrgDTOList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(params);
    }
  }

  private void notifyOnApplicationEnded() {
    HashMap<String, Object> params = new HashMap<>();
    params.put("joinDTOList", joinDTOList);
    params.put("volListDTOList", volListDTOList);
    params.put("generalRequestDTOList", generalRequestDTOList);
    params.put("generalRequestApplyDTOList", generalRequestApplyDTOList);
    params.put("generalRequestRejectDTOList", generalRequestRejectDTOList);
    params.put("commBoardDTOList", commBoardDTOList);
    params.put("commReviewDTOList", commReviewDTOList);
    params.put("commBoardReplyDTOList", commBoardReplyDTOList);
    params.put("challengeJoinDTOList", challengeJoinDTOList);
    params.put("challengeQuestionDTOList", challengeQuestionDTOList);
    params.put("challengeReviewDTOList", challengeReviewDTOList);
    params.put("donationBoardDTOList", donationBoardDTOList);
    params.put("donationBoardApplyDTOList", donationBoardApplyDTOList);
    params.put("donationBoardRejectDTOList", donationBoardRejectDTOList);
    params.put("donationRegisterDTOList", donationRegisterDTOList);
    params.put("myProfileDTOList", myProfileDTOList);
    params.put("myQuestionListDTOList", myQuestionListDTOList);
    params.put("challengeDTOList", challengeDTOList);
    params.put("noticeDTOList", noticeDTOList);
    //    params.put("questionDTOList", questionDTOList);
    params.put("approveOrgDTOList", approveOrgDTOList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(params);
    }
  }

  //MenuGroup?????? ????????? ????????? ????????????.
  MenuFilter menuFilter = menu -> (menu.getAccessScope() & AuthLoginHandler.getUserAccessLevel()) > 0;


  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      try {
        command.execute(new CommandRequest(commands));
      } catch(Exception e) {
        System.out.printf("%s ????????? ???????????? ??? ?????? ??????!\n", menuId);
        e.printStackTrace();
      }
    }
  }

  // ?????? ???????????? Handler 

  VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler = 
      new VolGeneralRequestAppliedListHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  GeneralRequestDTO personalRequestDTO = new GeneralRequestDTO();

  VolGeneralDoJoinHandler volRequestPersonalAppliedListDetailHandler =
      new VolGeneralDoJoinHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  // ???????????? ?????? ???????????? Handler

  VolPersonalRequestAppliedListHandler volPersonalRequestAppliedListHandler = new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  VolOrgRequestAppliedListHandler volOrgRequestAppliedListHandler = new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //?????????????????????
  VolGeneralDoJoinListHandler volDoJoinHandler = 
      new VolGeneralDoJoinListHandler
      (generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler);

  DonationRegisterDTO donationRegisterDTO = new DonationRegisterDTO();


  // ????????? ?????? ????????? ?????? Handler
  //  DonationBoardAppliedListHandler donationBoardAppliedListHandler =
  //      new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  //
  //  DonationPrompt donationPrompt = new DonationPrompt(donationBoardDTOList, donationRegisterDTOList);
  //  DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDTOList, donationRegisterDTOList);


  public ClientApp() throws Exception {

    requestAgent = new RequestAgent("127.0.0.1", 8888);

    JoinDao netJoinDao = new NetJoinDao(requestAgent);
    CommBoardDao netCommBoardDao = new NetCommBoardDao(requestAgent);
    CommReviewDao netCommReviewDao = new NetCommReviewDao(requestAgent);
    ChallengeDao netChallengeDao = new NetChallengeDao(requestAgent);
    QuestionDao questionDao = new NetQuestionDao(requestAgent);
    //    ChallengeQuestionDao netChallengeQuestionDao = new NetChallengeDao(requestAgent);
    //    ChallengeReviewDao netChallengeReviewDao = new NetChallengeDao(requestAgent);


    //?????????, ????????????
    commands.put("/auth/login", new AuthLoginHandler(netJoinDao)); // ?????????
    commands.put("/auth/logout", new AuthLogoutHandler()); // ????????????
    commands.put("/auth/changeUserInfo", new AuthUpdateUserHandler()); // ??????????????? ????????????
    commands.put("/auth/displayUserInfo", new AuthDisplayUserHandler()); // ??????????????? ??????????????????

    //????????????
    commands.put("/join/add", new JoinAddHandler(netJoinDao)); // ????????????
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(netJoinDao)); // ???????????? ????????? ??????
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(netJoinDao)); // ???????????? ????????? ??????
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(netJoinDao)); // ???????????? ??????

    commands.put("/volGeneralRequest/apply", new VolGeneralRequestApplyHandler(generalRequestDTOList,joinDTOList));
    commands.put("/volGeneralRequest/applyList", new VolGeneralRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volPersonalRequest/applyList", new VolPersonalRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volOrgRequest/applyList", new VolOrgRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volGeneralRequest/applyCompleteList", new VolGeneralRequestApplyCompleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/acceptApply", new VolGeneralRequestAcceptHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectApply", new VolGeneralRequestRejectHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/appliedList", new VolGeneralRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volPersonalRequest/appliedList", new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volOrgRequest/appliedList", new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectedList", new VolGeneralRequestRejectedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/delete", new VolGeneralRequestDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/bookmark", new VolGeneralRequestBookmarkHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volPersonalRequestAppliedListHandler,volOrgRequestAppliedListHandler));
    commands.put("/volGeneralDoJoin/add", new VolGeneralDoJoinHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralDoJoin/list", new VolGeneralDoJoinListHandler(generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler));
    commands.put("/volGeneralDoJoin/delete", new VolGeneralDoJoinDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    //???????????? (??????) + ???????????????
    //    commands.put("/volRequestOrg/apply", new VolRequestOrgApplyHandler(orgRequestDTOList,joinDTOList));
    //    commands.put("/volRequestOrg/applyList", new VolRequestOrgApplyListHandler(orgRequestDTOList));
    //    commands.put("/volRequestOrg/applyCompleteList", new VolRequestOrgApplyCompleteListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/acceptApply", new VolRequestOrgAcceptApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectApply", new VolRequestOrgRejectApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/appliedList", new VolRequestOrgAppliedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectedList", new VolRequestOrgRejectedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));

    // ???????????? ???????????????
    commands.put("/commBoard/add", new CommBoardAddHandler(netCommBoardDao));
    commands.put("/commBoard/list", new CommBoardListHandler(netCommBoardDao));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(netCommBoardDao));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(netCommBoardDao));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(netCommBoardDao));
    commands.put("/commBoard/search", new CommBoardSearchHandler(netCommBoardDao));
    // commands.put("/commBoard/like", new CommBoardLikeHandler(netCommBoardDao)); 

    // ???????????? ??????
    commands.put("/commBoardReply/connect", new CommBoardReplyConnectHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/add", new CommBoardReplyAddHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/list", new CommBoardReplyListHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/update", new CommBoardReplyUpdateHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/delete", new CommBoardReplyDeleteHandler(commBoardDTOList, commBoardReplyDTOList));

    // commands.put("/commBoard/connect", new CommBoardReplyConnectHandler());

    // ???????????? ??????????????? BEST
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    // ???????????? ????????????
    commands.put("/commReview/add", new CommReviewAddHandler(netCommReviewDao));
    commands.put("/commReview/list", new CommReviewListHandler(netCommReviewDao));
    commands.put("/commReview/update", new CommReviewUpdateHandler(netCommReviewDao));
    commands.put("/commReview/delete", new CommReviewDeleteHandler(netCommReviewDao));
    commands.put("/commReview/search", new CommReviewSearchHandler(netCommReviewDao));

    // ?????????
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(netChallengeDao));  // ????????? ??????
    commands.put("/challenge/detail", new ChallengeDetailHandler(netChallengeDao)); // ????????? ????????????
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(netChallengeDao));  // ????????????
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(netChallengeDao));  // ???????????????
    //    commands.put("/challengeDetail/like", new ChallengeLikeHandler(challengeDTOList));  // ????????? ????????? ??????(????????????)
    commands.put("/challengeDetail/wish", new ChallengeWishHandler(netChallengeDao));  // ?????? ????????? ??????(?????????)

    // ????????? ????????????&??????
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(netChallengeDao));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(netChallengeDao));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(netChallengeDao));
    //    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(netChallengeReviewDao, netChallengeDao));
    commands.put("/challengeReview/connect", new ChallengeReviewConnectHandler(netChallengeDao));

    // ????????? ????????????
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(netChallengeDao));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(netChallengeDao));
    //    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(netChallengeDao));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(netChallengeDao));
    //    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(netChallengeDao, netChallengeQuestionDao));
    commands.put("/challengeQuestion/connect", new ChallengeQuestionConnectHandler(netChallengeDao));


    // ????????? ??????
    commands.put("/ranking/list", new ChallengeRankingHandler(joinDTOList));  //????????????(????????????)
    commands.put("/myRanking/list", new MyRankingHandler(joinDTOList)); //????????????(????????????)

    // ????????? (??????????????????, ????????????, ??????, ??????)

    DonationBoardDao donationBoardDao = new NetDonationBoardDao(requestAgent);

    DonationPrompt donationPrompt = new DonationPrompt(donationBoardDao);
    DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDao);

    DonationRegisterDao donationRegisterDao = new NetDonationRegisterDao(requestAgent);

    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardDao));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDao));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDao));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDao));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDao));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDao, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDao, donationAdminPrompt));

    // ????????? (????????????)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDao, donationBoardDao));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDao));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDao));

    commands.put("/donationBoardRegister/list", new DonationBoardRegisterListHandler(donationRegisterDao));
    commands.put("/donationBoardDetailRegister/add", new DonationBoardDetailRegisterAddHandler(donationBoardDao, donationRegisterDao));

    // ???????????? ????????????
    commands.put("/question/add", new QuestionAddHandler(questionDao));
    commands.put("/question/list", new QuestionListHandler(questionDao));
    commands.put("/question/detail", new QuestionDetailHandler(questionDao));
    commands.put("/question/update", new QuestionUpdateHandler(questionDao));
    commands.put("/question/delete", new QuestionDeleteHandler(questionDao));
    commands.put("/question/search", new QuestionSearchHandler(questionDao));

    commands.put("/adminQuestion/connect", new AdminQuestionConnectHandler());
    //    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));

    // ???????????????
    commands.put("/myPage/info", new MyPageUpdateUserHandler(netJoinDao)); // ????????? ??????
    commands.put("/myPage/delete", new MyPageDeleteUserHandler(netJoinDao)); // ????????????

    commands.put("/myVol/applied", new MyAppliedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/appliedDetail", new MyAppliedVolDetailHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/rejected", new MyRejectedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    commands.put("/myChallenge/list", new MyChallengeListHandler(challengeDTOList));
    commands.put("/myChallenge/detail", new MyChallengeDetailHandler(challengeDTOList));
    commands.put("/myChallenge/wish", new MyChallengeWishHandler(challengeDTOList));


    commands.put("/myBoard/list", new MyBoardListHandler()); // ??????????????? ??????
    commands.put("/myBoard/detail", new MyBoardDetailHandler()); // ??????????????? ??????
    commands.put("/myBoard/update", new MyBoardUpdateHandler()); // ??????????????? ??????
    commands.put("/myBoard/delete", new MyBoardDeleteHandler()); // ??????????????? ??????

    commands.put("myPoint/list", new MyPointListHandler(joinDTOList)); // ??????????????? 

    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // ?????? ??????????????? ???????????? 
    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // ?????? ??????????????? ????????????
    commands.put("/myDonation/list", new MyDonationHandler()); // ?????????
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDao)); // ?????????
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDao));

    // ?????????

    // ????????? ???????????? ??????
    commands.put("/join/list", new JoinListHandler(netJoinDao)); // ???????????? ?????? ????????? ??????
    commands.put("/join/detail", new JoinDetailHandler(netJoinDao)); // ???????????? ???????????? (???????????????)
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // ????????? ???????????? (?????? + ?????????)
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDTOList));

    // ????????? ????????????

    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(myQuestionListDTOList));

    // ????????? ?????????
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(netChallengeDao));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(netChallengeDao));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(netChallengeDao));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(netChallengeDao));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(netChallengeDao));
    commands.put("/adminChallenge/QuestionList", new AdminChallengeQuestionListHandler(netChallengeDao));
    commands.put("/adminChallenge/replyAdd", new AdminChallengeReplyAddHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyUpdate", new AdminChallengeReplyUpdateHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyDelete", new AdminChallengeReplyDeleteHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyConnect", new AdminChallengeReplyConnectlHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // ????????? ?????? ??????, ??????, ?????? ??????

    // ????????? ????????????

    //    challengeReviewMap.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    //    challengeReviewMap.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
  }


  void service() {

    notifyOnApplicationStarted();

    createMenu().execute();
    Prompt.close();

    notifyOnApplicationEnded();

  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*?????????Share*");
    mainMenuGroup.setMenuFilter(menuFilter);
    mainMenuGroup.setPrevMenuTitle("??????");

    mainMenuGroup.add(new MenuItem("?????????", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("???????????????", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);
    searchId.add(new MenuItem("?????????????????????????????????", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("???????????????????????????", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("??????????????????", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_MEMBER_ADMIN, "/auth/logout"));



    // ????????????
    MenuGroup doVolMenu = new MenuGroup("????????????");
    mainMenuGroup.add(doVolMenu);
    doVolMenu.setMenuFilter(menuFilter);


    doVolMenu.add(new MenuItem("????????????????????????", ACCESS_PERSONAL, "/volGeneralRequest/apply"));
    doVolMenu.add(new MenuItem("????????????????????????", ACCESS_ORG, "/volGeneralRequest/apply")); 
    doVolMenu.add(new MenuItem("???????????????????????????","/volGeneralRequest/appliedList")); 
    doVolMenu.add(createVolJoinMenu()); // ?????? ????????????
    doVolMenu.add(new MenuItem("?????????", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????

    // ????????????
    MenuGroup CommunityMenu = new MenuGroup("????????????");
    mainMenuGroup.add(CommunityMenu);
    CommunityMenu.setMenuFilter(menuFilter);

    CommunityMenu.add(createReviewMenu());      // ???????????????
    CommunityMenu.add(createBestReviewMenu());  // ???????????????BEST
    CommunityMenu.add(createShortReviewMenu()); // ????????????

    // ?????????
    MenuGroup challengeMenu = new MenuGroup("?????????");
    mainMenuGroup.add(challengeMenu);
    challengeMenu.setMenuFilter(menuFilter);

    MenuGroup monthlyChallengeMenu = new MenuGroup("????????? ?????????");
    challengeMenu.add(monthlyChallengeMenu);
    monthlyChallengeMenu.setMenuFilter(menuFilter);

    //    MenuGroup challengeListMenu = new MenuGroup("????????? ??????");
    //    monthlyChallengeMenu.add(challengeListMenu);

    //    MenuGroup challengeDetailMenu = new MenuGroup("????????? ????????????");
    //    monthlyChallengeMenu.add(challengeDetailMenu); 

    //    MenuGroup showChallengeDetailHandler = new MenuGroup("????????????");  // ????????????
    //    challengeDetailMenu.add(showChallengeDetailHandler);

    monthlyChallengeMenu.add(new MenuItem("????????? ??????", "/adminChallenge/list"));

    monthlyChallengeMenu.add(new MenuItem("????????? ????????????", "/challenge/detail"));

    //    monthlyChallengeMenu.add(new MenuItem("????????????", ACCESS_MEMBER, "/challengeJoin/join"));
    //
    //    monthlyChallengeMenu.add(new MenuItem("????????? ??????", ACCESS_MEMBER, "/challengeJoin/list"));
    //
    //    monthlyChallengeMenu.add(createChallengeReviewMenu()); // ????????????&??????
    //    monthlyChallengeMenu.add(createChallengeQuestionMenu()); // ????????????

    challengeMenu.add(createMonthlyRankingMenu()); // ????????? ??????


    // ?????????
    mainMenuGroup.add(createDonationMenu());


    // ????????????
    MenuGroup supportMenu = new MenuGroup("????????????");
    mainMenuGroup.add(supportMenu);
    supportMenu.setMenuFilter(menuFilter);

    supportMenu.add(createNoticeMenu());      // ????????????
    supportMenu.add(createQuestionMenu());         // ????????????

    // ???????????????
    MenuGroup MyPageMenu = new MenuGroup("???????????????", ACCESS_MEMBER);
    mainMenuGroup.add(MyPageMenu);
    MyPageMenu.setMenuFilter(menuFilter);

    MyPageMenu.add(createMyProfileMenu());    // ????????????
    MyPageMenu.add(createMyVolunteerMenu());  // ????????????
    MyPageMenu.add(createMyBoardMenu());      // ???????????????
    MyPageMenu.add(createMyChallengeMenu());    // ???????????????
    MyPageMenu.add(createMyPointMenu());      // ???????????????
    MyPageMenu.add(createMyDonationMenu());   // ???????????????
    MyPageMenu.add(createOrgApprovewMenu());  // ??????????????????
    MyPageMenu.add(new MenuItem("??????", ACCESS_MEMBER, "/myPage/delete")); 

    // ?????????
    //    MenuGroup adminMenu = new MenuGroup("?????????", ACCESS_ADMIN);
    //    mainMenuGroup.add(adminMenu);

    mainMenuGroup.add(createAdminMemberMenu());      // ????????????
    mainMenuGroup.add(createAdminDonationMenu());    // ????????????
    mainMenuGroup.add(createAdminVolMenu());         // ????????????
    mainMenuGroup.add(createAdminNoticeMenu());      // ??????????????????
    mainMenuGroup.add(createAdminAskMenu());         // ??????????????????
    mainMenuGroup.add(createAdminChallengeMenu());   // ???????????????
    mainMenuGroup.add(createAdminApproveInfoMenu()); // ??????????????????
    mainMenuGroup.add(createAdminCommMenu()); // ???????????? ??????

    mainMenuGroup.add(new MenuItem("????????????", ACCESS_MEMBER, "/myPage/delete"));

    return mainMenuGroup;



  }

  ////////////////////////////////////////////////////////////////////////////////////////////////



  private Menu createVolJoinMenu() {
    MenuGroup volJoinMenu = new MenuGroup("??????????????????");
    volJoinMenu.setMenuFilter(menuFilter);

    volJoinMenu.add(new MenuItem("??????????????????",ACCESS_PERSONAL,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("??????????????????",ACCESS_ORG,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("?????????????????????","/volDoJoin/list")); 
    volJoinMenu.add(new MenuItem("?????????", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????
    volJoinMenu.add(createVolReviewMenu());
    volJoinMenu.add(createVolQuestionMenu()); 

    return volJoinMenu;
  }


  private Menu createVolReviewMenu() {
    MenuGroup volReview = new MenuGroup("????????????&??????");
    volReview.setMenuFilter(menuFilter);
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER, "/volJoinReview/add"));
    volReview.add(new MenuItem("?????? ???????????? ??????", "/volJoinReview/list"));
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER,"/volJoinReview/update"));
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER,"/volJoinReview/delete"));
    volReview.add(new MenuItem("?????? ???????????? ??????", "/volJoinReview/search"));

    return volReview;
  }


  private Menu createVolQuestionMenu() {
    MenuGroup VolQuestion = new MenuGroup("????????????");
    VolQuestion.setMenuFilter(menuFilter);

    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/add"));
    VolQuestion.add(new MenuItem("?????? ??????",  "/volQuestion/list"));
    VolQuestion.add(new MenuItem("?????? ????????????", ACCESS_MEMBER,"/volQuestion/detail"));
    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/update"));
    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/delete"));
    VolQuestion.add(new MenuItem("?????? ??????",  "/volQuestion/search"));

    return VolQuestion;
  }





  private Menu createReviewMenu() {
    MenuGroup reviewMenu = new MenuGroup("?????? ?????????");
    reviewMenu.setMenuFilter(menuFilter);

    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commBoard/add"));
    reviewMenu.add(new MenuItem("??????","/commBoard/list"));
    reviewMenu.add(new MenuItem("????????????","/commBoard/detail"));
    //    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN,"/commBoard/update"));
    //    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commBoard/delete"));
    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commBoard/search"));

    return reviewMenu;
  }

  private Menu createBestReviewMenu() {
    MenuGroup bestReviewMenu = new MenuGroup("?????? ????????? BEST");
    bestReviewMenu.setMenuFilter(menuFilter);

    bestReviewMenu.add(new MenuItem("??????","/commBest/list"));
    bestReviewMenu.add(new MenuItem("????????????","/commBest/detail"));

    return bestReviewMenu;
  }

  private Menu createShortReviewMenu() {
    MenuGroup shortReviewMenu = new MenuGroup("??? ??? ??????");
    shortReviewMenu.setMenuFilter(menuFilter);

    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("??????", "/commReview/list")); 
    //    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/update")); 
    //    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/delete")); 
    shortReviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commReview/search"));


    return shortReviewMenu;
  }


  public  Menu createChallengeReviewMenu() {
    MenuGroup ChallengeReview = new MenuGroup("????????????&??????");
    ChallengeReview.setMenuFilter(menuFilter);
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", "/challengeReview/list"));
    //    ChallengeReview.add(new MenuItem("????????????&?????? ????????????", ACCESS_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", "/challengeReview/search"));

    return ChallengeReview;
  }



  private Menu createChallengeQuestionMenu() {
    MenuGroup ChallengeQuestion = new MenuGroup("????????????");
    ChallengeQuestion.setMenuFilter(menuFilter);
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("?????? ????????????", ACCESS_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/search"));

    return ChallengeQuestion;
  }



  private Menu createMonthlyRankingMenu() {
    MenuGroup monthlyRankingMenu = new MenuGroup("????????? ??????");
    monthlyRankingMenu.setMenuFilter(menuFilter);
    monthlyRankingMenu.add(new MenuItem("????????? ????????????", "/ranking/list"));  //????????????(????????????)
    monthlyRankingMenu.add(new MenuItem("?????? ????????????", ACCESS_MEMBER, "/myRanking/list"));  //????????????(????????????)

    return monthlyRankingMenu;
  }

  private Menu createDonationMenu() {
    MenuGroup donationMenu = new MenuGroup("?????????");
    donationMenu.setMenuFilter(menuFilter);

    donationMenu.add(new MenuItem("?????? ????????? ??????", "/donationRegister/totalMoney"));
    donationMenu.add(new MenuItem("?????? ?????? ????????????", "/donationRegister/participation"));
    donationMenu.add(new MenuItem("???????????????","/donationBoard/list"));
    donationMenu.add(new MenuItem("????????? ????????????", "/donationBoard/applyDetail"));
    //    donationMenu.add(new MenuItem("????????????", ACCESS_MEMBER, "/donationRegister/add"));
    donationMenu.add(new MenuItem("????????? ????????????", ACCESS_ORG, "/donationBoard/apply"));

    return donationMenu;
  }


  private Menu createNoticeMenu() {
    MenuGroup noticeMenu = new MenuGroup("????????????");
    noticeMenu.setMenuFilter(menuFilter);

    noticeMenu.add(new MenuItem("???????????? ??????", ACCESS_ADMIN,"/adminNotice/add"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/list"));
    noticeMenu.add(new MenuItem("???????????? ????????????","/adminNotice/detail"));
    //    noticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/update"));
    //    noticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/delete"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/search"));

    return noticeMenu;
  }

  private Menu createQuestionMenu() {
    MenuGroup question = new MenuGroup("????????????");
    question.setMenuFilter(menuFilter);
    question.add(new MenuItem("??????", ACCESS_MEMBER,"/question/add"));
    question.add(new MenuItem("??????", "/question/list"));
    question.add(new MenuItem("????????????", ACCESS_MEMBER_ADMIN, "/question/detail"));
    //    ask.add(new MenuItem("??????", ACCESS_MEMBER,"/question/update"));
    //    ask.add(new MenuItem("??????", ACCESS_MEMBER, "/question/delete"));
    question.add(new MenuItem("??????", "/question/search"));

    return question;
  }


  // ???????????????

  private Menu createMyProfileMenu() {
    MenuGroup myProfile = new MenuGroup("????????????", ACCESS_MEMBER);
    myProfile.setMenuFilter(menuFilter);
    myProfile.add(new MenuItem("??? ??????", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("??? ?????? ??????", "/auth/changeUserInfo"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("?????? ??????");
    myVolunteer.setMenuFilter(menuFilter);

    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_PERSONAL,"/myVol/appliedDetail")); 
    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_ORG,"/myVol/appliedDetail")); // ????????????
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_PERSONAL,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_PERSONAL,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_PERSONAL,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_ORG,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("??????????????? ????????????",ACCESS_MEMBER,"/volGeneralDoJoin/delete"));    
    myVolunteer.add(new MenuItem("????????????",ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????

    return myVolunteer;
  }

  private Menu createMyBoardMenu() {

    MenuGroup myBoard = new MenuGroup("?????? ?????????"); // ????????????
    myBoard.setMenuFilter(menuFilter);
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/list"));
    myBoard.add(new MenuItem("??????????????? ????????????","/myBoard/detail"));
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/update"));
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/delete"));

    return myBoard;
  }
  private Menu createMyChallengeMenu() {

    MenuGroup myChallenge = new MenuGroup("?????? ?????????"); // ????????????
    myChallenge.setMenuFilter(menuFilter);
    myChallenge.add(new MenuItem("??????????????? ??????","/myChallenge/list"));
    myChallenge.add(new MenuItem("??????????????? ????????????","/myChallenge/detail"));
    myChallenge.add(new MenuItem("??????????????? ????????????","/myChallenge/wish"));

    return myChallenge;
  }


  private Menu createMyDonationMenu() {
    MenuGroup myDonation = new MenuGroup("?????? ?????????"); 
    myDonation.setMenuFilter(menuFilter);
    myDonation.add(new MenuItem("?????? ????????? ??????????????? ??????", ACCESS_ORG, "/myDonation//applyCompleteList")); 
    myDonation.add(new MenuItem("?????? ????????????", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("????????? ????????? ????????????",ACCESS_ORG,"/donationBoard/appliedList")); 
    myDonation.add(new MenuItem("????????? ????????? ????????????", ACCESS_ORG,"/donationBoard/rejectedList"));  

    return myDonation;
  }

  private Menu createMyPointMenu() {
    MenuGroup myPoint = new MenuGroup("?????? ?????????"); // ????????????
    myPoint.setMenuFilter(menuFilter);
    myPoint.add(new MenuItem("?????????????????????","myPoint/list"));

    return myPoint;
  }


  private Menu createOrgApprovewMenu() {
    MenuGroup orgpprove = new MenuGroup("?????? ?????? ??????");
    orgpprove.setMenuFilter(menuFilter);

    orgpprove.add(new MenuItem("?????? ????????????","/orgMyVol/apply"));
    orgpprove.add(new MenuItem("?????? ????????????","/orgMyVol/approve"));

    return orgpprove;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  // ?????????

  private Menu createAdminMemberMenu() {
    MenuGroup adminMemberMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminMemberMenu.setMenuFilter(menuFilter);

    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN, "/join/list"));
    adminMemberMenu.add(new MenuItem("???????????? ????????????", ACCESS_ADMIN,"/join/detail"));
    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN,"/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminDonationMenu() {
    MenuGroup adminDonationMenu = new MenuGroup("????????? ??????" ,ACCESS_ADMIN);
    adminDonationMenu.setMenuFilter(menuFilter);

    adminDonationMenu.add(new MenuItem("????????? ?????? ???????????? ??????",ACCESS_ADMIN, "/donationBoard/applyList"));
    adminDonationMenu.add(new MenuItem("????????? ?????? ???????????? ????????????",ACCESS_ADMIN, "/adminDonationBoard/applyDetail"));
    //    adminDonationMenu.add(new MenuItem("????????? ?????? ????????????", "/donationBoard/acceptApply"));
    //    adminDonationMenu.add(new MenuItem("????????? ?????? ????????????", "/donationBoard/rejectApply"));

    return adminDonationMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminVolMenu.setMenuFilter(menuFilter);

    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volPersonalRequest/applyList"));
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volOrgRequest/applyList")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volGeneralRequest/acceptApply"));
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volGeneralRequest/acceptApply")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volGeneralRequest/rejectApply"));
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volGeneralRequest/rejectApply")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????",ACCESS_ADMIN,"/volGeneralRequest/delete"));

    return adminVolMenu;
  }

  private Menu createAdminNoticeMenu() {
    MenuGroup adminNoticeMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminNoticeMenu.setMenuFilter(menuFilter);

    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/add"));
    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/list"));
    adminNoticeMenu.add(new MenuItem("???????????? ????????????",ACCESS_ADMIN,"/adminNotice/detail"));
    //    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/update"));
    //    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/delete"));
    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/search"));

    return adminNoticeMenu;
  }

  private Menu createAdminAskMenu() {
    MenuGroup adminAskInfo = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminAskInfo.setMenuFilter(menuFilter);

    //    adminAskInfo.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/question/add"));
    adminAskInfo.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/question/list"));
    adminAskInfo.add(new MenuItem("???????????? ????????????",ACCESS_ADMIN,"/question/detail"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/question/update"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/question/delete"));
    adminAskInfo.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/question/search"));

    return adminAskInfo;
  }


  private Menu createAdminChallengeMenu() {
    MenuGroup adminChallengeInfo = new MenuGroup("????????? ??????", ACCESS_ADMIN);
    adminChallengeInfo.setMenuFilter(menuFilter);

    adminChallengeInfo.add(new MenuItem("????????? ??????",ACCESS_ADMIN,"/adminChallenge/add"));
    adminChallengeInfo.add(new MenuItem("????????? ??????",ACCESS_ADMIN,"/adminChallenge/list"));
    adminChallengeInfo.add(new MenuItem("????????? ????????????",ACCESS_ADMIN,"/adminChallenge/detail"));
    //    adminChallengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/update"));
    //    adminChallengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/delete"));
    //    adminChallengeInfo.add(new MenuItem("????????? ???????????? ??????","/adminChallengeQuestion/add"));

    return adminChallengeInfo;
  }

  private Menu createAdminApproveInfoMenu() {
    MenuGroup adminApproveInfo = new MenuGroup("?????? ??????", ACCESS_ADMIN);
    adminApproveInfo.setMenuFilter(menuFilter);

    adminApproveInfo.add(new MenuItem("?????????????????? ??????",ACCESS_ADMIN,"/adminChallenge/list"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????",ACCESS_ADMIN,"/adminChallenge/detail"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????",ACCESS_ADMIN,"/adminChallenge/update"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????",ACCESS_ADMIN,"/adminChallenge/delete"));

    return adminApproveInfo;
  }
  private Menu createAdminCommMenu() {
    MenuGroup adminCommInfo = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminCommInfo.setMenuFilter(menuFilter);

    adminCommInfo.add(new MenuItem("??????????????? ??????", ACCESS_MEMBER_ADMIN, "/commBoard/list"));
    adminCommInfo.add(new MenuItem("???????????????", ACCESS_MEMBER_ADMIN, "/commBoard/detail")); 
    adminCommInfo.add(new MenuItem("??????????????? Best ????????????", ACCESS_MEMBER_ADMIN, "/commBest/detail")); 
    adminCommInfo.add(new MenuItem("???????????? ??????",ACCESS_MEMBER_ADMIN,"/commReview/list"));


    return adminCommInfo;
  }


  public static void main(String[] args) throws Exception {

    ClientApp app = new ClientApp(); 
    app.addApplicationContextListener(new AppInitListener());
    app.addApplicationContextListener(new FileListener());
    app.service();

    Prompt.close();
  }


}

