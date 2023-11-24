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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "tinyint(1)")
    private boolean published;

    private String content;
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post parent;
    @Column(columnDefinition = "varchar(100)")
    private String metaTitle;

    private String summary;
    private Instant createdAt;
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;
    @Column(columnDefinition = "varchar(75)")
    private String title;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;
    private Instant updateAt;
    private Instant publishedAt;
}
