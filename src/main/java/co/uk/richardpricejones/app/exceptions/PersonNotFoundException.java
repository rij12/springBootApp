package co.uk.richardpricejones.app.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
