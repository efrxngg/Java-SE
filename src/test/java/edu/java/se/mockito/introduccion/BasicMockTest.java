package edu.java.se.mockito.introduccion;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BasicMockTest {
    @Test
    void testList() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("one");
        assertEquals("one", mockedList.get(0));
    }

    @Test
    void testLinkedList() {
        LinkedList<String> mockedList = mock();
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }
}
