package kosogroup.infinity.thread;

import kosogroup.infinity.dto.IDataDTO;
import kosogroup.infinity.dto.ShellDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConnectionThreadObject extends ConnectionThread<ConnectionThreadObject>
{
    protected ObjectOutputStream _objectOutputStream;
    protected ObjectInputStream _objectInputStream;

    @Override
    public void run()
    {
        try
        {
            this._objectOutputStream = new ObjectOutputStream(this._socket.getOutputStream());
            this._objectInputStream = new ObjectInputStream(this._socket.getInputStream());

            this._socket.setTcpNoDelay(true);

            //To-do: create system for Packet0KeepAlive!!!

            while (true)
            {
                ShellDTO shellDTO = new ShellDTO()
                        .setConnection(this._connection)
                        .setObject(_objectInputStream.readObject());

                this._connection.getConnectionDTO()
                        .getHandler()
                        .handle(shellDTO);
            }
        }
        catch (IOException | ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendData(IDataDTO iDataDTO)
    {
        try
        {
            this._objectOutputStream.writeObject(iDataDTO);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
