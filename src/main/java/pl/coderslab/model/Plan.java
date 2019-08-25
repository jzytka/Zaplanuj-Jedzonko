package pl.coderslab.model;

public class Plan {

    private int id;
    private String name;
    private String description;
    private String created;
    private int adminId;


    public Plan(int id, String name, String description, String created, int adminId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.adminId = adminId;
    }

    public Plan(int id, String name, String description, int adminId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adminId = adminId;
    }

    public Plan(String name, String description, int adminId) {
        this.name = name;
        this.description = description;
        this.adminId = adminId;
    }

    public Plan() {
    }

    public int getId() {
        return id;
    }

    public Plan setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Plan setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plan setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public Plan setCreated(String created) {
        this.created = created;
        return this;
    }

    public int getAdminId() {
        return adminId;
    }

    public Plan setAdminId(int adminId) {
        this.adminId = adminId;
        return this;
    }

    @Override
    public String toString() {
        return "Plan [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created +
                ", adminId=" + adminId + "]";
    }




}
