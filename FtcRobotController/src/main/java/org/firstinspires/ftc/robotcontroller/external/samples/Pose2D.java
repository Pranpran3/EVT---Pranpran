package org.firstinspires.ftc.robotcontroller.external.samples;

public class Pose2D {
    private double x; // X-coordinate in the 2D plane
    private double y; // Y-coordinate in the 2D plane
    private double heading; // Heading in radians (or degrees, based on your preference)

    // Constructors
    public Pose2D() {
        this(0, 0, 0);
    }

    public Pose2D(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    // Methods
    public void translate(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public void rotate(double deltaHeading) {
        this.heading += deltaHeading;
    }

    public double distanceTo(Pose2D other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public double angleTo(Pose2D other) {
        return Math.atan2(other.y - this.y, other.x - this.x);
    }

    @Override
    public String toString() {
        return String.format("Pose2D{x=%.2f, y=%.2f, heading=%.2f}", x, y, heading);
    }
}