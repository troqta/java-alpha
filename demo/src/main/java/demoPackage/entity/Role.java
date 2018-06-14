package demoPackage.entity;

@Entity
@Table(name="roles")
public class Role{
    private Integer Id;
    private String name;
    private Set<User> users;
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    @Collumn(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role (){
        this.users = new HashSet<>();
    }
    @ManyToMany(mappedBy = "Roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}