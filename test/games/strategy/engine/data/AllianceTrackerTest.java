/**
 *
 */
package games.strategy.engine.data;

import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

/**
 * @author Mukul Agrawal
 *
 */
public class AllianceTrackerTest extends TestCase {
	private GameData m_data;

	public void setUp() throws Exception
	{
		//get the xml file
		URL url = this.getClass().getResource("Test.xml");
		InputStream input= url.openStream();
		m_data = (new GameParser()).parse(input);
	}

	public void testAddAlliance() throws Exception
	{
		PlayerID bush=m_data.getPlayerList().getPlayerID("bush");
		PlayerID castro=m_data.getPlayerList().getPlayerID("castro");
		AllianceTracker allianceTracker = m_data.getAllianceTracker();
        RelationshipTracker relationshipTracker = m_data.getRelationshipTracker();
		assertEquals(relationshipTracker.isAllied(bush,castro), false);
		allianceTracker.addToAlliance(bush, "natp");
		assertEquals(relationshipTracker.isAllied(bush,castro), true);

	}

	//TODO create test suite for Alliance/Relationships/Politics
/* Shouldn't test something that the engine doesn't use.

 	public void testRemoveAlliance() throws Exception
	{
		//reset the GameData
		URL url = this.getClass().getResource("Test.xml");
		InputStream input= url.openStream();
		m_data = (new GameParser()).parse(input);

		//Test removeFromAlliance
		PlayerID castro=m_data.getPlayerList().getPlayerID("castro");
		PlayerID chretian = m_data.getPlayerList().getPlayerID("chretian");
		AllianceTracker tracker=m_data.getAllianceTracker();
		tracker.removeFromAlliance(castro, "natp");
		assertEquals(tracker.isAllied(castro, chretian), false);

	}

	*/



	public void tearDown() throws Exception
	{
		m_data=null;
	}
}
