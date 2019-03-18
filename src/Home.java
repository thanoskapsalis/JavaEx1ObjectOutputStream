import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame {



    public Home() {

        //basic UI Loading

        //window//
        super("Διαχείρηση Ερευνητικών Π.Αιγαίου");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //END//

        //Window Controls//
        JLabel label = new JLabel("Παρακάτω μπορείτε είτε να προσθέσετε είτε να αναζητήσετε δημοσιεύσεις");
        JButton add_new = new JButton("Προσθήκη");
        JButton search = new JButton("Αναζήτηση");
        //END//

        add(label);
        add(add_new);
        add(search);
        //END//

        //ActionControllers

        //Ανάλογα με την επιλογή του χρήστη για το άμα θέλει να προσθέσει ή να αναζητήσει μια δημοσίευση  υπάρχει το κατάλληλο κουμπί
        //Που τον πηγαίνει στο κατάλληλο παράθυρο
        add_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new NewItem().setVisible(true);


            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search().setVisible(true);
            }
        });



    }
}
