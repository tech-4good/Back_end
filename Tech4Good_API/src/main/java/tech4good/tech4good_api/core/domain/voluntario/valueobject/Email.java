package tech4good.tech4good_api.core.domain.voluntario.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.regex.Pattern;

public class Email {

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private final String value;

    @JsonCreator
    public Email(String value) {
        this.value = value;
    }

    public static Email valueOf(String email) {
        if (email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser vazio.");
        }

        if (!EMAIL_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }

        // Aqui o trim serve só para retirar os espaços
        return new Email(email.toLowerCase().trim());

        //REPARE BEM QUE O METODO VALUEOF SERÁ O MODO COMO NÓS IREMOS CRIAR UM EMAIL,
        // OU SEJA, NÃO UTILIZAREMOS SETTERS
    }

    @JsonValue
    public String getValue() {
        return value;
    }


    //CRIEI UM METODO DE EQUALS, CASO FORMOS UTILIZAR BASTA DESCOMENTAR

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }
*/
    /*@Override
    public int hashCode() {
        return Objects.hash(value);
    }*/

    @Override
    public String toString() {
        return value;
    }
}
