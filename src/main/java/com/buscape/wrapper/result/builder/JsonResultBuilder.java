package com.buscape.wrapper.result.builder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.buscape.wrapper.result.Result;
import com.buscape.wrapper.result.adapter.Adaptable;
import com.buscape.wrapper.result.adapter.json.JsonAdapter;
import com.buscape.wrapper.result.type.Category;
import com.buscape.wrapper.result.type.Contact;
import com.buscape.wrapper.result.type.Item;
import com.buscape.wrapper.result.type.Link;
import com.buscape.wrapper.result.type.Offer;
import com.buscape.wrapper.result.type.Product;
import com.buscape.wrapper.result.type.Rating;
import com.buscape.wrapper.result.type.RatingEntry;
import com.buscape.wrapper.result.type.RatingEntry.RatingKind;
import com.buscape.wrapper.util.Messages;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JsonResultBuilder extends AbstractResultBuilder {

	
	private final JsonAdapter adapter;
	private static final Gson gson;

	static {
		Type listLinkType = new TypeToken<List<Link>>() {}.getType();
		Type listContactType = new TypeToken<List<Contact>>() {}.getType();
		Type listOfferType = new TypeToken<List<Offer>>() {}.getType();
		Type listCategoryType = new TypeToken<List<Category>>() {}.getType();
		Type listProductType = new TypeToken<List<Product>>() {}.getType();
		Type listItemType = new TypeToken<List<Item>>() {}.getType();

		gson = new GsonBuilder()
				.registerTypeAdapter(Rating.class, new RatingDeserializer())
				.registerTypeAdapter(listContactType, new ContatctDeserializer())
				.registerTypeAdapter(listLinkType, new LinkDeserializer())
				.registerTypeAdapter(listOfferType, new OfferDeserializer())
				.registerTypeAdapter(listCategoryType, new CategoryDeserializer())
				.registerTypeAdapter(listProductType, new ProductDeserializer())
				.registerTypeAdapter(listItemType, new ItemDeserializer())
				.create();
	}

	public JsonResultBuilder(Adaptable<?> adapter) {
		super();
		if(!(adapter instanceof JsonAdapter)) {
			throw new IllegalArgumentException("Argument adapter is not a JsonAdapter."); //$NON-NLS-1$
		}
		
		this.adapter = (JsonAdapter) adapter;		
	}

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#buildCategory()
	 */
	@Override
	public AbstractResultBuilder buildCategory() {
		Category category = new Category();
		if(adapter.hasCategory()) {
			category = gson.fromJson(adapter.getCategory(), Category.class);			
		}
		
		result.setCategory(category);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#buildOffer()
	 */
	@Override
	public AbstractResultBuilder buildOffer() {
		if(adapter.hasOffer()) {
			Type listOfferType = new TypeToken<List<Offer>>() {}.getType();
			final List<Offer> offers = gson.fromJson(adapter.getOffer(), listOfferType);
			for (Offer offer : offers) {
				result.addOffer(offer);
			}
		}
		
		return this;
	}

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#buildProduct()
	 */
	@Override
	public AbstractResultBuilder buildProduct() {
		if(adapter.hasProduct()) {
			Type listProductType = new TypeToken<List<Product>>() {}.getType();
			List<Product> products = gson.fromJson(adapter.getProduct(), listProductType);
			for(Product product : products) {
				result.addProduct(product);
			}
		}
		
		return this;
	}

	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#buildSubcategory()
	 */
	@Override
	public AbstractResultBuilder buildSubcategory() {
		if(adapter.hasSubcategory()) {
			Type listCategoryType = new TypeToken<List<Category>>() {}.getType();
			List<Category> subategories = gson.fromJson(adapter.getSubcategory(), listCategoryType);
			for(Category category : subategories) {
				result.getCategory().addSubCategory(category);
			}
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#buildTop5Category()
	 */
	@Override
	public AbstractResultBuilder buildTop5Category() {
		if(adapter.hasTop5Category()) {
			Type listCategoryType = new TypeToken<List<Category>>() {}.getType();
			List<Category> topCategories = gson.fromJson(adapter.getTop5Category(), listCategoryType);
			for(Category category : topCategories) {
				result.getCategory().addTop5Category(category);
			}
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.buscape.wrapper.result.builder.AbstractResultBuilder#getResult()
	 */
	@Override
	public Result getResult() {
		return result;
	}
	
	private static class LinkDeserializer implements JsonDeserializer<List<Link>> {

		@Override
		public List<Link> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Link> result = new ArrayList<Link>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject link = it.next().getAsJsonObject();
				result.add(gson.fromJson(link.get(Messages.getString("Json.link-key")), Link.class)); //$NON-NLS-1$
			}

			return result;
		}
	}
	
	private static class ItemDeserializer implements JsonDeserializer<List<Item>> {

		@Override
		public List<Item> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Item> result = new ArrayList<Item>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject link = it.next().getAsJsonObject();
				result.add(gson.fromJson(link.get(Messages.getString("Json.item-key")), Item.class)); //$NON-NLS-1$
			}

			return result;
		}
	}

	private static class OfferDeserializer implements JsonDeserializer<List<Offer>> {

		@Override
		public List<Offer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Offer> result = new ArrayList<Offer>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject off = it.next().getAsJsonObject();
				result.add(gson.fromJson(off.get(Messages.getString("Json.offer-key")), Offer.class)); //$NON-NLS-1$
			}

			return result;
		}
	}

	private static class ContatctDeserializer implements JsonDeserializer<List<Contact>> {

		@Override
		public List<Contact> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Contact> result = new ArrayList<Contact>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject off = it.next().getAsJsonObject();
				result.add(gson.fromJson(off.get(Messages.getString("Json.contact-key")), Contact.class)); //$NON-NLS-1$
			}

			return result;
		}
	}
	
	private static class ProductDeserializer implements JsonDeserializer<List<Product>> {

		@Override
		public List<Product> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Product> result = new ArrayList<Product>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject off = it.next().getAsJsonObject();
				result.add(gson.fromJson(off.get(Messages.getString("Json.product-key")), Product.class)); //$NON-NLS-1$
			}

			return result;
		}
	}
	
	private static class CategoryDeserializer implements JsonDeserializer<List<Category>> {

		@Override
		public List<Category> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<Category> result = new ArrayList<Category>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject off = it.next().getAsJsonObject();
				String name = off.get(Messages.getString("Json.subcategory-key")) != null ? Messages.getString("Json.subcategory-key") : Messages.getString("Json.top5category-key");  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				result.add(gson.fromJson(off.get(name), Category.class));
			}

			return result;
		}
		
	}

	private static class RatingDeserializer implements JsonDeserializer<Rating> {

		@Override
		public Rating deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			Rating result = new Rating();

			for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
				RatingEntry rating = gson.fromJson(entry.getValue(), RatingEntry.class);
				RatingKind kind = RatingKind.fromString(entry.getKey());
				rating.setKing(kind);
				switch (kind) {
				case EBIT:

					result.seteBitRating(rating);
					break;

				case USER:
					result.setUserAverageRating(rating);
					break;
				}
			}

			return result;
		}
	}

}
