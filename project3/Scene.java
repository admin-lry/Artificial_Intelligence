public class Scene {
    private String monkey;
    private String banana;
    private String box;
    private boolean isPicked;
    private boolean isOnBox;

    public Scene() {
        this.monkey = "";
        this.banana = "";
        this.box = "";
        this.isPicked = false;
        isOnBox = false;
    }

    /*the following method are generated automatically*/
    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public boolean isOnBox() {
        return isOnBox;
    }

    public void setOnBox(boolean onBox) {
        isOnBox = onBox;
    }


    public String getMonkey() {
        return monkey;
    }

    public void setMonkey(String monkey) {
        this.monkey = monkey;
    }

    public String getBanana() {
        return banana;
    }

    public void setBanana(String banana) {
        this.banana = banana;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}

