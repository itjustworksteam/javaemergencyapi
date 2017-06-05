package it.itjustworks.emergency;

public class ItalianLanguage implements Language {

	@Override
	public String country() {
		return "Tu sei in ";
	}

	@Override
	public String city() {
		return " e la citta' piu' vicina e' ";
	}
	
	@Override
	public String start() {
		String output = "";
		output += "Benvenuto! " + Emoji.hello() + " Con questo bot tu puoi avere i numeri di emergenza " + Emoji.sos() + ""
				+ "della nazione semplicemente inviando la tua posizione " + Emoji.location() + ".\nPer altro premi su /help o"
				+ "semplicemente premi il bottone \"SEND YOUR LOCATION\" " + Emoji.below();
		return output;
	}

	@Override
	public String help() {
		String output = "";
		output += "Questo bot ha bisogno solamente della tua posizione.\n"
				+ "Per far questo clicca sul bottone della tastiera 'SEND YOUR LOCATION' per inviare la tua posizione.\n\n"
				+ "Tutti i comandi sono:\n"
				+ "/start - avvia la chat.\n"
				+ "/help - mostra questo messaggio.\n"
				+ "/credits - scopri chi ha sviluppato il bot.\n"
				+ "/contribute - contribuisci allo sviluppo del bot.\n"
				+ "/feedback - dicci cosa ne pensi.\n";
		return output;
	}
	
	@Override
	public String feedback() {
		String output = "";
		output += "Se hai una qualsiasi domanda o hai bisogni di aiuto, per favore usa il nostro bot di supporto: @itjustworksbot.\n"
				+ "Ti risponderemo il prima possibile!";
		return output;
	}

	@Override
	public String invalid() {
		String output = "";
		output += "Comando non valido. Per favore clicca /help per più informazioni.";
		return output;
	}

}
