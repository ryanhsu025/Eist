package de.tum.in.ase.eist;

public interface Comment {

    boolean save();

    String getText();

    void setText(String text);

    Person getAuthor();

    void setAuthor(Person author);

}

