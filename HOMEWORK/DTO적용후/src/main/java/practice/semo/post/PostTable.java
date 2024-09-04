package practice.semo.post;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@ToString
public class PostTable {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer post_id;
    @Column(unique = true)
    private Integer user_id;
    private String title;
    private String content;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_at;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updated_at;


}
