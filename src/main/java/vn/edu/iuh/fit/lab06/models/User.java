package vn.edu.iuh.fit.lab06.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(15)")
    private String mobile;
    private Instant lastLogin;
    @Column(columnDefinition = "varchar(50)")
    private String firstName;
    @Column(columnDefinition = "varchar(50)")
    private String middleName;
    @Column(columnDefinition = "varchar(50)")
    private String lastName;
    private String intro;
    private String profile;
    private Instant registeredAt;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments;
    private String passwordHash;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
    private String email;
}
