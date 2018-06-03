package com.huttchang.example.controllers;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.BookMark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllersTest {

    @Autowired
    private BookController bookController;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBookList() throws Exception {
        ResponseEntity<Model> response = bookController.getBookList("title", "사랑", "50", "1", new ConcurrentModel(), "eyJzZWMiOiJ1cml0eSIsImFsZyI6IkhTMjU2In0.eyJqd3QiOnsiaWQiOjE1LCJlbWFpbCI6Imh1dHRjaGFuZ0BnbWFpbC5jb20iLCJuYW1lIjoi7Iug7Zy07LC9IiwicGFzc3dvcmQiOiIiLCJzdGF0dXMiOjIsImNyZWF0ZURhdGUiOm51bGwsInRva2VuIjpudWxsfX0.P2DqMGCzkpmtTVysZP0e7hRoVuaTlM1Ui9Ur4k97Bs4");
        List<Book> searchData = (List<Book>) response.getBody().asMap().get("data");
        assertNotNull(searchData);
        System.out.println(String.format("%s : Test Result = %s", "[testBookList]", searchData.toString()));

    }

    @Test
    public void testBookDetail() throws Exception {
        List<Book> books = bookController.getBookDetail("8960773425");
        assertNotNull(books);
        System.out.println(String.format("%s : Test Result = %s", "[testBookDetail]", books.toString()));
    }

    @Test
    public void testBookmarkList() throws Exception {
        List<BookMark> data = bookController.getBookMarks("eyJzZWMiOiJ1cml0eSIsImFsZyI6IkhTMjU2In0.eyJqd3QiOnsiaWQiOjE1LCJlbWFpbCI6Imh1dHRjaGFuZ0BnbWFpbC5jb20iLCJuYW1lIjoi7Iug7Zy07LC9IiwicGFzc3dvcmQiOiIiLCJzdGF0dXMiOjIsImNyZWF0ZURhdGUiOm51bGwsInRva2VuIjpudWxsfX0.P2DqMGCzkpmtTVysZP0e7hRoVuaTlM1Ui9Ur4k97Bs4");
        assertNotNull(data);
        System.out.println(String.format("%s : Test Result = %s", "[testBookmarkList]", data.toString()));
    }

    @Test
    public void testBookmark() throws Exception {
        try{
            BookMark mark = new BookMark();
            mark.setUserId(15);
            mark.setBookIsbn("8960773425");
            bookController.addBookMarks(mark, "eyJzZWMiOiJ1cml0eSIsImFsZyI6IkhTMjU2In0.eyJqd3QiOnsiaWQiOjE1LCJlbWFpbCI6Imh1dHRjaGFuZ0BnbWFpbC5jb20iLCJuYW1lIjoi7Iug7Zy07LC9IiwicGFzc3dvcmQiOiIiLCJzdGF0dXMiOjIsImNyZWF0ZURhdGUiOm51bGwsInRva2VuIjpudWxsfX0.P2DqMGCzkpmtTVysZP0e7hRoVuaTlM1Ui9Ur4k97Bs4");
            System.out.println(String.format("%s : Test Result = %s", "[testBookmark]", "SUCCESS"));
        }catch (Exception e){
            System.out.println(String.format("%s : Test Result = %s", "[testBookmark]", "FAILED"));
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBookmark() throws Exception {
        try{
            bookController.delBookMarks(1);
            System.out.println(String.format("%s : Test Result = %s", "[testDeleteBookmark]", "SUCCESS"));
        }catch (Exception e){
            System.out.println(String.format("%s : Test Result = %s", "[testDeleteBookmark]", "Fail"));
            e.printStackTrace();
        }
    }

    @Test
    public void testHistoryList() throws Exception {
        List<Book> data = bookController.getHistoryList("eyJzZWMiOiJ1cml0eSIsImFsZyI6IkhTMjU2In0.eyJqd3QiOnsiaWQiOjE1LCJlbWFpbCI6Imh1dHRjaGFuZ0BnbWFpbC5jb20iLCJuYW1lIjoi7Iug7Zy07LC9IiwicGFzc3dvcmQiOiIiLCJzdGF0dXMiOjIsImNyZWF0ZURhdGUiOm51bGwsInRva2VuIjpudWxsfX0.P2DqMGCzkpmtTVysZP0e7hRoVuaTlM1Ui9Ur4k97Bs4");
        assertNotNull(data);
        System.out.println(String.format("%s : Test Result = %s", "[testHistoryList]", data.toString()));
    }

}