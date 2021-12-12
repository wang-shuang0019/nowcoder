package com.nowcoder.community.entity;

public class Page {
    private int current = 1;
    private int limit = 10;
    private String path;
    private int rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 1 && limit < 100) {
            this.limit = limit;
        }
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows > 0){
            this.rows = rows;
        }
    }
    /*
     * 得到当前页的起始行数
     * */
    public int getOffset(){
        return current*limit - limit;
    }

    /*
    * 获取总页数
    * */
    public int getTotal(){
        return rows % limit == 0 ? rows/limit:rows/limit+1;
    }
    /*
    * 获取起始页码
    * */
    public int getFrom(){
        return current - 1 > 0 ? current-1 : 1;
    }
    /*
    * 获取后页码
    * */
    public int getTo(){
        return current + 1 > getTotal() ? getTotal():current+1;
    }
}

