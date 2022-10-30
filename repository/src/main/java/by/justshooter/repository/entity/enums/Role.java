package by.justshooter.repository.entity.enums;

public enum Role {
    ADMIN("Administrator"),
    SALE_USER("Sale User"),
    CUSTOMER_USER("Customer User"),
    SECURE_API_USER("Secure API User");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Role getRoleByName(String name){
        for (Role role: Role.values()){
            if (role.getName().equals(name)){
                return role;
            }
        }
        return null;
    }
}
