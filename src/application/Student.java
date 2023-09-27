package application;

public class Student {
    private String name;
    private String university = "Hochschule Mittweida";
    private int points;
    private String subject;
    private double note;
    private String outcome;

    public Student(String name, int points, String subject) {
        this.name = name; // Name of the student 
        this.points = points; // The number of points, written as
        this.subject = subject;
        calculateNoteAndOutcome();
    }
    	
// Note and Prädikant berechnen
    private void calculateNoteAndOutcome() {
        if (points >= 94) {
            note = 1.0;
            outcome = "sehr gut";
        } else if (points >= 76.4) {
            note = 2.0 + (94 - points) / (76.4 - 94) * 0.3;
            outcome = "gut";
        } else if (points >= 58.8) {
            note = 3.0 + (76.4 - points) / (58.8 - 76.4) * 0.3;
            outcome = "befriedigend";
        } else if (points >= 49) {
            note = 4.0 + (58.8 - points) / (49 - 58.8) * 0.3;
            outcome = "ausreichend";
        } else {
            note = 5.0;
            outcome = "durchgefallen";
        }
    }

    public String getFormattedOutcome() {
        if (note >= 1.0 && note <= 1.3) {
            return String.format("%.1f (%s)", note, "sehr gut");
        } else if (note >= 1.7 && note <= 2.3) {
            return String.format("%.1f (%s)", note, "gut");
        } else if (note >= 2.7 && note <= 3.3) {
            return String.format("%.1f (%s)", note, "befriedigend");
        } else if (note >= 3.7 && note <= 4.0) {
            return String.format("%.1f (%s)", note, "ausreichend");
        } else {
            return String.format("%.1f (%s)", note, "durchgefallen");
        }
    }

    @Override
    public String toString() {
        return String.format("\nStatus: Student%nUniversity: %s%nNote: %s%nSubject: %s",
                university, getFormattedOutcome(), subject);
    }
    }