package com.cary.cwish.dao;

import java.util.List;

import com.cary.cwish.pojo.Article;

public interface ArticleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    Article selectByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Article record);
    
    /**
     * get article count from database
     */
    int selectArticleCount();
    
    /**
     * get 10 record from one selection
     */
    List<Article> selectByPrimaryKeyInLimit(Integer startNum);
    
    /**
     * insert into user_article one record
     */
    int insertArticleRecord(Article record);
}