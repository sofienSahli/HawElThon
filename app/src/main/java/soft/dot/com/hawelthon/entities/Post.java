package soft.dot.com.hawelthon.entities;

public class Post {

    private int id;
    private String image;
    private String description;

    public Post(int id, String image, String description) {
        this.id = id;
        this.image = image;
        this.description = description;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
