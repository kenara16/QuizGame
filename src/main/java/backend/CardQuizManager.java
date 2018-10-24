package backend;

import Persistence.DBConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class CardQuizManager {
    private List<Card> cards;
    private static CardQuizManager privInstance;

    private CardQuizManager() {}

    private static CardQuizManager GetManager() {
        if(CardQuizManager.privInstance == null) {
            CardQuizManager.privInstance = new CardQuizManager();
        }

        return CardQuizManager.privInstance;
    }

    public static List<Card> Draw4Cards() {
        CardQuizManager pMan = CardQuizManager.GetManager();
        assert (pMan != null);

        pMan.cards = new ArrayList<>();
        DBConnectionManager.Get4CardAnd4Quiz(pMan.cards);
        return pMan.cards;
    }
}
