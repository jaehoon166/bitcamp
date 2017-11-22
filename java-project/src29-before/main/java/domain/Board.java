package domain;
import java.sql.Date;

public class Board {
    protected int num;
    protected String title;
    protected String contents;
    protected Date regdate;
    protected int viewCount;

    public Board() {

    }

    public Board(int num, String title, String contents) {
        this.num = num;
        this.title = title;
        this.contents = contents;
    }
    

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

}
