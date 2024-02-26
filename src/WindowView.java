package src;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 *  Write more actionListeners and wire the rest of the buttons
 **/

public class WindowView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member

    CarView carView;

    public WindowView(String framename, CarView cv){
        this.carView = cv;
        initComponents(framename);
    }



    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");

    // Constructor


    // Sets everything in place and fits everything
    // Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(carView);



        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));


        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);


        controlPanel.add(startButton, 3);
        controlPanel.add(stopButton, 4);
        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOffButton, 6);


        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(addCarButton, 8);
        controlPanel.add(removeCarButton, 9);
        controlPanel.setPreferredSize(new Dimension((X - 100), 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.lightGray);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
//        startButton.setPreferredSize(new Dimension(X/7-15,100));
//        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
//        stopButton.setPreferredSize(new Dimension(X/7-15,100));
//        this.add(stopButton);

        addCarButton.setBackground(Color.red);
        addCarButton.setForeground(Color.black);
//        addCarButton.setPreferredSize(new Dimension(X/7-15,100));
//        this.add(addCarButton);

        // This actionListener is for the gas button only
        // Create more for each component as necessary


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}