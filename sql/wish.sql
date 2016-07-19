DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24);


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

select * from user where user_name='cary@qq.com';

insert  into `user`(`id`,`user_name`,`password`,`age`) values (1,'Cary@qq.com','123456',24);

select
	*
    from user
    where user_name = 'cary@qq.com';

DROP TABLE IF EXISTS `user_article`;
    
CREATE TABLE `user_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` varchar(65530) NOT NULL,
  `date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


select * from user_article;

insert into `user_article`(`article_id`,`user_name`,`title`,`text`,`date`) values (1, 'Cary@qq.com', 'This is title', 'This is text', null);

update user_article set text = '绿蚁新醅酒，红泥小火炉。晚来天欲雪，能饮一杯无？<br/><br/>
外面是白色的，屋内是橘黄色。<br/>
缩着头下楼买两个烤红薯，左手换到右手，哈着白气跑上楼。<br/>
下厨整两热菜，配上一小碟茴香豆。<br/>
有故事有酒，有暖气有女朋友。<br/>
桌下的小狗摇着尾巴，翘着首。<br/>' where article_id = '1';


update user_article set title = '你所期待的冬天是什么样子的？' where article_id='1';

insert into `user_article` (`user_name`, `title`, `text`, `date`) values('cy2', '你所期待的冬天是什么样子的？', '绿蚁新醅酒，红泥小火炉。晚来天欲雪，能饮一杯无？<br/><br/>
外面是白色的，屋内是橘黄色。<br/>
缩着头下楼买两个烤红薯，左手换到右手，哈着白气跑上楼。<br/>
下厨整两热菜，配上一小碟茴香豆。<br/>
有故事有酒，有暖气有女朋友。<br/>
桌下的小狗摇着尾巴，翘着首。<br/>', null);

select count(*)
    from user_article
    where user_name = 'cary@qq.com';
    
    
select * from user_article
order by date desc
limit 0, 10;

select * from user_article
where user_name = 'cary@qq.com';

delete from user_article where article_id = 20;

insert into `user_article`(`user_name`,`title`,`text`,`date`) values ('Vantza', 'This is title', 'This is text', null);


CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `text` varchar(255) NOT NULL,
  `date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

select * from comments; 



