package monkeypickbanana;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 23:20
 */
public class Box implements Obj {
    private String location;

    public Box() {
    }

    public String getName() {
        return "box";
    }

    public Box(String location) {
        this.location = location;
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
