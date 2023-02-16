package model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.testng.annotations.BeforeMethod;

@Setter
@Getter
@ToString
@Builder
public class User {

    private String email;
    private String password;

}
