package myUtils;

public class GuitarShopException extends Exception {

    public GuitarShopException() {}

    public GuitarShopException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }

    public GuitarShopException(String s) {
        super(s);
    }

    public String getXmlMassage() {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        builder.append("<exception>" + super.getMessage() + "</exception>");
        return builder.toString();
    }
}