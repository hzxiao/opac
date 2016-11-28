package com.hzx.opac.persistence;

import com.hzx.opac.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hz on 16-11-28.
 */
public interface UserMapper {
    @Select("select *from t_user where user_id=#{userId}")
    User selectByPrimaryKey(int userId);
}
