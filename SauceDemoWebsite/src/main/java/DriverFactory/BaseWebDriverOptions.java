package DriverFactory;


/*
*
* The <T> is just a generic type to be decided when class implements the interface
* which will be the same type the method will return
* */
public interface BaseWebDriverOptions<T> {
    T getOptions();
}
