package practice.semo.item;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(indexes = @Index(columnList = "price", name = "price_index"))
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 알아서 ID를 1씩 증가후 저장
    public Long id;
    private String title;
    private Integer price;

}
//new Item().title
