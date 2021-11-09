package kosogroup.infinity.dto;

import kosogroup.infinity.handler.HandlerObject;

import java.io.IOException;
import java.io.Serializable;

public interface IObjectDTO<T extends HandlerObject> extends Serializable, IDataDTO
{
    void handle(T iHandler, ShellDTO shellDTO) throws IOException;
}
