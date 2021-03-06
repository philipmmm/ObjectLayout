/*
 * Written by Gil Tene and Martin Thompson, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

package org.ObjectLayout;


import java.lang.reflect.Constructor;

/**
 * A subclassable array of object references.
 *
 * ReferenceArray is designed with semantics specifically chosen and restricted such that a "flat" memory
 * layout of the implemented data structure would be possible on optimizing JVMs. While fully functional
 * on all JVM implementation (of Java SE 6 and above), the semantics are such that a JVM may transparently
 * optimise the implementation to provide a compact contiguous layout that facilitates dead-reckoning (as
 * opposed to de-referenced) access to elements
 *
 * @param <T> The reference type
 */

public class ReferenceArray<T> extends AbstractReferenceArray<T> {

    /**
     * Get a reference to a T[] that represents the contents of this array. Will throw an
     * exception if array is too long to represent as a T[].
     *
     * @return a reference to a T[] that represents the contents of this array
     * @throws IllegalStateException if array is too long to represent as a T[]
     */
    public T[] asArray() throws IllegalStateException {
        return _asArray();
    }

    /**
     * Get the length of the array
     *
     * @return the length of the array
     */
    public long getLength() {
        return _getLength();
    }

    /**
     * Get the value of an element in the array.
     *
     * @param index the index of the element
     * @return the value of the element at the given index
     */
    public T get(final int index) {
        return _get(index);
    }


    /**
     * Get the value of an element in the array.
     *
     * @param index the index of the element
     * @return the value of the element at the given index
     */
    public T get(final long index) {
        return _get(index);
    }

    /**
     * set the value of an element in the array.
     *
     * @param index the index of the element to set
     * @param value the value to assign to the element
     */
    public void set(final int index, final T value) {
        _set(index, value);
    }

    /**
     * set the value of an element in the array.
     *
     * @param index the index of the element to set
     * @param value the value to assign to the element
     */
    public void set(final long index, final T value) {
        _set(index, value);
    }

    /**
     * Default constructor
     */
    public ReferenceArray() {
        super();
    }

    /**
     * Copy constructor
     *
     * @param sourceArray the array to copy
     */
    public ReferenceArray(ReferenceArray<T> sourceArray) {
        super(sourceArray);
    }

    /**
     * Create a new instance of ReferenceArray&ltT&gt with a given length.
     *
     * @param length the length of the array
     * @param <T> the reference type
     * @return A newly created ReferenceArray&ltT&gt
     */
    public static <T> ReferenceArray<T> newInstance(final long length) {
        @SuppressWarnings("unchecked")
        ReferenceArray<T> referenceArray = _newInstance(ReferenceArray.class, length);
        return referenceArray;
    }

    /**
     * Create a new instance of &ltA extends {@link ReferenceArray}&ltT&gt&gt with a given length.
     *
     * @param arrayClass The class of the array to be created (extends ReferenceArray&ltT&gt)
     * @param length the length of the array.
     * @param <T> the reference type
     * @param <A> The class of the array to be created (extends ReferenceArray&ltT&gt)
     * @return a new instance of &ltA extends {@link ReferenceArray}&ltT&gt&gt with a given length
     */
    public static <T, A extends ReferenceArray<T>> A newInstance(
            final Class<A> arrayClass,
            final long length) {
        return AbstractPrimitiveArray._newInstance(arrayClass, length);
    }

    /**
     * Create a new instance of &ltA extends {@link ReferenceArray}&ltT&gt&gt with a given length,
     * array constructor, and array constructor arguments.
     *
     * @param length The length of the array.
     * @param arrayConstructor The array constructor to use
     * @param arrayConstructorArgs The arguments to pass to the array constructor
     * @param <T> the reference type
     * @param <A> The class of the array to be created (extends ReferenceArray&ltT&gt)
     * @return a new instance of &ltA extends {@link ReferenceArray}&ltT&gt&gt
     */
    public static <T, A extends ReferenceArray<T>> A newInstance(
            final long length,
            final Constructor<A> arrayConstructor,
            final Object... arrayConstructorArgs) {
        return AbstractPrimitiveArray._newInstance(length, arrayConstructor, arrayConstructorArgs);
    }

    /**
     * Create a new &ltA extends {@link ReferenceArray}&ltT&gt&gt instance, using a copy constructor to
     * replicate the contents of the given source array
     * @param source The array to replicate
     * @param <A> The class of the array to be created (extends ReferenceArray&ltT&gt)
     * @return a new instance of &ltA extends {@link ReferenceArray}&ltT&gt&gt copied from the source array
     * @throws NoSuchMethodException if &ltA&gt does not have a copy constructor
     */
    public static <T, A extends ReferenceArray<T>> A copyInstance(A source) throws NoSuchMethodException {
        return AbstractPrimitiveArray._copyInstance(source);
    }
}
