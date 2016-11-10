package com.example.ofir.testfunctionality2.Search;

/**
 * Created by Ofir on 04/06/2016.
 */
public class ChildRow {
    private int icon;
    private String text;

    public ChildRow(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }
    public ChildRow( String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
