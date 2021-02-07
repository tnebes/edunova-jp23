package dataHandler;

import java.io.IOException;

import IO.IDCounter;
import IO.UserInputHandler;
import consoleApp.DataClasses.Article;
import consoleApp.DataClasses.Invoice;

public class ArticleHandler {

	public static void addArticle() {
		Controller.addMessage();
		Article newArticle = new Article();
		assignArticleID(newArticle);
		assignArticleNames(newArticle);
		assignArticleWarehouseLocation(newArticle);
		assignArticlePrices(newArticle);
		Controller.articles.add(newArticle);
		System.out.print("Successfully added article ");
		showArticle(getLastArticle());
		System.out.print("\n");
		try {
			IO.DataIO.writeDataArticlesFile(Controller.articles);
		} catch (IOException e) {
			System.out.print("Unable to write articles to file.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	static boolean articleIdIsUnique(long id) {
		for (Article article : Controller.articles) {
			if (article.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static void assignArticleNames(Article article) {
		assignArticleShortName(article);
		assignArticleLongName(article);
		assignArticleShortDescription(article);
		assignArticleLongDescription(article);
		assignArticleQuantity(article);
	}

	static void assignArticleQuantity(Article article) {
		System.out.print("Enter the amount of articles in the warehouse. Leave blank for 0: ");
		article.setWarehouseQuantity(UserInputHandler.getIntegerInput(false));
	}

	static void assignArticleShortName(Article article) {
		System.out.print("* Article short name: ");
		article.setShortName(UserInputHandler.getStringInput(true));
	}

	static void assignArticleLongName(Article article) {
		System.out.print("Article long name: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	private static void assignArticleShortDescription(Article article) {
		System.out.print("Article short description: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	static void assignArticleLongDescription(Article article) {
		System.out.print("Article long description: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	static void assignArticlePrices(Article article) {
		System.out.printf(
				"Enter tax rate without %% for article. Leave blank for automatic application of %d%% tax rate: ",
				Article.STANDARD_TAX_RATE);
		byte userIntInput = (byte) UserInputHandler.getIntegerInput(false);
		if (userIntInput == 0) {
			article.setTaxRate(Article.STANDARD_TAX_RATE);
		} else {
			article.setTaxRate(userIntInput);
		}
		boolean userInput = UserInputHandler.oneOrTwoDialogue("1 - enter retail price\n2 - enter wholesale price: ");
		if (userInput) {
			enterArticleRetailPrice(article);
			calculateWholesalePrice(article);
		} else {
			enterArticleWholesalePrice(article);
			calculateArticleRetailPrice(article);
		}
	}

	static void assignArticleID(Article article) {
		// System.out.print("Enter article ID. Leave blank for automatic generation: ");
		// long userInput = UserInputHandler.getIntegerInput(false);
		// if (userInput == 0) {
		// article.setId(IDCounter.getArticleCounter());
		// } else {
		// article.setId(enterId((byte) 3, userInput));
		// }
		article.setId(IDCounter.getArticleCounter());
	}

	private static void calculateArticleRetailPrice(Article article) {
		article.setRetailPrice((float) (article.getWholesalePrice() * (article.getTaxRate() / 100.0 + 1)));
	}

	static void calculateWholesalePrice(Article article) {
		article.setWholesalePrice((float) (article.getRetailPrice() / (article.getTaxRate() / 100.0 + 1)));
	}

	private static void enterArticleWholesalePrice(Article article) {
		System.out.print("* Enter wholesale price: ");
		article.setWholesalePrice((float) UserInputHandler.getDoubleInput(true));
	}

	private static void enterArticleRetailPrice(Article article) {
		System.out.print("* Enter retail price: ");
		article.setRetailPrice((float) UserInputHandler.getDoubleInput(true));
	}

	private static void assignArticleWarehouseLocation(Article article) {
		System.out.print("* Article warehouse location: ");
		article.setWarehouseLocation(UserInputHandler.getStringInput(true));
	}

	static void showArticle(Article article) {
		StringBuilder sb = new StringBuilder();
		sb.append(article.getId()).append(" ");
		if (!article.getLongName().isBlank()) {
			sb.append(article.getLongName()).append(" ");
		}
		sb.append(article.getShortName()).append(" ");
		sb.append(article.getWarehouseLocation()).append(" ");
		sb.append(article.getWarehouseQuantity()).append(" ");
		sb.append(article.getRetailPrice());
		System.out.print(sb.toString());
	}

	public static void showArticles() {
		if (Controller.articles.size() == 0) {
			System.out.print("No articles in the database.\n");
			return;
		}
		for (Article article : Controller.articles) {
			showArticle(article);
			System.out.print("\n");
		}
	}
	
	private static Article getArticle(long id) {
		for (Article article : Controller.articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		System.out.print("No such invoice.\n");
		return null;
	}

	public static Article getLastArticle() {
		return Controller.articles.get(Controller.articles.size() - 1);
	}

	public static void changeArticle() {
		// TODO Auto-generated method stub

	}

	public static void deleteArticle() {
		// TODO add a check if the article is associated with an invoice. If it
		// is
		// let the user decide whether he wants to purge the invoices
		// associated with the article.
		// WARNING. This is a bad idea.
		
		if (Controller.articles.size() == 0) {
			System.out.print("No articles in database.\n");
			return;
		}
		while (true) {
			showArticles();
			System.out.print("Enter ID to delete an article. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			// badness due to not-so-good implementation of getIntegerInput
			if (getArticle(0) != null) {
				if (UserInputHandler.yesNoDialogue("Delete article 0? y/n ")) {
					Controller.articles.remove(getArticle(0));
					System.out.print("Successfully removed article 0\n");
					return;
				} else {
					return;
				}
			}
			if (getArticle(userInput) != null) {
				Controller.articles.remove(getArticle(userInput));
				System.out.printf("Successfully removed article %d\n", userInput);
				return;
			} else {
				System.out.print("No such article.\n");
				continue;
			}
		}

	}

}
