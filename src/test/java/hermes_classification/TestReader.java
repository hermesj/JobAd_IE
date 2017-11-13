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
		List<ClassifyUnit> newAdsFromFile = fj.getCategorizedAdsFromFile(new File("src/main/resources/getIn_JobAdDB.xlsx"), false, new File("src/main/resources/getIn_focuses.xlsx"), false);
		for (ClassifyUnit focusClassifyUnit : newAdsFromFile) {
			
			FocusClassifyUnit fcu = (FocusClassifyUnit) focusClassifyUnit;
			//System.out.println(focusClassifyUnit.getContent());
			System.out.println(fcu.getDegrees());
			System.out.println(fcu.getInFocus());
			System.out.println(fcu.getStudySubjects());
			System.out.println(fcu.getTitle());
			System.out.println();
		}
	}

}
