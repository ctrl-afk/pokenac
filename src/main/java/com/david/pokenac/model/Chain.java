package com.david.pokenac.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "chain")
public class Chain {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Chain> evolves_to = new ArrayList<>();

    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Chain parent;
    @OneToOne(mappedBy = "chain")
    private EvoChain evo_chain;
    // public Post addComment(PostComment comment) {
    //        comments.add(comment);
    //        comment.setPost(this);
    //        return this;
    //    }
}
