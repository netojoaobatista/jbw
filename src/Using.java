import java.util.Iterator;
import com.buscape.wrapper.Buscape;
import com.buscape.wrapper.exception.BuscapeException;
import com.buscape.wrapper.request.Country;
import com.buscape.wrapper.result.Result;
import com.buscape.wrapper.result.type.Offer;

public class Using {
	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		final Buscape wrapper = new Buscape( "6a46486e764a51354753343d" , Country.valueOf( "BR" ) );

		try {
			final Result result = wrapper.findOfferList( "celular" );

			final Iterator<Offer> offerIterator = result.getOfferIterator();

			while ( offerIterator.hasNext() ) {
				System.out.println( offerIterator.next().getThumbnail().getURL() );
			}
		} catch ( final BuscapeException e ) {
			e.printStackTrace();
		}
	}
}