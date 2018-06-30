package am.mydrugbox.mery.beauty_guide;

public class Name {
    private String name;
    private  int image;

    public Name(String name, int image) {
        this.name = name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
