package com.ruin.renting.dao;

import com.ruin.renting.domain.Msg;
import com.ruin.renting.utils.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruin
 * @date 2019/12/12-13:04
 */
public interface MsgRepository extends JpaRepository<Msg,Integer> {

    @Query(value = "SELECT DISTINCT RECEIVER_ID C FROM \n" +
            "(SELECT RECEIVER_ID FROM TB_MSG WHERE SENDER_ID=?1\n" +
            "\tUNION ALL\n" +
            "SELECT SENDER_ID FROM TB_MSG WHERE RECEIVER_ID=?1) SC",nativeQuery = true)
    public List<Integer> getContactsId(Integer userId);

    @Query(value = "SELECT * FROM tb_msg WHERE \n" +
            "(receiver_id=?1 AND sender_id=?2) OR(receiver_id=?2 AND sender_id=?1)",nativeQuery = true)
    public List<Msg> getChatInformation(Integer userId,Integer contactId);
}
