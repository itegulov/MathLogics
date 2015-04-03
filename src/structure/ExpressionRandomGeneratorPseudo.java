package structure;

import structure.purelogic.*;

import java.util.Random;

public final class ExpressionRandomGeneratorPseudo implements ExpressionRandomGenerator<LogicExpression> {
    //TODO: javadoc
    private Random rnd;

    public ExpressionRandomGeneratorPseudo() {
        rnd = new Random();
    }

    private String generateName() {
        int len = rnd.nextInt(3) + 1;
        StringBuilder sb = new StringBuilder();
        sb.append((char)('A' + rnd.nextInt(26)));
        for (int i = 0; i < len - 1; i++) {
            sb.append((char)('0' + rnd.nextInt(10)));
        }
        return sb.toString();
    }

    @Override
    public LogicExpression generate(int size) {
        if (size == 1) {
            return new NVariable(generateName());
        }

        if (size == 2) {
            return new Not(generate(size - 1));
        }

        int t = rnd.nextInt(4);
        size -= 3;
        int c;
        if (size == 0) {
            c = 1;
        } else {
            c = rnd.nextInt(size) + 1;
        }
        switch (t) {
            case 0:
                return new And(generate(c), generate(size - c + 2));
            case 1:
                return new Or(generate(c), generate(size - c + 2));
            case 2:
                return new Entailment(generate(c), generate(size - c + 2));
            case 3:
                return new Not(generate(size + 2));
        }
        return null;
    }
}
