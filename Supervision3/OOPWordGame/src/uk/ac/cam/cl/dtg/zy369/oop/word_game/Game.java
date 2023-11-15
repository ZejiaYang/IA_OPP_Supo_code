package uk.ac.cam.cl.dtg.zy369.oop.word_game;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import uk.ac.cam.cl.dtg.zy369.oop.word_game.grid.*;
/**
 * Game This is a basic class that can be modified to create a word game.
 * 
 * Hint: Can this class be converted into a singleton?
 * 
 * @author Stephen Cummins
 * @version 1.0 Released 11/10/2005
 */
public class Game extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates an instance of the Game.
	 */
	public Game() {
		// build the GUI as soon as the default constructor is called.
		buildGUI();
	}

	/**
	 * This method will construct each element of the game's GUI
	 */
	public void buildGUI() {
		final JFrame frame = new JFrame("Java Word Game");

		TileCollection collection = new TileCollection();
		final Grid grid = new Grid(6, 6, collection);
		final GridGUI gui = new GridGUI(grid);
		gui.setBackground(Color.PINK);
		final Move move = new Move(grid, gui);
		final Font font = new Font("Times New Roman", Font.BOLD, 15);
		final Border border = new BevelBorder(BevelBorder.RAISED, Color.orange, Color.red);
		final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 0));
		final JButton button1 = new JButton("Accept Word");
		final JButton button2 = new JButton("New Game");
		button1.setFont(font);
		button2.setFont(font);
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.setBackground(Color.PINK);

		final JPanel labelPanel = new JPanel(new GridLayout(2, 2));
		final JLabel score = new JLabel("Current Score");
		final JLabel scoredisplay = new JLabel("0");
		final JLabel word = new JLabel("Current Word");
		final JLabel worddisplay = new JLabel("");
		final JLabel[] display= {score, scoredisplay, word, worddisplay};

		for(JLabel label: display){
			label.setFont(font);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBorder(border);
			labelPanel.add(label);
		}
		labelPanel.setBackground(Color.PINK);

		gui.setTileForeground(Color.orange);
		gui.setTileBackground(Color.white);
		gui.setBackground(Color.PINK);


		gui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Tile source = (Tile) actionEvent.getSource();
				if(move.validMove(source))
					move.nextMove(source);
				else{
					move.resetMove(source);
				}
				worddisplay.setText(move.getProgressWord());
			}
		});

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = move.getProgressWord();
				boolean ac = move.acceptWord();
				scoredisplay.setText("" + move.getscore());
				if(grid.isOver()) {
					worddisplay.setText("Congratulation!");
				}else if(ac){
					worddisplay.setText("Accepted:  " + word);
				}else{
					worddisplay.setText("Unaccepted:  " + word);
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				grid.reset();
				gui.setTileForeground(Color.orange);
				gui.setTileBackground(Color.white);
				move.resetGame();
				scoredisplay.setText(""+move.getscore());
				worddisplay.setText(move.getProgressWord());
			}
		});

		frame.setTitle("Java Word Game");

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(gui, BorderLayout.WEST);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		frame.getContentPane().add(labelPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setResizable(false);
		frame.toFront();

		frame.setBackground(Color.PINK);
		frame.setVisible(true);
	}
}