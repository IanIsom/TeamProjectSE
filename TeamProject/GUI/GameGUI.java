package GUI;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clientSubSystem.CreateAccountControl;
import clientSubSystem.GameClient;
import clientSubSystem.LoginControl;
import gameInterface.CharacterSelectControl;
import gameInterface.GameLobbyControl;


public class GameGUI extends JFrame
{
  
  
  // Constructor that creates the client GUI.
  public GameGUI()
  {
    // Set up the chat client.
    GameClient client = new GameClient();
    client.setHost("localhost");
    client.setPort(8300);
    try
    {
      client.openConnection();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    
    
    // Set the title and default close operation.
    this.setTitle("Game Client");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    // Create the card layout container.
    CardLayout cardLayout = new CardLayout();
    JPanel container = new JPanel(cardLayout);
    
    //Create the Controllers next
    //Next, create the Controllers
    InitialControl ic = new InitialControl(container,client);
    LoginControl lc = new LoginControl(container,client);
    CreateAccountControl cac = new CreateAccountControl(container,client);
    CharacterSelectControl cs = new CharacterSelectControl(container, client);
    
    //Set the client info
    client.setLoginControl(lc);
    client.setCreateAccountControl(cac);
    client.setCharacterSelectControl(cs);
   
    
    // Create the four views. (need the controller to register with the Panels
    JPanel view1 = new InitialPanel(ic);
    JPanel view2 = new LoginPanel(lc);
    JPanel view3 = new CreateAccountPanel(cac);
    JPanel view4 = new CharacterSelectPanel(cs);
    
    // Add the views to the card layout container.
    container.add(view1, "1");
    container.add(view2, "2");
    container.add(view3, "3");
    container.add(view4, "4");
   
    
    // Show the initial view in the card layout.
    cardLayout.show(container, "1");
    
    // Add the card layout container to the JFrame.
    // GridBagLayout makes the container stay centered in the window.
    this.setLayout(new GridBagLayout());
    this.add(container);

    // Show the JFrame.
    this.setSize(550, 350);
    this.setVisible(true);
  }

  // Main function that creates the client GUI when the program is started.
  public static void main(String[] args)
  {
	  //starts
    new GameGUI();
  }
}

