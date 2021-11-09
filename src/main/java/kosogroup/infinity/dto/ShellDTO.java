package kosogroup.infinity.dto;

import kosogroup.infinity.InfinityConnection;

public class ShellDTO
{
    private InfinityConnection _connection;
    private Object _object;

    public ShellDTO setConnection(InfinityConnection connection)
    {
        this._connection = connection;
        return this;
    }
    public ShellDTO setObject(Object _object)
    {
        this._object = _object;
        return this;
    }

    public InfinityConnection getConnection()
    {
        return this._connection;
    }

    public Object getObject()
    {
        return this._object;
    }

    public <T> T getObject(T objectClass)
    {
        return (T) this.getObject();
    }

}
