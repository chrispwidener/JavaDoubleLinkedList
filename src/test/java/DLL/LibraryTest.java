/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package DLL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DLLTest {
    
    @Test
    void addHeadWorks() {
        DLL<Integer> dll = new DLL<Integer>();
        dll.linkHead(1);

        assertEquals(1, dll.unlinkHead());

        //Library classUnderTest = new Library();
        //assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}
