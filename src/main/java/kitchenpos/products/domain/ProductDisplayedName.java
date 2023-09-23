package kitchenpos.products.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductDisplayedName {
    @Column(name = "name", nullable = false)
    private String value;

    protected ProductDisplayedName() {
    }

    public ProductDisplayedName(final String value, PurgomalumClient purgomalumClient) {
        validate(value, purgomalumClient);
        this.value = value;
    }


    private void validate(final String name, PurgomalumClient purgomalumClient) {
        if (Objects.isNull(name) || purgomalumClient.containsProfanity(name)) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }
}