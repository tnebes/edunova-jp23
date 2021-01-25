/*
 * Create a private inner class in this class which is called Document
 * and has 4 different data fields
 * 
 * define 3 constructs
 * Make an array of documents
 * and instantiate 3 objects using the constructors
 */

package edunova.zadaci;

public class Exercise01 {
	
	public Exercise01() {
			final int numberOfDocuments = 3;
			Document[] myDocuments = new Document[numberOfDocuments];
			for (int i = 0; i < numberOfDocuments; i++) {
				myDocuments[i] = new Document(
						(int) ((Math.random() * 500) + 10),
						(float) (Math.random()), "My Document",
						((int) Math.random() * 2) == 1 ? true : false
				);
			}
	}
	
	public static void main(String[] args) {
		new Exercise01();
	}
	
	private class Document {
		int pages;
		float dirtyness;
		String name;
		boolean isReserved;
		
		public Document() {
			this(100, 0.0f, "Untitled", false);
		}
		
		public Document(int pages, String name) {
			this(pages, 0.0f, name, false);
		}
		
		public Document(int pages, float dirtyness, String name, boolean isReserved) {
			this.pages = pages;
			this.dirtyness = dirtyness;
			this.name = name;
			this.isReserved = isReserved;
		}
		
		
	}

}
