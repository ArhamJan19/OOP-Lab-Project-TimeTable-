package com.example.oopassignment4;

public class TimetableEntry {
    private String day;
    private String time;
    private String course;
    private String section;
    private String room;
    private String teacher;

    public TimetableEntry(String day, String time, String course, String section, String room, String teacher) {
        this.day = day;
        this.time = time;
        this.course = course;
        this.section = section;
        this.room = room;
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacher() {
        return teacher;
    }
}
