package com.example.myenglish.Model;

public class NoteModel {
    private int id;
    private String note;

    public NoteModel() {
    }

    public NoteModel(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
