/**
 * The singleton design pattern ensures that a class has only one instance, and
 * provide a global point of access to it.
 *
 * Singletons maintain a static reference to the sole singleton instance and
 * return a reference to that instance from a static getInstance() method.
 *
 * To ensure that no more than one instance of the class is created singleton
 * class should.
 *
 * Several interesting points concerning singleton:
 *  - lazy initialization
 *  - private (final class) / protected constructor
 *  - class loader
 *  - serialization
 *  - thread-safe
 *
 * Singleton class should employ a technique known as *lazy instantiation* to
 * create the singleton; as a result, the singleton instance is not created
 * until the getInstance() method is called for the first time. This technique
 * ensures that singleton instances are created only when needed.
 *
 * If singleton class implements protected constructor it does not ensure that
 * there could be only one instance of singleton class, since protected constructor
 * can be called by other classes from the same package. But advantage is that
 * this singleton class can be subclassed.
 *
 * If singleton class implements private constructor, this class can't be
 * subclassed, and with that this singleton class should be declared as final.
 *
 * It's possible to have multiple singleton instances if classes loaded by
 * different classloaders access a singleton.
 *
 * If singleton class implements Serializable interface, the class's instances
 * can be serialized and deserialized. However, if you serialize a singleton
 * object and subsequently deserialize that object more than once, you will have
 * multiple singleton instances.
 *
 * Singleton class should be thread-safe. If two threads call getInstance() at
 * the same time, two Singleton instances can be created if Thread-1 is
 * preempted just after it enters the if block and control is subsequently given
 * to Thread-2.
 *
 * @author Luka Obradovic (obradovic.luka.83@gmail.com)
 */
package org.hoshi.playground.designpatterns.singleton;