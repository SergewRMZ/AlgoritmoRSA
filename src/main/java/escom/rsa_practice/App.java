package escom.rsa_practice;


import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import views.Main;

public class App {
  public static void main (String args[]) {
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new FlatLightLaf());
        UIManager.put("Panel.arc", 100);
        Main main = Main.getInstance();
        SwingUtilities.updateComponentTreeUI(main);
        main.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
