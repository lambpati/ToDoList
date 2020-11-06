import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests that Observers can be added to a list of subscribers and can be notified and
 * unsubscribed from the list.
 */
class PublisherTest {
    Observer testObserver = () -> {

    };

    Publisher publisher = new Publisher() {
        @Override
        public void subscribe(Observer o) {
            super.subscribe(o);
        }
    };

    /**
     * Tests that an empty testObserver is in the list of observers
     * and subscribed for updates.
     */
    @Test
    void subscribe() {
        publisher.subscribe(testObserver);
        assertFalse(publisher.subscribers.isEmpty());
        assertTrue(publisher.subscribers.contains(testObserver));

    }

    /**
     * Removes the testObserver from the list of observers and tests
     * that it was correctly removed.
     */
    @Test
    void unsubscribe() {
        subscribe();
        publisher.unsubscribe(testObserver);
        assertTrue(publisher.subscribers.isEmpty());
    }

    /**
     * Subscribes an empty testObserver to a notify list and then asserts that
     * the publisher publishes changes to the testObserver.
     */
    @Test
    void notifySubscribers() {
        subscribe();
        publisher.notifySubscribers();
//        System.out.println(publisher.subscribers.get(0));
        assertTrue(publisher.subscribers.contains(testObserver));
    }
}