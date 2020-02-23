package ua.com.foxminded.core;

public class BlankTextException extends Exception {
    protected BlankTextException() {
	super("It has been passed a line with blank text");
    }
}
