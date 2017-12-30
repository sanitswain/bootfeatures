package practice.boot.features.failureanalyzers;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * Demonstrating FailureAnalyzer feature. In case any exception raised during
 * application start, all the FailureAnalyzer classes will be invoked in a
 * sequence. If any of the FailureAnalyzer class returning
 * <code>FailureAnalysis</code> object then the exception won't be propagated to
 * further FailureAnalysis classes.
 * <p>
 * Please make sure you register your FailureAnalysis class in
 * <i>'resource/META-INF/spring.factories'</i> file.
 *
 */
public class SampleFailureAnalyzer extends AbstractFailureAnalyzer<Exception> {

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, Exception cause) {
		System.out.println("\n===>SampleFailureAnalyzer::analyze()\n");
		String desciption = "This is an example to verify FailureAnalyzer feature";
		String action = "Comment the exception code block";
		return new FailureAnalysis(desciption, action, cause);
	}

}
