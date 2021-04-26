package conversor.dev.com.convertidor.Entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Document(collection = "Convert")
public class Convert {

    @Id
    @Indexed(unique = true)
    private int id;
    private String base_currency_code;
    private String base_currency_name;
    private String amount;
    private String updated_date;
    private Rates rates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase_currency_code() {
        return base_currency_code;
    }

    public void setBase_currency_code(String base_currency_code) {
        this.base_currency_code = base_currency_code;
    }

    public String getBase_currency_name() {
        return base_currency_name;
    }

    public void setBase_currency_name(String base_currency_name) {
        this.base_currency_name = base_currency_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Convert(int id,String base_currency_code, String base_currency_name, String amount, String updated_date, Rates rates) {
        this.id = id;
        this.base_currency_code = base_currency_code;
        this.base_currency_name = base_currency_name;
        this.amount = amount;
        this.updated_date = updated_date;
        this.rates = rates;
    }
}
