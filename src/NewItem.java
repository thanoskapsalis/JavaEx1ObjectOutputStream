import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class NewItem extends JFrame {
    public NewItem() {
        super("Προσθήκη νεου στοιχείου");

        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));


        //Κατασκευάζουμε ενα GridLayout για την καλύτερη κατανομή χώρου στο παράθυρο μιας και θα υπάρχει αρκετή πληροφορία
        //Έχουμε ένα menu που ο χρήστης επιλέγει τι είδους δημοσίευση θέλει να προσθέσει (περιοδικού η συνεδρίου)
        //Αφού επιλέγει πατάει submit και υστερα φορτόνωνται τα αντίστοιχα στοιχεία για εισαγωγή

        //PHASE1 CHOOSE TYPE OF POST//
        String[] choises = {"Περιοδικο", "Συνέδριο"};
        JLabel place = new JLabel("Πεδίο Δημοσίευσης:");
        place.setBounds(65, 68, 46, 14);
        final JComboBox<String> cb = new JComboBox<String>(choises);
        cb.setBounds(128, 65, 86, 20);
        add(cb);
        JButton submit = new JButton("Επιλογή");
        add(submit);
        //END//

        //COMMON ITEMS (still DISABLED)//
        JLabel title = new JLabel("Τίτλος");
        add(title);
        title.setVisible(false);

        JTextField title_val = new JTextField();
        add(title_val);
        title_val.setVisible(false);

        JLabel writer = new JLabel("Συγγραφείς");
        add(writer);
        writer.setVisible(false);

        JTextField writer_val = new JTextField();
        add(writer_val);
        writer_val.setVisible(false);

        JButton save = new JButton("Αποθήκευση");

        //END//

        //Άνάλογα με την επιλογή του χρήστη εμφανίζονται οι φόρμες που χρειαζόμαστε
        //Καθώς και το SAVE button που έχει και δύο διαφορετικά Action Listener(ανάλογα τι πρέπει να προσθέσει)
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println(cb.getSelectedItem().toString());
                if (cb.getSelectedItem().equals("Περιοδικο")) {

                    title.setVisible(true);
                    title_val.setVisible(true);
                    writer.setVisible(true);
                    writer_val.setVisible(true);

                    //Case Items//
                    JLabel magazine = new JLabel("Τίτλος Περιοδικού");
                    add(magazine);
                    //magazine.setVisible(false);
                    magazine.setVisible(true);

                    JTextField magazine_val = new JTextField();
                    add(magazine_val);
                    //magazine_val.setVisible(false);
                    magazine_val.setVisible(true);

                    JLabel page_num = new JLabel("Αριθμός Σελίδων");
                    add(page_num);
                    //page_num.setVisible(false);
                    page_num.setVisible(true);

                    JTextField page_num_val = new JTextField();
                    add(page_num_val);
                    //page_num_val.setVisible(false);
                    page_num_val.setVisible(true);

                    JLabel year = new JLabel("Έτος δημοσίευσης");
                    add(year);
                    //year.setVisible(false);
                    year.setVisible(true);

                    JTextField year_val = new JTextField();
                    add(year_val);
                    //year_val.setVisible(false);
                    year_val.setVisible(true);

                    JLabel volume = new JLabel("Τόμος");
                    add(volume);
                    //volume.setVisible(false);
                    volume.setVisible(true);

                    JTextField volume_val = new JTextField();
                    add(volume_val);
                    // volume_val.setVisible(false);
                    volume_val.setVisible(true);

                    JLabel mag_page = new JLabel("Σελίδα Τόμου");
                    add(mag_page);
                    // mag_page.setVisible(false);
                    mag_page.setVisible(true);

                    JTextField mag_page_val = new JTextField();
                    add(mag_page_val);
                    //mag_page_val.setVisible(false);
                    mag_page_val.setVisible(true);
                    add(save);

                    save.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Magazine_Post mag = new Magazine_Post("MAG", title_val.getText(), writer_val.getText(), magazine_val.getText(), page_num_val.getText(), year_val.getText(), volume_val.getText(), mag_page_val.getText());
                            //Προσθήκη στην αρχική ArrayList
                            Exercise1.posts.add(mag);
                            ObjectOutputStream out = null;

                            try {

                                //ADDING ARRAYLIST TO FILE
                                //Κάθε φορά που προστίθεται μια δησμοσίευση πρώτα κανει extend την arrayList και ύστερα
                                //Περνάμε ολη την ArrayList κάθε φορά στο αρχείο (κάτι σαν refresh ωστε να μπορούμε να κρατάμε και τα παλία
                                out = new ObjectOutputStream(new FileOutputStream("object.txt"));
                                for (int i = 0; i < Exercise1.posts.size(); i++) {
                                    out.writeObject(Exercise1.posts.get(i));
                                }
                                out.close();
                                //END

                            } catch (FileNotFoundException ex) {
                                System.out.println(ex);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            } finally {
                                //Όταν όλα πάνε καλά το πρόγραμμα ενημερώνει τον χρήστη για την προσθήκη και κλείνει το frame
                                JOptionPane.showMessageDialog(null, "Προστέθηκε με επιτυχία");
                                setVisible(false);
                            }
                        }
                    });

                    //END//

                    //Ακολουθούμε την ίδια διαδικασία
                } else if (cb.getSelectedItem().equals("Συνέδριο")) {
                    title.setVisible(true);
                    title_val.setVisible(true);
                    writer.setVisible(true);
                    writer_val.setVisible(true);

                    JLabel con_name = new JLabel("Όνομα Συνεδρίου");
                    add(con_name);
                    //volume.setVisible(false);
                    con_name.setVisible(true);

                    JTextField con_name_val = new JTextField();
                    add(con_name_val);
                    // volume_val.setVisible(false);
                    con_name_val.setVisible(true);

                    JLabel date = new JLabel("Ημερομηνία διεξαγωγής");
                    add(date);
                    //volume.setVisible(false);
                    date.setVisible(true);

                    JTextField date_val = new JTextField();
                    add(date_val);
                    // volume_val.setVisible(false);
                    date_val.setVisible(true);

                    JLabel location = new JLabel("Τοποθεσία");
                    add(location);
                    //volume.setVisible(false);
                    location.setVisible(true);

                    JTextField location_val = new JTextField();
                    add(location_val);
                    // volume_val.setVisible(false);
                    location_val.setVisible(true);
                    add(save);

                    save.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Conference_Post mag = new Conference_Post("CON", title_val.getText(), writer_val.getText(), con_name_val.getText(), date_val.getText(), location_val.getText());
                            //Προσθήκη στο ArrayList
                            Exercise1.posts.add(mag);
                            ObjectOutputStream out = null;

                            try {
                                //Refresh file
                                out = new ObjectOutputStream(new FileOutputStream("object.txt"));
                                for (int i = 0; i < Exercise1.posts.size(); i++) {
                                    out.writeObject(Exercise1.posts.get(i));
                                }
                                out.close();

                            } catch (FileNotFoundException ex) {
                                System.out.println(ex);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            } finally {
                                //all fine
                                JOptionPane.showMessageDialog(null, "Προστέθηκε με επιτυχία");
                                setVisible(false);
                            }
                        }
                    });

                }


            }
        });

    }

}
