package xin.kingsman.validatordemo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xin.kingsman.validatordemo.validationgroup.BookCreateGroup;
import xin.kingsman.validatordemo.validationgroup.BookUpdateGroup;
import xin.kingsman.validatordemo.vo.Book;


import javax.validation.groups.Default;
import java.math.BigDecimal;

/**
 * @author songhao
 */
@RestController
@RequestMapping("book")
public class BookController {
    public static final String OK = "ok";


    @GetMapping
    public Book getOne() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("道格李");
        book.setTitle("并发编程实战");
        book.setCategoryEnum(1);
        book.setPress("机械工业");
        book.setPrice(BigDecimal.TEN);
        book.setVersion("1.0");
        return book;
    }


    /**
     *
     *
     {
     "id": 1,
     "title": "并发编程实战",
     "author": "道格李",
     "press": "机械工业",
     "price": 10
     }
     * @param book
     * @return
     */
    @PostMapping
    public String create(@Validated(BookCreateGroup.class) @RequestBody Book book) {
        System.out.println(book);
        return OK;
    }


    /**
     *
     *
     {
     "id": 1,
     "title": "并发编程实战",
     "author": "道格李",
     "press": "机械工业",
     "price": 10,
     "version": "1.0",
     "categoryEnum": 1,
     "bookDirectoryList":[{
     "name":"悯农",
     "pageNum":"18"
     }]
     }
     * @param book
     * @return
     */
    @PutMapping
    public String update(@Validated({BookCreateGroup.class, BookUpdateGroup.class, Default.class}) @RequestBody Book book) {
        System.out.println(book);
        return OK;
    }




}
