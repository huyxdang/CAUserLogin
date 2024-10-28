package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.change_password.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class LoggedInPresenter implements ChangePasswordOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {
        // Update the view model to indicate the password change was successful
        loggedInViewModel.setSuccessMessage("Password changed successfully!");
        loggedInViewModel.firePropertyChanged("password");
    }

    @Override
    public void prepareFailView(String error) {
        // Update the view model to reflect an error
        loggedInViewModel.setErrorMessage(error);
        loggedInViewModel.firePropertyChanged("error");
    }
}
