package practice.semo.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    public Integer user_id;
    public String username;
    public String password;
    public String email;
    UserDto(){

    }


}
