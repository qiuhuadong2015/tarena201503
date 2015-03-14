package version01.vo;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 * 分页组件的父类，用来封装分页的通用内容和逻辑
 */
public class Page {
    //用户要输入的分页条件，在输入之前先设置默认值方便测试

    //    默认显示第一页
    private int currentPage=1;
    //    默认每页显示5行
    private int pageSize=5;

    //自动计算出的总行数
    private int rows;
    //根据总行数计算出总页数，然后将总页数输出给页面
    private int totalPage;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage(){
        if(rows%pageSize==0){
            totalPage=rows/pageSize;
        }else{
            totalPage=rows/pageSize+1;
        }
        return totalPage;
    }

    //  因为在mapper.xml中，不能在#{}中对currentPage和pageSize进行计算得出行号范围，
//  因此在本类中计算后再给出，mapper.xml直接通过get方法获得
    private int begin;
    private int end;

    public int getBegin() {
        begin=(currentPage-1)*pageSize;
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        end=currentPage*pageSize+1;
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
