import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.geometry.Pos;

import java.io.Serializable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Search extends JFrame {

    //Η ArrayList reloaded διαβάζει τα αντικείμενα απο το αρχείο και τα αποθηκεύει σε αυτη για ευκολότερη διαχείρηση
    public static ArrayList<Post> reloaded = new ArrayList<>();
    public boolean cont = true;


    public Search() {
        super("Αναζήτηση");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        //basic UI//
        JLabel label = new JLabel("Εισάγετε την μεταβλητη αναζήτησης");
        JTextField to_search = new JTextField();
        JButton print_all = new JButton("Εμφάνιση όλων");
        JButton submit = new JButton("Επιλογή");
        add(label);
        add(to_search);
        add(submit);
        add(print_all);

        //με το που φορτωσουν τα γραφικά κάνω το αρχείο arrayList
        reload_file();


        //magazine Posts
        JLabel label1 = new JLabel("Δημοσιεύσεις Περιοδικών");
        JTextArea mag_output = new JTextArea();
        mag_output.setEditable(false);
        add(label1);
        add(mag_output);
        mag_output.append("Τίτλος     Συγργραφέας     Περιοδικό     Αριθμός Σελ.     Έτος Κυκλοφορίας     Τόμος     Σελίδα" + "\n");
        //END

        //Conference Posts
        JLabel label2 = new JLabel("Δημοσιεύσεις Περιοδικών");
        JTextArea con_output = new JTextArea();
        mag_output.setEditable(false);
        add(label2);
        add(con_output);
        con_output.append("Τίτλος     Συγργραφέας     Όνομα Συν.     Ημερομηνία Περιοχή" + "\n");
        //END//


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < reloaded.size(); i++) {
                    //Ελέγχουμε αν το περιεχόμενο που έδωσε ο χρήστης αντοιστιχεί σε τίτλο δημοσίευσης και όνομα συγγραφέα
                    //αν ναι το εμφανίζει στην κατάλληλη κατηγορία
                    if (to_search.getText().equals(reloaded.get(i).getTitle())
                            || to_search.getText().equals(reloaded.get(i).getWriter())) {
                        if (reloaded.get(i).getID().equals("MAG"))
                            mag_output.append(reloaded.get(i).toString()+"\n");
                        if (reloaded.get(i).getID().equals("CON"))
                            con_output.append(reloaded.get(i).toString()+"\n");

                    }
                }
            }
        });

        print_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Εμφανίζονται όλα χρησιμοποιούμε το ID ώστε να μπορούμε να διαλέξουμε το κατάλληλο πεδίο εμφάνισης
                for (int i = 0; i < reloaded.size(); i++) {
                    if (reloaded.get(i).getID().equals("MAG"))
                        mag_output.append(reloaded.get(i).toString()+"\n");
                    if (reloaded.get(i).getID().equals("CON"))
                        con_output.append(reloaded.get(i).toString()+"\n");
                }
            }


        });


    }

    public void reload_file() {

        //Διαβάζω όλό το  αρχείο μέχρι να φτάσω στο τέλος του αρχείου
        //Για να το πετύχω αυτό έχω μια μεταβλητή boolean που γίνεται false ώστε να σταματήσει η επανάληψη
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.txt"));
            while (cont) {
                Post post = (Post) in.readObject();
                if (post != null)
                    reloaded.add(post);
                else
                    cont = false;
            }

            //System.out.println(post);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < reloaded.size(); i++) {
            System.out.println(reloaded.get(i));
        }
    }


}
