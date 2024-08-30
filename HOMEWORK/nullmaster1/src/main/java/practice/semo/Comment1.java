package practice.semo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@ToString
public class Comment1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer comment_id;
    @Column(nullable = false, unique = true)
    private Integer post_id;
    @Column(nullable = false, unique = true)
    private Integer user_id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp create_at;


}
