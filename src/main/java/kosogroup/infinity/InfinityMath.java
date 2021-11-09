package kosogroup.infinity;

import java.nio.ByteBuffer;

public class InfinityMath
{

    public static byte[] toBytes(int value)
    {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static int toInteger(byte[] bytes)
    {
        return ByteBuffer.wrap(bytes).getInt();
    }
}
