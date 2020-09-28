package monkeypickbanana;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 23:19
 */
public class Monkey implements Obj {
    private String location;

    public Monkey() {
    }

    @Override
    public String getName() {
        return "monkey";
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
