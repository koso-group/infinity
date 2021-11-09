package kosogroup.infinity;

import kosogroup.infinity.dto.join.BootstrapDTO;
import kosogroup.infinity.dto.join.ConnectionDTO;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class InfinityBootstrapper
{
    final private ServerThread _serverThread = new ServerThread();

    protected BootstrapDTO _BootstrapDTO;

    public InfinityBootstrapper(BootstrapDTO bootstrapDTO)
    {
        this._BootstrapDTO = bootstrapDTO;
    }

    public InfinityBootstrapper run()
    {
        this._serverThread.start();
        return this;
    }


    private class ServerThread extends Thread
    {
        private ServerSocket _serverSocket;
        public ArrayList<InfinityConnection> connectionArray = new ArrayList<>();



        @Override
        public void run()
        {

            this.setUncaughtExceptionHandler(_BootstrapDTO.getUncaughtExceptionHandler());

            try
            {
                this._serverSocket = new ServerSocket(_BootstrapDTO.getPort());

                while (true)
                {

                    ConnectionDTO connectionDTO = new ConnectionDTO()
                            .impl_join(_BootstrapDTO)
                            .setSocket(this._serverSocket.accept());

                    connectionArray.add(InfinityConnection.join(connectionDTO));
                }

            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        }

        public void stopServer()
        {
            try
            {
                this._serverSocket.close();
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        }
    }
}