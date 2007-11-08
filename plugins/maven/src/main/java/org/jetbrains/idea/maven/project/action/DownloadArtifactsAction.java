package org.jetbrains.idea.maven.project.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import org.jetbrains.idea.maven.project.MavenArtifactDownloader;

/**
 * User: Vladislav.Kaznacheev
 */
public class DownloadArtifactsAction extends AnAction {
  public void update(AnActionEvent e) {
    final Project project = e.getData(PlatformDataKeys.PROJECT);
    e.getPresentation().setEnabled(project != null);
  }

  public void actionPerformed(AnActionEvent e) {
    final Project project = e.getData(PlatformDataKeys.PROJECT);
    if (project != null) {
      MavenArtifactDownloader.download(project);
    }
  }
}