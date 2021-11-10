package kosogroup.infinity.thread;

import kosogroup.infinity.InfinityConnection;
import kosogroup.infinity.dto.IDataDTO;

import java.io.IOException;
import java.net.Socket;

public abstract class ConnectionThread<T> extends Thread
{
    protected Socket _socket;
    protected InfinityConnection _connection;


    public InfinityConnection getConnection()
    {
        return this._connection;
    }
    public T setConnection(InfinityConnection connection)
    {
        this._connection = connection;

        return (T) this;
    }

    public Socket getSocket()
    {
        return this._socket;

    }
    public T setSocket(Socket socket)
    {
        this._socket = socket;

        return (T) this;
    }

    @Override
    public abstract void run();

    public abstract void sendData(IDataDTO iDataDTO) throws IOException;

    public ConnectionThread newInstance()
    {
        try {
            return this.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
