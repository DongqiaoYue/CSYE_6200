package neu.edu.csye6200;

public class User {

    private User user;

    private String username;

    private boolean isLoggedIn;

    private UserTypeEnum userTypeEnum;

    private User(){

    }

    public User getInstance(){
        user = new User();
        return user;
    }

    public boolean isUserLoggedIn(){
        return isLoggedIn;
    }

    public void logout(){
        isLoggedIn = false;
    }

    public void login(String username, String password){
        //TODO check the user

        isLoggedIn = true;
    }
}
