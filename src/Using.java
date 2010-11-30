import java.util.Iterator;
import com.buscape.wrapper.Buscape;
import com.buscape.wrapper.request.Filter;
import com.buscape.wrapper.request.Sort;
import com.buscape.wrapper.result.Result;
import com.buscape.wrapper.result.type.Offer;
import com.buscape.wrapper.shared.Medal;

public class Using {
	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		final Buscape wrapper = new Buscape( "6a46486e764a51354753343d" );
		final Filter filter = new Filter();

		filter.setPriceMin( 800 );
		filter.setMedal( Medal.GOLD );
		filter.setSort( Sort.D_RATE );

		wrapper.setFilter( filter );

		try {
			final Result result = wrapper.findOfferList( "celular" );
			final Iterator<Offer> iterator = result.getOfferIterator();

			while ( iterator.hasNext() ) {
				final Offer current = iterator.next();

				System.out.printf( "[R$ %7.02f] - %s - %s\n" , current.getPrice().getValue() , current.getName() , current.getThumbnail().getURL() );
			}
		} catch ( final Throwable e ) {
			e.printStackTrace();
		}
	}
}