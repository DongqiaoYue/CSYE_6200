package neu.edu.csye6200;

public class User {

    private static User user;

    private String username;

    private boolean isLoggedIn;

    private UserTypeEnum userTypeEnum;

    private User(){

    }

    public static User getInstance(){
        user = new User();
        return user;
    }

    public boolean isUserLoggedIn(){
        return isLoggedIn;
    }

    public void logout(){
        isLoggedIn = false;
    }

    public void login(){
        isLoggedIn = true;
    }

    public void setUserTypeEnum(String type){
        if (type.equals("teacher")){
            userTypeEnum = UserTypeEnum.TEACHER;
        }else if (type.equals("student")){
            userTypeEnum = UserTypeEnum.STUDENT;
        }
    }

    public UserTypeEnum getUserTypeEnum(){
        return userTypeEnum;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
