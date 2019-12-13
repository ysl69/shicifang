package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ysl
 * @Date 2019/12/13 23:17
 * @Description:  不喜欢列表数据访问层
 **/
public interface NoFriendDao extends JpaRepository<NoFriend,String> {
}
