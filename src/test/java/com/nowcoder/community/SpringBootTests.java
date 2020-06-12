package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SpringBootTests {

    @Autowired
    private DiscussPostService discussPostService;

    private DiscussPost post;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");

        // 初始化测试数据
        post = new DiscussPost();
        post.setUserID(111);
        post.setTitle("TestTitle");
        post.setContent("TestContent");
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);
    }

    @After
    public void after() {
        System.out.println("after");

        // 删除测试数据
        discussPostService.updateStatus(post.getId(), 2);
    }

//    @Test
//    public void test1() {
//        System.out.println("test1");
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("test2");
//    }

    @Test
    public void testFindById() {
        DiscussPost discussPost = discussPostService.findDiscussPostById(post.getId());
        Assert.assertNotNull(discussPost);
        Assert.assertEquals(post.getTitle(), discussPost.getTitle());
        Assert.assertEquals(post.getContent(), discussPost.getContent());
    }

    @Test
    public void testUpdateScore() {
        int rows = discussPostService.updateScore(post.getId(), 2000.00);
        Assert.assertEquals(1, rows);

        DiscussPost discussPost = discussPostService.findDiscussPostById(post.getId());
        Assert.assertEquals(2000.00, discussPost.getScore(), 2);
    }

}
