package sn.ndongoinformatique.forage;

import java.util.ArrayList;
import java.util.List;

public class ClientForage extends Personne {

	public ClientForage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientForage(String codePersonne, String prenomPersonne, String nomPersonne, Village villageClient) {
		super(codePersonne, prenomPersonne, nomPersonne, villageClient);
		// TODO Auto-generated constructor stub
	}

	public ClientForage(String codePersonne, String prenomPersonne, String nomPersonne) {
		super(codePersonne, prenomPersonne, nomPersonne);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}


}
