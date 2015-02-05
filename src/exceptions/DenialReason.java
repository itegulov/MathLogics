package exceptions;

public enum DenialReason {
    ERROR_1("терм %s не свободен для подстановки в формулу %s вместо переменной %s."),
    ERROR_2("переменная %s входит свободно в формулу %s."),
    ERROR_3("используется %s с квантором по переменной %s, " +
            "входящей свободно в допущение %s: \n%s\n_______________________________\n%s"),
    ERROR_4("используется схема аксиом с квантором по переменной %s, " +
            "входящей свободно в допущение %s: %s");
    String reason;

    DenialReason(String reason) {
        this.reason = reason;
    }

    public String create(int row, String... params) {
        StringBuilder sb = new StringBuilder();
        sb.append("Вывод некорректен, начиная с формулы № ").append(row).append("\n");
        reason = String.format(reason, params);
        sb.append(reason);
        return sb.toString();
    }

}