package com.Federico;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
/**
 * Created by Federico on 12/3/2016.
 */
public class TicketGUI extends JFrame {
    private JPanel RootPanel;
    private JList <Ticket> UnresolvedList;
    private JTextField IDField;
    private JTextField DescriptionField;
    private JComboBox PriorityBox;
    private JButton solveTicketButton;
    private JButton addTicketButton;
    private JList <Ticket> ResolvedList;
    private JButton quitButton;
    private JButton deleteTicketButton;

    DefaultListModel<Ticket> UnresolvedListModel;
    DefaultListModel<Ticket> SolvedListModel;

    protected TicketGUI() {
        this.setContentPane(RootPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configureRatings();
        pack();
        setVisible(true);

        UnresolvedListModel = new DefaultListModel<>();
        UnresolvedList.setModel(UnresolvedListModel);
        SolvedListModel = new DefaultListModel<>();
        ResolvedList.setModel(SolvedListModel);


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TicketID = IDField.getText();
                String Description = DescriptionField.getText();
                String priority = PriorityBox.getSelectedItem().toString();


                Ticket addedElement = new Ticket(TicketID, Description, priority, new Date());
                UnresolvedListModel.addElement(addedElement);//Adding the ticket element to the JList

            }
        });

        deleteTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticket toDelete;

                        toDelete = UnresolvedList.getSelectedValue();
                        if (toDelete == null) {
                            JOptionPane.showMessageDialog(TicketGUI.this, "None selected");
                            return;
                        }
                        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(TicketGUI.this, "Are you sure you want to delete?", "Delete?", JOptionPane.OK_CANCEL_OPTION)) {
                            UnresolvedList.clearSelection();
                            UnresolvedListModel.removeElement(toDelete);

                            // toDelete = addTicketsJList.clearSelection();
                            UnresolvedList.clearSelection();
                        }


                    UnresolvedList.clearSelection();

                }

            });
        solveTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticket toSolve = UnresolvedList.getSelectedValue();

                SolvedListModel.addElement(toSolve);
                UnresolvedListModel.removeElement(toSolve);
                UnresolvedList.clearSelection();
            }
        });


    }



        private void configureRatings(){
            for (int x = 1; x <= 5; x++){
                PriorityBox.addItem(x);
            }
    }







}

