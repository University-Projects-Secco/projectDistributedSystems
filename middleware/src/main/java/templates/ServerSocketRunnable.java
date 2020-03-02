package templates;

import middleware.networkThreads.P2PConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerSocketRunnable<T extends PrimitiveParser> implements Runnable{
    /**
     * Used to accept connections with the other replicas
     */
    private final ServerSocket serverSocket;
    /**
     * A logger
     */
    private static final Logger logger = Logger.getLogger(ServerSocketRunnable.class.getName());

    /**
     * Creates a ConnectionAcceptor listening to the given port
     * @param port The port to listen to
     * @throws IOException If thrown by {@linkplain ServerSocket#ServerSocket(int)}
     */
    public ServerSocketRunnable(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    /**
     * While {@link #serverSocket} is opened, accepts incoming connections and starts a {@link P2PConnection} using the created Socket
     */
    @Override
    public void run() {
        while (!serverSocket.isClosed()){
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(T.getInstance(clientSocket)).start();    //TODO: this calls PrimitiveParser.getInstance->Use a factory
            } catch (IOException e) {
                logger.warning("An error occurred while accepting a connection by "+serverSocket);
            }
        }

    }
}