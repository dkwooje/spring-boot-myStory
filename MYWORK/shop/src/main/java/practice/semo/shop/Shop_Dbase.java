package practice.semo.shop;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Shop_Dbase {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(nullable = false,unique = true)
    private String title;
    private Integer price;
    private String color;
    private String shape;
    private Integer age;



}
