import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class LoggingImageViewer{
	public static void main(String[] args){
		if(System.getProperty("java.util.logging.config.class") == null
			&& System.getProperty("java.util.logging.config.file") == null){
				try{
					Logger.getLogger(LoggingImageViewer.class).setLevel(Level.ALL);
					final int LOG_ROTATION_COUNT = 10;
					Handler handler = new FileHandler(
						"%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
					Logger.getLogger(LoggingImageViewer.class).addHandler(handler);
				}catch(IOException e){
					Logger.getLogger(LoggingImageViewer.class).log(Level.SEVERE,
										 "err", e);
				}
			}
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				Handler windowHandler = new WindowHandler();
				windowHandler.setLevel(Level.ALL);
				Logger.getLogger(Logging.ImageViewer.class).
						  addHandler(windowHandler);
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("LoggingImageViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Logger.getLogger(LoggingImageViewer.class).fine("Showing frame");
				frame.setVisible(true);
			}
		});
	}
}


