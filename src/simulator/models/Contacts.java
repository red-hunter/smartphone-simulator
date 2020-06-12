package simulator.models;

public class Contacts extends CallDetails{
    private String profilePicture;

    // Methods to set and get the profile picture directory

    public Contacts(String name, String phone, String picture){
        super();
        setName(name);
        setPhoneNumber(phone);
        setProfilePicture(picture);
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }



}
