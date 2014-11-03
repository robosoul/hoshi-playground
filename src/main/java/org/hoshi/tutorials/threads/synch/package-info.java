/**
 * Examples in this package demonstrate fixing concurrency issues using
 * synchronization.
 *
 * Synchronization is built around an internal entity known as the intrinsic
 * lock or monitor lock. (The API specification often refers to this entity
 * simply as a "monitor.") Intrinsic locks play a role in both aspects of
 * synchronization: enforcing exclusive access to an object's state and
 * establishing happens-before relationships that are essential to visibility.
 *
 * !Every object! has an intrinsic lock associated with it. By convention, a
 * thread that needs exclusive and consistent access to an object's fields has
 * to acquire the object's intrinsic lock before accessing them, and then
 * release the intrinsic lock when it's done with them. A thread is said to own
 * the intrinsic lock between the time it has acquired the lock and released the
 * lock. As long as a thread owns an intrinsic lock, no other thread can acquire
 * the same lock. The other thread will block when it attempts to acquire the lock.
 *
 * When a thread releases an intrinsic lock, a happens-before relationship is
 * established between that action and any subsequent acquisition of the same lock.
 *
 * @author Luka Obradovic (luka@vast.com)
 */
package org.hoshi.tutorials.threads.synch;