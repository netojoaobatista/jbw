package com.buscape.wrapper.result.adapter.json;

import com.buscape.wrapper.result.adapter.Adaptable;
import com.buscape.wrapper.util.Messages;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonAdapter implements Adaptable<JsonElement> {

	private JsonObject root;
	
	public JsonAdapter(String rawdata) {
		root = new JsonParser().parse(rawdata).getAsJsonObject();
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getDetails()
	 */
	@Override
	public JsonElement getDetails() {
		return root.get(Messages.getString("Json.details-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getCategory()
	 */
	@Override
	public JsonElement getCategory() {
		return root.get(Messages.getString("Json.category-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getSubcategory()
	 */
	@Override
	public JsonElement getSubcategory() {
		return root.get(Messages.getString("Json.subcategory-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getTop5Category()
	 */
	@Override
	public JsonElement getTop5Category() {
		return root.get(Messages.getString("Json.top5category-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getProduct()
	 */
	@Override
	public JsonElement getProduct() {
		return root.get(Messages.getString("Json.product-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#getOffer()
	 */
	@Override
	public JsonElement getOffer() {
		return root.get(Messages.getString("Json.offer-key")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasDetails()
	 */
	@Override
	public boolean hasDetails() {
		return root.has(Messages.getString("Json.details-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasCategory()
	 */
	@Override
	public boolean hasCategory() {
		return root.has(Messages.getString("Json.category-key")); //$NON-NLS-1$
	}	
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasSubcategory()
	 */
	@Override
	public boolean hasSubcategory() {
		return root.has(Messages.getString("Json.subcategory-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasTop5Category()
	 */
	@Override
	public boolean hasTop5Category() {
		return root.has(Messages.getString("Json.top5category-key")); //$NON-NLS-1$
	}	

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasProduct()
	 */
	@Override
	public boolean hasProduct() {
		return root.has(Messages.getString("Json.product-key")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.adapter.json.Adaptable#hasOffer()
	 */
	@Override
	public boolean hasOffer() {
		return root.has(Messages.getString("Json.offer-key")); //$NON-NLS-1$
	}
	
}
