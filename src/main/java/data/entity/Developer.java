package data.entity;

import javax.persistence.*;

@Entity
@Table(name ="DEVELOPER")
public class Developer {
    @Id
    @Column(name ="DEVELOPER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
