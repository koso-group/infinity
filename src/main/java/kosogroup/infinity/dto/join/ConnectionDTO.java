package kosogroup.infinity.dto.join;

import java.io.IOException;
import java.net.Socket;

public class ConnectionDTO extends BootstrapDTO<ConnectionDTO>
{
    protected String _networkAddress;
    protected Socket _socket;

    public ConnectionDTO() { }

    public ConnectionDTO(String networkAddress, int newtworkPort)
    {
        this._networkAddress = networkAddress;
        this._networkPort = newtworkPort;
    }

    public ConnectionDTO impl_join(BootstrapDTO bootstrapDTO)
    {
        this.setUncaughtExceptionHandler(bootstrapDTO.getUncaughtExceptionHandler());
        this.setConnectionThread(bootstrapDTO.getConnectionThread().newInstance());
        this.setHandler(bootstrapDTO.getHandler());

        return this;
    }

    public ConnectionDTO setSocket(Socket socket)
    {
        this._socket = socket;
        return this;
    }
    public Socket getSocket() throws IOException
    {
        if(this._socket == null)
            this._socket = new Socket(this._networkAddress, this._networkPort);
        return this._socket;
    }

    public String getAddress()
    {
        return this._networkAddress;
    }
    public ConnectionDTO setAddress(String networkAddress)
    {
        this._networkAddress = networkAddress;
        return this;
    }
}