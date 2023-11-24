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
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    @Column(length = 100)
    private String title;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    private boolean published;
    private String content;
    private Instant publishedAt;
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment parent;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
