import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTest{
	public static void main(String[] args){
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit proogram?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener{
	public void actionPerformed(ActionEvent event){
		Date now = new Date();
		System.out.println("==>>>"+ now);
		Toolkit.getDefaultToolkit().beep();
	}
}
