import javax.swing.*;
public class Sort extends JFrame {

	public Sort() {
		super("Sortowanie");
		JPanel Displaying = new Displaying();
		add(Displaying);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(620, 310);
		setLocation(50,50);
		
	}
}