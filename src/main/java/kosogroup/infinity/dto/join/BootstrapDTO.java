package kosogroup.infinity.dto.join;

import kosogroup.infinity.handler.IHandler;
import kosogroup.infinity.thread.ConnectionThread;

public class BootstrapDTO<T extends BootstrapDTO>
{
    protected int _networkPort = 1488;

    protected ConnectionThread _connectionThread;

    protected Thread.UncaughtExceptionHandler _uncaughtExceptionHandler = null;

    protected IHandler _iHandler;



    public BootstrapDTO() { }

    public BootstrapDTO(int newtworkPort)
    {
        this._networkPort = newtworkPort;
    }

    public ConnectionThread getConnectionThread()
    {
        return this._connectionThread;
    }

    public T setConnectionThread(ConnectionThread connectionThread)
    {
        this._connectionThread = connectionThread;
        return (T) this;
    }


    public int getPort()
    {
        return this._networkPort;
    }
    public T setPort(int networkPort)
    {
        this._networkPort = networkPort;
        return (T) this;
    }

    public T  setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler)
    {
        this._uncaughtExceptionHandler = uncaughtExceptionHandler;
        return (T) this;
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
    {
        if(this._uncaughtExceptionHandler == null)
            this._uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

        return this._uncaughtExceptionHandler;
    }

    public T setHandler(IHandler iHandler)
    {
        this._iHandler = iHandler;
        return (T) this;
    }

    public IHandler getHandler()
    {
        return this._iHandler;
    }
}
