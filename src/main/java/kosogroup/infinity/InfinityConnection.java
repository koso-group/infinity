package kosogroup.infinity;

import kosogroup.infinity.dto.IDataDTO;
import kosogroup.infinity.dto.join.ConnectionDTO;
import kosogroup.infinity.thread.ConnectionThread;

import java.io.IOException;

public class InfinityConnection
{
    protected ConnectionThread _connectionThread;
    protected ConnectionDTO _ConnectionDTO;

    public InfinityConnection() {}

    public InfinityConnection(ConnectionDTO connectionDTO) throws IOException
    {
        this._ConnectionDTO = connectionDTO;
        this._connectionThread = this._ConnectionDTO.getConnectionThread();

        this._connectionThread.setConnection(this);
        this._connectionThread.setSocket(this._ConnectionDTO.getSocket());

    }

    public static InfinityConnection join(ConnectionDTO connectionDTO) throws IOException
    {
        return new InfinityConnection(connectionDTO).connect();
    }

    public InfinityConnection connect()
    {
        this._connectionThread.start();

        return this;
    }

    public ConnectionDTO getConnectionDTO()
    {
        return this._ConnectionDTO;
    }

    public InfinityConnection sendData(IDataDTO iDataDTO) throws IOException
    {
        this._connectionThread.sendData(iDataDTO);

        return this;
    }


}
