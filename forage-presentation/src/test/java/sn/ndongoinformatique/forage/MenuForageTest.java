package sn.ndongoinformatique.forage;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MenuForageTest {

    private final Appender appender = mock(Appender.class);
    private final Logger logger = Logger.getRootLogger();

    @Before
    public void setup() {
        logger.addAppender(appender);
    }

    @Test
    public void affMenu() {
        // when
        Logger.getLogger(MenuForageTest.class).info("Test");

        // then
        ArgumentCaptor<LoggingEvent> argument = ArgumentCaptor.forClass(LoggingEvent.class);
        verify(appender).doAppend(argument.capture());
        assertEquals(Level.INFO, argument.getValue().getLevel());
        assertEquals("Test", argument.getValue().getMessage());
        assertEquals("MyTest", argument.getValue().getLoggerName());
    }

    @After
    public void cleanup() {
        logger.removeAppender(appender);
    }
}