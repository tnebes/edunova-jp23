// Create a package homework
// Create a model of classes that describes the world of flora and fauna
// use minimally 4 inheritances
// on each inheritance level define at least 2 properties
// Instantiate each of the lower classes
// Highest level superclasses are abstract

package homework;

public class Start {

	public Start() {
		// create a cat and touch it.
		
		// animalia kingdom
		Kingdom animalia = new Kingdom();
		animalia.setKingdomName("Animalia");
		animalia.setCanSexuallyReproduce(true);
		animalia.setExclusivelyLandBased(false);
		animalia.setMulticellular(true);
		
		// mammalia class
		BioClass mammalia = new BioClass(animalia);
		mammalia.setClassName("Mammalia");
		mammalia.setMaxNumOfPodes(4);
		
		// carnivora order
		Order carnivora = new Order(mammalia);
		carnivora.setOrderName("Carnivora");
		carnivora.setHasFeathers(false);

		// felidae family
//		Family felidae = new Family(carnivora);
//		felidae.setFamilyName("Felidae");
//		felidae.setBearsNuts(false);
		
//		Felidae felidae = new Felidae; // extends family? 
		
		// felis catus species
		Species felisCatus = new Species();
		felisCatus.setFamilyName("felidae");
		felisCatus.setBearsNuts(false);
		felisCatus.setSpeciesName("Felis catus");
		felisCatus.setCute(true);
		felisCatus.setIndividualName("Felix");
		felisCatus.setLocalisation("meow");
		felisCatus.setNeedsWater(true);
		
		System.out.printf("This is %s.\n", felisCatus.getIndividualName());
		System.out.printf("%s is a %s.\n", felisCatus.getIndividualName(), felisCatus.getSpeciesName());
		System.out.printf("%s belongs to:\t %s\t %s\t %s\t %s\t %s\n",
				felisCatus.getSpeciesName(),
				felisCatus.getFamilyName(),
				felisCatus.getOrderName(),
				felisCatus.getClassName(),
				felisCatus.getKingdomName(),
				felisCatus.getDomainName()
				);
		System.out.printf("Fun facts about %s:\n", felisCatus.getIndividualName());
		System.out.printf("%s is cute? %b\n", felisCatus.getIndividualName(), felisCatus.isCute());
		System.out.printf("Needs water? %b\n", felisCatus.isNeedsWater());
		System.out.printf("Number of legs? %d\n", felisCatus.getMaxNumOfPodes());
		System.out.print("Let's touch the cat and see what it has to say.\n");
		felisCatus.touch();
		System.out.printf("\nThe cat is on %s\n", felisCatus.getPlanet());
		
		
		
		
	}

	public static void main(String[] args) {
		
		new Start();

	}

}
