package hermes_classification;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import de.uni_koeln.spinfo.classification.core.data.ClassifyUnit;
import de.uni_koeln.spinfo.ml_classification.data.FocusClassifyUnit;
import de.uni_koeln.spinfo.ml_classification.workflow.FocusJobs;

public class TestReader {

	@Test
	public void test() throws IOException {
		FocusJobs fj = new FocusJobs();
		List<ClassifyUnit> classifiedAds = fj.getCategorizedAdsFromFile
				(new File("src/main/resources/getIn_JobAdDB.xlsx"), 
				false, 
				new File("src/main/resources/getIn_focuses.xlsx"), 
				false);
		
		int javaInTitle = 0;

		for (ClassifyUnit classifiedAd : classifiedAds) {
			
			FocusClassifyUnit fcu = (FocusClassifyUnit) classifiedAd;
			//System.out.println(focusClassifyUnit.getContent());
			
			String title = fcu.getTitle();
			title = title.toLowerCase();
			if(title.contains("java")){
				javaInTitle++;
			}
//			System.out.println(title);
//			System.out.println(fcu.getStudySubjects());
//			System.out.println(fcu.getInFocus());
//			System.out.println(fcu.getDegrees());
			System.out.println(fcu.getContent());
			System.out.println("********************************************************************************");
		}
		System.out.println("Java Teil des Titels in " + javaInTitle + " Fällen.");
		System.out.println("Java kam nicht im Titel vor in " + (classifiedAds.size()-javaInTitle ) + " Fällen.");
	}

}
