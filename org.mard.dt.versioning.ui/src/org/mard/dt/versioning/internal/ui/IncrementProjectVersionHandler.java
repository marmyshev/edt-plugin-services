package org.mard.dt.versioning.internal.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com._1c.g5.v8.bm.core.IBmTransaction;
import com._1c.g5.v8.bm.integration.AbstractBmTask;
import com._1c.g5.v8.bm.integration.IBmModel;
import com._1c.g5.v8.dt.core.platform.IBmModelManager;
import com._1c.g5.v8.dt.core.platform.IConfigurationProvider;
import com._1c.g5.v8.dt.metadata.mdclass.Configuration;
import com.google.inject.Inject;

public class IncrementProjectVersionHandler extends AbstractHandler {

	private static final String FIRST_VERSION = "1.0.1.0";

	@Inject
	private IConfigurationProvider configurationProvider;

	@Inject
	private IBmModelManager bmModelManager;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection sel = HandlerUtil.getCurrentStructuredSelection(event);
		if (!sel.isEmpty()) {
			Object first = sel.getFirstElement();
			if (first instanceof IProject) {
				IProject project = (IProject) first;
				final Configuration configuration = configurationProvider.getConfiguration(project);
				String version = configuration.getVersion();

				if (version == null || version.isBlank()) {
					version = FIRST_VERSION;
				}
				String[] segments = version.split("\\.");
				if (segments.length > 1) {
					String last = segments[segments.length - 1];

					int quallifier;
					try {
						quallifier = Integer.parseInt(last);
					} catch (NumberFormatException e) {
						quallifier = 0;
					}

					quallifier++;
					last = String.valueOf(quallifier);
					segments[segments.length - 1] = last;
					final String newVersion = String.join(".", segments);

					IBmModel model = bmModelManager.getModel(project);
					if (model != null) {
						model.getGlobalContext().execute(new AbstractBmTask<Void>("Increment version") {

							@Override
							public Void execute(IBmTransaction transaction, IProgressMonitor monitor) {
								Configuration editing = transaction.toTransactionObject(configuration);
								editing.setVersion(newVersion);
								return null;
							}
						});
					}
				}

			}
		}
		return null;
	}

}
