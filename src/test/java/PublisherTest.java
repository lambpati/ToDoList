import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublisherTest {
    Observer testObserver = () -> {

    };

    Publisher publisher = new Publisher() {
        @Override
        public void subscribe(Observer o) {
            super.subscribe(o);
        }
    };

    @Test
    void subscribe() {
        publisher.subscribe(testObserver);
        assertFalse(publisher.subscribers.isEmpty());
        assertTrue(publisher.subscribers.contains(testObserver));

    }

    @Test
    void unsubscribe() {
        subscribe();
        publisher.unsubscribe(testObserver);
        assertTrue(publisher.subscribers.isEmpty());
    }

    @Test
    void notifySubscribers() {
        subscribe();
        publisher.notifySubscribers();
        System.out.println(publisher.subscribers.get(0));
        assertTrue(publisher.subscribers.contains(testObserver));
    }
}