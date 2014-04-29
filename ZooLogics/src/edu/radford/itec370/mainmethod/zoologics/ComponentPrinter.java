package edu.radford.itec370.mainmethod.zoologics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;

import javax.print.attribute.HashPrintRequestAttributeSet;

public class ComponentPrinter implements Printable {

	private Component comp;
	
	private ComponentPrinter() {
		super();
	}
	
	public ComponentPrinter(Component comp) {
		this();
		this.comp = comp;
	}

	public static void preview(Component comp) {
		ComponentPrinter printable = new ComponentPrinter(comp);
		HashPrintRequestAttributeSet att = new HashPrintRequestAttributeSet();
		PrinterJob pj = PrinterJob.getPrinterJob();
		new PrintPreview(printable, pj.getPageFormat(att));
	}
	
	public static void runPrintJob(Component comp) {
		ComponentPrinter printable = new ComponentPrinter(comp);
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(printable);
		boolean doPrint = job.printDialog();
		if (doPrint) {
		    try {
		        job.print();
		    } catch (PrinterException e) {
		        // The job did not successfully
		        // complete
		    }
		}
	}
	
	public int print(Graphics g, PageFormat pf, int pageNumber)
			throws PrinterException {
		if (pageNumber > 0) {
			return Printable.NO_SUCH_PAGE;
		}

		// Get the preferred size of the component...
//		Dimension compSize = comp.getPreferredSize();
		Dimension compSize = comp.getSize();
		// Make sure we size to the preferred size
//		comp.setSize(compSize);
		// Get the the print size
		Dimension printSize = new Dimension();
		printSize.setSize(pf.getImageableWidth(), pf.getImageableHeight());

		// Calculate the scale factor
		double scaleFactor = getScaleFactorToFit(compSize, printSize);
		// Don't want to scale up, only want to scale down
		if (scaleFactor > 1d) {
			scaleFactor = 1d;
		}

		// Calculate the scaled size...
		double scaleWidth = compSize.width * scaleFactor;
		double scaleHeight = compSize.height * scaleFactor;

		// Create a clone of the graphics context.  This allows us to manipulate
		// the graphics context without begin worried about what effects
		// it might have once we're finished
		Graphics2D g2 = (Graphics2D) g.create();
		// Calculate the x/y position of the component, this will center
		// the result on the page if it can
		double x = ((pf.getImageableWidth() - scaleWidth) / 2d) + pf.getImageableX();
		double y = ((pf.getImageableHeight() - scaleHeight) / 2d) + pf.getImageableY();
		// Create a new AffineTransformation
		AffineTransform at = new AffineTransform();
		// Translate the offset to out "center" of page
		at.translate(x, y);
		// Set the scaling
		at.scale(scaleFactor, scaleFactor);
		// Apply the transformation
		g2.transform(at);
		// Print the component
		comp.printAll(g2);
		// Dispose of the graphics context, freeing up memory and discarding
		// our changes
		g2.dispose();

		comp.revalidate();
		return Printable.PAGE_EXISTS;
	}

    public static double getScaleFactorToFit(Dimension original, Dimension toFit) {
        double dScale = 1d;
        if (original != null && toFit != null) {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }

    public static double getScaleFactor(int iMasterSize, int iTargetSize) {
        double dScale = 1;
        if (iMasterSize > iTargetSize) {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } else {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;
    }

}
