package kosogroup.infinity.handler;

import kosogroup.infinity.dto.ShellDTO;

import java.io.IOException;

public interface IHandler
{
    void handle(ShellDTO shellDTO) throws IOException;
}
