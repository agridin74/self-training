import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelWrite {
	public static void main(String args[]){
		try(FileChannel fChan = (FileChannel)
			Files.newByteChannel(Paths.get("test.txt"),
					  StandardOpenOption.WRITE,
					  StandardOpenOption.CREATE  ))
		{
			ByteBuffer mBuf = ByteBuffer.allocate(26);
			for(int i=0; i<26; i++)
					  mBuf.put((byte)('A' + i));
			mBuf.rewind();
			fChan.write(mBuf);
		}catch(InvalidPathException e){
			System.out.println("Err path " + e);
		}catch(IOException e){
			System.out.println("Err read-write " + e);
			System.exit(1);
		}
	}
}
