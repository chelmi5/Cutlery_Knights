package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//a button listener that 
public class ButtonListener implements ActionListener {
	//callback method
	Callback cb;
	
	public ButtonListener(Callback c) {
		this.cb = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cb.invoke();
	}

}
