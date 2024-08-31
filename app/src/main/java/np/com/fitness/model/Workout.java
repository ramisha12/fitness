package np.com.fitness.model;


public class Workout {
    private String name;
    private String duration;
    private int imageResId;

    public Workout(String name, String duration, int imageResId) {
        this.name = name;
        this.duration = duration;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public int getImageResId() {
        return imageResId;
    }
}
