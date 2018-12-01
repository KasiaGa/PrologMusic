/**
 * Created by kasia on 26.11.18.
 */
import javafx.scene.control.*;

import java.awt.*;
import java.awt.Label;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JPanel
        implements ItemListener {
    JCheckBox chinButton;
    JCheckBox glassesButton;
    JCheckBox hairButton;
    JCheckBox teethButton;

    private java.util.List<JCheckBox> pozytywne = new ArrayList<>();
    private java.util.List<JCheckBox> negatywne = new ArrayList<>();
    private java.util.List<JCheckBox> nastroj = new ArrayList<>();
    private java.util.List<JCheckBox> okres = new ArrayList<>();
    private java.util.List<JCheckBox> instrument = new ArrayList<>();

    private Prolog prolog = new Prolog();

    private JRadioButton yes = new JRadioButton("Tak");
    private JRadioButton no = new JRadioButton("Nie");

    StringBuffer choices;

    public GUI() {
        super(new GridLayout(8, 2));

        prolog.initialize();

        JPanel checkPanel = new JPanel(new GridLayout(5, 3));
        JPanel checkPanel1 = new JPanel(new GridLayout(5, 2));
        JPanel checkPanel2 = new JPanel(new GridLayout(1, 1));
        JPanel checkPanel3 = new JPanel(new GridLayout(5, 1));
        JPanel radioPanel = new JPanel(new GridLayout(1, 2));

        AttributesForUserChoice attributesForUserChoice = new AttributesForUserChoice();

        for (String s : attributesForUserChoice.getInstrument()) {
            JCheckBox jCheckBox = new JCheckBox(s);
            instrument.add(jCheckBox);
            checkPanel.add(jCheckBox);
        }

        for (String s : attributesForUserChoice.getOkres()) {
            JCheckBox jCheckBox = new JCheckBox(s);
            okres.add(jCheckBox);
            checkPanel1.add(jCheckBox);
        }

        for (String s : attributesForUserChoice.getNastroj()) {
            JCheckBox jCheckBox = new JCheckBox(s);
            nastroj.add(jCheckBox);
            checkPanel2.add(jCheckBox);
        }

        for (String s : attributesForUserChoice.getPozytywne()) {
            JCheckBox jCheckBox = new JCheckBox(s);
            pozytywne.add(jCheckBox);
            checkPanel3.add(jCheckBox);
        }

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(yes);
        radioButtonGroup.add(no);
        radioPanel.add(yes);
        radioPanel.add(no);

        JLabel label = new JLabel();


        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
                getCheckBoxResult();
                label.setText(prolog.getResult());
            }
        });


        add(new Label("Instrumenty"));
        add(new Label("Okres"));
        add(checkPanel);
        add(checkPanel1);
        add(new Label("Nastrój"));
        add(new Label("Dodatkowe wymagania"));
        add(checkPanel2);
        add(checkPanel3);
        add(new Label("Wokal"));
        add(new JPanel());
        add(radioPanel);
        add(new JPanel());
        add(submit);
        add(label);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new GUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public void getCheckBoxResult() {
        prolog.pozytywne.clear();
        prolog.instrument.clear();
        prolog.nastroj.clear();
        prolog.okres.clear();
        prolog.negatywne.clear();

        for (JCheckBox checkBox : pozytywne) {
            if (checkBox.isSelected()) {
                prolog.pozytywne.add(checkBox.getText());
            }
        }

        for (JCheckBox checkBox : instrument) {
            if (checkBox.isSelected()) {
                prolog.instrument.add(checkBox.getText());
            }
        }

        for (JCheckBox checkBox : nastroj) {
            if (checkBox.isSelected()) {
                prolog.nastroj.add(checkBox.getText());
            }
        }

        for (JCheckBox checkBox : okres) {
            if (checkBox.isSelected()) {
                prolog.okres.add(checkBox.getText());
            }
        }

        if (yes.isSelected()) {
            prolog.pozytywne.add("wokal");
        } else if (no.isSelected()) {
            prolog.negatywne.add("wokal");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}