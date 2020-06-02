package com.management.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Project extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PROJECT_SEQ")
    @SequenceGenerator(sequenceName = "project_seq",name = "PROJECT_SEQ",allocationSize = 10 )
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name", length = 200)
    private String projectName;

    @Column(name = "project_code", length = 50)
    private String projectCode;

    @JoinColumn (name = "project_manager_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;
}
