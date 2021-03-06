package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_GROUP;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.share.context.ApplicationContextListener;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerShortReviewDao;
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
import com.share.ftp.handler.join.GroupFormUpdateHandler;
import com.share.ftp.handler.join.GroupHandler;
import com.share.ftp.handler.join.GroupListHandler;
import com.share.ftp.handler.join.GroupUserDeleteHandler;
import com.share.ftp.handler.join.GroupUserUpdateHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinGroupHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinListTestHandler;
import com.share.ftp.handler.join.JoinOrgHandler;
import com.share.ftp.handler.join.JoinPersonalHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.OrgFormUpdateHandler;
import com.share.ftp.handler.join.OrgHandler;
import com.share.ftp.handler.join.OrgListHandler;
import com.share.ftp.handler.join.OrgUserDeleteHandler;
import com.share.ftp.handler.join.OrgUserUpdateHandler;
import com.share.ftp.handler.join.PersonalHandler;
import com.share.ftp.handler.join.PersonalUserDeleteHandler;
import com.share.ftp.handler.join.PersonalUserUpdateHandler;
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
import com.share.ftp.handler.personal.community.VolunteerBoardAddHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardDeleteHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardDetailHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardListHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardSearchHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardUpdateHandler;
import com.share.ftp.handler.personal.community.VolunteerShortReviewListHandler;
import com.share.ftp.handler.personal.donation.DonationAdminPrompt;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardConnectHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDeleteHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDetailRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRegisterListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardSearchHandler;
import com.share.ftp.handler.personal.donation.DonationBoardUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeDetailHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeListHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeWishHandler;
import com.share.ftp.handler.personal.mypage.MyPointListHandler;
import com.share.ftp.handler.personal.mypage.MyRankingHandler;
import com.share.ftp.handler.personal.mypage.MyVolWishHandler;
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
import com.share.ftp.handler.personal.volunteer.MyVolunteerHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionAddHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionConnectHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionListHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerApproveHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerApproveListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerDetailHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerGroupJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerOtherJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerWishHandler;
import com.share.ftp.listener.AppInitListener;
import com.share.menu.Menu;
import com.share.menu.MenuFilter;
import com.share.menu.MenuGroup;
import com.share.request.RequestAgent;
import com.share.util.Prompt;

public class ClientApp {

  Connection con;

  SqlSession sqlSession;

