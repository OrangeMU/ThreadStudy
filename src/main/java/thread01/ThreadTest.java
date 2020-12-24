package thread01;

import java.lang.invoke.MethodHandleProxies;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class ThreadTest {

    int x = 9;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        VarHandle handle = MethodHandles.lookup().in(ThreadTest.class).findVarHandle(ThreadTest.class, "x", int.class);
    }
}
