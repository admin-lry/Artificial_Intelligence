package monkeypickbanana;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 23:20
 */
public class Banana implements Obj {
    private String location;

    public Banana() {
    }

    public String getName() {
        return "banana";
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }
}