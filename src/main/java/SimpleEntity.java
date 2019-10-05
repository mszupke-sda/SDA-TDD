public class SimpleEntity {
    private int uniqueId;
    private SecondEntity secondEntity;

    public SimpleEntity(SecondEntity secondEntity) {
        this.secondEntity = secondEntity;
    }

    public int getUniqueId() {
        return uniqueId;
    }
}
