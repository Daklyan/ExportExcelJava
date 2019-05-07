package Mission2.Dao;

public class Course {
    private int userId;
    private String userName;
    private String driverName;
    private String beginning;
    private String destination;
    private int estimatedPrice;
    public String createdDate;

    public Course(int userId, String userName,String driverName, String beginning, String destination, int estimatedPrice, String createdDate) {
        this.userId = userId;
        this.userName = userName;
        this.driverName = driverName;
        this.beginning = beginning;
        this.destination = destination;
        this.estimatedPrice = estimatedPrice;
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getBeginning() {
        return beginning;
    }

    public String getDestination() {
        return destination;
    }

    public int getEstimatedPrice() {
        return estimatedPrice;
    }

    public String toString(){
        return  String.format("%d - %s - %s - %s - %s - %d",this.userId,
                this.userName,
                this.driverName,
                this.beginning,
                this.destination,
                this.estimatedPrice);
    }
}
