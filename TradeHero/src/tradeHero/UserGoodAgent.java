package tradeHero;

import jade.lang.acl.ACLMessage;
import sajas.core.behaviours.CyclicBehaviour;

public class UserGoodAgent extends UserAgent {
	
	public UserGoodAgent() {
		super();
	}
	
	@Override
	public void setup() {
		super.commonSetup();
		
		addBehaviour(new ResultsListener());
	}
	
	private class ResultsListener extends CyclicBehaviour {
		private static final long serialVersionUID = 1L;

		@Override
        public void action() 
        {
			ACLMessage inform = myAgent.receive();
			if (inform!=null)
               System.out.println( " - " + myAgent.getLocalName() + " <- " + inform.getContent() );
			block();
        }
    }

}
