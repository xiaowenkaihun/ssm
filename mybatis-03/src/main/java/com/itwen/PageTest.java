package com.itwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itwen.mapper.EmpMapper;
import com.itwen.mapper.PageMapper;
import com.itwen.pojo.Emp;
import com.itwen.pojo.Page;
import com.itwen.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PageTest {
    /**
     * PageInfo{pageNum=1, pageSize=4, size=4, startRow=1, endRow=4, total=48, pages=12,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=48, pages=12, reasonable=false, pageSizeZero=false}
     * [Page{id=1, username='c'}, Page{id=2, username='c'}, Page{id=3, username='c'}, Page{id=4, username='c'}],
     * prePage=0, nextPage=2, isFirstPage=true,
     * isLastPage=false,
     * hasPreviousPage=false,
     * hasNextPage=true,
     * navigatePages=5,
     * navigateFirstPage=1,
     * navigateLastPage=5,
     * navigatepageNums=[1, 2, 3, 4, 5]}
     */
    @Test
    public void testPage(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PageMapper mapper = sqlSession.getMapper(PageMapper.class);
        com.github.pagehelper.Page<Object> page = PageHelper.startPage(1, 4);
        List<Page> pages = mapper.selectByExample(null);
        pages.forEach(System.out::println);
        System.out.println(page);
        // 查询之后可以获取分页相关的所有数据
        PageInfo<Page> pagePageInfo = new PageInfo<>(pages, 5);
        System.out.println(pagePageInfo);
    }
}
