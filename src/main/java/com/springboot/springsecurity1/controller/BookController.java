package com.springboot.springsecurity1.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.bean.BookOwnerVO;
import com.springboot.springsecurity1.bean.Owner;
import com.springboot.springsecurity1.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Api("书本控制层")
@RequestMapping("book")
@RestController
public class BookController {

    @Autowired(required = true)
    private BookService bookService;

    /**
     * 测试导出
     *
     */
    @ApiOperation(value = "导出excel文件")
    @GetMapping("poi")
    public List<BookOwnerVO> testpoi(HttpServletResponse response) throws FileNotFoundException {
        List<BookOwnerVO> list =  bookService.selectAll();
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("我是sheet名字");
        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, BookOwnerVO.class, list);
        File savefile = new File("E:/temp/easypoi");
        if (!savefile.exists()) {
            boolean result = savefile.mkdirs();
            System.out.println("目录不存在，创建" + result);
        }
        FileOutputStream fos = new FileOutputStream("E:/temp/easypoi/学生.xls");
        try {
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据书编号查询书的信息
     * @return
     */
    @ApiOperation(value ="传入bookId查询对应Book")
    @GetMapping("/get")
    public Book Search(int bookId){
        Book book = bookService.getBookById(bookId);
        System.out.println(book);
        return book;
    }

    @ApiOperation(value ="传入书名进行模糊查询")
    @GetMapping("/gets")
    public List<Book> likeSearch(Book book){
        List<Book> list= bookService.getBooksByName(book);
        System.out.println(list.size());
        for(Book b : list){
            System.out.println(b);
        }
        return list;
    }

    @ApiOperation(value ="传入书名和介绍进行模糊查询")
    @GetMapping("getsf")
    public List<Book> getBookByFuzzy(Book book){
        List<Book> list = bookService.getBookByFuzzy(book);
        for(Book b : list){
            System.out.println(b);
        }
        return list;
    }

    @ApiOperation(value ="联表查询，返回BookOwnerVO")
    @GetMapping("getall")
    public List<BookOwnerVO> getAll(){
        return bookService.selectAll();
    }

    @ApiOperation(value ="通过书名查书")
    @GetMapping("getbookbyname")
    public List<Book> getBookByBookName(String bookName){
        return bookService.getBookByBookName(bookName);
    }

    @ApiOperation(value ="添加一本书")
    @PostMapping ("add")
    public int getBookByBookName(Book book){
        return bookService.addBook(book);
    }

    @ApiOperation(value ="删除一本书")
    @PostMapping("delete")
    public int getBookByBookName(int bookid){
        return bookService.deleteBook(bookid);
    }

    @ApiOperation(value ="修改一本书的信息")
    @PostMapping("update")
    public int update(Book book){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id",book.getBookId());
        return bookService.updateBook(book,queryWrapper);
    }

    @ApiOperation("导入到数据库")
    @PostMapping("/imp")
    public int upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        ImportParams params = new ImportParams();
        //params.setHeadRows(2);
        // params.setTitleRows(0);
        System.out.println(multipartFile.getOriginalFilename());
        //扫描xls文件
        List<Book> result = ExcelImportUtil.importExcel(multipartFile.getInputStream(),
                Book.class, params);
       for(Book book :result){
           System.out.println(book);
       }
       //导入数据库
        return bookService.insertbBookBatch(result);
        //return 0;
    }

    @ApiOperation("批量添加Book")
    @RequestMapping("batch")
    public int batchTest(){
        List<Book> list = new ArrayList<>();
        Book b1 = new Book("2020.8.10java测试1","测试",1,1,"张三","诗人");
        Book b2 = new Book("2020.8.10java测试2","测试",1,1,"张三","诗人");
        Book b3 = new Book("2020.8.10java测试3","测试",1,1,"张三","诗人");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        return bookService.insertbBookBatch(list);
    }
    @PostMapping("/com")
    @ResponseBody
    public Boolean updateAll(@RequestBody JSONObject param){
        JSONObject task_json = param.getJSONObject("owner");
        Owner task = (Owner)JSONObject.toJavaObject(task_json,Owner.class);
        System.out.println(task);
        return true;
    }


}
