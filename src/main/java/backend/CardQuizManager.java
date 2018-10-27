package backend;

import Persistence.DBConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class CardQuizManager {
    //private List<Card> cards;
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

        List<Card> newCards = new ArrayList<>();
        DBConnectionManager.Get4CardAnd4Quiz(newCards);
        return newCards;
    }

    public static Question DrawAQuestionFromRevealedCard() {
        CardQuizManager pMan = CardQuizManager.GetManager();
        assert (pMan != null);

        Question question = DBConnectionManager.GetAQuestionFromRevealedCardFromMongoDB();
        return question;
    }
}
