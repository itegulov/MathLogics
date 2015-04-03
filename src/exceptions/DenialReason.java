package exceptions;

public enum DenialReason {
    ERROR_1("терм %s не свободен для подстановки в формулу %s вместо переменной %s"),
    ERROR_2("переменная %s входит свободно в формулу %s"),
    ERROR_3("используется %s с квантором по переменной %s, " +
            "входящей свободно в допущение %s");
    String reason;

    DenialReason(String reason) {
        this.reason = reason;
    }

    public String create(int row, String... params) {
        StringBuilder sb = new StringBuilder();
        sb.append("Вывод некорректен, начиная с формулы номер ").append(row).append(": ");
        String s = String.format(reason, (Object[]) params);
        sb.append(s);
        return sb.toString();
    }

}