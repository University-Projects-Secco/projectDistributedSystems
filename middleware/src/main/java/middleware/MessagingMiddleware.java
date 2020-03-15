package middleware;

import middleware.group.GroupManager;
import middleware.primitives.Primitive;

public interface MessagingMiddleware <Key, Value, ApplicativePrimitive extends Enum<ApplicativePrimitive> & Primitive> extends GroupManager<Key,Value> {
    void shareOperation(ApplicativePrimitive command, Key key, Value value);
}
