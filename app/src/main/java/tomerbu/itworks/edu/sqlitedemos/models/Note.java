package tomerbu.itworks.edu.sqlitedemos.models;

public class Note {
    /*private Fields*/
    private int id;
    private String title;
    private String content;


    /*Constructors*/
    public Note() {

    }

    public Note(int id, String title, String content) {

        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    /*Getters And Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
