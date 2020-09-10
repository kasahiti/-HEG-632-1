import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognized, one of the default responses is randomly chosen.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 */
public class Responder
{
    // Ne pas modifier cette classe !
    
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    
    public String generateResponse(HashSet<String> words)
    {
        for (String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        
        // If we get here, none of the words from the input line was recognized.
        // In this case we pick one of our default responses (what we say when
        // we cannot think of anything else to say...)
        return pickDefaultResponse();
    }

    /**
     * Enter all the known keywords and their associated responses
     * into our response map.
     */
    private void fillResponseMap()
    {
        responseMap.put("1", 
                        "Voici la liste de vos abonnements :");
        responseMap.put("2", 
                        "Voici la liste de tous les abonnements disponibles :");
        responseMap.put("3", 
                        "Parmi vos services, veuillez entrer le nom du service que vous souhaitez supprimer : ");
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("Ce numéro n'est lié à aucune opération.");
    }

    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
