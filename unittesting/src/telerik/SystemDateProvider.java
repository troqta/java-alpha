package telerik;

import java.util.Date;

public class SystemDateProvider implements DateProvider {
    @Override
    public Date getDate() {
        return new Date();
    }
}
