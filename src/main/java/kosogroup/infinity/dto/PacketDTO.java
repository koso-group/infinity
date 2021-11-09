package kosogroup.infinity.dto;



import kosogroup.infinity.handler.HandlerPacket;

import java.io.IOException;

public class PacketDTO implements IDataDTO
{

    protected void handle(HandlerPacket iHandler, ShellDTO shellDTO) throws IOException
    {
        iHandler.handle(shellDTO);
    }

    public byte[] _magic = new byte[4];
    public byte[] _length = new byte[4];
    public byte[] _nn = new byte[4];

    public byte[] _content;



}
