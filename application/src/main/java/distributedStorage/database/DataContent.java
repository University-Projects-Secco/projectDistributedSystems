package distributedStorage.database;

import lombok.Data;
import distributedStorage.primitives.DataOperations;

@Data
public class DataContent<K, V> {
    K key;
    V value;
    DataOperations operations;
}