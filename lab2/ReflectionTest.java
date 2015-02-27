package javaapplication1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    long x, count;
    Long y;
    Client client = new Client();
    long start_time, end_time;
    Field age, weight;
    Method value;

    public ReflectionTest() throws NoSuchFieldException, NoSuchMethodException {
        count = 20000000000L;
        client = new Client();
        age = client.getClass().getField("age");
        weight = client.getClass().getField("weight");
        value = client.getClass().getMethod("value", long.class);
    }

    public void testGetPrimitive() {
        System.out.println("GET PRIMITIVE");
        start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            x = client.age;
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testSetPrimitive() {
        System.out.println("SET PRIMITIVE");
        start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            client.age = i;
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testGetPrimitiveReflection() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("GET PRIMITIVE REFLECTION");
        start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            x = age.getLong(client);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testSetPrimitiveReflection() throws IllegalArgumentException, IllegalAccessException, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException {
        System.out.println("SET PRIMITIVE REFLECTION");
        start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            age.setLong(client, i);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testGetReference() {
        System.out.println("GET REFERENCE");
        start_time = System.currentTimeMillis();
        for (Long i = 0L; i < count; i++) {
            y = client.weight;
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testSetReference() {
        System.out.println("SET REFERENCE");
        start_time = System.currentTimeMillis();
        for (Long i = 0L; i < count; i++) {
            client.weight = i;
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testGetReferenceReflection() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("GET REFERENCE REFLECTION");
        start_time = System.currentTimeMillis();
        for (Long i = 0L; i < count; i++) {
            y = (Long) weight.get(client);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testSetReferenceReflection() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("SET REFERENCE REFLECTION");
        start_time = System.currentTimeMillis();
        for (Long i = 0L; i < count; i++) {
            weight.set(client, i);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testGetMethod() {
        System.out.println("GET METHOD");
        start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            client.value(i);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public void testGetMethodReflection() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("GET METHOD REFLECTION");
        start_time = System.currentTimeMillis();
        for (Long i = 0L; i < count; i++) {
            value.invoke(client, i);
        }
        end_time = System.currentTimeMillis();
        System.out.println("execution time: " + (end_time - start_time));
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ReflectionTest app = new ReflectionTest();
        app.testGetPrimitive();
        app.testSetPrimitive();
        app.testGetPrimitiveReflection();
        app.testSetPrimitiveReflection();
        app.testGetReference();
        app.testSetReference();
        app.testGetReferenceReflection();
        app.testSetReferenceReflection();
        app.testGetMethod();
        app.testGetMethodReflection();
    }
}
