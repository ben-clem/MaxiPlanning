package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ConnectionPanel;

// The Controller coordinates interactions
// between the View and Model

public class ConnectionPanelController {
	
    // ATTRIBUTS
    
	private ConnectionPanel theView;
	// model ?
	
    // METHODES
    
    // public ConnectionPanelController(ConnectionPanel theView, Model? theModel) {
    
	public ConnectionPanelController(ConnectionPanel theView) {
		this.theView = theView;
		//this.theModel = theModel;
		
        // On connecte l'ActionListener à la vue
		this.theView.addConnButtonListener(new ConnButtonListener());
	}
	
    // On implémente l'ActionListener
	class ConnButtonListener implements ActionListener{

        String email, password = "null";
        
        @Override
		public void actionPerformed(ActionEvent event) {
			
			try{
			
                email = theView.getEmail();
                password = theView.getPassword();
                
                //theModel -> aller checker dans DB
                
                //theView? -> si c'est bon, rediriger, sinon reset
                
				theView.popupMessage("On va chercher dans la DB.\nmais reste tranquille frr c'est pas fait encore");
			
			}

			catch(Exception e){
				
				System.out.println(e);
				
				theView.popupMessage("Erreur");
				
			}
			
		}
		
	}
	
}