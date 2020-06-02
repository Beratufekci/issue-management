package com.management.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "user_seq",name="USER_SEQ",allocationSize = 10)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "uname", length = 100, unique = true)
    private String uname;

    @Column(name = "pwd", length = 50)
    private String pwd;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "assignee_id",targetEntity = Issue.class)
    private List<Issue> issueList;

}
