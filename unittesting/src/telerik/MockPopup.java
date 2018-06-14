package telerik;

public class MockPopup implements Popup {
    private boolean popupShown = false;

    public boolean isPopupShown() {
        return popupShown;
    }

    @Override
    public void showPopup() {
        popupShown = true;
    }
}
