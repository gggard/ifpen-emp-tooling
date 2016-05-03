# Requirements #

All you need to install the IFPEN EMP tooling modules is an Eclipse installation in version >= 3.7.

# Installation #

First launch your Eclipse installation and run the menu "Help > Install New Software...".

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstallMenu.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstallMenu.png)

A installation window opens. In this window, make sure the "Contact all update sites during install to find required software" is checked. Then click on the "Add..." button.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstallWindow.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstallWindow.png)

Once the "Add..." button clicked, a new window opens to add a new software repository. Fill out the form with the following data:
```
 - Name: IFPEN EMP Tooling repository
 - Location: https://googledrive.com/host/0BzVxxkst7BU5QXhmMzEyU3RBYjA/
```

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/IFPENToolingRepository.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/IFPENToolingRepository.png)

Then validate.

The software installation window displays all the available IFPEN Tooling modules.
Before checking the modules you want to install, you may have to add complementary software repositories.

If you use a Eclipse version before 4.3 (Kepler), you have to add the EEF 1.2 repository. In this case, you have to perform the same process as for the first repository, but you will use the following data:
```
 - Name: EEF 1.2 repository
 - Location: http://download.eclipse.org/modeling/emft/eef/updates/releases/1.2
```

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/EEF12Repository.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/EEF12Repository.png)

The second repository you may have to install is required by the Cuboid Modeler Sample. If you want to install it, you have to add the following repository:
```
 - Name: IFPEN EMP Tooling JOGL repository
 - Location: https://googledrive.com/host/0BzVxxkst7BU5QkdaSkJET0VUU1U/
```

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/JOGLRepository.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/JOGLRepository.png)

Once all required repositories added, you can choose the IFPEN EMP Tooling repository in the first combo box of the software installation window and the check the modules you want to install in the list below the combo box.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/ModuleSelection.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/ModuleSelection.png)

Once the modules selected, click on the "Next" button. Eclipse compute the modules requirements and should display a new page listing all the installed softwares. If an error is encountered, check the repositories you have added to Eclipse in the preceding step.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstalledSoftware.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/InstalledSoftware.png)

Click on the "Next" button to go to the next page. This page displays the modules licences (EPL).

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/LicenseAgreement.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/LicenseAgreement.png)

Select the "I accept the terms of the license agreement" option and click again on the "Next" button to start the modules download.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/ModuleDownload.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/ModuleDownload.png)

Once the modules download, a dialog will display a warning message specifying that the downloaded modules are not signed. Click on the "Ok" button to continue the installation.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/SecurityWarning.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/SecurityWarning.png)

Finally, a last dialog box ask you to restart Eclipse in order to finish the installation. Click on "Restart Now" to restart your Eclipse installation.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/EclipseRestart.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/pics/installation/EclipseRestart.png)

Once Eclipse is started, the modules are installed, you can use them.