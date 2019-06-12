package com.hpeu.cache.vo;

public class PageInfo {
    private long size = 10;
    private long count;
    private long total = 0;
    public long current;

    public PageInfo() {
    }

    public PageInfo(long size, long count, long total, long current) {
        this.size = size;
        this.count = count;
        this.total = total;
        this.current = current;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
