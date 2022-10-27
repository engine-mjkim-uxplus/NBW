package com.finalpj.nbw.mypage.service;

import com.finalpj.nbw.member.dao.MemberDao;
import com.finalpj.nbw.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MypageService {

    @Autowired
    private MemberDao memberDao;


    public Member getMyInfo(String id) throws Exception{
        return memberDao.selectMember(id);
    }

    public int postMyInfo(Member member) throws Exception{
        log.info("SERVICE ====================> 회원정보 수정 : "+ member.getUsername());
        return memberDao.updateMyInfo(member);
    }
}
