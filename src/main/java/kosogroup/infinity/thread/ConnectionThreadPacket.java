package kosogroup.infinity.thread;

import kosogroup.infinity.InfinityMath;
import kosogroup.infinity.dto.IDataDTO;
import kosogroup.infinity.dto.PacketDTO;
import kosogroup.infinity.dto.ShellDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConnectionThreadPacket extends ConnectionThread<ConnectionThreadPacket>
{
    protected OutputStream _outputStream;
    protected InputStream _inputStream;


    @Override
    public void run()
    {
        try
        {
            this._outputStream = this._socket.getOutputStream();
            this._inputStream = this._socket.getInputStream();

            this._socket.setTcpNoDelay(true);

            while (true)
            {
                ShellDTO shellDTO = new ShellDTO().setConnection(this._connection);

                PacketDTO packetDTO = new PacketDTO();

                this._inputStream.read(packetDTO._magic,0, 4);
                this._inputStream.read(packetDTO._length,0, 4);
                this._inputStream.read(packetDTO._nn,0, 4);

                packetDTO._content = new byte[InfinityMath.toInteger(packetDTO._length)];

                this._inputStream.read(packetDTO._content, 0, InfinityMath.toInteger(packetDTO._length));

                shellDTO.setObject(packetDTO);

                this._connection.getConnectionDTO()
                        .getHandler()
                        .handle(shellDTO);
            }

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendData(IDataDTO iDataDTO)
    {
        PacketDTO iPacketDTO = (PacketDTO) iDataDTO;

        try
        {
            this._outputStream.write(iPacketDTO._magic);
            this._outputStream.write(iPacketDTO._length);
            this._outputStream.write(iPacketDTO._nn);
            this._outputStream.write(iPacketDTO._content);
            this._outputStream.flush();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
