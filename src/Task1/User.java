package Task1;

public class User {
    private Long id;
    private String name;
    private boolean active;
    private int age;

    public User(Long id, String name, boolean active, int age) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", age=" + age +
                '}';
    }
}
