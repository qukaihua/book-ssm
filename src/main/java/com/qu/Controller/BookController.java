package com.qu.Controller;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.security.token.SSOToken;
import com.google.code.kaptcha.Producer;
import com.qu.Service.BookService;
import com.qu.bean.Book;
import com.qu.bean.BookSearch;
import com.qu.bean.Result;
import com.qu.bean.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by 96283 on 2018/11/8.
 */
@Controller
@RequestMapping("/book")
@ResponseBody
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    Producer captchaProducer;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @RequestMapping(value ="/insert",method = RequestMethod.POST)
    public Result insert (Book book){
          bookService.insertBook(book);
          return Result.success();
    }

    @RequestMapping(value ="/delete",method = RequestMethod.POST)
     public Result delete(int id){
        bookService.deleteBook(id);
        return Result.success();
    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Result update(Book book){
        bookService.updateBook(book);
        return Result.success();
    }

    @RequestMapping(value ="/search",method = RequestMethod.POST)
    public Result search(BookSearch bookSearch,String page,String rows,String sort,String seq){
        int page1= Integer.parseInt(page);
        int rows2 = Integer.parseInt(rows);
       List<Book> books = bookService.getBooks(bookSearch,page1,rows2,sort,seq);
        return Result.success(books);
    }

    @RequestMapping(value = "/getCaptchaCode",method =RequestMethod.GET)
    public void getCaptchaCode(HttpServletRequest request, HttpServletResponse response){
                 response.setDateHeader("Expires", 0);
                 response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                 response.addHeader("Cache-Control", "post-check=0, pre-check=0");
                 response.setHeader("Pragma", "no-cache");
                 response.setContentType("image/gif");
        String text = captchaProducer.createText();
        request.getSession().setAttribute("captext",text);
        BufferedImage bi = captchaProducer.createImage(text);
        ServletOutputStream out = null;
        try {
           out = response.getOutputStream();
            ImageIO.write(bi,"gif",out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(login login){
        if(!login.getUsername().trim().isEmpty()&&login.getUsername().equals("qq")&&!login.getPassword().trim().isEmpty()&&login.getPassword().equals("ququ")){
            SSOHelper.setCookie(request,response, SSOToken.create().setIp(request).setId(1000).setIssuer(login.getUsername()),false);
            return Result.success();
        }
        return null;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Result logout(){
            SSOHelper.clearLogin(request,response);
            return Result.success();
        }

    }





