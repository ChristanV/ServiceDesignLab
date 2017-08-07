package petstore.model;

/**
 * Created by bbdnet1594 on 2017/07/31.
 */
public class Pet {
    private String petId;
    private String name;
    private String imageurl;
    private boolean petStatus; //true: Ordered, false: available for adoption

    public Pet(String petId, String name, String imageurl) {
        this.petId = petId;
        this.name = name;
        this.imageurl = imageurl;
        this.petStatus = false;
    }

    public Pet() {

    }

    public Pet(String name, String image){
        this.name = name;
        this.imageurl = image;
        this.petStatus = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return imageurl;
    }

    public void setImage(String image) {
        this.imageurl = image;
    }

    public boolean getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(boolean petStatus) {
        this.petStatus = petStatus;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
}
