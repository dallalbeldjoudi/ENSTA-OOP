public abstract class Marketplace {
    private String name;
    private String id;
    private float currentBalance;

    public Marketplace(String name, String id, float currentBalance) {
        this.name = name;
        this.id = id;
        this.currentBalance = currentBalance;
    }

    // Abstract method that subclasses must implement
    public abstract void transaction(Marketplace target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }
}
