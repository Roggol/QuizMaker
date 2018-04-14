package Quizzle;

import javax.swing.JLabel;

public class GUImanager {//This function is taken from: http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
	
	public void Font(JLabel label, int font){		
		java.awt.Font labelFont = label.getFont();
		String labelText = label.getText();
		int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = label.getWidth();
		double widthRatio = (double)componentWidth / (double)stringWidth;
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();		
		int fontSizeToUse = Math.min(newFontSize, componentHeight);	
		label.setFont(new java.awt.Font(labelFont.getName(), font, fontSizeToUse));				
	}

	}
