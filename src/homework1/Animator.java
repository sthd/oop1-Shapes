package homework1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * Main application class for exercise #1.
 * This application allows the user to add shapes to a graphical window and
 * to animate them.
 */
@SuppressWarnings("serial")
public class Animator extends JFrame implements ActionListener {

	// preferred frame width and height.
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;

	// graphical components
	private JMenuBar menuBar;
	private JMenu fileMenu, insertMenu, helpMenu;
	private JMenuItem newItem, exitItem,
											triangleItem, ovalItem,
											numberedOvalItem, sectorItem, aboutItem;
	private JCheckBoxMenuItem animationCheckItem;
	private JPanel mainPanel;

	// shapes that have been added to this
	// TODO: Add and initialize a container of shapes called shapes.
	
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * @modifies this
	 * @effects Initializes the GUI and enables a timer that steps animation
	 * 			of all shapes in this 25 times per second while animation
	 * 			checkbox is selected.
	 */
	public Animator()  {
		super("Animator");
		
		// create main panel and menubar
		mainPanel = (JPanel)createMainPanel();
		getContentPane().add(mainPanel);
		menuBar = (JMenuBar)createMenuBar();
        setJMenuBar(menuBar);

        // enable animation timer (ticks 25 times per second)
		// If the animation doesn't work on your computer, increase the first argument of the Timer constructor
		// until you see the animation. Return the number to 40 before submitting the code.
        Timer timer = new Timer(110, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                if (animationCheckItem.isSelected()) {
	                	// TODO: Add code for making one animation step for all
	                	// 		 shapes in this
	                	
	            		java.util.Iterator<Shape> iteratorShapes = shapes.iterator();
	            		iteratorShapes.forEachRemaining((shape)->((LocationChangingShape)shape).step(new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT)));	
	            			         	
	            		repaint();	// make sure that the shapes are redrawn
	                }
	            }
	        });
        timer.start();
	}


	/**
	 * @return main GUI panel.
	 */
	private JComponent createMainPanel() {
    	JPanel mainPanel = new JPanel();
    	mainPanel.setPreferredSize(
    			new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    	mainPanel.setBorder(BorderFactory.createLoweredBevelBorder());
    	mainPanel.setBackground(Color.WHITE);

    	return mainPanel;
	}


	/**
	 * @return main GUI menubar.
	 */
	private JMenuBar createMenuBar() {
    	JMenuBar menuBar = new JMenuBar();

    	fileMenu = new JMenu("File");
    	newItem = new JMenuItem("New");
    	newItem.addActionListener(this);
    	fileMenu.add(newItem);
    	animationCheckItem = new JCheckBoxMenuItem("Animation");
    	fileMenu.add(animationCheckItem);
    	exitItem = new JMenuItem("Exit");
    	exitItem.addActionListener(this);
    	fileMenu.add(exitItem);
    	menuBar.add(fileMenu);

    	insertMenu = new JMenu("Insert");
    	triangleItem = new JMenuItem("Triangle");
    	triangleItem.addActionListener(this);
    	insertMenu.add(triangleItem);
    	ovalItem = new JMenuItem("Oval");
    	ovalItem.addActionListener(this);
    	insertMenu.add(ovalItem);
    	numberedOvalItem = new JMenuItem("Numbered Oval");
    	numberedOvalItem.addActionListener(this);
    	insertMenu.add(numberedOvalItem);
    	sectorItem = new JMenuItem("Sector");
    	sectorItem.addActionListener(this);
    	insertMenu.add(sectorItem);
    	menuBar.add(insertMenu);

    	helpMenu = new JMenu("Help");
    	aboutItem = new JMenuItem("About");
    	aboutItem.addActionListener(this);
    	helpMenu.add(aboutItem);
    	menuBar.add(helpMenu);

    	return menuBar;
	}


	/**
	 * @modifies g
	 * @effects Paint this including all its shapes to g. This method is
	 * 			invoked by Swing to draw components. It should not be invoked
	 * 			directly, but the repaint method should be used instead in
	 * 			order to schedule the component for redrawing.
	 */
	//TODO: Add code for drawing all shapes in this
	public void paint(Graphics g) {
		super.paint(g);
		java.util.Iterator<Shape> iteratorShapes = shapes.iterator();
		iteratorShapes.forEachRemaining((shape)->shape.draw(getContentPane().getGraphics()));	
			
	}


	/**
	 * @modifies this
	 * @effects Invoked when the user selects an action from the menubar
	 * 			and performs the appropriate operation.
	 */
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)(e.getSource());

		// File->New : clear all shapes
		if (source.equals(newItem)) {
			shapes.clear();
			repaint();

			//TODO  Add code for number of LocationChangingNumerOval = 0
			LocationChangingNumberedOval.restartCounter();
		}

		// File->Exit: close application
		else if (source.equals(exitItem)) {
        	dispose();
        }

		// Insert a shape
		else if ((source.equals(triangleItem)) ||
      		 	 (source.equals(ovalItem)) ||
      		 	 (source.equals(numberedOvalItem)) ||
      		 	 (source.equals(sectorItem))) {
			// TODO: Add code for creating the appropriate shape such that:
			// 		 it is completely inside the window's bounds &&
			//		 its location and size are randomly selected &&
			//		 1/10*WINDOW_WIDTH <= shape.width < 3/10*WINDOW_WIDTH &&
			//		 1/10*WINDOW_HEIGHT <= shape.height < 3/10*WINDOW_HEIGHT
			Color color = new Color((int)(Math.random() * 0x1000000));
			Random rand = new Random();
			Dimension dimension = new Dimension(rand.nextInt((int)WINDOW_WIDTH/10,(int)WINDOW_WIDTH*3/10),
					rand.nextInt((int)WINDOW_WIDTH/10,(int)WINDOW_WIDTH*3/10));
			Point point = new Point(rand.nextInt(WINDOW_WIDTH-dimension.width),rand.nextInt(WINDOW_HEIGHT-dimension.height));
			
			LocationChangingShape shape = switch(source.getText()) {
				case "Triangle"->
					 new LocationAndColorChangingTriangle(point,color) ;

				case "Oval"->
					 new LocationChangingOval(point,color) 	;				

				case "Numbered Oval"->
					 new LocationChangingNumberedOval(point,color) ;

				case "Sector"->
					  new AngleChangingSector(point,color);

				default -> new LocationChangingNumberedOval(point,color) ;
			};
			
			try {
				shape.setSize(dimension);
			} catch (ImpossibleSizeException e1) {
				
			}
			shapes.add(shape);
			repaint();
		}

		// Help->About : show about message dialog
		else if (source.equals(aboutItem)){
			JOptionPane.showMessageDialog(
					this,
					"Animator - 1st" +
					" homework assignment",
					"About",
					JOptionPane.INFORMATION_MESSAGE);
		}
    }


	/**
	 * @effects Animator application.
	 */
	public static void main(String[] args) {
        Animator application = new Animator();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setResizable(false);
        application.pack();
        application.setVisible(true);
	}
}
