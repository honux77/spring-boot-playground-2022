package net.honux.springbootdemo;

public class ReadLog {

    private Long book;
    private int count = 0;

    public ReadLog(Long book) {
        this.book = book;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getBook() {
        return book;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ReadLog{" +
                "BookId=" + book +
                ", count=" + count +
                '}';
    }
}
