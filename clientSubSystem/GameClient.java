package clientSubSystem;


import ocsf.client.AbstractClient;
import gameInterface.*;
import gameInterface.Error;


public class GameClient extends AbstractClient
{
  // Private data fields for storing the GUI controllers.
  private LoginControl loginControl;
  private CreateAccountControl createAccountControl;
  private CharacterSelectControl characterSelectControl;
  private GameLobbyControl gameLobbyControl;
  private P1GameArenaControl gameArenaControl1;
  private P2GameArenaControl gameArenaControl2;

  // Setters for the GUI controllers.
  public void setLoginControl(LoginControl loginControl)
  {
    this.loginControl = loginControl;
  }
  public void setCreateAccountControl(CreateAccountControl createAccountControl)
  {
    this.createAccountControl = createAccountControl;
  }
  
  public void setCharacterSelectControl(CharacterSelectControl characterSelectControl) {
	  this.characterSelectControl = characterSelectControl;
  }
  
  public void setGameLobbyControl(GameLobbyControl gameLobbyControl) {
	  this.gameLobbyControl = gameLobbyControl;
  }
  
  public void setGameArenaControl1(P1GameArenaControl gameArenaControl1) {
	  this.gameArenaControl1 = gameArenaControl1;
  }
  public void setGameArenaControl2(P2GameArenaControl gameArenaControl2) {
	  this.gameArenaControl2 = gameArenaControl2;
  }



  // Constructor for initializing the client with default settings.
  public GameClient()
  {
    super("localhost", 8300);
  }
  
  // Method that handles messages from the server.
  public void handleMessageFromServer(Object arg0)
  {
    // If we received a String, figure out what this event is.
    if (arg0 instanceof String)
    {
      // Get the text of the message.
      String message = (String)arg0;
      
      // If we successfully logged in, tell the login controller.
      if (message.equals("LoginSuccessful"))
      {
        loginControl.loginSuccess();
      }
      
      // If we successfully created an account, tell the create account controller.
      else if (message.equals("CreateAccountSuccessful"))
      {
        createAccountControl.createAccountSuccess();
      }
      else if (message.equals("Player1 Found"))
      {
        gameLobbyControl.p1Found();
      }
      else if (message.equals("Player2 Found"))
      {
        gameLobbyControl.p2Found();
      }
      else if (message.equals("CharacterSelected"))
      {
        characterSelectControl.CharacterSelectSuccess();
      }
    }
    
    // If we received an Error, figure out where to display it.
    else if (arg0 instanceof Error)
    {
      // Get the Error object.
      Error error = (Error)arg0;
      
      // Display login errors using the login controller.
      if (error.getType().equals("Login"))
      {
        loginControl.displayError(error.getMessage());
      }
      
      // Display account creation errors using the create account controller.
      else if (error.getType().equals("CreateAccount"))
      {
        createAccountControl.displayError(error.getMessage());
      }
    }
  }  
}

