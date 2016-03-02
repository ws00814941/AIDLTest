// aidltest1.aidl
package com.cqf.aidltest.aldl;

// Declare any non-default types here with import statements

interface AIDLTest1 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            int add( int value1, in int value2);
}
