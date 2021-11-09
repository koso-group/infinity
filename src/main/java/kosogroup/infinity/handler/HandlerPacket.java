package kosogroup.infinity.handler;

import kosogroup.infinity.dto.ShellDTO;

import java.io.IOException;

public abstract class HandlerPacket implements IHandler
{
    @Override
    public abstract void handle(ShellDTO shellDTO) throws IOException;
}
