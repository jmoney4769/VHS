/*
 * @(#)PetShop.java 1.0 04/07/05
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package govhs.apsc.week21;

import java.awt.*;
import java.awt.event.*;

class PetShop extends Frame {
	
	public PetShop() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting PetShop...");
		PetShop mainFrame = new PetShop();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("PetShop");
		mainFrame.setVisible(true);
	}
}
