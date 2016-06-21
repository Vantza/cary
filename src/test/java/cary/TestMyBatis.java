package cary;

import java.util.List;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;
import com.cary.cwish.pojo.Article;
import com.cary.cwish.pojo.User;
import com.cary.cwish.service.ArticleService;
import com.cary.cwish.service.UserService;  
  
@RunWith(SpringJUnit4ClassRunner.class)    //表示继承了SpringJUnit4ClassRunner类 
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
    @Resource  
    private UserService userService = null;
    @Resource
    private ArticleService articleService = null;
    
    
    @Test  
    public void testGetUserById() throws Exception {
    	logger.info("get in testGetUserById");
        User user = userService.getUserById(1);  
        // System.out.println(user.getUserName());  
        // logger.info("用户名"+user.getUserName());  
        logger.info(JSON.toJSONString(user));  
    }
    
    @Test
    public void testGetArticleById() throws Exception {

    	logger.info("get in testGetArticleById");
    	Article art = articleService.getArticleById(1);
//    	Article art = dao.selectByPrimaryKey(1);
    	logger.info(JSON.toJSONString(art));
    }
    
    @Test
    public void testGetArticleCount() throws Exception {
    	logger.info("get in testGetArticleCount");
    	int count = articleService.getArticleCount();
    	logger.info(JSON.toJSONString(count));
    }
    
    @Test
    public void testGetArticles() throws Exception {
    	logger.info("get in testGetArticles");
    	List<Article> arts = articleService.getArticles(0);
    	for(Article a : arts) {
    		logger.info(JSON.toJSONString(a));
    	}
    }
    
    @Test
    public void testInsertArticle() throws Exception {
    	logger.info("get in testInsertArticle");
    	Article article = new Article();
    	article.setTitle("This is an amazing story!!");
    	article.setText("What a pity! I do not know what the story tells..");
    	article.setUserName("Wulala");
    	int recordCount = articleService.insertArticle(article);
    	logger.info(recordCount);
    }
    
    @Test
    public void testGetArticlesByUserName() throws Exception {
    	logger.info("get in testGetArticlesByUserName");
    	List<Article> arts = articleService.getArticlesByUserName("cary@qq.com");
    	for(Article a : arts) {
    		logger.info(JSON.toJSONString(a));
    	}
    }
}  