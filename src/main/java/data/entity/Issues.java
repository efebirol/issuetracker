package data.entity;

import javax.persistence.*;

@Entity
@Table(name ="ISSUES")
public class Issues{
    @Id
    @Column(name ="ISSUES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
