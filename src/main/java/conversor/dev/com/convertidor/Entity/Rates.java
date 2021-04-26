package conversor.dev.com.convertidor.Entity;


import java.util.List;

public class Rates {

    private USD usds;
    private boolean status;

    public Rates(USD usds, boolean status) {
        super();
        this.usds = usds;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public USD getUsds() {
        return usds;
    }

    public void setUsds(USD usds) {
        this.usds = usds;
    }
}