  RequestAgent requestAgent;

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

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }

  private void notifyOnApplicationEnded() {

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
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

  public ClientApp() throws Exception {

    requestAgent = null;

    // DBMS??? ??????
    //    con = DriverManager.getConnection(
    //        "jdbc:mysql://localhost:3306/happysharedb?user=happyshare&password=1111");

    sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/share/ftp/conf/mybatis-config.xml")).openSession();

    // ?????????
    JoinDao joinDao = sqlSession.getMapper(JoinDao.class);
    PersonalDao personalDao = sqlSession.getMapper(PersonalDao.class);
    GroupDao groupDao = sqlSession.getMapper(GroupDao.class);
    OrgDao orgDao = sqlSession.getMapper(OrgDao.class);

    // ?????? ?????????
    GeneralDao generalDao = sqlSession.getMapper(GeneralDao.class);




    VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);

    // ????????? ??????
    ChallengeDao challengeDao = sqlSession.getMapper(ChallengeDao.class);
    ChallengeQuestionDao challengeQuestionDao = sqlSession.getMapper(ChallengeQuestionDao.class);
    ChallengeReviewDao challengeReviewDao = sqlSession.getMapper(ChallengeReviewDao.class);
    QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
    NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);

    // ???????????? ?????????
    VolunteerBoardDao volunteerBoardDao = sqlSession.getMapper(VolunteerBoardDao.class);
    //    VolunteerBoardCommentDao volunteerBoardCommentDao = sqlSession.getMapper(VolunteerBoardCommentDao.class);
    VolunteerShortReviewDao volunteerShortReviewDao = sqlSession.getMapper(VolunteerShortReviewDao.class);    

    //?????????, ????????????

    commands.put("/auth/login", new AuthLoginHandler(personalDao, groupDao, orgDao, joinDao)); // ?????????
    commands.put("/auth/logout", new AuthLogoutHandler()); // ????????????
    commands.put("/auth/displayUserInfo", new AuthDisplayUserHandler()); // ??????????????? ??????????????????
    commands.put("/userInfo/personal", new PersonalHandler()); 
    commands.put("/userInfo/group", new GroupHandler()); 
    commands.put("/userInfo/org", new OrgHandler()); 

    //????????????
    commands.put("/join/add", new JoinAddHandler()); // ????????????
    commands.put("/join/personal", new JoinPersonalHandler(personalDao,sqlSession)); // ????????????
    commands.put("/join/group", new JoinGroupHandler(groupDao,sqlSession)); // ????????????
    commands.put("/join/org", new JoinOrgHandler(orgDao,sqlSession)); // ????????????
    commands.put("/join/list", new JoinListHandler(personalDao,groupDao,orgDao)); // ????????????
    commands.put("/join/groupForm", new GroupFormUpdateHandler(groupDao,sqlSession)); // ????????????
    commands.put("/join/orgForm", new OrgFormUpdateHandler(orgDao,sqlSession)); // ????????????
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(personalDao)); // ???????????? ????????? ??????
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(personalDao)); // ???????????? ????????? ??????kvp
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(personalDao)); // ???????????? ??????

    // ??????
    commands.put("/volRequest/apply", new VolunteerRequestApplyHandler(volunteerDao,generalDao,sqlSession));
    commands.put("/vol/list", new VolunteerListHandler(volunteerDao));  
    commands.put("/vol/detail", new VolunteerDetailHandler(volunteerDao));

    commands.put("/vol/approvelist", new VolunteerApproveListHandler(volunteerDao));
    commands.put("/vol/approve", new VolunteerApproveHandler(volunteerDao));  
    commands.put("/vol/reject", new VolunteerRejectHandler(volunteerDao)); 

    commands.put("/volJoin/add", new VolunteerJoinHandler(volunteerDao));
    commands.put("/volJoin/groupAdd", new VolunteerGroupJoinHandler(volunteerDao));
    commands.put("/volJoin/list", new VolunteerJoinListHandler(volunteerDao));
    commands.put("/volJoin/delete", new VolunteerJoinDeleteHandler(volunteerDao));
    commands.put("/volJoin/otherDelete", new VolunteerOtherJoinDeleteHandler(volunteerDao));

    commands.put("/volGeneralRequest/delete", new VolGeneralRequestDeleteHandler(volunteerDao));
    commands.put("/vol/wish", new VolunteerWishHandler(volunteerDao,sqlSession));
    commands.put("/vol/wishList", new MyVolWishHandler(volunteerDao));
    //    commands.put("/volGeneralRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volPersonalRequestAppliedListHandler,volOrgRequestAppliedListHandler));

    //???????????? ????????????
    commands.put("/volQuestion/add", new VolQuestionAddHandler(volunteerDao));
    commands.put("/volQuestion/list", new VolQuestionListHandler(volunteerDao));
    commands.put("/volQuestion/update", new VolQuestionUpdateHandler(volunteerDao));
    commands.put("/volQuestion/delete", new VolQuestionDeleteHandler(volunteerDao));
    commands.put("/volQuestion/connect", new VolQuestionConnectHandler(volunteerDao));


    // ???????????? ???????????????
    commands.put("/volunteerBoard/add", new VolunteerBoardAddHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/list", new VolunteerBoardListHandler(volunteerBoardDao));
    commands.put("/volunteerBoard/detail", new VolunteerBoardDetailHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/update", new VolunteerBoardUpdateHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/delete", new VolunteerBoardDeleteHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/search", new VolunteerBoardSearchHandler(volunteerBoardDao));
    //    commands.put("/volunteerBoard/like", new CommBoardLikeHandler(volboardDao, sqlSession)); 

    // ???????????? ??????
    //    commands.put("/volunteerBoardComment/connect", new CommBoardReplyConnectHandler(volunteerBoardCommentDao));
    //    commands.put("/volunteerBoardComment/add", new CommBoardReplyAddHandler(volunteerBoardCommentDao, sqlSession));
    //    commands.put("/volunteerBoardComment/list", new CommBoardReplyListHandler(volunteerBoardCommentDao));
    //    commands.put("/volunteerBoardComment/update", new CommBoardReplyUpdateHandler(volunteerBoardCommentDao, sqlSession));
    //    commands.put("/volunteerBoardComment/delete", new CommBoardReplyDeleteHandler(volunteerBoardCommentDao, sqlSession));

    // ???????????? ????????????
    //    commands.put("/volunteerShortReview/add", new VolunteerShortReviewAddHandler(volunteerShortReviewDao, sqlSession));
    commands.put("/volunteerShortReview/list", new VolunteerShortReviewListHandler(volunteerShortReviewDao));
    //    commands.put("/volunteerShortReview/update", new VolunteerShortReviewUpdateHandler(volunteerShortReviewDao, sqlSession));
    //    commands.put("/volunteerShortReview/delete", new VolunteerShortReviewDeleteHandler(volunteerShortReviewDao, sqlSession));
    //    commands.put("/volunteerShortReview/search", new VolunteerShortReviewSearchHandler(volunteerShortReviewDao));



    //    // ???????????? ??????????????? BEST
    //    commands.put("/commBest/list", new CommBestListHandler(communityDao));
    //    commands.put("/commBest/detail", new CommBestDetailHandler(communityDao));

    // ?????????
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDao));  // ????????? ??????
    commands.put("/challenge/detail", new ChallengeDetailHandler(challengeDao)); // ????????? ????????????
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(challengeDao, sqlSession));  // ????????????
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(challengeDao));  // ???????????????
    //    commands.put("/challengeDetail/like", new ChallengeLikeHandler(challengeDTOList));  // ????????? ????????? ??????(????????????)
    commands.put("/challengeDetail/wish", new ChallengeWishHandler(challengeDao, sqlSession));  // ?????? ????????? ??????(?????????)

    // ????????? ????????????&??????
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(challengeDao, challengeReviewDao, sqlSession));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(challengeDao, challengeReviewDao));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDao, sqlSession));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeDao, challengeReviewDao, sqlSession));
    //    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(netChallengeReviewDao, netChallengeDao));
    commands.put("/challengeReview/connect", new ChallengeReviewConnectHandler(challengeReviewDao));

    // ????????? ????????????
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(challengeDao ,challengeQuestionDao, sqlSession));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(challengeDao, challengeQuestionDao));
    //    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(challengeQuestionDao, sqlSession));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(challengeDao, challengeQuestionDao, sqlSession));
    //    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(netChallengeDao, netChallengeQuestionDao));
    commands.put("/challengeQuestion/connect", new ChallengeQuestionConnectHandler(challengeQuestionDao));


    // ????????? ??????
    commands.put("/ranking/list", new ChallengeRankingHandler(personalDao));  
    commands.put("/myRanking/list", new MyRankingHandler(personalDao)); 

    // ????????? (??????????????????, ????????????, ??????, ??????)

    DonationBoardDao donationBoardDao = sqlSession.getMapper(DonationBoardDao.class);

    DonationPrompt donationPrompt = new DonationPrompt(donationBoardDao);
    DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDao);

    DonationRegisterDao donationRegisterDao = sqlSession.getMapper(DonationRegisterDao.class);

    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardDao));
    commands.put("/donationBoard/connect", new DonationBoardConnectHandler(donationBoardDao));
    commands.put("/donationBoard/update", new DonationBoardUpdateHandler(donationBoardDao, sqlSession));
    commands.put("/donationBoard/delete", new DonationBoardDeleteHandler(donationBoardDao, sqlSession));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDao, generalDao, sqlSession));
    commands.put("/donationBoard/search", new DonationBoardSearchHandler(donationBoardDao));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDao));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDao));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDao, sqlSession));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDao, sqlSession));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDao));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDao, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDao, donationAdminPrompt));

    // ????????? (????????????)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDao, donationBoardDao));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDao));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDao));

    commands.put("/donationBoardRegister/list", new DonationBoardRegisterListHandler(donationRegisterDao));
    commands.put("/donationBoardDetailRegister/add", new DonationBoardDetailRegisterAddHandler(donationBoardDao, donationRegisterDao, orgDao));

    // ???????????? ????????????
    commands.put("/question/add", new QuestionAddHandler(questionDao,generalDao,sqlSession));
    commands.put("/question/list", new QuestionListHandler(questionDao));
    commands.put("/question/detail", new QuestionDetailHandler(questionDao));
    commands.put("/question/update", new QuestionUpdateHandler(questionDao, sqlSession));
    commands.put("/question/delete", new QuestionDeleteHandler(questionDao));
    commands.put("/question/search", new QuestionSearchHandler(questionDao));

    commands.put("/adminQuestion/connect", new AdminQuestionConnectHandler());
    //    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));

    // ???????????????

    // ???????????? ?????? ??? ??????
    commands.put("/myPage/personal", new PersonalUserUpdateHandler(personalDao)); // ???????????? ????????? ??????
    commands.put("/myPage/delete", new PersonalUserDeleteHandler(personalDao)); // ??????????????????
    commands.put("/myPage/group", new GroupUserUpdateHandler(groupDao)); // ???????????? ????????? ??????
    commands.put("/myPage/delete", new GroupUserDeleteHandler(groupDao)); // ??????????????????
    commands.put("/myPage/org", new OrgUserUpdateHandler(orgDao)); // ???????????? ????????? ??????
    commands.put("/myPage/delete", new OrgUserDeleteHandler(orgDao)); // ??????????????????

    commands.put("/myVol/list", new MyVolunteerHandler(volunteerDao));
    commands.put("/myVol/applied", new MyAppliedVolHandler(volunteerDao));
    commands.put("/myVol/appliedDetail", new MyAppliedVolDetailHandler(volunteerDao));
    commands.put("/myVol/rejected", new MyRejectedVolHandler(volunteerDao));

    commands.put("/myChallenge/list", new MyChallengeListHandler(challengeDao));
    commands.put("/myChallenge/detail", new MyChallengeDetailHandler(challengeDao));
    commands.put("/myChallenge/wish", new MyChallengeWishHandler(challengeDao));

    commands.put("myPoint/list", new MyPointListHandler(personalDao)); // ??????????????? 

    //    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // ?????? ??????????????? ???????????? 
    //    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // ?????? ??????????????? ????????????
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDao)); // ?????????
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDao));

    // ?????????

    // ????????? ???????????? ??????
    //    commands.put("/join/list", new JoinListHandler(personalDao)); // ???????????? ?????? ????????? ??????
    commands.put("/join/test", new JoinListTestHandler(personalDao)); // ???????????? ???????????? ????????? ??????
    commands.put("/join/groupList", new GroupListHandler(groupDao, sqlSession)); // ???????????? ???????????? ????????? ??????
    commands.put("/join/orgList", new OrgListHandler(orgDao, sqlSession)); // ???????????? ???????????? ????????? ??????
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // ????????? ???????????? (?????? + ?????????)
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDao,generalDao,sqlSession));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDao));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDao));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDao));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDao,sqlSession));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDao));

    // ????????? ????????????

    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(questionDao));
    //        commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(myQuestionListDTOList));

    // ????????? ?????????
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDao));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDao));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/QuestionList", new AdminChallengeQuestionListHandler(challengeDao, challengeQuestionDao));
    commands.put("/adminChallenge/replyAdd", new AdminChallengeReplyAddHandler(challengeDao, challengeQuestionDao, sqlSession)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyUpdate", new AdminChallengeReplyUpdateHandler(challengeDao, challengeQuestionDao)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyDelete", new AdminChallengeReplyDeleteHandler(challengeDao, challengeQuestionDao)); // ????????? ?????? ??????
    commands.put("/adminChallenge/replyConnect", new AdminChallengeReplyConnectlHandler(challengeDao, challengeQuestionDao)); // ????????? ?????? ??????, ??????, ?????? ??????

    // ????????? ????????????

    //        challengeReviewMap.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    //    challengeReviewMap.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
  }


  void service() throws Exception {

    notifyOnApplicationStarted();

    createMenu().execute();
    Prompt.close();

    notifyOnApplicationEnded();

    con.close();

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
    mainMenuGroup.add(new MenuItem("???????????? ??????", ACCESS_LOGOUT, "/join/groupForm"));
    mainMenuGroup.add(new MenuItem("???????????? ??????", ACCESS_LOGOUT, "/join/orgForm"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_MEMBER_ADMIN, "/auth/logout"));



    // ????????????
    MenuGroup doVolMenu = new MenuGroup("????????????");
    mainMenuGroup.add(doVolMenu);
    doVolMenu.setMenuFilter(menuFilter);

    doVolMenu.add(new MenuItem("?????? ????????? ??????", "/volRequest/apply"));
    doVolMenu.add(new MenuItem("?????? ??????", "/vol/list"));

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

    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/volunteerBoard/add"));
    reviewMenu.add(new MenuItem("??????","/volunteerBoard/list"));
    reviewMenu.add(new MenuItem("????????????","/volunteerBoard/detail"));
    //    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN,"/volunteerBoard/update"));
    //    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/volunteerBoard/delete"));
    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/volunteerBoard/search"));

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

    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/add"));
    shortReviewMenu.add(new MenuItem("??????", "/volunteerShortReview/list")); 
    //    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/update")); 
    //    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/delete")); 
    shortReviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/volunteerShortReview/search"));


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
    donationMenu.add(new MenuItem("????????? ??????", "/donationBoard/search"));
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
    myProfile.add(new MenuItem("??? ?????? ??????", ACCESS_PERSONAL, "/myPage/personal"));
    myProfile.add(new MenuItem("??? ?????? ??????", ACCESS_GROUP, "/myPage/group"));
    myProfile.add(new MenuItem("??? ?????? ??????", ACCESS_ORG, "/myPage/org"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("?????? ??????");
    myVolunteer.setMenuFilter(menuFilter);

    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_GROUP,"/myVol/list")); 
    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_ORG,"/myVol/list")); 
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_GROUP,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_GROUP,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_GROUP,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_ORG,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("??????????????? ????????????",ACCESS_PERSONAL,"/volJoin/delete"));    
    myVolunteer.add(new MenuItem("??????????????? ????????????",ACCESS_GROUP,"/volJoin/otherDelete"));    
    myVolunteer.add(new MenuItem("??????????????? ????????????",ACCESS_ORG,"/volJoin/otherDelete"));    
    myVolunteer.add(new MenuItem("????????????",ACCESS_MEMBER,"/vol/wishList")); 

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
    myDonation.add(new MenuItem("?????? ????????????", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("?????? ????????? ??????????????? ??????", ACCESS_ORG, "/myDonation//applyCompleteList")); 
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

    //    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN, "/join/list"));
    adminMemberMenu.add(new MenuItem("???????????? ??????", ACCESS_ADMIN,"/join/list"));
    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN, "/join/groupList"));
    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN, "/join/orgList"));
    adminMemberMenu.add(new MenuItem("????????????",ACCESS_ADMIN,"/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);
    adminVolMenu.setMenuFilter(menuFilter);

    adminVolMenu.add(new MenuItem("??????????????? ??????",ACCESS_ADMIN,"/vol/approveList"));

    return adminVolMenu;
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

    adminCommInfo.add(new MenuItem("??????????????? ??????", ACCESS_MEMBER_ADMIN, "/volunteerBoard/list"));
    adminCommInfo.add(new MenuItem("??????????????? ????????????", ACCESS_MEMBER_ADMIN, "/volunteerBoard/detail")); 
    adminCommInfo.add(new MenuItem("???????????? ??????",ACCESS_MEMBER_ADMIN,"/volunteerShortReview/list"));


    return adminCommInfo;
  }


  public static void main(String[] args) throws Exception {

    ClientApp app = new ClientApp(); 
    app.addApplicationContextListener(new AppInitListener());
    //    app.addApplicationContextListener(new FileListener());
    app.service();

    Prompt.close();
  }


}

