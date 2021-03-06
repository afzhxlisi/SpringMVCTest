package com.cn.hnust.dao;

import com.cn.hnust.pojo.User;
import com.cn.hnust.pojo.UserTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int countByExample(UserTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int deleteByExample(UserTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    List<User> selectByExample(UserTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    User selectByPrimaryKey(Integer id);
    
    User selectByPrimaryKeyForUpdate(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int updateByExample(@Param("record") User record, @Param("example") UserTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_t
     *
     * @mbggenerated Fri Aug 12 00:08:03 CST 2016
     */
    int updateByPrimaryKey(User record);
}