package middleware.messages;

import java.util.HashSet;

public class MessageProducerImpl<T> implements MessageProducer<T> {
    HashSet<MessageConsumer<T>> consumers;
    HashSet<Message<T>> buffer;

    @Override
    public void addConsumer(MessageConsumer<T> consumer) {
        consumers.add(consumer);
    }

    @Override
    public void addMessageToBuffer(Message<T> msg) {
        buffer.add(msg);
    }

    @Override
    public void shareMessage(Message<T> msg) {
        //TODO
    }

    private void notifyConsumers(Message<T> msg) {
        consumers.forEach(c-> c.consumeMessage(msg));
    }
}