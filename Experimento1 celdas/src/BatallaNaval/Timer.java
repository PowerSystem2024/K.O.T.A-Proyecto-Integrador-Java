
package BatallaNaval;


public class Timer {
    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public String getElapsedTime() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        long minutes = (elapsedTime / 1000) / 60;
        long seconds = (elapsedTime / 1000) % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
    

