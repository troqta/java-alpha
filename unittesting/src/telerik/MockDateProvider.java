package telerik;

import java.util.Date;

public class MockDateProvider implements DateProvider {
    private Date date;

    public MockDateProvider(Date date) {
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }
}
