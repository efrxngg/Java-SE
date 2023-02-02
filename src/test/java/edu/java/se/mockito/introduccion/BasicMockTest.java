package edu.java.se.mockito.introduccion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BasicMockTest {
    @Test
    void testList() {
        List<String> mockList = new ArrayList<String>();
        var mockedList = mock(mockList.getClass());
        when(mockedList.get(0)).thenReturn("one");
        assertEquals("one", mockedList.get(0));
    }

    @Test
    void testLinkedList() {
        List<String> mockList = new LinkedList<String>();
        var mockedList = mock(mockList.getClass());
        mockedList.clear();
        verify(mockedList).clear();

    }
}
