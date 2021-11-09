package kosogroup.infinity.handler;

import kosogroup.infinity.dto.IObjectDTO;
import kosogroup.infinity.dto.ShellDTO;

import java.io.IOException;

public class HandlerObject implements IHandler
{
    public void handle(ShellDTO shellDTO) throws IOException
    {
        ((IObjectDTO) shellDTO.getObject()).handle(this, shellDTO);
    }
}
